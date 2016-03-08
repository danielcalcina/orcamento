package br.com.orcamento.model;

import java.util.HashMap;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orcamento")
public class Orcamento {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "idCliente")
	private Cliente cliente;
	
	@Column(name = "idItensOrcamento")
	private HashMap<String, ItemOrcamento> itensOrcamento;
	
	@Column(name = "valorTotal")
	private double valorTotal;
	
	@Column(name = "valorMaoDeObra")
	private double valorMaoDeObra;
	
	@Column(name="prazo")
	private float prazo;

	// ---------------------------------------------------------------------------------------------------
	// Metodos
	// ---------------------------------------------------------------------------------------------------

	public Orcamento adicionaItem(ItemOrcamento item) {
		this.itensOrcamento.put(item.getNomeItem(), item);
		return this;
	}

	public Orcamento removeItem(String nomeItem) {
		this.itensOrcamento.remove(nomeItem);
		return this;
	}

	public Orcamento calculaValorTotal() {
		this.valorTotal = 0.0;
		Iterator<ItemOrcamento> itens = this.itensOrcamento.values().iterator();

		while (itens.hasNext()) {
			ItemOrcamento itemOrcamento = itens.next();
			this.valorTotal += itemOrcamento.getValorItem() + (itemOrcamento.getHorasMaoDeObra() * this.valorMaoDeObra);
		}
		return this;
	}

	// ---------------------------------------------------------------------------------------------------
	// Getters and Setters
	// ---------------------------------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public HashMap<String, ItemOrcamento> getItensOrcamento() {
		return itensOrcamento;
	}

	public void setItensOrcamento(HashMap<String, ItemOrcamento> itensOrcamento) {
		this.itensOrcamento = itensOrcamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public double getValorMaoDeObra() {
		return valorMaoDeObra;
	}

	public void setValorMaoDeObra(double valorMaoDeObra) {
		this.valorMaoDeObra = valorMaoDeObra;
	}

	public float getPrazo() {
		return prazo;
	}

	public void setPrazo(float prazo) {
		this.prazo = prazo;
	}

}
