package br.com.stefanini.provaqtres.persistence;

import java.util.List;

import br.com.stefanini.provaqtres.dto.ClienteDto;
import br.com.stefanini.provaqtres.dto.EnderecoDto;

public interface IClienteDao {
	public ClienteDto findByCode(int code) throws Exception;
	public List<ClienteDto> findAllCliente() throws Exception;
	public Integer createCliente(ClienteDto cliente, EnderecoDto endereco) throws Exception;
	public ClienteDto update(ClienteDto clientedto, EnderecoDto endereco) throws Exception;
}
