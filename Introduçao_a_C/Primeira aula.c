/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>

int  dobrar(float x)
{
    float dobro = x * 2;

    printf("\n\nO valor dobrado de %f é: %.1f\n\n", x , dobro);
    
    return 0;

}

int main() //bloco main, tudo que estiver entre as chaves {}, pertence ao bloco main
{
    int idade;
    
    printf("Olá, me chamo Arthur Lucas Evangelista Machado\n\n");
    printf("Sou formado no ensino médio, e estou cursando \nAnálise e desenvolvimento de sistemas na UNA");
    dobrar( 50.5 );  //como o programa sempre começa pelo main, por isso que se colocar essa linha "dobrar(50.5" no bloco acima não vai aparecer nada
    printf("Qual a sua idade? \n");
    scanf( "%d",&idade); //SCAN F É COMANDO DE ENTRADAAAAAA!!!!! Ou seja, se vc quer fazer com que o úsuario digite alguma coisa é necessário usalo
    printf("\nMinha idade é: %d" , idade);

    return 0;
}




