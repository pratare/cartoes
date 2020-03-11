package com.itau.cartoes.dto;

import com.itau.cartoes.dto.request.CartaoRequest;
import com.itau.cartoes.dto.response.CartaoResponse;
import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.models.Cliente;

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

}
