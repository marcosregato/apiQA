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

import com.br.apiQA.documents.TesteFuncional;
import com.br.apiQA.responses.ResponseTesteFuncional;
import com.br.apiQA.services.TesteFuncionalService;

@RestController
@RequestMapping(path = "/api/testefuncional")
public class TesteFuncionalController {
	
	@Autowired
	private TesteFuncionalService service;
	
	@GetMapping
	public ResponseEntity<ResponseTesteFuncional<List<TesteFuncional>>> listarTodos() {
		return ResponseEntity.ok(new ResponseTesteFuncional<List<TesteFuncional>>(this.service.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseTesteFuncional<TesteFuncional>> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new ResponseTesteFuncional<TesteFuncional>(this.service.listarPorId(id)));
	}
	
	@PostMapping
	public ResponseEntity<ResponseTesteFuncional<TesteFuncional>> cadastrar(@Valid @RequestBody TesteFuncional valor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseTesteFuncional<TesteFuncional>(erros));
		}
		
		return ResponseEntity.ok(new ResponseTesteFuncional<TesteFuncional>(this.service.cadastrar(valor)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ResponseTesteFuncional<TesteFuncional>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody TesteFuncional valor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseTesteFuncional<TesteFuncional>(erros));
		}
		
		valor.setId(id);
		return ResponseEntity.ok(new ResponseTesteFuncional<TesteFuncional>(this.service.atualizar(valor)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseTesteFuncional<Integer>> remover(@PathVariable(name = "id") String id) {
		this.service.remover(id);
		return ResponseEntity.ok(new ResponseTesteFuncional<Integer>(1));
	}

}
