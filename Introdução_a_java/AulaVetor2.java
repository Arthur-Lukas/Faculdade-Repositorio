package Introdução_a_java;
import javax.swing.JOptionPane;
public class AulaVetor2 
{
    public static void main(String[] args) throws Exception 
    {                
        int tam = 20;
        int[] vet = new int[tam];
       
        for( int i = 0; i < tam ; i++)
        {
            vet[i] = ((i+1) * 10);
        }
        String texto = "";
        for( int i = 0; i < tam ; i++)
        {
            System.out.print( vet[i] + " - " );
            texto += vet[i] + " - ";
        }
        texto += "\n\n";
        System.out.println("\n---------------------");
        String[] carros = {"Doblo" , "Renegade" , "Uno", "Hilux"};
        for( int i = 0 ; i < carros.length ; i++){ //esse "length" faz com que não seja necessário declarar o tamanho do vetor, então ele terá o tamanho que for necessário. Como tem 4 carros, ele terá tamanho 4, mas se for adicionado ou tirado algum ele se adaptará. Em outras palavras, não precisa se preocupar com o tamnho do vetor, pois o "legth" retornará exatamente o tamanho deste vetor
            System.out.print( carros[i] + " - " );
            texto += carros [i] + "\n";
        }
        JOptionPane.showMessageDialog(null, texto);
        System.out.println("\n---------------------");
        for (String car : carros) //Outra forma de fazer um "array" sem declarar limite
        {
            System.out.print( car + " tam: " + car.length() + " - " );
        }
        System.out.println("\n---------------------");
        for (int numero : vet)
        {
            System.out.print( numero + " - ");
        }
    }
}
