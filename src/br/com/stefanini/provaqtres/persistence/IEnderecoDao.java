package br.com.stefanini.provaqtres.persistence;

import java.util.List;

import br.com.stefanini.provaqtres.dto.EnderecoDto;

public interface IEnderecoDao {
	
	public EnderecoDto findByCode(int code) throws Exception;
	public List<EnderecoDto> findAllEndereco() throws Exception;
	public Integer createEndereco(EnderecoDto enderecodto) throws Exception;
	public EnderecoDto update(EnderecoDto enderecodto) throws Exception;
	
}
