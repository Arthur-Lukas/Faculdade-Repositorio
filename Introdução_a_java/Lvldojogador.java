import java.util.Scanner;  

public class Lvldojogador {    
    public static void main(String[] args) {    
        //Declaring String variable  
        Scanner entra = new Scanner(System.in);
        System.out.print("Escreva o nível do jogador: Muito fraco ou Dá pro gasto ou Tá saindo da jaula o monstro\n\n ----> "); 
        String levelString = entra.nextLine();  
        
        //String levelString="Expert";  
        int level=0;  
        //Using String in Switch expression  
        switch(levelString){    
        //Using String Literal in Switch case  
        case "Muito fraco": level=1;  
        break;    
        case "Dá pro gasto": level=2;  
        break;    
        case "Tá saindo da jaula o monstro": level=3;  
        break;    
        default: level=0;  
        break;  
        }    
        System.out.println("Seu nível é: "+level);  
        entra.close();
    }    
}   