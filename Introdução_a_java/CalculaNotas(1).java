
import java.util.Scanner;

public class CalculaNotas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o número de alunos da turma: ");
        int numAlunos = entrada.nextInt();
        System.out.print("Digite o número de provas: ");
        int numProvas = entrada.nextInt();
        int aprovados = 0;
        int reprovados = 0;
        for (int i = 1; i <= numAlunos; i++) {
            System.out.println("\nAluno " + i + ":");
            double notaFinal = 0;
            for (int j = 1; j <= numProvas; j++) {
                System.out.print("Digite a nota da prova " + j + " do aluno " + i + ": ");
                double nota = entrada.nextDouble();
                notaFinal += nota;
            }
            double media = notaFinal/numProvas;
            System.out.println("Nota final do aluno " + i + ": " + media);
            if (media >= 70) {
                System.out.println("Aluno aprovado!");
                aprovados++;
            } else {
                System.out.println("Aluno reprovado!");
                reprovados++;
            }
        }
        System.out.println("\nNúmero de alunos aprovados: " + aprovados);
        System.out.println("Número de alunos reprovados: " + reprovados);
        entrada.close();
    }
}

