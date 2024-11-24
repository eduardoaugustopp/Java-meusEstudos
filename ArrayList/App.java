package com.arraylist.pacote;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayEstatico = new String[5];
		arrayEstatico[0] = "Teste1";
		arrayEstatico[1] = "Teste2";
		arrayEstatico[2] = "Teste3";
		arrayEstatico[3] = "Teste4";
		arrayEstatico[4] = "Teste5";

//		arrayEstatico[5] = "Teste6"; erro

		System.out.println("Imprimindo o Array Estático");
		for (int indice = 0; indice < arrayEstatico.length; indice++) {
			System.out.println(arrayEstatico[indice]);
		}

		ArrayList<String> arrayDinamico = new ArrayList<>();
		arrayDinamico.add("Teste6");
		arrayDinamico.add("Teste7");
		arrayDinamico.add("Teste8");
		arrayDinamico.add("Teste9");
		arrayDinamico.add("Teste10");
		arrayDinamico.add("Teste11");

		System.out.println("Imprimindo o ArrayList");

		System.out.println("Removido Teste6");
		arrayDinamico.remove(0);

//        arrayDinamico.clear();

		System.out.println(arrayDinamico.size());

//        for (int indice = 0; indice < arrayDinamico.size(); indice++) {
//            System.out.println(arrayDinamico.get(indice));
//        }

		for (String nome : arrayDinamico) {
			System.out.println(nome);
		}



		




	}

}
