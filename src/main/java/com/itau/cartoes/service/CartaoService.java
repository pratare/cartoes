package com.itau.cartoes.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itau.cartoes.exception.CartaoNotFoundException;
import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.repository.CartaoRepository;

@Component
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;


    public Cartao mostrarCartao(String numero) {
    	Optional<Cartao> cartaoOptional = cartaoRepository.getByNumero(numero);

        if(!cartaoOptional.isPresent()) {
            throw new CartaoNotFoundException();
        }

        return cartaoOptional.get();

    }

    public Cartao criarCartao(Cartao cartao) {
    	
    	cartao = cartaoRepository.save(cartao);
    	
        return cartao;
    }

//    public ResponseEntity<Object> ativarCartao(boolean ativo) {
//
//        Optional<Cartao> cartaoBuscado = cartaoRepository.findById(id);
//        if(!cartaoBuscado.isPresent()) {
//            throw new UserNotFoundException("id - "+id);
//        }
//        return ResponseEntity.created(location).build();
//    }

}
