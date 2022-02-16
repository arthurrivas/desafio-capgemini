package br.com.capgemini.desafio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuestaoTres {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Digite a palavra que deseja ver quantos anagramas tem nas substrings: ");
		String palavraEscolhida = scan.next();

		Integer quantidadeAnagramas = verificaAnagramasSubstring(palavraEscolhida, palavraEscolhida.length());

		System.out.println("Essa palavra tem " + quantidadeAnagramas + "anagramas dentro de si");

	}

	// valida que uma String é anagrama da outra
	private static boolean saoAnagramas(String caracteresUm, String caracteresDois) {

		char[] listaCharUm = caracteresUm.toCharArray();
		char[] ListaCharDois = caracteresDois.toCharArray();

		Arrays.sort(listaCharUm);
		Arrays.sort(ListaCharDois);

		return Arrays.equals(listaCharUm, ListaCharDois);
	}

	// Vai testar a palavra escolhida com substring dela mesma
	private static int verificaAnagramasSubstring(String s, int p) {
		Integer quantidadeAnagramas = 0;

		ArrayList<String> listaConjuntos = new ArrayList();

		for (int i = 0; i <= s.length() - p; i++) {
			listaConjuntos.add(s.substring(i, i + p));
		}

		for (int i = 0; i < listaConjuntos.size(); i++) {
			for (int c = i + 1; c < listaConjuntos.size(); c++) {

				String comparaUm = listaConjuntos.get(i);
				String comparaDois = listaConjuntos.get(c);

				if (saoAnagramas(comparaUm, comparaDois)) {
					quantidadeAnagramas++; 
				}
			}
		}

		if (p == 1) {
			return quantidadeAnagramas;
		}

		return quantidadeAnagramas + verificaAnagramasSubstring(s, p - 1);

	}

}
