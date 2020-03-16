package br.com.estrelas.estoque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EstoqueLimpeza implements Estoque<ProdutoLimpeza> {

	public List<ProdutoLimpeza> produtosLimpeza;

	private static List<ProdutoLimpeza> produtosL = new ArrayList<ProdutoLimpeza>();

	@Override
	public boolean cadastraProduto(ProdutoLimpeza produto) {
		return produtosL.add(produto);
	}
	
	@Override
	public void alteraPrecoProdutos(float porcentagem, boolean aumenta) {
		for (ProdutoLimpeza produto : produtosL) {
			if (aumenta) {
				
				float novoPreco = produto.getPrecoVenda() * ((porcentagem / 100) + 1);
				produto.setPrecoVenda(novoPreco);
				
			} else {
				
				float novoPreco = produto.getPrecoVenda() * (1 - (porcentagem / 100));
				produto.setPrecoVenda(novoPreco);
			}
		}
	}

	@Override
	public boolean removeProduto(long codigoDeBarras) {
		for (int index = 0; index < produtosL.size(); index++) {
			boolean mesmoCodigoDeBarras = produtosL.get(index).getCodigoDeBarras() == codigoDeBarras;
			if (mesmoCodigoDeBarras) {
				produtosL.remove(index);
				return true;
			}
		}

		return false;
	}

	@Override
	public List<ProdutoLimpeza> listaProdutos() {
		return produtosL;
	}

	@Override
	public void alteraPrecoProduto(float porcentagem, boolean aumenta, long codigoDeBarras) {
		for (ProdutoLimpeza produto : produtosL) {
			if (produto.getCodigoDeBarras() == codigoDeBarras) {
				if (aumenta) {

					float novoPreco = produto.getPrecoVenda() * ((porcentagem / 100) + 1);
					produto.setPrecoVenda(novoPreco);

				} else {

					float novoPreco = produto.getPrecoVenda() * (1 - (porcentagem / 100));
					produto.setPrecoVenda(novoPreco);

				}

			}

		}
	}

	@Override
	public ProdutoLimpeza consultaProduto(long codigoDeBarras) {
		for (ProdutoLimpeza produto : produtosL) {
			if (produto.getCodigoDeBarras() == codigoDeBarras) {
				return produto;
			}
		}
		return null;
	}

	@Override
	public boolean gravaListaProdutos() throws IOException {

		FileWriter writer = new FileWriter("C:\\repo\\zup-estrelas-desafio-estoque\\ListaDeProdutos.txt");
		PrintWriter gravarArquivo = new PrintWriter(writer);

		for (ProdutoLimpeza produto : produtosL) {
			gravarArquivo.print(produto);
		}

		writer.close();

		FileReader fileReader = new FileReader("C:\\repo\\zup-estrelas-desafio-estoque\\ListaDeProdutos.txt");
		BufferedReader reader = new BufferedReader(fileReader);

		String linha = reader.readLine();

		while (linha != null) {
			System.out.printf("%s\n", linha);
			linha = reader.readLine();
		}

		fileReader.close();

		return true;
	}

	@Override
	public int quantidadeProdutosEmEstoque() {
		return produtosL.size();
	}
	
	// criei esse método para contabilizar o total de dinheiro que entrou no caixa e estipulei uma constante, que seria a meta diária 
	// que o dono deve atingir em vendas por dia. A partir disso, ele pode saber se atingiu a meta diária,
	// se ele já atingiu mostra uma mensagem e o valor atingido, se já ultrapassou mostra que já cumpriu a meta e o valor
	// e caso não tenha atingido mostra que ainda não cumpriu a meta de vendas diária e quanto falta para atingir
	
	

	@Override
	public float getPrecoVenda() {
		return getPrecoVenda();
	}
}
