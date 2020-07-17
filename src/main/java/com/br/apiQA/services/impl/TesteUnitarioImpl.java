package com.br.apiQA.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.apiQA.documents.TesteUnitario;
import com.br.apiQA.repositories.TesteUnitarioRepository;
import com.br.apiQA.services.TesteUnitarioService;

public class TesteUnitarioImpl implements TesteUnitarioService{
	
	@Autowired
	private TesteUnitarioRepository respository;

	@Override
	public List<TesteUnitario> listarTodos() {
		return this.respository.findAll();
	}

	@Override
	public TesteUnitario listarPorId(String id) {
		return this.respository.findOne(id);
	}

	@Override
	public TesteUnitario cadastrar(TesteUnitario valor) {
		return this.respository.save(valor);
	}

	@Override
	public TesteUnitario atualizar(TesteUnitario valor) {
		return this.respository.save(valor);
	}

	@Override
	public void remover(String id) {
		this.respository.delete(id);
		
	}
}