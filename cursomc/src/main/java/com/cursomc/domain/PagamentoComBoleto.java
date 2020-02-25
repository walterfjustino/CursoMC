package com.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{	//Implementando Serializable (padrão: 1L)	
	private static final long serialVersionUID = 1L;


	
	/*Atributos básicos*/
	
	private Date dataVencimento;
	private Date dataPagamento;

	/*CONSTRUTORES (não incluso coleções no construtor com parâmetros)*/
	
	//Construtor vazio
	
	public PagamentoComBoleto() {
		
	}

	//Construtor com parâmetros
	
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		
	}
	
	/*Getters e setters*/

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	

	/* Não é necessário implementar hashCode e equals, pois será herdada da Classe Pagamento*/
	
}

