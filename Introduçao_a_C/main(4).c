//FUAQ solicite ao usuário que digite um número de 1 a 7. Utilizando switch,
//informe a este usuário, qual o dia da semana correspondente ao número
//Se for informado qualquer número diferente, imprima uma mensagem de Opção Inválida.

#include <stdio.h>

int main(){
    
    int numero;
    
    printf("Digite um numero de 1 a 7: ");
    scanf("%d", &numero);
    
    switch(numero){
        case 1:
            printf("Domingo\n");
            break;
        case 2:
            printf("Segunda\n");
            break;
        case 3:
            printf("terça\n");
            break;
        case 4:
            printf("Quarta\n");
            break;
        case 5:
            printf("Quinta\n");
            break;
        case 6:
            printf("Sexta\n");
            break;
        case 7:
            printf("Sábado\n");
            break;
        default:
            printf("Opção Inválida!");
            break;
    }
    return 0;
}
