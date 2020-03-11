package com.itau.cartoes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itau.cartoes.dto.ClienteRequest;
import com.itau.cartoes.exception.UserNotFoundException;
import com.itau.cartoes.models.Cliente;
import com.itau.cartoes.repository.ClienteRepository;

@Component
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ClienteRequest clienteRequest;
	
	public Cliente buscarCliente(Integer id) {
		Optional<Cliente> user = clienteRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		return user.get();
	}

	public Cliente cadastrar(Cliente cliente) {

		cliente = clienteRepository.save(cliente);

        return cliente;
	}

}
