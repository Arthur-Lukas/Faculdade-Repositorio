import java.util.*;
public class SwitchZodiacExample 
{    
    public static void main(String[] args) 
    {   Scanner escolha = new Scanner(System.in); 
        //Specifying Zodiac number  
        
        System.out.println("Escolha um número que representa um mês do ano, e veja qual constelação do Zodiaco ele representa");
        int mes = escolha.nextInt();
        
        String Zodiaco="";
        //Switch statement  
        switch(mes)
        {    //Áries, Touro, Gêmeos, Câncer, Leão, Virgem, Libra, Escorpião, Ofiúco, Sagitário, Capricórnio, Aquário e Peixes
             //case statements within the switch block  
             case 1: Zodiaco="1 - Áries";  
             break;    
             case 2: Zodiaco="2 - Touro";  
             break;    
             case 3: Zodiaco="3 - Gêmeos";  
             break;    
             case 4: Zodiaco="4 - Câncer";  
             break;    
             case 5: Zodiaco="5 - Leão";  
             break;    
             case 6: Zodiaco="6 - Virgem";  
             break;    
             case 7: Zodiaco="7 - Libra";  
             break;    
             case 8: Zodiaco="8 - Escorpião";  
             break;    
             case 9: Zodiaco="9 - Sagitário";  
             break;    
             case 10: Zodiaco="10 - Capricórnio";  
             break;    
             case 11: Zodiaco="11 - Aquário";  
             break;    
             case 12: Zodiaco="12 - Peixes";  
             break;    
             default:System.out.println("Invalid Month!");    
        }    
        //Printing month of the given number  
        System.out.println(Zodiaco);  
       
    }    
}   


