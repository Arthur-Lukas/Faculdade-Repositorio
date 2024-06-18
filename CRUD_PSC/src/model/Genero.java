package model;

public class Genero {
    public int id;
    public String nomeGe;

    public Genero(){
        this.nomeGe = "Sem gênero definido";
    }

    public Genero(int id, String nomeGe){
        this.id = id;
        this.nomeGe = nomeGe;
    }
}