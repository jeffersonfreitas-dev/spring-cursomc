package com.jefferson.cursomc;

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
import com.jefferson.cursomc.repository.CategoriaRepository;
import com.jefferson.cursomc.repository.CidadeRepository;
import com.jefferson.cursomc.repository.ClienteRepository;
import com.jefferson.cursomc.repository.EnderecoRepository;
import com.jefferson.cursomc.repository.EstadoRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class CursomcApplication implements CommandLineRunner{

	private final CategoriaRepository categoriaRepository;
	private final EstadoRepository estadoRepository;
	private final CidadeRepository cidadeRepository;
	private final ClienteRepository clienteRepository;
	private final EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria("INFORMÁTICA");
		Categoria cat2 = new Categoria("ELETRONICOS");
		Categoria cat3 = new Categoria("DOMESTICOS");
		Categoria cat4 = new Categoria("EQUIPAMENTOS");
		Categoria cat5 = new Categoria("CASA");
		Categoria cat6 = new Categoria("VARIADOS");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		
		Estado estado = new Estado("CEARÁ");
		estadoRepository.save(estado);
		
		Cidade cidade = new Cidade("IGUATU", estado);
		cidadeRepository.save(cidade);

		Cliente cliente = new Cliente("FULANO DE TAL", 1);
		clienteRepository.save(cliente);

		Endereco endereco = new Endereco("RUA CLEIA", cliente, cidade);
		enderecoRepository.save(endereco);
		
	}

}
