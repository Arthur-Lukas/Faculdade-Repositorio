/***********************************************************************************
- [ ]  2)Faça um programa que leia o código dos produtos pedidos e as quantidades desejadas
calcule e mostre o valor a ser pago por produto (preço*quantidade) e o total do pedido.
Considere que o cliente deve informar quando o pedido deve ser encerrado.
    
    Produto | Código | Preço (unitário)
    
    Cachorro quente    |    1   | R$ 1,50
    Hamburguer         |    2   | R$ 2,00
    Cheeseburger       |    3   | R$ 2,50
    Eggcheeseburger    |    4   | R$ 3,00
    Refrigerante       |    5   | R$ 1,50
*************************************************************************************/

package Introdução_a_java;

import java.util.Scanner;

public class Maquina_de_lanches
{
    public static void main(String[]args)
    {
        Scanner ler=new Scanner(System.in);
        int opcao=1,quantidade;
        double p1=1.5,p2=2,p3=2.5,p4=3,p5=1.5,total1,total2,total3,total4,total5;
        double total=0;
        while(opcao!=0)
        {
            System.out.println("Produto            | Código | Preço (unitário)");
            System.out.println("Cachorro quente    |    1   | R$ 1,50");
            System.out.println("Hamburguer         |    2   | R$ 2,00");
            System.out.println("Cheeseburger       |    3   | R$ 2,50");
            System.out.println("Eggcheeseburger    |    4   | R$ 3,00");
            System.out.println("Refrigerante       |    5   | R$ 1,50");
            System.out.println("Digite zero para fechar a sua conta");
            System.out.println("Qual produto você vai querer? Digite uma opção: ");
            opcao=ler.nextInt();
        
            switch(opcao)
            {
                case 1:
                    System.out.println("Cachorro quente");
                    System.out.println("Quantos? ");
                    quantidade=ler.nextInt();
                    total1=quantidade*p1;
                    System.out.println("Sua compra está em R$"+total1+" de Cachorro quente");                  
                    total=total+total1;
                    break;
                case 2:
                    System.out.println("Hamburguer");
                    System.out.println("Quantos? ");
                    quantidade=ler.nextInt();
                    total2=quantidade*p2;
                    System.out.println("Sua compra está em R$"+total2+" de Hamburguer\n");
                    total=total+total2;
                    break;
                case 3:
                    System.out.println("Cheeseburguer");
                    System.out.println("Quantos? ");
                    quantidade=ler.nextInt();
                    total3=quantidade*p3;
                    System.out.println("Sua compra está em R$"+total3+" de Cheeseburger\n");
                    total=total+total3;
                    break;
                case 4:
                    System.out.println("Eggcheeseburger");
                    System.out.println("Quantos? ");
                    quantidade=ler.nextInt();
                    total4=quantidade*p4;
                    System.out.println("Sua compra está em R$"+total4+" de Eggcheeseburguer\n");
                    total=total+total4;
                    break;
                case 5:
                    System.out.println("Refrigerante");
                    System.out.println("Quantos? ");
                    quantidade=ler.nextInt();
                    total5=quantidade*p5;
                    System.out.println("Sua compra está em de R$"+total5+" de Refrigerante\n");
                    total=total+total5;
                    break;
                case 0:
                    opcao=0;
                    System.out.println("Sua compra ficou no total de R$"+total);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }   
        }ler.close();
    }
}
