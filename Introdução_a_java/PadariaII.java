import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        // Declarando as variáveis que serão inteiras porque é a quantidade de cada pão
        int paofrances, integral, doceliso, docefarofa, ciabatta;

        // 1. Entrada com a quantidade de cada pão. O usuário deverá entrar com a quantidade que ele quer
        System.out.print("Quantos pães franceses gostaria de comprar? ");
        paofrances = scanner.nextInt();
        System.out.print("Quantos pães integrais gostaria de comprar? ");
        integral = scanner.nextInt();
        System.out.print("Quantos pães doce liso gostaria de comprar? ");
        doceliso = scanner.nextInt();
        System.out.print("Quantos pães doce farofa gostaria de comprar? ");
        docefarofa = scanner.nextInt();
        System.out.print("Quantos pães ciabatta gostaria de comprar? ");
        ciabatta = scanner.nextInt();

        // 2. Saída com o número de cada tipo e pão e seu respectivo valor de venda
        double soma1 = paofrances * 1.05;
        double soma2 = integral * 1.05;
        double soma3 = doceliso * 1.10;
        double soma4 = docefarofa * 1.13;
        double soma5 = ciabatta * 0.96;

        System.out.println("\nVocê comprou " + paofrances + " pães franceses, dando um total de: R$" + df.format(soma1));
        System.out.println("Você comprou " + integral + " pães integrais, dando um total de: R$" + df.format(soma2));
        System.out.println("Você comprou " + doceliso + " pães doce liso dando um total de: R$" + df.format(soma3));
        System.out.println("Você comprou " + docefarofa + " pães doce farofa, dando um total de: R$" + df.format(soma4));
        System.out.println("Você comprou " + ciabatta + " pães ciabatta, dando um total de: R$" + df.format(soma5));

        // 3. Saída com o valor total da compra supondo que um mesmo cliente comprou vários tipos de pães.
        double total = soma1 + soma2 + soma3 + soma4 + soma5;
        double arredonda = Double.parseDouble(df.format(total));
        System.out.println("\nO total da sua compra foi de R$" + arredonda + " reais");
    }
}