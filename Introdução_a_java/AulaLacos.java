package Introdução_a_java;

import java.util.Scanner;

public class AulaLacos 
{    
   public static void main(String[] args) 
    {
        System.out.println("Eaeeeee!\n");
        System.out.println("-----------------------------\n");
        
        for( int i = 1 ; i<10; i+=2)
        {
            System.out.print(i);
        }            
            System.out.println("\n----------------------------\n");
        
        for(int i=20; i>=11; i--)
        {
            System.out.print(i);
        }
            System.out.println("\n------------------------------\n");
     int soma = 0;
     for(int i=1; i<=10; i++)
        {
         soma = soma+=i;
        }
         System.out.print("A soma dos numeros de 1 a 10 e: \n"+ soma);
         System.out.println("\n-----------------------------------\n");
         
         soma = 0;
         for(int i = 2; i<=100; i++)
         {
             if(i%2==0)
             {
                 soma+=i;
                 
                 /***Se colocar pra mostra a resposta dentro dos {} 
                 vai mostrar todas as operações matemáticas que chegaram no resultado**/
                 System.out.println("A soma dos numeros pares entre 1 e 100 e de: "+soma);
             }
        } 
          System.out.println("\n-------------------------\n");
    
    //Calcular o fatorial de 5, utilizando o for
    int fatorial = 1;
    for (int i=1; i<=5; i++)
        {
        fatorial *=i;
        }
        {
        System.out.println("O fatorial de 1 a 5 e: "+fatorial);
        }
        System.out.println("\n--------------------------------------------------------\n");
        
        Scanner ler = new Scanner(System.in);
        
        System.out.print("Digite o valor que deseja calcular o fatorial: ");
        int valor = ler.nextInt();
        
        fatorial = 1;
        for (int i = valor; i>1; i--)
        {
            fatorial *= i;
        }
        System.out.println("\nO fatorial de " + valor + " e: \n" + fatorial);
        
        /**********************************************************************
         Usando FOR, construa um algoritmo que o usuário informa 5 valores, 
         ao final o algoritmo imprime o maior e o menor valor inserido e a média dos valores
         **********************************************************************/
        ler.close();
    }
}