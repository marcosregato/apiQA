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
import com.br.apiQA.model.Projeto;
import com.br.apiQA.repositories.ProjetoRepository;

@RestController
@RequestMapping(path = "/api/projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository repository;
	
	@GetMapping
	public List<Projeto> listarTodos() throws ResourceNotFoundException {
		return repository.findAll();
	}

	@GetMapping(path = "/projeto/{id}")
	public ResponseEntity<Projeto> getId(@PathVariable(value = "id") Long id) 
			throws ResourceNotFoundException {

		Projeto idProjeto = repository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("TesteUnitario não encontrado para este id -> " + id));
		return ResponseEntity.ok().body(idProjeto);
	}

	@PostMapping("/projeto")
	public Projeto salvar(@Valid @RequestBody Projeto valor) 
			throws ResourceNotFoundException {
		return repository.save(valor);
	}

	@PutMapping(path = "/projeto/{id}")
	public ResponseEntity<Projeto> update(@PathVariable(name = "id") Long id, @Valid @RequestBody Projeto valor) 
			throws ResourceNotFoundException {
		Projeto projeto = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id -> " + id));

		projeto.setId(projeto.getId());
		projeto.setNome(projeto.getNome());
		final Projeto update = repository.save(valor);
		return ResponseEntity.ok(update);
	}

	@DeleteMapping("/projeto/{id}")
	public Map < String, Boolean > delete(@PathVariable(name = "id") Long id) 
			throws ResourceNotFoundException {
		Projeto projeto = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id -> " + id));

		repository.delete(projeto);
		Map < String, Boolean > response = new HashMap < > ();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
