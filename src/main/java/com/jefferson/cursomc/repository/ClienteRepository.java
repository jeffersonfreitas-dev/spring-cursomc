package com.jefferson.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jefferson.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
