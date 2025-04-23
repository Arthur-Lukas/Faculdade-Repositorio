package model;

public class Produto {
	public int id;
	public String nome;
	public double preco, quantidade;
	public Categoria categoria;

	public Produto(){

	}

	public Produto( String nome ){
		this.nome = nome;
	}

	public Produto( String nome, double preco, double qtd, Categoria cat ){
		this.nome = nome;
		this.preco = preco;
		this.quantidade = qtd;
		this.categoria = cat;
	}
}
