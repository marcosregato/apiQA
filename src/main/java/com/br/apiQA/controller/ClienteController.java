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
import com.br.apiQA.model.Cliente;
import com.br.apiQA.repositories.ClienteRepository;


@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public List<Cliente> listarTodos() throws ResourceNotFoundException {
		return repository.findAll();
	}

	@GetMapping(path = "/cliente/{id}")
	public ResponseEntity<Cliente> getId(@PathVariable(value = "id") Long id) 
			throws ResourceNotFoundException {

		Cliente idProjeto = repository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("TesteUnitario não encontrado para este id -> " + id));
		return ResponseEntity.ok().body(idProjeto);
	}

	@PostMapping("/cliente")
	public Cliente salvar(@Valid @RequestBody Cliente valor) 
			throws ResourceNotFoundException {
		return repository.save(valor);
	}

	@PutMapping(path = "/cliente/{id}")
	public ResponseEntity<Cliente> update(@PathVariable(name = "id") Long id, @Valid @RequestBody Cliente valor) 
			throws ResourceNotFoundException {
		Cliente cliente = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id -> " + id));

		cliente.setId(cliente.getId());
		cliente.setNome(cliente.getNome());
		cliente.setEmail(cliente.getEmail());
		final Cliente update = repository.save(valor);
		return ResponseEntity.ok(update);
	}

	@DeleteMapping("/cliente/{id}")
	public Map < String, Boolean > delete(@PathVariable(name = "id") Long id) 
			throws ResourceNotFoundException {
		Cliente projeto = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id -> " + id));

		repository.delete(projeto);
		Map < String, Boolean > response = new HashMap < > ();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
