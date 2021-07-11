package br.com.stefanini.provaqtres.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.stefanini.provaqtres.dto.ClienteDto;
import br.com.stefanini.provaqtres.dto.ItemProdutoDto;
import br.com.stefanini.provaqtres.dto.VendaDto;
import br.com.stefanini.provaqtres.model.Produto;
import br.com.stefanini.provaqtres.view.Tela;

public class TelaController {
	ClienteDto clientedto;
	VendaDto vendadto;
	List<Produto> carrinho = new ArrayList<>();
	List<ItemProdutoDto> carrinhoItemDto = new ArrayList<>();
	
	public void escolhaDoUsuario(int opcao, ClienteDto clientedto, Scanner sc) throws Exception{
		this.clientedto = clientedto;
		switch(opcao) {
		case 1:
			System.out.println("A Opção 1-VERIFICAR PRODUTOS foi a escolhida.\n");
			ProdutoController pcontroller = new ProdutoController();

			List<Produto> produtos = new ArrayList<>();
			produtos = pcontroller.recuperarProdutosDisponiveisLista();
			
			Tela.gerarTelaVerificarProdutos(produtos);
			
			System.out.println("Você gostaria de escolher algum produto da lista? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			int resposta = sc.nextInt();
			sc.nextLine();
			int id;
			carrinhoItemDto = pcontroller.inserirProdutoNoCarrinho(resposta, sc);
			break;
		case 2:
			System.out.println("A Opção 2-VER CARRINHO foi a escolhida.\n");
			CarrinhoController carrinhoController = new CarrinhoController();
			carrinhoController.calcularCarrinho(carrinhoItemDto);
			break;
		case 3:
			System.out.println("A Opção 3-COMPRAR foi a escolhida.\n");
			VendaController vendacontroller = new VendaController();
			vendadto = vendacontroller.realizarCompra(this.clientedto);

			ItemProdutoController itemcontroller = new ItemProdutoController();
			carrinhoItemDto = itemcontroller.inserirItemProdutoNoBanco(vendadto,carrinhoItemDto);
			
			Double valorDaVenda = vendacontroller.calcularValorVenda(carrinhoItemDto);
			vendadto.setValorDaVenda(valorDaVenda);
			
			vendacontroller.updateValorDaVenda(vendadto);
			
			System.out.println("\nO valor da sua compra é: " + valorDaVenda);
			
			break;
		case 4:
			System.out.println("O Programa será encerrado.");
			System.exit(0);
			break;
		default:
			System.out.println("Default");
			break;
		}
	}
	
	public List<Integer> adicionarIdProdutoNoCarrinho() {
		return null;
	}
}
