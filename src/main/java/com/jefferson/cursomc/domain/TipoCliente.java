package com.jefferson.cursomc.domain;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa fisica"),
	PESSOAJURIDICA(2, "Pessoa juridica");
	
	private Integer codigo;
	private String descricao;
	
	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(TipoCliente x : TipoCliente.values()) {
			if(codigo == x.getCodigo()) {
				return x;
			}
		}
		throw new IllegalArgumentException("Código do tipo inválido: " + codigo);
	}

}
