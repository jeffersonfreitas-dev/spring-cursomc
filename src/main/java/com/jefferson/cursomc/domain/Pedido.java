package com.jefferson.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	
	@OneToOne(mappedBy="pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_endereco_entrega")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "id.produto")
	private Set<PedidoItem> itens = new HashSet<>();
	
	public List<Produto> getProdutos(){
		return itens.stream().map(i -> i.getId().getProduto()).collect(Collectors.toList());
	}

}
