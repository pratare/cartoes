package com.itau.cartoes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.cartoes.dto.CartaoMapper;
import com.itau.cartoes.dto.request.CartaoRequest;
import com.itau.cartoes.dto.response.CartaoDetalheResponse;
import com.itau.cartoes.dto.response.CartaoResponse;
import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.service.CartaoService;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoService cartaoService;
	
	@Autowired
	private CartaoMapper cartaoMapper;
	
	@GetMapping("/{numero}")
	public CartaoDetalheResponse exibeCartao(@PathVariable String numero) {
        Cartao cartao = cartaoService.mostrarCartao(numero);
        return cartaoMapper.toCartaoDetalheResponse(cartao);

	}

	@PostMapping
	public CartaoResponse cadastrarNovoCartao(@Valid @RequestBody CartaoRequest cartaoRequest){
		Cartao cartao = cartaoMapper.toCartao(cartaoRequest);
		cartao = cartaoService.criarCartao(cartao);
		return cartaoMapper.toCartaoResponse(cartao);
	}
	
//	@PatchMapping("/{numero}")
//	public ResponseEntity<Object> ativarCartao(@Valid @RequestBody boolean ativo){
//		return cartaoService.ativarCartao(ativo);
//	}

}
