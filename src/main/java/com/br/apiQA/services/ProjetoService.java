package com.br.apiQA.services;

import java.util.List;

import com.br.apiQA.documents.Cliente;
import com.br.apiQA.documents.Projeto;

public interface ProjetoService {
	
	List<Projeto> listarTodos();

	Projeto listarPorId(String id);

	Projeto cadastrar(Projeto valor);

	Projeto atualizar(Projeto valor);

	void remover(String id);

}
