package com.br.apiQA.services;

import java.util.List;

import com.br.apiQA.documents.TesteUnitario;

public interface TesteUnitarioService {
	
	List<TesteUnitario> listarTodos();

	TesteUnitario listarPorId(String id);

	TesteUnitario cadastrar(TesteUnitario valor);

	TesteUnitario atualizar(TesteUnitario valor);

	void remover(String id);

}
