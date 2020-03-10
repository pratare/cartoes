package com.itau.cartoes.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.itau.cartoes.dto.ClienteRequest;
import com.itau.cartoes.dto.ClienteResponse;
import com.itau.cartoes.models.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itau.cartoes.models.Cliente;
import com.itau.cartoes.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteMapper clienteMapper;
	
	@GetMapping("/{id}")
	public Optional<Cliente> exibeCliente(@PathVariable int id) {
		return clienteService.buscarCliente(id);
	}
	
	@PostMapping(HttpStatus.CREATED)
	public ClienteResponse cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
		Cliente cliente = clienteMapper.toCliente(clienteRequest);
		cliente = clienteService.cadastrar(cliente);
		return clienteMapper.toClienteResponse(cliente);
	}
	
}
