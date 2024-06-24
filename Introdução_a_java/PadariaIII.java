import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declarando as variáveis que serão inteiras porque é a quantidade de cada pão
        int paofrances = 0, integral = 0, doceliso = 0, docefarofa = 0, ciabatta = 0;
        int opcao;
        
        // Mostre as opções de pães que tem para comprar
        System.out.println("Selecione qual pão deseja comprar");
        System.out.println("1 - Pão francês R$ 1,05");
        System.out.println("2 - Pão integral R$ 1,05");
        System.out.println("3 - Pão doce liso R$ 1,10");
        System.out.println("4 - Pão doce farofa R$ 1,13");
        System.out.println("5 - Pão ciabatta R$ 0,96");
        System.out.println("\nQualquer outro número para finalizar o programa");

        // 1. Entrada com a quantidade de cada pão. O usuário deverá entrar com a quantidade que ele quer
        //    a - Usar estrutura de seleção múltipla;
        System.out.print("\nQual pão gostaria de comprar? ");
        opcao = scanner.nextInt();

        switch(opcao) {
            // 2. Saída com o número de cada tipo e pão e seu respectivo valor de venda
            case 1:
                System.out.print("Quantos pães franceses gostaria de comprar? ");
                paofrances = scanner.nextInt();
                System.out.println("Você comprou " + paofrances + " pães franceses, dando um total de: R$" + Math.round(paofrances * 1.05 * 100.0) / 100.0);
                break;

            case 2:
                System.out.print("Quantos pães integrais gostaria de comprar? ");
                integral = scanner.nextInt();
                System.out.println("Você comprou " + integral + " pães integrais, dando um total de: R$" + Math.round(integral * 1.05 * 100.0) / 100.0);
                break;

            case 3:
                System.out.print("Quantos pães doce liso gostaria de comprar? ");
                doceliso = scanner.nextInt();
                System.out.println("Você comprou " + doceliso + " pães doce liso, dando um total de: R$" + Math.round(doceliso * 1.10 * 100.0) / 100.0);
                break;

            case 4:
                System.out.print("Quantos pães doce farofa gostaria de comprar? ");
                docefarofa = scanner.nextInt();
                System.out.println("Você comprou " + docefarofa + " pães doce farofa, dando um total de: R$" + Math.round(docefarofa * 1.13 * 100.0) / 100.0);
                break;

            case 5:
                System.out.print("Quantos pães ciabatta gostaria de comprar? ");
                ciabatta = scanner.nextInt();
                System.out.println("Você comprou " + ciabatta + " pães ciabatta, dando um total de: R$" + Math.round(ciabatta * 0.96 * 100.0) / 100.0);
                break;

            default:
                break;
        }
    }
}