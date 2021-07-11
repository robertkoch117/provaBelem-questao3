package br.com.stefanini.provaqtres.dto;

import java.math.BigInteger;
import java.security.MessageDigest;

public class ClienteDto {
	private Integer idCliente;
	private String nome;
	private String email;
	private String senha;
	private String uuid;
	private String bairro;
	private String cidade;

	public ClienteDto() {
		super();
	}

	public ClienteDto(Integer idCliente, String nome, String email, String senha, String uuid, String bairro,
			String cidade) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.uuid = uuid;
		this.bairro = bairro;
		this.cidade = cidade;
	}
	
	public ClienteDto(Integer idCliente, String nome, String email, String senha) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "ClienteDto [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", bairro=" + bairro + ", cidade=" + cidade + "]";
	}

	public void gerarCriptografia() throws Exception{
		String chave = "robertkoch@gmail.com;www.robertkoch.com.@=1=1;*123+;";
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		this.setSenha(this.getSenha() + chave);
		byte[] messageDigest = md5.digest(this.senha.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashText = no.toString(16);
		while(hashText.length()<32) {
			hashText = "0"+hashText;
		}
		this.setSenha(hashText);
	}
}
