package com.br.apiQA.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.apiQA.documents.Cliente;
import com.br.apiQA.responses.ResponseCliente;
import com.br.apiQA.services.ClienteService;


@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<ResponseCliente<List<Cliente>>> listarTodos() {
		return ResponseEntity.ok(new ResponseCliente<List<Cliente>>(this.service.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseCliente<Cliente>> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new ResponseCliente<Cliente>(this.service.listarPorId(id)));
	}
	
	@PostMapping
	public ResponseEntity<ResponseCliente<Cliente>> cadastrar(@Valid @RequestBody Cliente valor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseCliente<Cliente>(erros));
		}
		
		return ResponseEntity.ok(new ResponseCliente<Cliente>(this.service.cadastrar(valor)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ResponseCliente<Cliente>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Cliente valor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseCliente<Cliente>(erros));
		}
		
		valor.setId(id);
		return ResponseEntity.ok(new ResponseCliente<Cliente>(this.service.atualizar(valor)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseCliente<Integer>> remover(@PathVariable(name = "id") String id) {
		this.service.remover(id);
		return ResponseEntity.ok(new ResponseCliente<Integer>(1));
	}

}
