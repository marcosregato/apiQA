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

import com.br.apiQA.documents.TesteUnitario;
import com.br.apiQA.responses.ResponseTesteUnitario;
import com.br.apiQA.services.TesteUnitarioService;

@RestController
@RequestMapping(path = "/api/testeunitario")
public class TesteUnitarioController {
	
	@Autowired
	private TesteUnitarioService service;
	
	@GetMapping
	public ResponseEntity<ResponseTesteUnitario<List<TesteUnitario>>> listarTodos() {
		return ResponseEntity.ok(new ResponseTesteUnitario<List<TesteUnitario>>(this.service.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseTesteUnitario<TesteUnitario>> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new ResponseTesteUnitario<TesteUnitario>(this.service.listarPorId(id)));
	}
	
	@PostMapping
	public ResponseEntity<ResponseTesteUnitario<TesteUnitario>> cadastrar(@Valid @RequestBody TesteUnitario valor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseTesteUnitario<TesteUnitario>(erros));
		}
		
		return ResponseEntity.ok(new ResponseTesteUnitario<TesteUnitario>(this.service.cadastrar(valor)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ResponseTesteUnitario<TesteUnitario>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody TesteUnitario valor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseTesteUnitario<TesteUnitario>(erros));
		}
		
		valor.setId(id);
		return ResponseEntity.ok(new ResponseTesteUnitario<TesteUnitario>(this.service.atualizar(valor)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseTesteUnitario<Integer>> remover(@PathVariable(name = "id") String id) {
		this.service.remover(id);
		return ResponseEntity.ok(new ResponseTesteUnitario<Integer>(1));
	}

}
