package com.br.apiQA.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apiQA.documents.TesteFuncional;
import com.br.apiQA.repositories.TesteFuncionalRepository;
import com.br.apiQA.services.TesteFuncionalService;

@Service
public class TesteFuncionalImple implements TesteFuncionalService{
	
	@Autowired
	private TesteFuncionalRepository respository;

	@Override
	public List<TesteFuncional> listarTodos() {
		return this.respository.findAll();
	}

	@Override
	public TesteFuncional listarPorId(String id) {
		return this.respository.findOne(id);
	}

	@Override
	public TesteFuncional cadastrar(TesteFuncional valor) {
		return this.respository.save(valor);
	}

	@Override
	public TesteFuncional atualizar(TesteFuncional valor) {
		return this.respository.save(valor);
	}

	@Override
	public void remover(String id) {
		this.respository.delete(id);
		
	}
	
	

}
