package com.br.apiQA.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.apiQA.documents.TesteFuncional;

public interface TesteFuncionalRepository extends MongoRepository<TesteFuncional, String> {

}
