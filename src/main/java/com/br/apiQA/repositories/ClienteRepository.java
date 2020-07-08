package com.br.apiQA.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.apiQA.documents.Cliente;


public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
