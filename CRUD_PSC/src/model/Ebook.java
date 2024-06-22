package model; //Erda as características da classe livro

public class Ebook extends Livro{
    
    public int paginas;
    private static String format = "PDF";

    public Ebook(){
        super();
    }
    
    public Ebook(int id, String titulo, String autor, int lancamento, Genero genero, int paginas){
        super(id, titulo, autor, lancamento, genero);
        this.paginas = paginas;
    }

    public Ebook(int id, String titulo, String autor, int lancamento, Genero genero, int paginas, String format){
        super(id, titulo, autor, lancamento, genero);
        this.paginas = paginas;
    }

    public static String getFormat(){
        return format;
    }
}