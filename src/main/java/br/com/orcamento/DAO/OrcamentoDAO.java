package br.com.orcamento.DAO;

import java.util.List;

import br.com.orcamento.model.Orcamento;

public class OrcamentoDAO implements InterfaceDAO {

	GenericDAO dao = new GenericDAO();

	public void gravar(Object orcamento) {
		orcamento = new Orcamento();
		dao.gravar(orcamento);
	}

	public void alterar(Object orcamento) {
		orcamento = new Orcamento();
		dao.alterar(orcamento);
	}

	public void deletar(Object orcamento) {
		orcamento = new Orcamento();
		dao.deletar(orcamento);
	}

	@SuppressWarnings("unchecked")
	public List<Orcamento> listar(Object orcamento) {
		orcamento = new Orcamento();
		return (List<Orcamento>) dao.listar(orcamento.getClass());
	}

	public Orcamento listar(Object orcamento, String id) {
		orcamento = new Orcamento();
		return (Orcamento) dao.buscarId(orcamento.getClass(), id);
		
	}
}
