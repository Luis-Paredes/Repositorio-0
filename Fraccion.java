// Construye un programa para calcular el resultado de una fracción n1/d1

/*
// Versión sin constructor
import java.util.*;
import java.text.*;
class Fracción {
    public static void main(String[]args){
        Fracción.imprimirFuncionamiento();
        double numerador = Fracción.pedirNumerador();
        double denominador = Fracción.pedirDenominador();
        double resultadoOperación = Fracción.calcularDivisión(numerador, denominador);
        Fracción.imprimirResultado(resultadoOperación);
    }
    public static void imprimirFuncionamiento() {
        System.out.println("La función de este programa es realizar el cálculo de una división");
    }
    public static double pedirNumerador(){
        Scanner s = new Scanner(System.in);
        System.out.println("Ingresa el valor para el numerador:");
        return s.nextDouble();
    }
    public static double pedirDenominador() {
            Scanner s = new Scanner(System.in);
            double división;
            do {
                System.out.println("Ingresa el valor para el denominador:");
                división = s.nextDouble();
            } while (división == 0);
            return división;

    }
    public static double calcularDivisión(double numerador, double denominador){
        return numerador/denominador;
    }
    public static void imprimirResultado(double resultadoOperación){
        DecimalFormat tresDígitos = new DecimalFormat("0.000");
        System.out.println("El resultado es: " + tresDígitos.format(resultadoOperación));
    }
}
*/

/*
// Versión con constructor y atruutos definidos
class Fraccion {
    private double numerador;
    private double denominador;

    public Fraccion (double numerador,double denominador) {
        this.numerador=numerador;
        this.denominador=denominador;
    }
    public double calcularFraccion(){
        return numerador/denominador;
    }
    public String toString(){
        return "Fracción: "+numerador+"/"+denominador+"\tEl resultado es: "+calcularFraccion();
    }
}
class Principal{
    public static void main(String[]args){
        Fraccion f1=new Fraccion(60f, 5f);
        System.out.println(f1);
    }
}
*/

/*
// Versión con constructor y validación del denominador
import java.util.Scanner;
class Fraccion {
    private final double numerador;
    private final double denominador;

    public Fraccion (double numerador,double denominador) {
        this.numerador=numerador;
        this.denominador=denominador;
    }
    public double calcularFraccion(){
        return numerador/denominador;
    }
    public String toString(){
        return "Fracción: "+numerador+"/"+denominador+"\tEl resultado es: "+calcularFraccion();
    }
}
class Principal{
    public static void main(String[]args){
        double n,d;
        Scanner x = new Scanner(System.in);
        System.out.println("Ingresa el numerador: ");
        n = x.nextDouble();
        do {
            System.out.println("Ingresa el denominador: ");
            d = x.nextDouble();
            if (d==0)
                System.out.println("El denominador no puede ser 0");
        } while (d==0);
        Fraccion f1 = new Fraccion(n,d);
        System.out.println(f1);
    }
}
*/

// Versión con constructor usando métodos set() y get() y validación del denominador
import java.text.*;
import java.util.*;

class Fraccion {
    private double numerador;
    private double denominador;

    // Método constructor
    public Fraccion (double numerador,double denominador) {
        setNumerador(numerador);
        setDenominador(denominador);
    }

    // Métodos set()
    public void setNumerador(double numerador){
        this.numerador=numerador;
    }
    public void setDenominador(double denominador){
        this.denominador=denominador;
    }

    // Métodos get()
    public double getNumerador(){
        return numerador;
    }
    public double getDenominador(){
        return denominador;
    }

    // Método para obtener el resultado de la división
    public double calcularFraccion(){
        return numerador/denominador;
    }

    // Método toString con Decimal Format
    public String toString(){
        DecimalFormat tresDigitos = new DecimalFormat("0.000");
        return "El resultado es: "+tresDigitos.format(calcularFraccion());
    }
}
class Principal{
    public static void main(String[]args){
        double n,d;
        // Pedir valores
        Scanner x = new Scanner(System.in);
        System.out.println("Ingresa el numerador: ");
        n = x.nextDouble();

        // Validar denominador
        do {
            System.out.println("Ingresa el denominador: ");
            d = x.nextDouble();
            if (d==0)
                System.out.println("El denominador no puede ser 0");
        } while (d==0);

        // Definir objeto
        Fraccion f1 = new Fraccion(n,d);

        // Imprimir con métodos get()
        System.out.println("División: "+f1.getNumerador()+"/"+f1.getDenominador());

        // Imprimir toString
        System.out.println(f1);
    }
}
