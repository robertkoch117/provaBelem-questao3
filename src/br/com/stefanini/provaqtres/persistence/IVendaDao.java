package br.com.stefanini.provaqtres.persistence;

import java.util.List;

import br.com.stefanini.provaqtres.dto.VendaDto;

public interface IVendaDao {
	public VendaDto findByCode(int code) throws Exception;

	public Integer createVenda(VendaDto vendadto) throws Exception;

	public List<VendaDto> findAllVenda() throws Exception;

	public void updateVenda(VendaDto vendadto) throws Exception;
}
