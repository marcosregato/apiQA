package com.br.apiQA.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "cenario")
public class Cenario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	private String nome;

	public Cenario() {
	}

	public Long  getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}