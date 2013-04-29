package br.com.myquimica.model;

public class Aluno {
	private int id;
	private String nome;
	private String matricula;
	private String email;
	
	public Aluno(){
		
	}
	
	public Aluno(String nome, String matricula, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
	}
	
	public Aluno(int id, String nome, String matricula, String email) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
