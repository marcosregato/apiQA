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
import com.br.apiQA.model.Cenario;
import com.br.apiQA.repositories.CenarioRepository;


@RestController
@RequestMapping(path = "/api/cenario")
public class CenarioController {
	
	@Autowired
	private CenarioRepository repository;
	
	@GetMapping
	public List<Cenario> listarTodos() throws ResourceNotFoundException {
		return repository.findAll();
	}

	@GetMapping(path = "/cenario/{id}")
	public ResponseEntity<Cenario> getId(@PathVariable(value = "id") Long id) 
			throws ResourceNotFoundException {

		Cenario idProjeto = repository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("TesteUnitario não encontrado para este id -> " + id));
		return ResponseEntity.ok().body(idProjeto);
	}

	@PostMapping("/cenario")
	public Cenario salvar(@Valid @RequestBody Cenario valor) 
			throws ResourceNotFoundException {
		return repository.save(valor);
	}

	@PutMapping(path = "/cenario/{id}")
	public ResponseEntity<Cenario> update(@PathVariable(name = "id") Long id, @Valid @RequestBody Cenario valor) 
			throws ResourceNotFoundException {
		Cenario cenario = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id -> " + id));

		cenario.setId(cenario.getId());
		cenario.setNome(cenario.getNome());
		final Cenario update = repository.save(valor);
		return ResponseEntity.ok(update);
	}

	@DeleteMapping("/projeto/{id}")
	public Map < String, Boolean > delete(@PathVariable(name = "id") Long id) 
			throws ResourceNotFoundException {
		Cenario projeto = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id -> " + id));

		repository.delete(projeto);
		Map < String, Boolean > response = new HashMap < > ();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
