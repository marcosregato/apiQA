package com.br.apiQA.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.apiQA.model.Cenario;

@Repository
public interface CenarioRepository extends JpaRepository<Cenario, Long>{

}
