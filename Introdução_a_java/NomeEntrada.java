import java.util.*;
public class NomeEntrada
{
    public static void main(String args[])
    {
        //Scanner é um "método", que está declarando a "variável" entry como uma "variável" de leitura
        Scanner entry = new Scanner(System.in);
        //Entrada do nome
        System.out.println("Put your name: ");
        String name = entry.nextLine(); //Lembrando que "string" é para conseguir entrar com vários carcteres
        //Entrada da idade
        System.out.println("Entry with your age: ");
        int idade = entry.nextInt();
        //Entrada do salário
        System.out.println("Entry with your salary: ");
        double sal = entry.nextDouble();
        System.out.println("Name is "+ name+", and my age is "+idade);
        System.out.println("My salary ir $"+sal);
        entry.close(); //esse "entry" pode ser substituido por qualquer coisa para declarar uma variável que consiga "ler", o que o usuário colocar, mas terá de substituir o outro 'entry' la encima
    }
}
