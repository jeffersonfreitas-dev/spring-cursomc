package com.jefferson.cursomc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jefferson.cursomc.domain.dto.response.CategoriaResponse;
import com.jefferson.cursomc.exception.IDNotFoundException;
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


	public CategoriaResponse finById(Integer id) {
		return repository.findById(id)
				.map(c -> mapper.map(c, CategoriaResponse.class))
				.orElseThrow(() -> new IDNotFoundException("ID não encontrado: " + id));
	}
	

}
