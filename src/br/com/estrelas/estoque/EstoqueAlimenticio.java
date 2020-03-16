package br.com.estrelas.estoque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EstoqueAlimenticio implements Estoque<ProdutoAlimenticio> {

	public List<ProdutoAlimenticio> produtosAlimenticios;

	private static List<ProdutoAlimenticio> produtosA = new ArrayList<ProdutoAlimenticio>();

	@Override
	public boolean cadastraProduto(ProdutoAlimenticio produto) {
		return produtosA.add(produto);
	}

	@Override
	public void alteraPrecoProdutos(float porcentagem, boolean aumenta) {
		for (ProdutoAlimenticio produto : produtosA) {
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
		for (int index = 0; index < produtosA.size(); index++) {
			boolean mesmoCodigoDeBarras = produtosA.get(index).getCodigoDeBarras() == codigoDeBarras;
			if (mesmoCodigoDeBarras) {
				produtosA.remove(index);
				return true;
			}
		}

		return false;
	}

	@Override
	public List<ProdutoAlimenticio> listaProdutos() {
		return produtosA;
	}

	@Override
	public void alteraPrecoProduto(float porcentagem, boolean aumenta, long codigoDeBarras) {
		for (ProdutoAlimenticio produto : produtosA) {
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
	public ProdutoAlimenticio consultaProduto(long codigoDeBarras) {
		for (ProdutoAlimenticio produto : produtosA) {
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
		for (ProdutoAlimenticio produto : produtosA) {
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
		return produtosA.size();
	}

	@Override
	public float getPrecoVenda() {
		return getPrecoVenda();
	}
}
