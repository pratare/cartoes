package com.itau.cartoes.dto;

import org.springframework.stereotype.Component;

import com.itau.cartoes.dto.request.CartaoRequest;
import com.itau.cartoes.dto.response.CartaoDetalheResponse;
import com.itau.cartoes.dto.response.CartaoResponse;
import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.models.Cliente;

@Component
public class CartaoMapper {
	
	public Cartao toCartao(CartaoRequest cartaoRequest){
		Cartao cartao = new Cartao();
		cartao.setNumeroCartao(cartaoRequest.getNumero());
			
		Cliente cliente = new Cliente();
        cliente.setId(cartaoRequest.getClienteId());

        cartao.setCliente(cliente);

        return cartao;
    }
	
	public CartaoResponse toCartaoResponse(Cartao cartao) {
		CartaoResponse cartaoResponse = new CartaoResponse();
		cartaoResponse.setId(cartao.getId());
		cartaoResponse.setNumero(cartao.getNumeroCartao());
		cartaoResponse.setAtivo(false);
		cartaoResponse.setClienteId(cartao.getCliente().getId());
        return cartaoResponse;
    }
	
	public CartaoDetalheResponse toCartaoDetalheResponse(Cartao cartao) {
		CartaoDetalheResponse cartaoDetalheResponse = new CartaoDetalheResponse();
		cartaoDetalheResponse.setId(cartao.getId());
		cartaoDetalheResponse.setNumero(cartao.getNumeroCartao());
		cartaoDetalheResponse.setClienteId(cartao.getCliente().getId());
		cartaoDetalheResponse.setAtivo(cartao.getAtivo());
        return cartaoDetalheResponse;
    }

}
