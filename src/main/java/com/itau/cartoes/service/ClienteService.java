package com.itau.cartoes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itau.cartoes.exception.UserNotFoundException;
import com.itau.cartoes.models.Cliente;
import com.itau.cartoes.repository.ClienteRepository;


public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Optional<Cliente> buscarCliente(Integer id) {
		Optional<Cliente> user = clienteRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		return clienteRepository.findById(id);
	}

}
