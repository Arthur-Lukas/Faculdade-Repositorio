package Introdução_a_java;
/******************
 Faca um programa que leia o codigo dos produtos pedidos e as quantidades desejadas;
 calcula e mostre o valor a ser pago por produto (preco * quantidade) e o total do pedido.
 Considere que o cliente deve informar quando o pedido deve ser encerrado.
 
 Produto:                  Codigo           Preco (unitario)
 Cachorro quente             1               R$ 1.50
 Hamburguer                  2               R$ 2.00
 Cheeseburguer               3               R$ 2.50
 Eggburguer                  4               R$ 3.00
 Refrigerante                5               R$ 1.50
 
 */

import javax.swing.JOptionPane;
public class Máquina_de_lanches_de_forma_diferente {

public static void main (String [] args){
    
    double qtd, total = 0, subtotal;
    int codigo = -1;
    String valorDigitado;

    while ( codigo != 0  ){
        String menu = " __Menu__\n";
        menu += " 1 - Cachorro quente\n";
        menu += " 2 - Hamburguer\n";
        menu += " 3 - Cheeseburguer\n";
        menu += " 4 - Eggcheeseburguer\n";
        menu += " 5 - Refrigerante\n";
        menu += " 0 - Digite sua opcao";
        valorDigitado = JOptionPane.showInputDialog(menu);   
        if( valorDigitado.isEmpty() ){
            JOptionPane.showMessageDialog(null , 
                        "Opção Inválida");
        }else{ 
            codigo = Integer.valueOf( valorDigitado );
            if( codigo != 0 ){
                valorDigitado = JOptionPane.showInputDialog("Informe a quantidade");
                qtd = Double.valueOf( valorDigitado );
                switch (codigo) {
                    case 1:
                        subtotal = qtd * 1.5;
                        break;
                    case 2:
                        subtotal = qtd * 2.0;
                        break;
                    case 3:
                        subtotal = qtd * 2.5;
                        break;
                    case 4:
                        subtotal = qtd * 3.0;
                        break;
                    case 5:
                        subtotal = qtd * 1.5;
                        break;
                    default:
                        subtotal = 0;
                        break;
                }
                total += subtotal;
                String texto = "Subtotal: " + subtotal + "\nTotal do Pedido: " + total; 
                JOptionPane.showMessageDialog(null, texto);
            }
        }
    }
}
}
