public class Main {
    public static void main(String[] args) {
        int vel = 200;
        System.out.println("Velocidade do carro " + vel + "km/h");
        
        if (vel <= 80) {
            System.out.println("Você está dentro do limite de velocidade, não pagará multa! Continue assim!");
        } else if (vel >= 80 && vel <= 80 + 10) {
            System.out.println("Você excedeu o limite de velocidade! Multa média de 150R$");
        } else if (vel >= 80 + 11 && vel <= 80 + 30) {
            System.out.println("Você excedeu o limite de velocidade! Multa grave de 250R$");
        } else if (vel >= 80 + 31) {
            System.out.println("Você excedeu o limite de velocidade! Multa gravíssima de 400R$");
        }
    }
}
