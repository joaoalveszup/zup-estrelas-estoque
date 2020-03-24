package br.com.estrelas.estoque;

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
		// FIXME: mudar o caminho para a sua m�quina caro avaliador c:
		// REVIEW: HAHAHAH eu ri muito disso, mudei cara aluna :), quando tiver 
		// algum coment�rio desse tipo utilize a chave FIXME para chamar aten��o pra ele.
		// XXX: O �nico ponto aqui � que o nome do arquivo deveria ser produtosLimpeza.txt
		FileWriter writer = new FileWriter("saida.txt");
		PrintWriter gravarArquivo = new PrintWriter(writer);

		for (ProdutoLimpeza produto : produtosL) {
			gravarArquivo.print(produto);
		}

		writer.close();

		
		return true;
	}

	@Override  
	public int quantidadeProdutosEmEstoque() {
		return produtosL.size();
	}
	
	// criei esse m�todo para contabilizar o total de dinheiro que entrou no caixa e estipulei uma constante, que seria a meta di�ria 
	// que o dono deve atingir em vendas por dia. A partir disso, ele pode saber se atingiu a meta di�ria,
	// se ele j� atingiu mostra uma mensagem e o valor atingido, se j� ultrapassou mostra que j� cumpriu a meta e o valor
	// e caso n�o tenha atingido mostra que ainda n�o cumpriu a meta de vendas di�ria e quanto falta para atingir
	
	

	@Override
	public float getPrecoVenda() {
		return getPrecoVenda();
	}
}
