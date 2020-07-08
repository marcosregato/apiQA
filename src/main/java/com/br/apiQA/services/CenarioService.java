package com.br.apiQA.services;

import java.util.List;

import com.br.apiQA.documents.Cenario;

public interface CenarioService {
	
	List<Cenario> listarTodos();

	Cenario listarPorId(String id);

	Cenario cadastrar(Cenario valor);

	Cenario atualizar(Cenario valor);

	void remover(String id);

}
