package com.br.apiQA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.apiQA.model.TesteFuncional;

@Repository
public interface TesteFuncionalRepository extends JpaRepository<TesteFuncional, Long> {

}
