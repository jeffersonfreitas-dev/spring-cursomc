package com.jefferson.cursomc.resources;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jefferson.cursomc.domain.dto.response.PedidoResponse;
import com.jefferson.cursomc.service.PedidoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidoResources {
	
	private final PedidoService service;
	
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public PedidoResponse findById(@PathVariable Integer id){
		return service.finById(id);
	}
}
