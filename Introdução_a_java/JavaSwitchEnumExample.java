//Esse realmente eu não entendi o que aconteceu aqui
public class JavaSwitchEnumExample {      
       public enum Day {  Sun, Mon, Tue, Wed, Thu, Fri, Sat  }    
       public static void main(String args[])    
       {    
         Day[] DayNow = Day.values();    
           for (Day Now : DayNow)    
           {    
                switch (Now)    
                {    
                    case Sun:    
                        System.out.println("Dia de não fazer nada");    
                        break;    
                    case Mon:    
                        System.out.println("Primeiro estalo do chicote");    
                        break;    
                    case Tue:    
                        System.out.println("Falta muito ainda");    
                        break;         
                    case Wed:    
                        System.out.println("Ansiedade alta");    
                        break;    
                    case Thu:    
                        System.out.println("Cansado, más há uma esperança");    
                        break;    
                    case Fri:    
                        System.out.println("Sextou!");    
                        break;    
                    case Sat:    
                        System.out.println("Dia de tomar banho");    
                        break;    
                }    
            }    
        }    
}    
