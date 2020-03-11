package com.itau.cartoes.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itau.cartoes.dto.PagamentoMapper;
import com.itau.cartoes.dto.request.PagamentoRequest;
import com.itau.cartoes.dto.response.PagamentoResponse;
import com.itau.cartoes.dto.response.PagamentoSummaryInListResponse;
import com.itau.cartoes.models.Pagamento;
import com.itau.cartoes.service.PagamentoService;

@RestController
public class PagamentoController {

	@Autowired
	PagamentoService pagamentoService;
	
	@Autowired
	PagamentoMapper pagamentoMapper;
	
	@PostMapping("/pagamento")
	public PagamentoResponse criarPagamento(@RequestBody PagamentoRequest pagamentoRequest) {
		Pagamento pagamento = pagamentoMapper.toPagamento(pagamentoRequest);
		pagamento = pagamentoService.criarPagamento(pagamento);
		
		return pagamentoMapper.toPagamentoResponse(pagamento);
	}
	
	@GetMapping("/pagamentos/{id_cartao}")
	public List<PagamentoSummaryInListResponse> listByCartaoId(@PathVariable Integer id) {
        List<Pagamento> pagamentos = pagamentoService.listPagamentoByCartaoId(id);
        List<PagamentoSummaryInListResponse> pagamentoSummaryInListResponseList = pagamentos.stream()
                .map(pagamento -> pagamentoMapper.toPagamentoSummaryInListResponse(pagamento))
                .collect(Collectors.toList());
        return pagamentoSummaryInListResponseList;
    }

}