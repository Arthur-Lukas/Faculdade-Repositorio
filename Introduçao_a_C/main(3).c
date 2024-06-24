/*****************
leia uma temperatura dada na escala celsius (c) e imprima o equivalente em fahrenheit (f)
(formula de conversão: F = 9/5 * C+ 32).
*/

#include <stdio.h>

float main()
{
    float C;
    float F = 9/5 * C+ 32;
    printf("Digite a temperatura em celsius: ");
    scanf("%f", &C);
    printf("Essa temperatura %.2f em fahrenheit é: %.2f", C, F);
    return 0;
}