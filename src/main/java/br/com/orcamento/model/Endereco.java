package br.com.orcamento.model;

public class Endereco {

	private Enum<TipoEndereco> tipo;
	private String endereco;
	private String numero;
	private String complemento;
	private String referencia;
	
	
	public Endereco(Enum<TipoEndereco> tipo, String endereco, String numero, String complemento, String referencia) {
		this.tipo = tipo;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.referencia = referencia;
	}
	
//---------------------------------------------------------------------------------------------------
//Getters and Setters
//---------------------------------------------------------------------------------------------------

	public Enum<TipoEndereco> getTipo() {
		return tipo;
	}
	public void setTipo(Enum<TipoEndereco> tipo) {
		this.tipo = tipo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
}
