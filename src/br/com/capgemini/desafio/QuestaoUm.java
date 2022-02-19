package br.com.capgemini.desafio;

import java.util.Collections;
import java.util.Scanner;

public class QuestaoUm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Integer numeroEscolhido = solicitaValor(scan); 

		montaEscada(numeroEscolhido);
 
	} 

	// Solicita um valor e garante que seja retornado um valor inteiro entre 1 e 100
	public static Integer solicitaValor(Scanner scan) {
		boolean opcaoInvalida = true;

		String quantidadeEscolhida = null;

		while (opcaoInvalida) {

			System.out.println("Quantos degraus você quer que a escada tenha?");
			System.out.println("Obs: escolha um numero inteiro entre 1 e 99");

			quantidadeEscolhida = scan.next();

			boolean valido = isInteger(quantidadeEscolhida);

			if (valido) {
				opcaoInvalida = false;
			} else {
				System.out.println("Valor invalido, favor digitar um numero inteiro");
			}

		}

		return Integer.valueOf(quantidadeEscolhida);
	}

	// valida se o valor passado como parametro é um inteiro
	public static boolean isInteger(String escolha) {
		if (escolha == null || !escolha.matches("[1-99]*")) {
			return false;
		} else {
			return true;
		}
	}
	
	// mostra a escada com a quantidade de degraus que for passado como parametro
	public static void montaEscada(Integer quantidadeDegraus) {
		Integer i = 0;

		while (i <= quantidadeDegraus) {

			String base = String.join("", Collections.nCopies(i, "*"));

			// Faz a validação se o ultimo o i é a base da piramide;
			if (i == quantidadeDegraus) {

				base = String.join("", Collections.nCopies(i, "* "));
				System.out.println(base);

			} else {
				System.out.println(base);
			}

			i++;

		}
	}

}
