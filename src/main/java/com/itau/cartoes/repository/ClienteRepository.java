package com.itau.cartoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.cartoes.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
