package com.br.apiQA.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.apiQA.error.ResourceNotFoundException;
import com.br.apiQA.model.TesteUnitario;
import com.br.apiQA.repositories.TesteUnitarioRepository;

@RestController
public class TesteUnitarioController {

	@Autowired
	private TesteUnitarioRepository repository;

	@GetMapping("/testeUnitario")
	public List<TesteUnitario> listarTodos() 
			throws ResourceNotFoundException {
		return repository.findAll();
	}

	@GetMapping("/testeUnitario/{id}")
	public ResponseEntity<TesteUnitario> getId(@PathVariable(value = "id") Long id) 
			throws ResourceNotFoundException {
		
		TesteUnitario idTeste = repository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("TesteUnitario não encontrado para este id -> " + id));
		return ResponseEntity.ok().body(idTeste);
	}

	@PostMapping("/testeUnitario")
	public TesteUnitario salvar(@Valid @RequestBody TesteUnitario valor) {
		return repository.save(valor);
	}

	@PutMapping("/testeUnitario/{id}")
	public ResponseEntity<TesteUnitario> update(@PathVariable(name = "id") Long id, @Valid @RequestBody TesteUnitario valor) 
			throws ResourceNotFoundException {
		
		TesteUnitario testeUnitario = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id -> " + id));

		testeUnitario.setId(testeUnitario.getId());
		testeUnitario.setData(testeUnitario.getData());
		testeUnitario.setPassou(testeUnitario.getPassou());
		final TesteUnitario update = repository.save(valor);
		return ResponseEntity.ok(update);
	}



	@DeleteMapping("/testeUnitario/{id}")
	public Map < String, Boolean > delete(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		
		TesteUnitario testeUnitario = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id -> " + id));

		repository.delete(testeUnitario);
		Map < String, Boolean > response = new HashMap < > ();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
