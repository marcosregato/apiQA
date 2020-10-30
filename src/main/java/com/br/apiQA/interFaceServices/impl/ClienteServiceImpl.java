package com.br.apiQA.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apiQA.documents.Cliente;
import com.br.apiQA.repositories.ClienteRepository;
import com.br.apiQA.services.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository respository;

	@Override
	public List<Cliente> listarTodos() {
		return this.respository.findAll();
	}

	@Override
	public Cliente listarPorId(String id) {
		return this.respository.findOne(id);
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		return this.respository.save(cliente);
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		return this.respository.save(cliente);
	}

	@Override
	public void remover(String id) {
		this.respository.delete(id);
	}

}
