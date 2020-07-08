package com.br.apiQA.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.apiQA.documents.Projeto;

public interface ProjetoRepository extends MongoRepository<Projeto, String>{

}
