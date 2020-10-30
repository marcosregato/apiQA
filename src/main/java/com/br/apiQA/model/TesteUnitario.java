package com.br.apiQA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "testeUnitario")
public class TesteUnitario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String total_teste;
	private String passou;
	private String erro;
	private String tempo_total;
	private String data;
	
	public TesteUnitario() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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