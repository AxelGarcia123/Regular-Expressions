package modelo;

import java.util.regex.*;
import java.util.Random;

public class Expresiones{
	public static void main(String args[]){		
		Random random = new Random();
		String cadena = "";
		int i = 0;

		while(i < 1000) {
			int num = random.nextInt(3);
			System.out.println(num);
			if(num == 0) 
				cadena += "a";
			else if(num == 1)
				cadena += "b";
			else if(num == 2)
				cadena += "c";
			else
				continue;
			i++;
		}
		
		String resultado = "";
		Pattern patron = Pattern.compile("a*bc+|ab+c");
		Matcher encaja = patron.matcher(cadena);
		while(encaja.find()) {
			resultado += encaja.group() + "\n";
		}
		
		System.out.println(resultado);
	}
}