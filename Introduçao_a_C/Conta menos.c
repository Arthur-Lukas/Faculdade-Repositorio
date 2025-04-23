/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

#include <stdio.h>

int main()

{
    int a, b, soma;
    
    printf("Digite um valor: \n");
    scanf("%d", &a);
    printf("Digite outro valor: \n ");
    scanf("%d", &b);
    
    soma = a-b;
    
    printf("O valor da soma é: %d", soma);

    return 0;
}