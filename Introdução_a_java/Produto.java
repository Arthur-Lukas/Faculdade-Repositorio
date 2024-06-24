/*Desenvolver um Sistema de Gerenciamento de Estoque:
Crie uma classe Produto com atributos como nome, preço e quantidadeEmEstoque.
Implemente métodos para adicionar produtos, atualizar preços e verificar o estoque.
Crie objetos dessa classe para simular um sistema de gerenciamento de estoque.*/

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    //Método construtor
    public Produto(String nome, double preco, int quantidadeEmEstoque) 
    {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Método para adicionar produtos ao estoque
    public void adicionarProduto(int quantidade)
    {
        quantidadeEmEstoque += quantidade;
        System.out.println(quantidade + " unidades do produto " + nome + " adicionadas ao estoque.");
    }

    // Método para atualizar o preço do produto
    public void atualizarPreco(double novoPreco) 
    {
        preco = novoPreco;
        System.out.println("Preço do produto " + nome + " atualizado para R$" + preco);
    }

    // Método para verificar o estoque
    public void verificarEstoque() 
    {
        System.out.println("Produto: " + nome);
        System.out.println("Preço: R$" + preco);
        System.out.println("Quantidade em estoque: " + quantidadeEmEstoque);
    }

    // Testando a classe 
    public static void main(String[] args) 
    {
        Produto produto1 = new Produto("Bolsa", 91.99, 130);
        produto1.verificarEstoque();

        produto1.adicionarProduto(20); 
        produto1.verificarEstoque();

        produto1.atualizarPreco(120.00); 
        produto1.verificarEstoque(); 

        Produto produto2 = new Produto("Tênis", 200, 50);
        produto2.verificarEstoque(); 
    }
}
