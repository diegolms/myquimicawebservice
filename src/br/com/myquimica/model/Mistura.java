package br.com.myquimica.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mistura {
	
	private int id;
	private String nome;
	private String mistura;	
	private String dica;
	private String informacao;
	
	public Mistura(){
		
	}
	
	
	public Mistura(int id, String nome, String mistura, String dica,
			String informacao) {
		this.id = id;
		this.nome = nome;
		this.mistura = mistura;
		this.dica = dica;
		this.informacao = informacao;
	}
	
	
	public Mistura(String nome, String mistura, String dica, String informacao) {
		super();
		this.nome = nome;
		this.mistura = mistura;
		this.dica = dica;
		this.informacao = informacao;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMistura() {
		return mistura;
	}
	public void setMistura(String mistura) {
		this.mistura = mistura;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	public String getInformacao() {
		return informacao;
	}
	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}
	
	
	
}
