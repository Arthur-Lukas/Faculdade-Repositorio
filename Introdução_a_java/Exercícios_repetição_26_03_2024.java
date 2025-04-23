/***************************************************
 Laço de Repetição
 1. Chico tem 1,50 metros e cresce 2 centímetros por ano, enquanto Zé Ramalho
 tem 1,10 metros e cresce 3 centímetros por ano. Construa um algoritmo que 
 calcule e imprima quantos anos serão necessários para que Zé seja maior que Chico.
 ***************************************************/

package Introdução_a_java;

public class Exercícios_repetição_26_03_2024
{
    public static void main(String[]args)
    {
        double c=150, z=110;
        int a=1;
                while(c>z) //enquanto c for maior que z, rode o que está dentro das chaves ai embaixo
                {
                    //Os 3 ai embaixo são meio que fomas diferentes para se somar
                    c=c+2;
                    z+=3; //É a mesma coisa do de cima "z recebe z + 3"
                    a++; //So se coloca "++" quando quer somar mais 1 apenas. 
                    //Minha dúvida quando tentei fazer sozinho foi "como vou contar os anos, se a conta vai ser entre o chico e o zé?" 
                    //Era só colocar os anos junto do calculo da soma das alturas, pq ai quando parasse iria parar os anos também, eu não tinha pensado nisso
                }System.out.println("Zé será maior que chico daqui a " +a+ " anos"); //Caso contrário, mostre essa mens
    }
}
