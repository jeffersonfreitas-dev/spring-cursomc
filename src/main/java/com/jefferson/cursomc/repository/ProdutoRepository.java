package com.jefferson.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jefferson.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
