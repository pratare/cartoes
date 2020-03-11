package com.itau.cartoes.service;
import com.itau.cartoes.dto.request.CartaoRequest;
import com.itau.cartoes.exception.UserNotFoundException;
import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.models.Cliente;
import com.itau.cartoes.repository.CartaoRepository;
import com.itau.cartoes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cartao> mostrarCartao(CartaoRequest cartaoRequest) {
        List<Cartao> cartaoBuscado = (List<Cartao>) cartaoRepository.findAll();
        if(cartaoBuscado.get(0).getNumeroCartao() == cartaoRequest.getNumero()) {
            throw new UserNotFoundException("numero cartao - "+ cartaoRequest.getNumero());
        }
        return cartaoRepository.findById(cartaoBuscado.get(0));
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
