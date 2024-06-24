//Java Program to demonstrate the use of Java Switch  
//statement with String  
public class SwitchStringExample {    
public static void main(String[] args) {    
    //Declaring String variable  
    String levelString="Nada mal";  //Você escolhe o level não pelos números mas sim pelo que for escrito
    int level=2;  
    //Using String in Switch expression  
    switch(levelString){    
    //Using String Literal in Switch case  
    case "Pra ser ruim, tem que melhorar muito ainda": level=1;  
    break;    
    case "Nada mal": level=2;  
    break;    
    case "Muito bom": level=3;  
    break;    
    default: level=0;  
    break;  
    }    
    System.out.println("Your Level is: "+level);  
}    
}   
