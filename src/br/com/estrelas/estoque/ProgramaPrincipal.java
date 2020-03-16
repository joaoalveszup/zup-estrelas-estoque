package br.com.estrelas.estoque;

import java.util.Scanner;

public class ProgramaPrincipal {
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println(" BEM-VINDO(A) AO MERCADO! ");
		System.out.println("");
		
		String opcao;
		do {

			System.out.println(" Digite ALIMENTICIO para as operações relacionadas a produtos alimentícios ");
			System.out.println(" Digite LIMPEZA para as operações relacionadas a produtos de limpeza ");
			System.out.println(" SAIR para cancelar as operações ");
			
			opcao = input.next();
			
			

			if(opcao.toLowerCase().equals("alimenticio")) {
				MenuProdutoAlimenticio.menuAlimentacao();
				
			}else if(opcao.toLowerCase().equals("limpeza")){
				
				MenuProdutoLimpeza.menuLimpeza();
			}else if(opcao.toLowerCase().equals("sair")) {
				System.out.println("até logo !");
			}

			
			
		} while (!opcao.toLowerCase().equals("sair"));
	}
}