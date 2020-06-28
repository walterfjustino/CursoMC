package com.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursomc.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;	//estratégia de geração do banco de dados

	@Bean // METODO RESPONSÁVEL PARA INSTANCIAR O BANCO DE DADOS NO PROFILE TEST
	public boolean InstantiateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {	// testa se a variavel strategy não for igual a create, não tem nenhuma ação
			return false;
			
		}
		
		dbService.instantiateTestDatabase();
		return true;
	}

}
