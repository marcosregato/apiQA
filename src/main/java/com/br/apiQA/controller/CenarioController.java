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

import com.br.apiQA.documents.Cenario;
import com.br.apiQA.responses.ResponseCenario;
import com.br.apiQA.services.CenarioService;


@RestController
@RequestMapping(path = "/api/cenario")
public class CenarioController {
	
	@Autowired
	private CenarioService service;
	
	@GetMapping
	public ResponseEntity<ResponseCenario<List<Cenario>>> listarTodos() {
		return ResponseEntity.ok(new ResponseCenario<List<Cenario>>(this.service.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseCenario<Cenario>> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new ResponseCenario<Cenario>(this.service.listarPorId(id)));
	}
	
	@PostMapping
	public ResponseEntity<ResponseCenario<Cenario>> cadastrar(@Valid @RequestBody Cenario valor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseCenario<Cenario>(erros));
		}
		
		return ResponseEntity.ok(new ResponseCenario<Cenario>(this.service.cadastrar(valor)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ResponseCenario<Cenario>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Cenario valor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseCenario<Cenario>(erros));
		}
		
		valor.setId(id);
		return ResponseEntity.ok(new ResponseCenario<Cenario>(this.service.atualizar(valor)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseCenario<Integer>> remover(@PathVariable(name = "id") String id) {
		this.service.remover(id);
		return ResponseEntity.ok(new ResponseCenario<Integer>(1));
	}

}
