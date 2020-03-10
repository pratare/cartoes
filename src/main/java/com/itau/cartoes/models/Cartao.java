package com.itau.cartoes.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cartao {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String numeroCartao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Cliente cliente;
	
	public Cartao() {
		
	}

	public Cartao(String numeroCartao) {
		super();
		this.numeroCartao = numeroCartao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
}
