package com.itau.cartoes.models;

import com.itau.cartoes.dto.ClienteDetalheResponse;
import com.itau.cartoes.dto.ClienteRequest;
import com.itau.cartoes.dto.ClienteResponse;

public class ClienteMapper {

    public Cliente toCliente(ClienteRequest clienteRequest){
        Cliente cliente = new Cliente();
        cliente.setName(clienteRequest.getName());
        return cliente;
    }

    public ClienteResponse toClienteResponse(Cliente cliente) {
    	ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setId(cliente.getId());
        clienteResponse.setName(cliente.getName());
        return clienteResponse;
    }

    public ClienteDetalheResponse toClienteDetalheResponse(Cliente cliente) {
    	ClienteDetalheResponse clienteDetalheResponse = new ClienteDetalheResponse();
    	clienteDetalheResponse.setId(cliente.getId());
    	clienteDetalheResponse.setName(cliente.getName());
        return clienteDetalheResponse;
    }



}
