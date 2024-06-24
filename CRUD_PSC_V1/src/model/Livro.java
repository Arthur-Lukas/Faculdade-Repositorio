package model;
public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private int lancamento;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public int getLancamento(){
        return lancamento;
    }
    public void setLancamento(int lancamento){
        this.lancamento = lancamento;
    }
}
