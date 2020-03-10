package com.itau.cartoes.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.itau.cartoes.dto.CartaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.service.CartaoService;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoService cartaoService;
	
	@GetMapping("/{numero}")
	public Optional<Cartao> exibeCartao(@PathVariable CartaoRequest cartaoRequest){
		return cartaoService.mostrarCartao(cartaoRequest);
	}

	@PostMapping
	public ResponseEntity<Object> cadastrarNovoCartao(@Valid @RequestBody CartaoRequest cartaoRequest){
		return cartaoService.criarCartao(cartaoRequest);
	}
	
//	@PatchMapping("/{numero}")
//	public ResponseEntity<Object> ativarCartao(@Valid @RequestBody boolean ativo){
//		return cartaoService.ativarCartao(ativo);
//	}

}
