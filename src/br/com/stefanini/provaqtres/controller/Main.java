package br.com.stefanini.provaqtres.controller;

import java.util.Scanner;

import br.com.stefanini.provaqtres.dto.ClienteDto;
import br.com.stefanini.provaqtres.dto.VendaDto;
import br.com.stefanini.provaqtres.view.Tela;

public class Main {
	public static void main(String[] args) {
		CadastroController cadcontroller = new CadastroController();
		ClienteDto clientedto = new ClienteDto();
		VendaDto vendadto;

		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Ol�, seja bem-vindo ao \nSistema de compras virtual do Robert Koch");
			System.out.println("\nPor favor, primeiro � necess�rio realizar um cadastro.");
			
			clientedto = cadcontroller.cadastroClienteEndereco(sc);
			
			while(clientedto == null) {
				System.out.println("Tente novamente.\n\n");
				clientedto = cadcontroller.cadastroClienteEndereco(sc);
				
			}
			
			Tela.gerarTelaPrincipal(clientedto.getNome());
			int escolha=0;
			escolha = sc.nextInt();

			TelaController telacontroller = new TelaController();
			
			while(escolha!=4) {
				telacontroller.escolhaDoUsuario(escolha, clientedto, sc);
				System.out.println("Voltaremos a Tela Principal\n");
				
				Tela.gerarTelaPrincipal(clientedto.getNome());
				escolha = sc.nextInt();
			}
			sc.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void gerarTela(String nome){
		System.out.println("         Ol�, " + nome + "! 	");
		System.out.println("================================");
		
		System.out.println("|    Qual op��o voc� deseja?   |");
		System.out.println("|  1 - Criar uma pergunta      | ");
		System.out.println("|  2 - Criar uma prova         | ");
		System.out.println("|  3 - Responder uma prova     |");
		System.out.println("|  4 - Sair                    |");
		System.out.println("================================\n");
	}
}
