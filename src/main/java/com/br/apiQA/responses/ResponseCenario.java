package com.br.apiQA.responses;

import java.util.List;

public class ResponseCenario<Cenarios> {
	
	private Cenarios valor;
	private List<String> erros;
	
	public ResponseCenario(Cenarios data) {
		this.valor = data;
	}
	
	public ResponseCenario(List<String> erros) {
		this.erros = erros;
	}

	public Cenarios getClientes() {
		return valor;
	}

	public void setClientes(Cenarios data) {
		this.valor = data;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

}
