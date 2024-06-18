package model;

public class Livro {

    public int id, lancamento;
    public String titulo, autor;
    public Genero genero;

    public Livro(){
        this.titulo = "Sem titulo";
        System.out.println("Título do livro: "+this.titulo);
    }

    public Livro(String titulo){
        this.titulo = titulo;
    }

    public Livro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public Livro(String titulo, String autor, Genero genero){
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public Livro(int id, String titulo, String autor, int lancamento){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.lancamento = lancamento;
    } 

    public Livro(String titulo, String autor, int lancamento, Genero genero){
        this.titulo = titulo;
        this.autor = autor;
        this.lancamento = lancamento;
        this.genero = genero;
    } 

    public Livro(int id, String titulo, String autor, int lancamento, Genero genero){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.lancamento = lancamento;
        this.genero = genero;
    } 
}