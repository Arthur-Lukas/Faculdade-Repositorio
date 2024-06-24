
import java.util.Scanner; // Importing Scanner class to read input from the user

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creating a Scanner object to read input
        boolean teste;
        int num;

        System.out.println("Digite qualquer número ai: ");
        num = scanner.nextInt(); // Reading an integer input from the user

        teste = (num > 20);

        System.out.println("O número digitado é maior que vinte? " + teste);
    }
}
