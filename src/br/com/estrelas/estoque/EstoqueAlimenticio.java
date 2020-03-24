package br.com.estrelas.estoque;

//XXX: N�o se esque�a de remover os imports n�o utilizados (Ctrl + Shift + o)
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
		//mudar para diret�rio da sua m�quina caro avaliador....
		// REVIEW: HAHAHAH eu ri muito disso, mudei cara aluna :), quando tiver 
		// algum coment�rio desse tipo utilize a chave FIXME para chamar aten��o pra ele.
		// XXX: O �nico ponto aqui � que o nome do arquivo deveria ser produtosAlimenticios.txt
		FileWriter writer = new FileWriter("saida.txt");
		PrintWriter gravarArquivo = new PrintWriter(writer);
		for (ProdutoAlimenticio produto : produtosA) {
			gravarArquivo.print(produto);
		}

		writer.close();


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
