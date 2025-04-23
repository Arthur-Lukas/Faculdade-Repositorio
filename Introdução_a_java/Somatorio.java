package Introdução_a_java;

import java.util.Scanner;

public class Somatorio 
{
    public static void main(String[]args)
    {
        Scanner ler=new Scanner(System.in);
        
        int soma = 0, valor;
        
        do
        {
            System.out.println("\n----MENU----");
            System.out.println("Digite qualquer valor para somar");
            System.out.println("Digite 0 para sair: ");
            valor = ler.nextInt();
            //Esse "soma+=valor" quer dizer que a soma vai receber o valor que ela já tem, mais o valor que o usuário digitar
            soma += valor;
            System.out.println("A soma está em "+soma);
        // O "while" é que faz o texto ficar sempre voltando depois de dar a resposta
        }while(valor!=0); //E esse valor 0 depois do "while" é para fazer o texto para de vir, ou seja, é a condição parar/sair o programa
        ler.close();
    }
}
