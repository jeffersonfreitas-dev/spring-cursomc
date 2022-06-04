package com.jefferson.cursomc.domain.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CategoriaRequest {
	
	@NotBlank(message = "Informe um nome para a categoria")
	private String nome;

}
