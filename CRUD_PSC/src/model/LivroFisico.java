package model; //Erda as características da classe livro

public class LivroFisico extends Livro{

    public double preco;
    private static double peso = 0.700; //este atributo pertence a classe e não aos objetos que serão criados a partir da classe, então não poderá ser alterado fora desta classe

    public LivroFisico(){ //Como este método não retorna nada, vai puxar o método construtor do livro que não recebe parametro
        super(); //E mesmo se encima tiver parametros, o super continuará a pegar o método construtor sem parametro
    }

    public LivroFisico(int id, String titulo, String autor, int lancamento, Genero genero, double preco){ //Os primeiros 5 atributos são da classe mãe 'livro' e depois é as caracteristicas desta classe mesmo
        super(id, titulo, autor, lancamento, genero);
        this.preco = preco;
    }

    public static double getPeso(){
        return peso;
    }

    public static void setPeso(Double novoPeso){
        peso = novoPeso;
    }
}