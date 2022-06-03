package com.jefferson.cursomc.exception;

public class IDNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public IDNotFoundException(String msg) {
		super(msg);
	}

}
