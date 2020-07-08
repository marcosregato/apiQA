package com.br.apiQA.responses;

import java.util.List;

public class ResponseCliente<Clientes> {
	
	private Clientes clientes;
	private List<String> erros;
	
	public ResponseCliente(Clientes data) {
		this.clientes = data;
	}
	
	public ResponseCliente(List<String> erros) {
		this.erros = erros;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes data) {
		this.clientes = data;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
	

}
