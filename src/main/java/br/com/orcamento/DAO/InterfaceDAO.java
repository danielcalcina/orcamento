package br.com.orcamento.DAO;

import java.util.List;

public interface InterfaceDAO {

	public void gravar(Object obj);
	public void alterar(Object obj);
	public void deletar(Object obj);
	public List<?> listar(Object obj);
	public Object listar(Object obj, String id);
	
}
