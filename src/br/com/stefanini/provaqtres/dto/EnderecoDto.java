package br.com.stefanini.provaqtres.dto;

import br.com.stefanini.provaqtres.model.Cliente;

public class EnderecoDto {
	
	private Integer idEndereco;
	private String bairro;
	private String cidade;
	private String cep;
	private Cliente cliente;
	
	public EnderecoDto() {
		super();
	}
	
	public EnderecoDto(Integer idEndereco, String bairro, String cidade, String cep, Cliente cliente) {
		super();
		this.idEndereco = idEndereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.cliente = cliente;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "EnderecoDto [idEndereco=" + idEndereco + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep
				+ ", cliente=" + cliente + "]";
	}
	
}
