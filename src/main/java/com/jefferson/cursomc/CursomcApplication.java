package com.jefferson.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jefferson.cursomc.domain.Categoria;
import com.jefferson.cursomc.domain.Cidade;
import com.jefferson.cursomc.domain.Cliente;
import com.jefferson.cursomc.domain.Endereco;
import com.jefferson.cursomc.domain.Estado;
import com.jefferson.cursomc.domain.EstadoPagamento;
import com.jefferson.cursomc.domain.Pagamento;
import com.jefferson.cursomc.domain.PagamentoComBoleto;
import com.jefferson.cursomc.domain.PagamentoComCartao;
import com.jefferson.cursomc.domain.Pedido;
import com.jefferson.cursomc.domain.PedidoItem;
import com.jefferson.cursomc.domain.Produto;
import com.jefferson.cursomc.repository.CategoriaRepository;
import com.jefferson.cursomc.repository.CidadeRepository;
import com.jefferson.cursomc.repository.ClienteRepository;
import com.jefferson.cursomc.repository.EnderecoRepository;
import com.jefferson.cursomc.repository.EstadoRepository;
import com.jefferson.cursomc.repository.PedidoItemRepository;
import com.jefferson.cursomc.repository.PedidoRepository;
import com.jefferson.cursomc.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class CursomcApplication implements CommandLineRunner{

	private final CategoriaRepository categoriaRepository;
	private final EstadoRepository estadoRepository;
	private final CidadeRepository cidadeRepository;
	private final ClienteRepository clienteRepository;
	private final EnderecoRepository enderecoRepository;
	private final ProdutoRepository produtoRepository;
	private final PedidoRepository pedidoRepository;
	private final PedidoItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria("Informática");
		Categoria cat2 = new Categoria("Escritório");
		
		Produto p1 = new Produto("Computador", 2000.00);
		Produto p2 = new Produto("Impressora", 800.00);
		Produto p3 = new Produto("Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado("Minas Gerais");
		Estado est2 = new Estado("São Paulo");
		
		Cidade c1 = new Cidade("Uberlândia", est1);
		Cidade c2 = new Cidade("São Paulo", est2);
		Cidade c3 = new Cidade("Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente("Maria Silva", "maria@gmail.com", "36378912377", 1);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
				
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		PedidoItem ip1 = new PedidoItem(ped1, p1, 0.00, 1, 2000.00);
		PedidoItem ip2 = new PedidoItem(ped1, p3, 0.00, 2, 80.00);
		PedidoItem ip3 = new PedidoItem(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}
