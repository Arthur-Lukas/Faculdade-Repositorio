/******************************************************************************

Escreva um algoritmo para caulcular o valor de y como função de x,
segunda a função Y = 3X + 2, num domínio real.

*******************************************************************************/
#include <stdio.h>

int main()
{
    float x;
    printf("Escreva o valor de 'x' para calcular o valor de 'y': ");
    scanf("%f", &x);
    float y= 3*x+2;
    printf("O valor de 'y' é: %2.f", y);
    return 0;
}


