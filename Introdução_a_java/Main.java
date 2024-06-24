import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i1, i2;
        double r1, r2;

        System.out.print("Escreva um número inteiro: ");
        i1 = scanner.nextInt();

        System.out.print("Escreva o segundo número inteiro: ");
        i2 = scanner.nextInt();

        System.out.print("Escreva agora o primeiro valor real: ");
        r1 = scanner.nextDouble();

        System.out.print("Escreva o segundo valor real: ");
        r2 = scanner.nextDouble();

        int somaint = i1 + i2;

        double somareal = r1 + r2;
        double prodreal = r1 * r2;
        double divreal;

        if (r2 <= 0) {
            System.out.println("Não pode ser 0 ou menor, tente novamente");
        } else {
            divreal = r1 / r2;

            System.out.println("\nValor da soma dos produtos inteiro é: " + somaint);
            System.out.println("Valor da soma dos produtos reais é: " + somareal);
            System.out.println("Valor da multiplicação dos produtos reais é: " + prodreal);
            System.out.println("Valor da divisão dos produtos reais é: " + divreal);
        }
    }
}
