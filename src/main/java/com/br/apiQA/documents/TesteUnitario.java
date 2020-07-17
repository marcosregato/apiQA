package com.br.apiQA.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TesteUnitario {

	@Id
	private String id;
	private String total_teste;
	private String passou;
	private String erro;
	private String tempo_total;
	private String data;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTotal_teste() {
		return total_teste;
	}
	public void setTotal_teste(String total_teste) {
		this.total_teste = total_teste;
	}
	public String getPassou() {
		return passou;
	}
	public void setPassou(String passou) {
		this.passou = passou;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getTempo_total() {
		return tempo_total;
	}
	public void setTempo_total(String tempo_total) {
		this.tempo_total = tempo_total;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}