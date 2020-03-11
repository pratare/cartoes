package com.itau.cartoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.itau.cartoes.models.Pagamento;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer>{

}
