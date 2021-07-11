package br.com.stefanini.provaqtres.controller;

import java.util.Scanner;

import br.com.stefanini.provaqtres.dto.ClienteDto;
import br.com.stefanini.provaqtres.dto.EnderecoDto;
import br.com.stefanini.provaqtres.model.Cliente;
import br.com.stefanini.provaqtres.model.Endereco;
import br.com.stefanini.provaqtres.persistence.ClienteDao;

public class CadastroController {
	ClienteDto clienteDto = null;
	EnderecoDto enderecoDto;
	
	public ClienteDto cadastroClienteEndereco(Scanner sc) throws Exception {
		System.out.println("Você já é um usuário cadastrado? ");
		
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		int resposta = sc.nextInt();
		sc.nextLine();
		if(resposta==1) {
			ClienteController clientecontroller = new ClienteController();
			clienteDto = clientecontroller.verificarClienteNoBanco(sc);
		}else {
			Cliente cliente = new Cliente();
			cliente = cadastrarCliente(sc);
			
			Endereco endereco = new Endereco();
			endereco = cadastrarEndereco(sc,cliente);
			
			clienteDto = new ClienteDto(cliente.getId(),cliente.getNome(),cliente.getEmail(),cliente.getSenha(),cliente.getUuid(),endereco.getBairro(),endereco.getCidade());
			clienteDto.gerarCriptografia();
			
			enderecoDto = new EnderecoDto();
			enderecoDto.setBairro(endereco.getBairro());
			enderecoDto.setCep(endereco.getCep());
			enderecoDto.setCidade(endereco.getCidade());
			
		}
		
		return clienteDto;
	}

	public Cliente cadastrarCliente(Scanner sc) {
		System.out.println("\nQual é o seu nome?");
		
		String nome = sc.nextLine();
		
		System.out.print("Olá, "+nome+"!");
		System.out.println();
		
		System.out.print("Qual é o seu email? ");
		String email = sc.nextLine();
		System.out.println();
		
		System.out.print("Escreva uma senha para a sua conta: ");
		String senha = sc.nextLine();
		System.out.println();
		
		Cliente cliente = new Cliente(null,nome,email,senha);
		
		return cliente;
	}

	private Endereco cadastrarEndereco(Scanner sc, Cliente cliente) {

		System.out.println("Ok, agora vamos ao cadastro do seu Endereço");
		System.out.println();
		
		System.out.println("Informe o seu cep: ");
		String cep = sc.nextLine();
		System.out.println();
		
		System.out.println("Sua cidade: ");
		String cidade = sc.nextLine();
		System.out.println();

		System.out.println("Seu bairro: ");
		String bairro = sc.nextLine();
		System.out.println();
		
		return new Endereco(null,bairro,cidade,cep,cliente);
	}
	
	public Integer cadastrarUsuarioEnderecoBancoDeDados(ClienteDto clientedto) throws Exception {
		ClienteDao clientedao = new ClienteDao();
		int chave = clientedao.createCliente(clientedto, enderecoDto);
		System.out.println("\nMuito bem, "+clientedto.getNome()+" usuário cadastrado com sucesso.\n");	
		return chave;
	}
	
}
