import java.util.Scanner;//importando a biblioteca "Java.util.Scanner", para que o usuário consiga fazer a entrada de dados

public class Main 
{ //Declarando a classe aluno
    static class Aluno 
    {
        float media; // variável para guardar a média do aluno
        int faltas; // variável para guardar a quantidade de faltas
    }

    // Método para contar a quantidade de alunos aprovados
    static int contaprov(Aluno[] alunos, int limite) 
    {
        int aprov = 0; // Variável para guardar a quantidade de alunos aprovados

        // Loop sobre cada aluno
        for (int i = 0; i < limite; i+=1) 
        {
            // Cálculo para saber se o aluno está apto a fazer a prova de recuperação
            if (alunos[i].media >= 40 && alunos[i].faltas <= 15) 
            {
                // Se a média é maior ou igual a 70, e menor ou igual a 100, o aluno está aprovado
                if (alunos[i].media >= 70 && alunos[i].media <= 100) 
                {
                    aprov+=1; //E será guardado aqui
                }
                // Se a média é menor que 70, mas o aluno tem média superior a 40, ele pode fazer prova final
                else if (alunos[i].media < 70 && alunos[i].media >= 40) 
                {
                    aprov+=1;
                    System.out.println("\nAluno " + (i + 1) + " está apto a fazer a prova final.");
                }
            }
        }return aprov;
    }

    public static void main(String[] args) 
    {
        Scanner entrada = new Scanner(System.in);
        Aluno[] alunos = new Aluno[20]; // array de alunos com limite de 20

        // Entrada de quanto cada aluno tirou na prova e quantas faltas tiveram cada um
        for (int i = 0; i < 20; i+=1) 
        {
            alunos[i] = new Aluno(); // Instanciando um novo aluno

            System.out.print("\nDigite a nota media do aluno " + (i + 1) + ": ");
            alunos[i].media = entrada.nextFloat();

            System.out.print("Quantidade de faltas deste aluno " + (i + 1) + ": ");
            alunos[i].faltas = entrada.nextInt();
        }
        // Método para contar a quantidade de alunos aprovados
        int aprov = contaprov(alunos, 20);

        // Resultado
        System.out.println("\nTotal de alunos aprovados: " + aprov);
    }
}
