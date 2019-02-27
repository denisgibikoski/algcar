package com.example.demo.model;

public enum Categoria {

	HATCH_COMPACTO("Hatch Compacto"),
	HATCH_MEDIO("Hatch Medio"),
	SEDAN_COMPACTO("Sedan Compacto"),
	SEDAN_MEDIO("Sedan Medio"),
	SEDAN_GRANDE("Sedan Grande"),
	MINIVAN("Minivan"),
	ESPORTIVO("Esportivo"),
	UTILITARIO_COMERCIAL("Utilitario Comercial");
	
	 Categoria(String descricao) {
		this.descricao=descricao;
	}
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	} 
	
}
