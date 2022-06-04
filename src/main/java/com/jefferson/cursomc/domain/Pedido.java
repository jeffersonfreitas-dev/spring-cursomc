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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;

	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_endereco_entrega")
	private Endereco endereco;

	@OneToMany(mappedBy = "id.produto")
	private Set<PedidoItem> itens = new HashSet<>();

	public Pedido(Date data, Cliente cliente, Endereco endereco) {
		this.data = data;
		this.cliente = cliente;
		this.endereco = endereco;
	}

	@JsonIgnore
	public List<Produto> getProdutos() {
		return itens.stream().map(i -> i.getProduto()).collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Double getTotal() {
		return this.itens.stream()
				.map(PedidoItem::getSubtotal)
				.reduce(0.0, (a, b) -> a + b);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n**** DETALHE DO PEDIDO ****");
		builder.append("\nPEDIDO nº ");
		builder.append(id);
		builder.append(", DATA: ");
		builder.append(data);
		builder.append(", CLIENTE: ");
		builder.append(cliente.getNome());
		builder.append(endereco);
		builder.append("\nTOTAL: ");
		builder.append(getTotal());
		builder.append("\nITENS DO PEDIDO: ");
		for(PedidoItem i : itens) {
			builder.append(i);
		}
		return builder.toString();
	}
	
	
	

}
