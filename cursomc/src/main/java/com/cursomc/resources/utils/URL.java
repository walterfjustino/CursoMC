package com.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {	//classe auxiliar que converte objeto do tipo Integer para um objeto do tipo List Integer
	
	
	public static String decodeParam(String s) {	//METODO PARA DESCODIFICAR UM PARAMETRO
		try {
			return URLDecoder.decode(s, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	
	}
	
	public static List <Integer> decodeIntList (String s){
		String [] vet = s.split(",");	//Split é uma função que pega a String e quebra em diversos pedaços com base no caracter(,)
		List<Integer> list = new ArrayList<>();	// instanciando a lista
		for (int i = 0; i < vet.length; i++) {	//For para percorrer o Vetor 
			list.add(Integer.parseInt(vet[i])); // converte o elemento na posição [i] do vetor para inteiro 
		}										//e o resultado add na lista de numeros inteiros
		return list;							// retona a lista
		
		//mesmo procedimento acima porém Utilizando Expressão lambda
		//para utilizar dessa forma: só substituir todo o código acima permanecendo apenas o public static List <Integer> decodeIntList (String s){
		//return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
	}
	
}
