package com.jefferson.cursomc.domain.dto.response;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jefferson.cursomc.domain.Cliente;
import com.jefferson.cursomc.domain.Endereco;
import com.jefferson.cursomc.domain.Pagamento;
import com.jefferson.cursomc.domain.PedidoItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	private Double total;
	private Pagamento pagamento;
	private Cliente cliente;
	private Endereco endereco;
	private Set<PedidoItem> itens = new HashSet<>();

}
