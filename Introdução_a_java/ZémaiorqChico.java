public class Main {
    public static void main(String[] args) {
        int c = 150, z = 110, a = 0;

        while (c >= z) {
            c = c + 2;
            z += 3;
            a++;
        }

        System.out.println("Levará " + a + " anos para que Zé fique maior que Chico");
    }
}