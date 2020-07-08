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

import com.br.apiQA.documents.Projeto;
import com.br.apiQA.responses.ResponseProjeto;
import com.br.apiQA.services.ProjetoService;

@RestController
@RequestMapping(path = "/api/projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoService service;
	
	@GetMapping
	public ResponseEntity<ResponseProjeto<List<Projeto>>> listarTodos() {
		return ResponseEntity.ok(new ResponseProjeto<List<Projeto>>(this.service.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseProjeto<Projeto>> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new ResponseProjeto<Projeto>(this.service.listarPorId(id)));
	}
	
	@PostMapping
	public ResponseEntity<ResponseProjeto<Projeto>> cadastrar(@Valid @RequestBody Projeto valor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseProjeto<Projeto>(erros));
		}
		
		return ResponseEntity.ok(new ResponseProjeto<Projeto>(this.service.cadastrar(valor)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ResponseProjeto<Projeto>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Projeto valor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseProjeto<Projeto>(erros));
		}
		
		valor.setId(id);
		return ResponseEntity.ok(new ResponseProjeto<Projeto>(this.service.atualizar(valor)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseProjeto<Integer>> remover(@PathVariable(name = "id") String id) {
		this.service.remover(id);
		return ResponseEntity.ok(new ResponseProjeto<Integer>(1));
	}

}
