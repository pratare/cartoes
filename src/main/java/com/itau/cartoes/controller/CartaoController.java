package com.itau.cartoes.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itau.cartoes.models.Cartao;
import com.itau.cartoes.service.CartaoService;

@RestController
public class CartaoController {
	
	@Autowired
	CartaoService cartaoService;
	
	/*@GetMapping("/cartao/{numero}")
	public Optional<Cartao> exibeCartao(@PathVariable Cartao cartao){
		return cartaoService.mostrarCartao(cartao);
	}
	
	@PostMapping("/cartao")
	public ResponseEntity<Object> cadastrarNovoCartao(@Valid @RequestBody Cartao cartao){
		return cartaoService.criarCartao(cartao);
	}*/
	
/*	@PatchMapping("/cartao/{numero}")*/


}
