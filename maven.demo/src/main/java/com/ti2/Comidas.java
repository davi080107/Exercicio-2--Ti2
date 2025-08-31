package com.ti2;

public class Comidas {
	private int numero;
	private String nome;
	private String tipo;
	private String ambiente;
	private int quantidade;
	
	public Comidas() {
	    this.numero = -1;        
	    this.nome = "";          
	    this.tipo = "";  
	    this.quantidade = 0;
	    this.ambiente = "";
	}
	
	public Comidas(int numero, String nome, String tipo , String ambiente, int quantidade) {
		this.numero = numero;
		this.nome = nome;
		this.tipo= tipo;
		this.ambiente= ambiente;
		this.quantidade = quantidade;
	}

	public int getIdentificador() {
		return numero;
	}

	public void setIdentificador(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente( String ambiente) {
		this.ambiente = ambiente;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Comidas [identificador=" + numero + ", nome=" + nome + ", tipo=" + tipo + ", ambiente="+ ambiente +", quantidade=" + quantidade + "]";
	}	
}
