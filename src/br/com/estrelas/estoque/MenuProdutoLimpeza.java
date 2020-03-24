package br.com.estrelas.estoque;

import java.io.IOException;
import java.util.Scanner;

import java.util.List;

public class MenuProdutoLimpeza {

	public static Scanner input = new Scanner(System.in);

	public static ProdutoLimpeza criaProdutoLimpeza() {

		System.out.println(" Digite o pre�o de custo do produto: ");
		float precoCusto = input.nextFloat();

		System.out.println(" Digite o pre�o de venda: ");
		float precoVenda = input.nextFloat();

		System.out.println(" Digite o nome do produto: ");
		String nomeProduto = input.next();

		System.out.println(" Digite o c�digo de barras: ");
		long codigoDeBarrasProduto = input.nextInt();

		System.out.println(" Digite a data de validade: ");
		String dataValidadeProduto = input.next();

		System.out.println(" Digite o aroma: ");
		String aroma = input.next();

		System.out.println(" Digite a �rea em que o produto � utilizado: ");
		String parteDaCasa = input.next();

		return new ProdutoLimpeza(precoCusto, precoVenda, nomeProduto, codigoDeBarrasProduto,
				dataValidadeProduto, aroma, parteDaCasa);
	}

	public static void menuLimpeza() {

		Scanner teclado = new Scanner(System.in);

		int opcaoProdLimp;

		EstoqueLimpeza estoqueLimpeza = new EstoqueLimpeza();

		System.out.println("");
		System.out.println(" Voc� escolheu opera��es relacionadas a produtos de limpeza. ");

		do {
			System.out.println(" Escolha a opera��o que deseja realizar:  \n");
			System.out.println(" ");
			System.out.println("\n Para cadastrar produto, digite 1");
			System.out.println("\n Para alterar o pre�o de TODOS os produtos, digite 2");
			System.out.println("\n Para remover produto, digite 3");
			System.out.println("\n Para obter uma lista de todos os produtos, digite 4 ");
			System.out.println("\n Para alterar o pre�o de um produto espec�fico, digite 5 ");
			System.out.println("\n Para consultar produto atrav�s do c�digo de barras, digite 6");
			System.out.println("\n Para guardar um novo produto no cat�logo de produtos, digite 7");
			System.out.println("\n Para saber a quantidade de produtos em estoque, digite 8");
			System.out.println("\n Para retornar ao menu anterior, digite 9");
			//XXX: Essa op��o n�o � v�lida nunca (n�o h� case pra ela)
			System.out.println("\n Para sair digite 0");

			opcaoProdLimp = teclado.nextInt();

			switch (opcaoProdLimp) {

			case 1:

				ProdutoLimpeza produto = MenuProdutoLimpeza.criaProdutoLimpeza();
				estoqueLimpeza.cadastraProduto(produto);
				break;

			case 2:

				System.out.println(" Digite uma porcentagem para alterar o pre�o de todos os produtos: ");
				float porcentagem = input.nextFloat();
				estoqueLimpeza.alteraPrecoProdutos(porcentagem, true);

				break;

			case 3:

				System.out.println(" Digite o c�digo de barras para remover o produto: ");
				long codigoDeBarras = input.nextLong();
				estoqueLimpeza.removeProduto(codigoDeBarras);

				break;

			case 4:
				 List<ProdutoLimpeza> produtos = estoqueLimpeza.listaProdutos();
				 
				 if(produtos.size() > 0) {
					 for(ProdutoLimpeza prod : produtos) {
						 System.out.println(prod.toString());
					 }
				 } else {
					System.out.println(" Estoque vazio. "); 
				 }

				break;

			case 5:

				System.out.println(" Digite uma porcentagem para alterar o pre�o de um produto:");
				float porcentagemProdUnit = input.nextFloat();

				System.out.println(" Digite o c�digo de barras do produto: ");
				long codigoDeBarrasProdUnit = input.nextLong();

				estoqueLimpeza.alteraPrecoProduto(porcentagemProdUnit, true, codigoDeBarrasProdUnit);				// 
				break;

			case 6:
				System.out.println(" Digite o c�digo de barras para consultar o produto: ");
				long codigoDeBarrasConsulta = input.nextLong();
				
				ProdutoLimpeza prod = estoqueLimpeza.consultaProduto(codigoDeBarrasConsulta);
				if(prod == null) {
					System.out.println(" produto n�o encontrado");
				} else {
					System.out.println(prod.toString());
				}
				break;

			case 7:

				try {
					estoqueLimpeza.gravaListaProdutos();
				} catch (IOException e) {
					System.out.println(" N�o foi poss�vel gravar o produto! ");
				}
				break;

			case 8:
				
				int qtdEstoque = estoqueLimpeza.quantidadeProdutosEmEstoque();
				System.out.println(" A quantidade de produtos em estoque � igual a: " + qtdEstoque);
				break;

			case 9:

				break;

				
			default:
				System.out.println("Op��o inv�lida.");
				break;
			}

		} while (opcaoProdLimp != 9);

	}

}
