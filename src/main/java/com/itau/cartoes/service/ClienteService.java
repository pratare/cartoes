package com.itau.cartoes.service;

import java.net.URI;
import java.util.Optional;

import com.itau.cartoes.dto.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;

import com.itau.cartoes.exception.UserNotFoundException;
import com.itau.cartoes.models.Cliente;
import com.itau.cartoes.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ClienteRequest clienteRequest;
	
	public Optional<Cliente> buscarCliente(Integer id) {
		Optional<Cliente> user = clienteRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		return clienteRepository.findById(id);
	}

	public Cliente cadastrar(Cliente cliente) {

		return cliente = clienteRepository.save();

//		URI location = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(clienteCriado.getId()).toUri();

//		return ResponseEntity.created(location).build();
	}

}
