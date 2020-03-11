package com.itau.cartoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.cartoes.dto.PagamentoMapper;
import com.itau.cartoes.dto.request.PagamentoRequest;
import com.itau.cartoes.dto.response.PagamentoResponse;
import com.itau.cartoes.models.Pagamento;
import com.itau.cartoes.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	PagamentoService pagamentoService;
	
	@Autowired
	PagamentoMapper pagamentoMapper;
	
	@PostMapping
	public PagamentoResponse criarPagamento(@RequestBody PagamentoRequest pagamentoRequest) {
		Pagamento pagamento = pagamentoMapper.toPagamento(pagamentoRequest);
		pagamento = pagamentoService.criarPagamento(pagamento);
		
		return pagamentoMapper.toPagamentoResponse(pagamento);
	}
	
	
	
}
