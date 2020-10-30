package com.br.apiQA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.apiQA.model.TesteUnitario;


@Repository
public interface TesteUnitarioRepository extends JpaRepository<TesteUnitario, Long> {
	
	
	 

}
