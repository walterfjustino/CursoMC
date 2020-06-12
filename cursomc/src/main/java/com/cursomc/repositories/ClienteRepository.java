package com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Transactional(readOnly = true) //READONLY: ELA NÃO NECESSITA DE SER ENVOLVIDA COMO UMA TRANSAÇÃO DE BANCO DE DADOS,
	Cliente findByEmail(String email);// DIMINUI O LOCKING DO GERENCIAMENTO DE TRANSAÇÕES DO BANCO DE DADOS

	
}
