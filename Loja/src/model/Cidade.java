package model;

public class Cidade {

	public int id;
	public String nome;

	// Método construtor que não recebe parâmetro
	public Cidade(){
		this.id = 0;
		this.nome = "Sem nome";
	}

	public Cidade(String nome){
		this.id = 0;
		this.nome = nome;
	}

	public Cidade(int id, String nome){
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString(){
		return "Cidade: \nid: "+ this.id + "\nNome: " + this.nome;
	}
}
