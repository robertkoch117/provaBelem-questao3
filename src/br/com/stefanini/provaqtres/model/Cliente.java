package br.com.stefanini.provaqtres.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private String uuid;
	
	private Endereco endereco;
	
	public Cliente() {

	}


	public Cliente(Integer id, String nome, String email, String senha, String uuid, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.uuid = uuid;
		this.endereco = endereco;
	}

	public Cliente(Integer id, String nome, String email, String senha, String uuid) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.uuid = uuid;
	}

	public Cliente(Integer id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
