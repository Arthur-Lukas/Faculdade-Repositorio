package Introdução_a_java;
import javax.swing.JOptionPane;

public class ExercícioVetor
{   
    //ler 10 valores inteiros e ao final da leitura
    //informar o maior núimero lide, o menor número lido,
    //a soma e a média dos números lidos
    public static void main(String[] args)
    {
        int tam = 4;
        int[] numeros = new int[ tam ];
        double soma = 0, maior = 0, menor = 0;
        double media = 0;
        
        int num = 0; //Vamos usar esse 'num' para transformar as 'strings' que o usuário for digitar para 'inteiroq'
        for(int i = 0 ; i < tam ; i++)
        {
            //Essa é uma forma diferente de se pedir para o usuário para dar entrada com um valor. Diferente daquele "Scanner"
            String valor = JOptionPane.showInputDialog("Digite o " + (i+1) + "° valor: ");  //No caso desse "JOptionpane" todo valor que será digitado será uma "String"
            //No caso, a nossa variável de referência ai encima é o "valor" então lidamos é com ela
            if( valor.isEmpty())  //Traduzindo ficaria "se o usuário não digitar nada e der enter"
            { //Ai vai executar isso aq
                num = 0;
            }else{ // Esse "elese" seria um "se não". Mais uma vez traduzindo de robô para humano "se não..."
                num = Integer.valueOf(valor );  //Ele vai pegar o que digitou em 'string', e transformar em 'inteiro', através do 'integer'
                soma += num;
            }
            numeros[i] = num;
            if( i == 0 )
            {
                menor = num;
                maior = num;
            }else{
                if( num < menor )//Isso aqui é mt viage, pra explicar vou ter de dar exemplo. Se o usuário digitou 5,6,7,8, em todos eles passou por esse if, só que ele começou em 0 igual está lá encima, depois foi pra 8, beleza, começamos por ai. No próximo array ele digitou 7, então o que o sistema fez? É isso ai que está sendo executado aqui dentro que vou explicar agora. Se 'num' que no caso é o 7 que a pessoa digitou, for menor que a varíavel 'menor' que no momento está sendo 8 (e a varíavel muda cada vez que tiver um n° menor)
                {
                    menor = num; //Ele executará esta caixa que fará com que a variável 'menor', troque agora para o novo n° menor, que é o '7', e a cada vez que isso acontecer e provar ser verdadeiro trocará.
                }
                if( num > maior )//Mesma coisa que acontece encima, porém troca o sinal para guardar na variável 'maior'
                {
                    maior = num;
                }
            }
        }
        String texto = "";
        for (int val : numeros) //isso quer dizer que pode declarar quantos n° quiser
        {
            texto += val +" - ";
        }
        texto += "\n\nSoma: " + soma + "\nMaior" + maior + "\nMenor: " + menor;
        media = soma / tam;
        texto += "\nMédia: " + media;
        JOptionPane.showMessageDialog(null, texto);
    }
}
