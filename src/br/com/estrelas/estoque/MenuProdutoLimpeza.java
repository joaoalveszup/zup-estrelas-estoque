package br.com.estrelas.estoque;

import java.io.IOException;
import java.util.Scanner;

public class MenuProdutoLimpeza {

	public static Scanner input = new Scanner(System.in);

	public static ProdutoLimpeza criaProdutoLimpeza() {

		System.out.println(" Digite o preço de custo do produto: ");
		float precoCusto = input.nextFloat();

		System.out.println(" Digite o preço de venda: ");
		float precoVenda = input.nextFloat();

		System.out.println(" Digite o nome do produto: ");
		String nomeProduto = input.next();

		System.out.println(" Digite o código de barras: ");
		long codigoDeBarrasProduto = input.nextInt();

		System.out.println(" Digite a data de validade: ");
		String dataValidadeProduto = input.next();

		System.out.println(" Digite o aroma: ");
		String aroma = input.next();

		System.out.println(" Digite a área em que o produto é utilizado: ");
		String parteDaCasa = input.next();

		return new ProdutoLimpeza(precoCusto, precoVenda, nomeProduto, codigoDeBarrasProduto,
				dataValidadeProduto, aroma, parteDaCasa);
	}

	public static void menuLimpeza() {

		Scanner teclado = new Scanner(System.in);

		int opcaoProdLimp;

		EstoqueLimpeza estoqueLimpeza = new EstoqueLimpeza();

		System.out.println("");
		System.out.println(" Você escolheu operações relacionadas a produtos de limpeza. ");

		do {
			System.out.println(" Escolha a operação que deseja realizar:  \n");
			System.out.println(" ");
			System.out.println("\n Para cadastrar produto, digite 1");
			System.out.println("\n Para alterar o preço de TODOS os produtos, digite 2");
			System.out.println("\n Para remover produto, digite 3");
			System.out.println("\n Para obter uma lista de todos os produtos, digite 4 ");
			System.out.println("\n Para alterar o preço de um produto específico, digite 5 ");
			System.out.println("\n Para consultar produto através do código de barras, digite 6");
			System.out.println("\n Para guardar um novo produto no catálogo de produtos, digite 7");
			System.out.println("\n Para saber a quantidade de produtos em estoque, digite 8");
			System.out.println("\n Para retornar ao menu anterior, digite 9");
			System.out.println("\n Para sair digite 0");

			opcaoProdLimp = teclado.nextInt();

			switch (opcaoProdLimp) {

			case 1:

				ProdutoLimpeza produto = MenuProdutoLimpeza.criaProdutoLimpeza();
				estoqueLimpeza.cadastraProduto(produto);
				break;

			case 2:

				System.out.println(" Digite uma porcentagem para alterar o preço de todos os produtos: ");
				float porcentagem = input.nextFloat();
				estoqueLimpeza.alteraPrecoProdutos(porcentagem, true);

				break;

			case 3:
				System.out.println(" Digite o código de barras para remover o produto: ");
				long codigoDeBarras = input.nextLong();
				estoqueLimpeza.removeProduto(codigoDeBarras);

				break;

			case 4:
				estoqueLimpeza.listaProdutos();

				break;

			case 5:

				System.out.println(" Digite uma porcentagem para alterar o preço de um produto:");
				float porcentagemProdUnit = input.nextFloat();

				System.out.println(" Digite o código de barras do produto: ");
				long codigoDeBarrasProdUnit = input.nextLong();

				estoqueLimpeza.alteraPrecoProduto(porcentagemProdUnit, true, codigoDeBarrasProdUnit);

				break;

			case 6:

				System.out.println(" Digite o código de barras para consultar o produto: ");
				long codigoDeBarrasConsulta = input.nextLong();
				estoqueLimpeza.consultaProduto(codigoDeBarrasConsulta);

				break;

			case 7:

				try {
					estoqueLimpeza.gravaListaProdutos();
				} catch (IOException e) {
					System.out.println(" Não foi possível gravar o produto! ");
				}
				break;

			case 8:
				
				estoqueLimpeza.quantidadeProdutosEmEstoque();
				break;

			case 9:

				break;

			case 10:

				break;

			default:
				System.out.println("Opção inválida.");
				break;
			}

		} while (opcaoProdLimp == 0);

	}

}
