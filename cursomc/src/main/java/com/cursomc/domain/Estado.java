package com.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Estado implements Serializable {	//Implementando Serializable (padrão: 1L)	
	private static final long serialVersionUID = 1L;
	
	/*Atributos básicos*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//Gera o Id automaticamente
	private Integer id;
	private String nome;
	
	/*ASSOCIAÇÕES (iniciando às coleções)*/
	
	@JsonBackReference
	@OneToMany(mappedBy="estado")	// Mapeamento 1 para Muitos
	private List<Cidade> cidades = new ArrayList<>();
	
	/*CONSTRUTORES (não incluso coleções no construtor com parâmetros)*/
	
	//Construtor vazio
	
	public Estado() {
		
	}

	//Construtor com parâmetros
	
	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
