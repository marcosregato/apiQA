package com.br.apiQA.responses;

import java.util.List;

public class ResponseTesteUnitario <TesteUnitario> {
	
	private TesteUnitario valor;
	private List<String> erros;
	
	public ResponseTesteUnitario(TesteUnitario data) {
		this.valor = data;
	}
	
	public ResponseTesteUnitario(List<String> erros) {
		this.erros = erros;
	}

	public TesteUnitario getTesteFuncional() {
		return valor;
	}

	public void setTesteFuncional(TesteUnitario data) {
		this.valor = data;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
}
