package com.cursomc.domain;

import javax.persistence.Entity;

import com.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {	//Implementando Serializable (padrão: 1L)	
	private static final long serialVersionUID = 1L;

	
	/*Atributos básicos*/
	
	private Integer numeroDeParcelas;
	
	/*CONSTRUTORES (não incluso coleções no construtor com parâmetros)*/
	
	//Construtor vazio
	
	public PagamentoComCartao() {
		
	}
	
	//Construtor com parâmetros

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	/*Getters e setters*/

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	/* Não é necessário implementar hashCode e equals, pois será herdada da Classe Pagamento*/
	
	
	
}
