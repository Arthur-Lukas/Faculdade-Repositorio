import java.util.*;  
public class SwitchExample {  
public static void main(String[] args) {  
    //Entrando com o valor teste ----------------------------------- 
    Scanner entra = new Scanner(System.in);
    System.out.print("Escreva o primeiro valor para realizar a conta (7,69 ou 50): "); 
    int teste = entra.nextInt();  
    System.out.print("Escreva o segundo valor: "); 
    int teste2 = entra.nextInt();     

    //Switch expression  
    switch(teste){  
    //Case statements  
    case 7: 
        System.out.println("para 10 o produto é: " + teste * teste2);  
    break;  
    case 69: 
        System.out.println("para 20 o produto é: " + teste * teste2);  
    break;  
    case 50: 
        System.out.println("para 30 o produto é: " + teste * teste2);  
    break;  
    //Para outro valor  
    default:System.out.println("Não é 7, 69 ou 50");  
    }  
}  
}  



