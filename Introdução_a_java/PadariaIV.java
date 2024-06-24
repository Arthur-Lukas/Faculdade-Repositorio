import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fechar = 1;
        int paofrances, integral, quantidoceliso, quantidocefrfa, ciabatta, opcao, totalpao = 0;
        double totalvalor = 0.0;

        while (fechar != 0) {
            System.out.println("\nSelecione qual pão deseja comprar");
            System.out.println("1 - Pão francês R$ 1,05");
            System.out.println("2 - Pão integral R$ 1,05");
            System.out.println("3 - Pão doce liso R$ 1,10");
            System.out.println("4 - Pão doce farofa R$ 1,13");
            System.out.println("5 - Pão ciabatta R$ 0,96");
            System.out.println("0 - Para finalizar compra");

            System.out.print("\nQual pão gostaria de comprar? ");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    System.out.print("Quantos pães franceses gostaria de comprar? ");
                    paofrances = scanner.nextInt();
                    double soma1 = Math.round(paofrances * 1.05 * 100.0) / 100.0;
                    System.out.println("Você comprou " + paofrances + " pães franceses, dando um total de: R$" + soma1);
                    totalvalor += soma1;
                    totalpao += paofrances;
                    break;

                case 2:
                    System.out.print("Quantos pães integrais gostaria de comprar? ");
                    integral = scanner.nextInt();
                    double soma2 = Math.round(integral * 1.05 * 100.0) / 100.0;
                    System.out.println("Você comprou " + integral + " pães integrais, dando um total de: R$" + soma2);
                    totalvalor += soma2;
                    totalpao += integral;
                    break;

                case 3:
                    System.out.print("Quantos pães doce liso gostaria de comprar? ");
                    quantidoceliso = scanner.nextInt();
                    double soma3 = Math.round(quantidoceliso * 1.10 * 100.0) / 100.0;
                    System.out.println("Você comprou " + quantidoceliso + " pães doce liso, dando um total de: R$" + soma3);
                    totalvalor += soma3;
                    totalpao += quantidoceliso;
                    break;

                case 4:
                    System.out.print("Quantos pães doce farofa gostaria de comprar? ");
                    quantidocefrfa = scanner.nextInt();
                    double soma4 = Math.round(quantidocefrfa * 1.13 * 100.0) / 100.0;
                    System.out.println("Você comprou " + quantidocefrfa + " pães doce farofa, dando um total de: R$" + soma4);
                    totalvalor += soma4;
                    totalpao += quantidocefrfa;
                    break;

                case 5:
                    System.out.print("Quantos pães ciabatta gostaria de comprar? ");
                    ciabatta = scanner.nextInt();
                    double soma5 = Math.round(ciabatta * 0.96 * 100.0) / 100.0;
                    System.out.println("Você comprou " + ciabatta + " pães ciabatta, dando um total de: R$" + soma5);
                    totalvalor += soma5;
                    totalpao += ciabatta;
                    break;

                case 0:
                    System.out.println("\nCompra finalizada!");
                    System.out.println("Quantidade de pães: " + totalpao + " e o valor total da sua compra foi de R$" + totalvalor);
                    fechar = 0;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}