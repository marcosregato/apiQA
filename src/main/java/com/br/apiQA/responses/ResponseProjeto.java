package com.br.apiQA.responses;

import java.util.List;

public class ResponseProjeto<Projetos> {
	
	private Projetos valor;
	private List<String> erros;
	
	public ResponseProjeto(Projetos data) {
		this.valor = data;
	}
	
	public ResponseProjeto(List<String> erros) {
		this.erros = erros;
	}

	public Projetos getData() {
		return valor;
	}

	public void setData(Projetos data) {
		this.valor = data;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

}
