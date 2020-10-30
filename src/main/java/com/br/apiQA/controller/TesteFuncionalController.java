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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.apiQA.error.ResourceNotFoundException;
import com.br.apiQA.model.TesteFuncional;
import com.br.apiQA.repositories.TesteFuncionalRepository;

@RestController
@RequestMapping(path = "/api/testefuncional")
public class TesteFuncionalController {

	@Autowired
	private TesteFuncionalRepository repository;

	@GetMapping
	public List<TesteFuncional> listarTodos() throws ResourceNotFoundException {
		return repository.findAll();
	}

	@GetMapping(path = "/testeFuncional/{id}")
	public ResponseEntity<TesteFuncional> getId(@PathVariable(value = "id") Long id) 
			throws ResourceNotFoundException {

		TesteFuncional idProjeto = repository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("TesteUnitario não encontrado para este id -> " + id));
		return ResponseEntity.ok().body(idProjeto);
	}

	@PostMapping("/testeFuncional")
	public TesteFuncional salvar(@Valid @RequestBody TesteFuncional valor) 
			throws ResourceNotFoundException {
		return repository.save(valor);
	}

	@PutMapping(path = "/testeFuncional/{id}")
	public ResponseEntity<TesteFuncional> update(@PathVariable(name = "id") Long id, @Valid @RequestBody TesteFuncional valor) 
			throws ResourceNotFoundException {
		TesteFuncional projeto = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id -> " + id));

		projeto.setId(projeto.getId());
		projeto.setData(projeto.getData());
		projeto.setHora(projeto.getHora());
		final TesteFuncional update = repository.save(valor);
		return ResponseEntity.ok(update);
	}

	@DeleteMapping("/testeFuncional/{id}")
	public Map < String, Boolean > delete(@PathVariable(name = "id") Long id) 
			throws ResourceNotFoundException {
		TesteFuncional projeto = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id -> " + id));

		repository.delete(projeto);
		Map < String, Boolean > response = new HashMap < > ();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
