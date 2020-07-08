package com.br.apiQA.services;

import java.util.List;

import com.br.apiQA.documents.TesteFuncional;

public interface TesteFuncionalService {
	
	List<TesteFuncional> listarTodos();

	TesteFuncional listarPorId(String id);

	TesteFuncional cadastrar(TesteFuncional valor);

	TesteFuncional atualizar(TesteFuncional valor);

	void remover(String id);

}
