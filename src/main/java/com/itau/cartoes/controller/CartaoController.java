package com.itau.cartoes.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itau.cartoes.dto.CartaoMapper;
import com.itau.cartoes.dto.request.CartaoRequest;
import com.itau.cartoes.dto.response.CartaoResponse;
import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.models.Cliente;
import com.itau.cartoes.service.CartaoService;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoService cartaoService;
	
	@Autowired
	private CartaoMapper cartaoMapper;
	
	@GetMapping("/{numero}")
	public Optional<Cartao> exibeCartao(@PathVariable CartaoRequest cartaoRequest){
		return cartaoService.mostrarCartao(cartaoRequest);
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
