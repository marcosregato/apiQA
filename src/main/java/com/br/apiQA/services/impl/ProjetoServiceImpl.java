package com.br.apiQA.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apiQA.documents.Projeto;
import com.br.apiQA.repositories.ProjetoRepository;
import com.br.apiQA.services.ProjetoService;


@Service
public class ProjetoServiceImpl implements ProjetoService {
	
	@Autowired
	private ProjetoRepository respository;

	@Override
	public List<Projeto> listarTodos() {
		return this.respository.findAll();
	}

	@Override
	public Projeto listarPorId(String id) {
		return this.respository.findOne(id);
	}

	@Override
	public Projeto cadastrar(Projeto valor) {
		return this.respository.save(valor);
	}

	@Override
	public Projeto atualizar(Projeto valor) {
		return this.respository.save(valor);
	}

	@Override
	public void remover(String id) {
		this.respository.delete(id);
	}
}
