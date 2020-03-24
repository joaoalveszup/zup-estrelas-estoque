package br.com.estrelas.estoque;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuProdutoAlimenticio {

	public static Scanner input = new Scanner(System.in);

	public static ProdutoAlimenticio criaProdutoAlimenticio() {

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

		System.out.println(" Digite a origem do produto (ex: fazenda, ceasa): ");
		String origem = input.next();

		return new ProdutoAlimenticio(precoCusto, precoVenda, nomeProduto, codigoDeBarrasProduto, dataValidadeProduto,
				origem);
	}

	public static void menuAlimentacao() {

		int opcaoProdAlim;

		EstoqueAlimenticio estoqueAlimenticio = new EstoqueAlimenticio();

		System.out.println("");
		System.out.println(" Voc� escolheu opera��es relacionadas a produtos aliment�cios. ");
		
		do {
			System.out.println(" Escolha a opera��o que deseja realizar:  \n");
			System.out.println(" ");
			System.out.println("\n Para cadastrar produto, digite 1");
			System.out.println("\n Para alterar o pre�o de TODOS os produtos, digite 2");
			System.out.println("\n Para remover produto, digite 3");
			System.out.println("\n Para obter uma lista de todos os produtos, digite 4 ");
			System.out.println("\n Para alterar o pre�o de um produto espec�fico, digite 5 ");
			System.out.println("\n Para consultar produto atrav�s do c�digo de barras, digite 6");
			//XXX: Corrigir o texto para "guardar um arquivo com os produtos."
			System.out.println("\n Para guardar um novo produto no estoque de produtos, digite 7");
			System.out.println("\n Para saber a quantidade de produtos em estoque, digite 8");
			System.out.println("\n Para retornar ao menu anterior, digite 9");

			opcaoProdAlim = input.nextInt();
			input.nextLine();
			switch (opcaoProdAlim) {

			case 1:

				ProdutoAlimenticio produto = MenuProdutoAlimenticio.criaProdutoAlimenticio();
				estoqueAlimenticio.cadastraProduto(produto);
				break;

			case 2:

				System.out.println(" Digite uma porcentagem para alterar o pre�o de todos os produtos: ");
				Scanner newInput = new Scanner(System.in);
				String result = newInput.next();
				Float porcentagem = Float.parseFloat(result);
				estoqueAlimenticio.alteraPrecoProdutos(porcentagem, true);

				break;

			case 3:
				System.out.println(" Digite o c�digo de barras para remover o produto: ");
				long codigoDeBarras = input.nextLong();
				estoqueAlimenticio.removeProduto(codigoDeBarras);

				break;

			case 4: 
				List<ProdutoAlimenticio> produtos = estoqueAlimenticio.listaProdutos();
				
				if(produtos.size() > 0) {

					for(ProdutoAlimenticio prod : produtos ) {
						System.out.println(prod.toString());
					}
				}else {

					System.out.println("Estoque vazio.");
				}
				
				break;

			case 5:

				System.out.println(" Digite uma porcentagem para alterar o pre�o de um produto:");
				float porcentagemProdUnit = input.nextFloat();

				System.out.println(" Digite o c�digo de barras do produto: ");
				long codigoDeBarrasProdUnit = input.nextLong();

				estoqueAlimenticio.alteraPrecoProduto(porcentagemProdUnit, true, codigoDeBarrasProdUnit);

				break;

			case 6:

				System.out.println(" Digite o c�digo de barras para consultar o produto: ");
				long codigoDeBarrasConsulta = input.nextLong();
				ProdutoAlimenticio prod = estoqueAlimenticio.consultaProduto(codigoDeBarrasConsulta);
				if(prod == null) {
					System.out.println("produto n�o encontrado");
				}else {
					System.out.println(prod.toString());
				}
				break;

			case 7:

				try {
					estoqueAlimenticio.gravaListaProdutos();
				} catch (IOException e) {
					System.out.println(" N�o foi poss�vel gravar o produto! ");
				}
				break;

			case 8:

				int qtdEstoque = estoqueAlimenticio.quantidadeProdutosEmEstoque();
				System.out.println("A quantidade de produtos em estoque � igual a: " + qtdEstoque);
				break;

			case 9:

				break;



			default:
				System.out.println("Op��o inv�lida.");
				break;
			}
 
		} while (opcaoProdAlim != 9);

	}

}
