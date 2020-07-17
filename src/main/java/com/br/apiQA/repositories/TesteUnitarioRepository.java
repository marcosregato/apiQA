package com.br.apiQA.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.apiQA.documents.TesteUnitario;

public interface TesteUnitarioRepository extends MongoRepository<TesteUnitario, String> {

}
