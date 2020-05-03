package com.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity											 // Essa anotação @Inheritance(strategy=InheritanceType.JOINED 
@Inheritance(strategy=InheritanceType.JOINED)	 //define se às tabelas Herdadas(PagamentoComCartão e PagamentoComBoleto) será 1 tabela para cada*/
public abstract class Pagamento implements Serializable { //Implementando Serializable (padrão: 1L)	
	private static final long serialVersionUID = 1L;


	/*Atributos básicos*/
	
	@Id
	private Integer id;
	private Integer estado;
	
	/*ASSOCIAÇÕES (iniciando às coleções)*/
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId
	private Pedido pedido;
	
	/*CONSTRUTORES (não incluso coleções no construtor com parâmetros)*/
	
	//Construtor vazio
	
	public Pagamento() {
		
	}

	//Construtor com parâmetros
	
	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = (estado == null) ? null : estado.getCod();
		this.pedido = pedido;
	}
	
	/*Getters e setters*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	/* hashCode e equals (implementação padrão: somente id) */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	
	
	
}
