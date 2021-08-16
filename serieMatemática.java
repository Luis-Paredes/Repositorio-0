/*  - Escudería McQueen
    - Miguel Otero - 542281, Alejandro Santacruz - 554400, Karina García - 557661, Juan Pablo González - 619220, Luis Paredes - 621861
    - Desarrollar un programa que sume 1+((x^n)/n!+...) siendo x el dato de entrada, n el exponente y el factorial.
      Condiciones: (0<=x<=1), se ejecutará mientras los términos sean mayores a 10^-8   */

import java.io.*;
import java.util.*;
import java.text.*;
class serieMatemática {
    public static void main(String[]args){          // Método principal
        double número = serieMatemática.pedirNúmero();         // Llama al método donde se pide el número al usuario
        double operación = serieMatemática.operación(número);  // Llama al método que calcula la suma
        serieMatemática.imprimirResultado(operación);          // Llama al método que imprime la suma
    }
    public static double pedirNúmero(){             // Método donde se pide el número al usuario
        Scanner s = new Scanner(System.in);         // Se inicializa el Scanner para recibir datos
        double x;                                   // Variable decimal que guarda el número
        do {                                        // Ciclo de verificación
            System.out.println("Ingresa un número que sea mayor o igual a 0 y menor o igual a 1");
            x = s.nextDouble();                     // Se guarda el dato ingresado
        } while (x>1 || x<0);                       // Valida la condición (0<=x<=1)
        return x;                                   // Retorna el valor de la variable
    }
    public static double operación(double número){  // Método que calcula la suma
        double factorialAcum = 1;                   // Variable que acumula los factoriales del ciclo
        double contadorPotecial = 1;                // Variable que incrementa la potencia del número
        double contadorFactorial = 1;               // Variable que incrementa el número factorial divisor
        double término;                             // Variable que calcula la división
        double suma = 1;                            // Variable que suma los términos calculados y 1
        do {                                                        // Ciclo de verificación
            double potencia = Math.pow(número,contadorPotecial);    // Variable que calcula la potencia
            contadorPotecial ++;                                    // Incrementa 1
            double factorial = factorialAcum * contadorFactorial;   // Variable que calcula el factorial
            factorialAcum = factorial;                              // Guarda el último valor del factorial
            contadorFactorial ++;                                   // Incrementa 1
            término = potencia/factorial;                           // Realiza la divisón que calcula el término
            suma += término;                                        // Guarda el valor de término
        } while(término>0.0000001);                                 // Valida la condición (término > 10^-8)
        return suma;                                                // Retorna el valor de la suma
    }
    public static void imprimirResultado(double operación){                                 // Método que imprime la suma
        DecimalFormat tresDígitos = new DecimalFormat("0.000");                      // Define 3 decimales para imprimir
        System.out.println("El resultado de la suma es: " + tresDígitos.format(operación)); // Imprime el resultado final
    }
}
