package com.jefferson.cursomc.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jefferson.cursomc.domain.dto.CategoriaResponse;
import com.jefferson.cursomc.service.CategoriaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
public class CategoriaResources {
	
	private final CategoriaService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CategoriaResponse> findAll(){
		return service.findAll();
	}
}
