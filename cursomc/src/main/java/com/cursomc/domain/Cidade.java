package com.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cidade implements Serializable {	//Implementando Serializable (padrão: 1L)	
	private static final long serialVersionUID = 1L;

	/*Atributos básicos*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //Gera o Id automaticamente
	private Integer id;
	private String nome;
	
	
	/*ASSOCIAÇÕES (iniciando às coleções)*/
		
	@JsonManagedReference	
	@ManyToOne					////Mapeamento Muitos para 1 
	@JoinColumn(name="estado_id")
	private Estado estado;
	
	/*CONSTRUTORES (não incluso coleções no construtor com parâmetros)*/
	
	//Construtor vazio
	
	public Cidade() {
		}
	
	//Construtor com parâmetros

	public Cidade(Integer id, String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}
	
	/*Getters e setters*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
