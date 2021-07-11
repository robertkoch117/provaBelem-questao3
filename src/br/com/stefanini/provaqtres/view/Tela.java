package br.com.stefanini.provaqtres.view;

import java.util.List;

import br.com.stefanini.provaqtres.model.Produto;

public class Tela {
	
	public static void gerarTelaPrincipal(String nome){
		System.out.println("         Olá, " + nome + "! 	");
		System.out.println("*==============================*");
		System.out.println("|    Qual opção você deseja?   |");
		System.out.println("|  1 - VERIFICAR PRODUTOS      |");
		System.out.println("|  2 - VER CARRINHO            |");
		System.out.println("|  3 - COMPRAR                 |");
		System.out.println("|  4 - SAIR                    |");
		System.out.println("*==============================*\n");
	}
	
	public static void gerarTelaVerificarProdutos(List<Produto> produtos) {
		System.out.println("*============================================================*");
		System.out.println("                      Tela de Produtos                         \n");
		for(Produto p : produtos){
			System.out.println("Produto ID: " + p.getIdProduto());
			System.out.println("Nome: " + p.getNome());
			System.out.println("Preco: " + p.getPreco());
			System.out.println("Quantidade no Estoque: " + p.getQtdEstoque());
			System.out.println("_________________________________________________________");
		}
		
		
		System.out.println("*============================================================*");
	}
	
}
