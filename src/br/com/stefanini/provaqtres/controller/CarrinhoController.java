package br.com.stefanini.provaqtres.controller;

import java.text.DecimalFormat;
import java.util.List;

import br.com.stefanini.provaqtres.dto.ItemProdutoDto;
import br.com.stefanini.provaqtres.model.Produto;

public class CarrinhoController {

	public void calcularCarrinho(List<ItemProdutoDto> carrinho) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		System.out.println("*********** Carrinho de Compras************");
		
		Double valorAcumulado=0.0;
		int qtdProdutosCarrinho = 0;
		for(ItemProdutoDto p : carrinho) {
			System.out.println("Nome do produto: " + p.getNome());
			System.out.println("Preco do produto: " + df.format(p.getPreco()));
			System.out.println("Quantidade pedida: "+ p.getQuantidade());
			valorAcumulado += p.getPreco() * p.getQuantidade();
			qtdProdutosCarrinho+= p.getQuantidade();
			System.out.println("Valor acumulado: "+df.format(valorAcumulado)+"\n");
		}
		
		System.out.println("\nQuantidade de produtos: " + qtdProdutosCarrinho);
		System.out.println("Valor Final: "+df.format(valorAcumulado));
		
		System.out.println("******************************************");
		
	}
}
