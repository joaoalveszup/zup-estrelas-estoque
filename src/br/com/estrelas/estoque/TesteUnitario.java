package br.com.estrelas.estoque;

import java.io.IOException;

public class TesteUnitario {

		// PARABÉNS, ESSA CLASSE DE TESTES É UM DIFERENCIAL
		// TESTAR A NOSSA LÓGICA É SUPER IMPORTANTE
	   public static void main(String[] args) throws IOException {

		// criei meus produtos e meu estoque alimenticio
		
		ProdutoAlimenticio arroz = new ProdutoAlimenticio(5.00f, 10.00f, "arroz", 123, "25/05/2020", "fazenda");

		ProdutoAlimenticio feijao = new ProdutoAlimenticio(5.00f, 10.00f, "feijao", 321, "30/05/2020", "fazenda");

		EstoqueAlimenticio estoqueAlimenticio = new EstoqueAlimenticio();
		
		// testando meus métodos com produtos alimenticios
		
		System.out.println("Produtos alimentícios \n");
		
		System.out.println(estoqueAlimenticio.cadastraProduto(arroz));

		System.out.println(estoqueAlimenticio.cadastraProduto(feijao));

		estoqueAlimenticio.alteraPrecoProdutos(100, true);

		System.out.println(estoqueAlimenticio.removeProduto(321));

		estoqueAlimenticio.alteraPrecoProduto(10, true, 321);

		System.out.println(estoqueAlimenticio.consultaProduto(123));

		System.out.println(estoqueAlimenticio.gravaListaProdutos());

		estoqueAlimenticio.alteraPrecoProduto(100, true, 123);

		System.out.println(estoqueAlimenticio.quantidadeProdutosEmEstoque());
		
		System.out.println(""); 
		
	    // criei meus produtos e meu estoque de limpeza
		
		System.out.println("Produtos de limpeza \n");
		
		ProdutoLimpeza amaciante = new ProdutoLimpeza(10.00f, 20.00f, "amaciante", 123456789, "24/05/2020", "Floral", "lavanderia");

		ProdutoLimpeza detergente = new ProdutoLimpeza(1.00f, 2.00f, "detergente", 987654321, "26/10/2020", "Limão", "cozinha");

		EstoqueLimpeza estoqueLimpeza = new EstoqueLimpeza();
		
		// testando meus métodos somente com produtos de limpeza
		
		System.out.println(estoqueLimpeza.cadastraProduto(amaciante));

		System.out.println(estoqueLimpeza.cadastraProduto(detergente));

		estoqueLimpeza.alteraPrecoProdutos(100, true);

		System.out.println(estoqueLimpeza.removeProduto(123456789));

		estoqueLimpeza.alteraPrecoProduto(10, true, 987654321);

		System.out.println(estoqueLimpeza.consultaProduto(987654321));

		System.out.println(estoqueLimpeza.gravaListaProdutos());

		estoqueLimpeza.alteraPrecoProduto(100, true, 987654321);

		System.out.println(estoqueLimpeza.quantidadeProdutosEmEstoque());
		
	} 
}
