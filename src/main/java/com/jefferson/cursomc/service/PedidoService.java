package com.jefferson.cursomc.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jefferson.cursomc.domain.dto.response.PedidoResponse;
import com.jefferson.cursomc.exception.IDNotFoundException;
import com.jefferson.cursomc.repository.PedidoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoService {
	
	private final PedidoRepository repository;
	private final ModelMapper mapper;

	public PedidoResponse finById(Integer id) {
		
		System.out.println(repository.findById(id));
		
		return repository.findById(id)
				.map(p -> mapper.map(p, PedidoResponse.class))
				.orElseThrow(() -> new IDNotFoundException("Id não encontrado: " + id));
	}

}
