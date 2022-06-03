package com.jefferson.cursomc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jefferson.cursomc.domain.dto.CategoriaResponse;
import com.jefferson.cursomc.repository.CategoriaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaService {
	
	private final CategoriaRepository repository;
	private final ModelMapper mapper;

	
	public List<CategoriaResponse> findAll() {
		return repository.findAll().stream()
				.map(c -> mapper.map(c, CategoriaResponse.class)).collect(Collectors.toList());
	}
	

}
