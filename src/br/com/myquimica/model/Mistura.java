package br.com.myquimica.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mistura {
	
	private int id;
	private String nome;
	private String formula;
	
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
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	
}
