package br.com.capgemini.desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestaoDois {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		solicitaNovaSenha(scan);
		
	}
	
	// responsavel por solicitar a senha e dar um retorno dizendo se eh uma senha valida ou não
	public static void solicitaNovaSenha(Scanner scan) {
		System.out.println("Digite uma senha para testar se ela é valida");
		System.out.println(	"Obs: ela deve conter no minimo 6 caracteres.");
		System.out.println("1 numero, 1 caractere especial uma letra em maiusculo e uma letra minusculo ");
		
		boolean senhaInvalida = true;
		while(senhaInvalida) {
			String senha = scan.next();
			
			if(senhaValida(senha)) {
				System.out.println("Senha Valida! Possui todos os pre-requisitos");
				senhaInvalida = false;
			}else {
				System.out.println("Digite novamente uma senha para testar se ela é valida");
			}
		}
		
		
		

	}
	
	//Possui varias expressoes regulares que serão comparados com a senha fornecida
	public static boolean senhaValida(String senha) {

		// expressao regular que tem todos os caracteres maiusculos 
		String caracteres =  "^(?=.*[A-Z])" + "(?=.*[a-z]).{5,50}$";
		
		// expressao regular que tem todos os numeros de 0 a 9
		String numeros = "^(?=.*[0-9]).{1,50}$";
		
		// expressao regular que tem todos os caracteres especiais 
		String caracteresEspeciais = "^(?=.*[@#$%^&+=]).{1,50}$";

		
		// armazena os erros que uma senha pode ter 
		List<String> listaErros = new ArrayList();
		
		//caso existam erros, seram mostrados ao usuario
		if(senha.length() < 6) {
			listaErros.add("A senha precisa ter pelo menos 6 caracteres");
		}
		
		if(!validaCaracteresPorRegex(senha , caracteres)){
			listaErros.add("A senha precisa ter pelo menos uma letra maiuscula e uma minuscula");
		}
		if(!validaCaracteresPorRegex(senha, numeros)) {
			listaErros.add("A senha precisa ter pelo menos um numero");
		}
		if(!validaCaracteresPorRegex(senha, caracteresEspeciais)) {
			listaErros.add("A senha precisa ter pelo menos um caractere especial");
		}
		
		if(listaErros.size() > 0) {
			listaErros.forEach(x -> {
				System.out.println(x);
			});
			return false;
		}
		return true;
		
	}
	
	//valida se uma string tem os padroes passados pelo parametro
	public static boolean validaCaracteresPorRegex(String senha , String padraoString) {
				String regex = padraoString;

				Pattern p = Pattern.compile(regex);

				Matcher m = p.matcher(senha);

				return m.find();
	}
	
	
	
}
