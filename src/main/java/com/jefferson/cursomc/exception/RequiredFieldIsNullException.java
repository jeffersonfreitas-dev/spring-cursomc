package com.jefferson.cursomc.exception;

public class RequiredFieldIsNullException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RequiredFieldIsNullException(String msg) {
		super(msg);
	}

}
