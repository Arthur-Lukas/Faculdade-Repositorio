/******************************************************************************
Elabore um programa que solicite ao usuário que
digite 2 números inteiros e após ele
escolha uma operação à realizar, conforme segue:
A - Adição
S - Subtração
M - Multiplicação
D - Divisão
Mostrar o resultado da operação realizada.
******************************************************************************/

#include <stdio.h>
#include <stdbool.h>
int main(){ //Todo programa para ser executado tem que ter isso aq//

    //Aqui está declarando as variáveis que iremos trabalhar apenas, tipo separando os ingredientes//
    char opcao; //char: caractére
    int n1, n2; //int: para mostrar apenas números inteiros
    float result = 0.0;  // mostrar números inteiros ou com casas décimais
    bool imprimir = true; //não sei o que é boleano ainda
    
    printf("----MENU----\n");
    printf("A - Adição\n");
    printf("S - Subtração\n");
    printf("M - Multiplicação\n");
    printf("D - Divisão\n");
    printf("Digite sua opcao: ");
    scanf("%c",&opcao); //Lê o caractére (se não digitar um caractére, não prosseguira) de ENTRADA que o usuário digitar e o armazena, para que possamos dar seguência com as instruções que queremos 
    
    printf("Digite o primeiro valor: ");
    scanf("%d",&n1); //Lê e armazena o valor que for colocado no "printf". O "%d" é para números inteiros"
    printf("Digite o segundo valor: ");
    scanf("%d",&n2); //Lê e armazena
    
    switch( opcao ){
        case 'a':
        case 'A':
            result = n1 + n2;
            break;
        case 's':
        case 'S':
            result = n1 - n2;
            break;
        case 'm':
        case 'M':
            result = n1 * n2;
            break;
        case 'd':
        case 'D':
            if( n2 == 0){
                printf("Não dá pra fazer divisão por 0 seu burro!"); 
                imprimir = false; 
            }else{
                result = (float) n1/n2;
            }
            break;
        default: //qualquer outra coisa que for digitada sem ser o que foi especificado acima resultará na resposta abaixo
            printf("Opção inválida\n");
            imprimir = false;
            break;
    }
    
    if(imprimir) {
        printf("%.2f\n", result);
    }
    return 0; 
}