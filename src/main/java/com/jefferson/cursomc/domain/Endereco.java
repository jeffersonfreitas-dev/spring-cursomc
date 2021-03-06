package com.jefferson.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jefferson.cursomc.exception.RequiredFieldIsNullException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	public Endereco(String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente,
			Cidade cidade) {
		setLogradouro(logradouro);
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		setCliente(cliente);
		setCidade(cidade);
	}

	public Endereco(String logradouro, Cliente cliente, Cidade cidade) {
		setLogradouro(logradouro);
		setCliente(cliente);
		setCidade(cidade);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		if(logradouro.equals("")) throw new RequiredFieldIsNullException("Campo logradouro é obrigatório");
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if(cliente == null) throw new RequiredFieldIsNullException("Cliente é obrigatório");
		this.cliente = cliente;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		if(cidade == null) throw new RequiredFieldIsNullException("Cidade é obrigatória");
		this.cidade = cidade;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nLOGRADOURO: ");
		builder.append(logradouro);
		builder.append(", nº ");
		builder.append(numero);
		builder.append(", COMPLEMENTO: ");
		builder.append(complemento);
		builder.append(", BAIRRO: ");
		builder.append(bairro);
		builder.append(", CEP: ");
		builder.append(cep);
		builder.append("\nCIDADE: ");
		builder.append(cidade.getNome());
		builder.append("/ ");
		builder.append(cidade.getEstado().getNome());
		builder.append("\n");
		return builder.toString();
	}
	
	
}
