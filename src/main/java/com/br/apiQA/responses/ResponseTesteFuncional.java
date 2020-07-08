package com.br.apiQA.responses;

import java.util.List;

public class ResponseTesteFuncional<TesteFuncional> {
	
	private TesteFuncional valor;
	private List<String> erros;
	
	public ResponseTesteFuncional(TesteFuncional data) {
		this.valor = data;
	}
	
	public ResponseTesteFuncional(List<String> erros) {
		this.erros = erros;
	}

	public TesteFuncional getTesteFuncional() {
		return valor;
	}

	public void setTesteFuncional(TesteFuncional data) {
		this.valor = data;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

}
