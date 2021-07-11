package br.com.stefanini.provaqtres.controller;

import java.util.Scanner;

import br.com.stefanini.provaqtres.dto.ClienteDto;
import br.com.stefanini.provaqtres.persistence.ClienteDao;

public class ClienteController {
	
	public ClienteDto verificarClienteNoBanco(Scanner sc) throws Exception{
		ClienteDao clientedao = new ClienteDao();
		ClienteDto clientedto = new ClienteDto();
		
		System.out.println("************** Login **************");
		System.out.print("Insira o seu email cadastrado: ");
		String email = sc.nextLine();
		System.out.println("");
		System.out.println("Insira a sua senha: ");
		String senha = sc.nextLine();
		
		clientedto.setEmail(email);
		clientedto.setSenha(senha);
		clientedto.gerarCriptografia();
		
		ClienteDto clientedto2 = new ClienteDto();
		
		clientedto2 = clientedao.findByEmail(clientedto.getEmail());
		
		if((clientedto.getSenha().equals(clientedto2.getSenha())) && (clientedto.getEmail().equals(clientedto2.getEmail()))) {
			System.out.println("Usuário encontrado com sucesso!");
			System.out.println("***********************************");
			return clientedto2;
		}else {
			System.out.println("Usuário não encontrado.");
			System.out.println("***********************************");
			return null;
		}
		
	}
	
}
