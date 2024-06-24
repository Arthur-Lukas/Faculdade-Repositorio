import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char parar = 'N'; // Initialize parar with 'N'

        while (parar != 'S') { // While parar is not 'S', continue executing the program
            System.out.println("Deseja parar o laço? (S/N)");
            parar = scanner.next().charAt(0); // Read the first character of input as char
        }
    }
}