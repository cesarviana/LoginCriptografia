package com.baumgartner.base.util;

import java.util.Random;

public class GeradorDeSenha {
	
	public static String geraSenha(){
		final char caracs[] = {'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K',
				'L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w',
				'X','x','Y','y','Z','z','1','2','3','4','5','6','7','8','9','0','!','@','#','$','%','&',
				'/','-','+'};
		Random r = new Random();
		int tam = r.nextInt(4) + 6;
		StringBuilder builder = new StringBuilder(); 
		for(int i=0; i<tam; i++){
			int pos = r.nextInt(caracs.length);
			builder.append(caracs[pos]);
		}
		String senha = builder.toString();
		return senha;
	}
	
}
