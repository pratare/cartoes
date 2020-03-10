package com.itau.cartoes.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itau.cartoes.models.Cliente;
import com.itau.cartoes.service.ClienteService;


@RestController
public class ClienteController {

@Autowired
ClienteService clienteService;
	
	@GetMapping("/cliente/{id}")
	public Optional<Cliente> exibeCliente(@PathVariable int id) {
		return clienteService.buscarCliente(id);
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<Object> cadastrarCliente(@Valid @RequestBody Cliente cliente) {
		return clienteService.cadastrar(cliente);
	}
	
	
	
}
