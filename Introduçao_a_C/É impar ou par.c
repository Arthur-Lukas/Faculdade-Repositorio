#include <stdio.h>

int main(){
    
    int opcao;
    printf("---MENU--------\n");
    printf("1 - Imprimir meu nome \n");
    printf("2 - Imprimir meu e-mail\n");
    printf("Digite sua opção: ");
    scanf( "%d" , &opcao );
    
    switch( opcao ){
        case 1:
            printf("Arthur Lucas Evangelista Machado");
            break;
        case 2:
        case 3:
            printf("evangelist01@gmail.com");
            break;
        default:
            printf("Opção inválida");
    }
    return 0;
}