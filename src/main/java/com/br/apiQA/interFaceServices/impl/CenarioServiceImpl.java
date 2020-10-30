package com.br.apiQA.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apiQA.documents.Cenario;
import com.br.apiQA.repositories.CenarioRepository;
import com.br.apiQA.services.CenarioService;

@Service
public class CenarioServiceImpl implements CenarioService {
	
	@Autowired
	private CenarioRepository respository;

	@Override
	public List<Cenario> listarTodos() {
		return this.respository.findAll();
	}

	@Override
	public Cenario listarPorId(String id) {
		return this.respository.findOne(id);
	}

	@Override
	public Cenario cadastrar(Cenario valor) {
		return this.respository.save(valor);
	}

	@Override
	public Cenario atualizar(Cenario valor) {
		return this.respository.save(valor);
	}

	@Override
	public void remover(String id) {
		this.respository.delete(id);
	}
}
