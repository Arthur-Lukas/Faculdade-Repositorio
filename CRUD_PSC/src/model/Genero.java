package model;

public class Genero {
    private int id;
    private String nomeGe;

    public Genero(){
        this.nomeGe = "Sem gênero definido";
    }

    public Genero(int id, String nomeGe){
        this.id = id;
        this.nomeGe = nomeGe;
    }

    //Método acessor Getters (GET)
    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nomeGe;
    }

    //Método modificador Setter (SET);
    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nomeGe = nome;
    }
}