package Introdução_a_java;
import javax.swing.JOptionPane;

public class AulaVetor
{
    public static void main(String[]args)throws Exception
    {
        // Em C: int vet[5];
        
        //Em java:
        int[] vet = new int[5];
        
     
//        vet[0] = 10;
//        vet[1] = 20;
//        vet[2] = 30;
//        vet[3] = 40;
//        vet[4] = 50;

        //"Pq começa no zero?" todas as linguagens baseadas em C, começam em zero
        for( int i = 0; i < 5 ; i++)
        {
            vet[i] = (i+1) * 10;
        }
        //Para criar a janelinha tem que colocar isso ai embaixo,
        //a "String" é um conjunto de caracteres
        String texto = "";
        for( int i = 0; i < 5 ; i++)
        {
            System.out.print( vet [i] + " - " );
            texto += vet[i] + " - ";
        }
        //E depois de tudo o que vc quiser mostrar,
        //Coloque essa parada ai de baixo
        JOptionPane.showMessageDialog(null, texto);
        
    }
}
