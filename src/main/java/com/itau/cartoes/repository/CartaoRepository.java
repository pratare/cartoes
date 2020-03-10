package com.itau.cartoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.itau.cartoes.models.Cartao;

public interface CartaoRepository extends CrudRepository<Cartao, Integer>{

}
