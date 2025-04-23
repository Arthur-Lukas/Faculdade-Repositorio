public class Pessoa {
    // Atributos
    private String nome;
    private int idade;

    // Construtor
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método para aumentar a idade
    public void aniversario() {
        idade++;
        System.out.println("Feliz aniversário, " + nome + "! Agora você tem " + idade + " anos.");
    }

    // Método para obter a idade
    public int getIdade() {
        return idade;
    }

    // Método para definir o nome
    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public static void main(String[] args) {
        // Criando um objeto Pessoa
        Pessoa pessoa1 = new Pessoa("Alice", 25);

        // Testando o método aniversario()
        pessoa1.aniversario(); // Deve imprimir "Feliz aniversário, Alice! Agora você tem 26 anos."

        // Testando o método getIdade()
        int idadeAtual = pessoa1.getIdade();
        System.out.println("Idade atual: " + idadeAtual); // Deve imprimir "Idade atual: 26"
        // Testando o método setNome()
        pessoa1.setNome("Carol");
        System.out.println("Novo nome: " + pessoa1.nome); // Deve imprimir "Novo nome: Carol"
    }
}

