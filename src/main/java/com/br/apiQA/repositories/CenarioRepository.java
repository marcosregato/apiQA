package com.br.apiQA.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.apiQA.documents.Cenario;

public interface CenarioRepository extends MongoRepository<Cenario, String>{

}
