/*2. *Implementar uma Classe Banco*:
    - Crie uma classe *Banco* com atributos como *nome* e *saldo*.
    - Adicione métodos para depositar, sacar e consultar saldo.
    - Crie objetos dessa classe e teste os métodos.*/
    
public class Banco {//Declaração de variáveis
    
    private String nome;
    private double saldo;

    public Banco(String nome, double saldo) 
    {
        this.nome = nome;
        this.saldo = saldo;
    }

    public void depositar(double adicionar) //Método para depositar(adicionar) na conta
    {
        saldo += adicionar;
        System.out.println("Você fez um depósito de R$" + adicionar + ".");
    }

    public void sacar(double adicionar) //E um método para sacar (subtrair) na conta
    {
        if (adicionar <= saldo) 
        {
            saldo -= adicionar;
            System.out.println("Saque de R$" + adicionar + " realizado com sucesso.");
        } 
        else //Que é o "se não" em portugol
        {
            System.out.println("Saldo insuficiente!");
        }
    }

    public double consultarSaldo() 
    {
        return saldo;
    }

    public static void main(String[] args) 
    {
        Banco conta = new Banco("Minha Conta", 1500.0);
        
        System.out.println("Saldo inicial: R$" + conta.consultarSaldo());

        conta.depositar(100.0);
        System.out.println("Saldo após depósito: R$" + conta.consultarSaldo());

        conta.sacar(400.0);
        System.out.println("Saldo após saque: R$" + conta.consultarSaldo());

        conta.sacar(3000.0); 
    }
}
