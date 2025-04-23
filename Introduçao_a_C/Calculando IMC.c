/******************************

FUAQ pergunte ao usuário, seu peso e sua altura. 
O algoritmo deve calcular o IMAC e informar em qual classe ele está

******************************/



#include <stdio.h>

int main()
{
    float peso, altura, imc;
    
    printf("Digite seu peso: \n");
    scanf("%f", &peso);
    
    printf("Digite a sua altura: \n");
    scanf("%f", &altura);
    
    imc=(peso/(altura*altura));
    
    printf("IMC: %.2F\n", imc);
    
    if(imc<18.5){
        printf("Abaixo do peso");
    }else{
        if(imc >= 18.5 && imc <25){
            printf("Peso normal");
        }else if(imc >=25 && imc <30){
            printf("Excesso de peso");
        }else if(imc >=30 && imc <35){
            printf("Obesidade classe I");
        }else if(imc >= 35 && imc <40){
            printf("Obesidade classe II");
        }else{
            printf("Obesidade classe III");
        }
    }
    
    return 0;
}