package Model;
import java.text.*;
import java.util.*;

// Clase Persona
public class Persona {
    // Atributos
    private final float estatura;
    private final float masa;
    private final char sexo;
    // Método constructor
    public Persona(float estatura, float masa, char sexo) {
        this.estatura = estatura;
        this.masa = masa;
        this.sexo = sexo;
    }
    // Método para calcular el índice de masa corporal
    public double calcularIMC() {
        return masa / (estatura * estatura);
    }
    // Método para calcular la masa ideal según el sexo
    public int calcularMasaIdeal() {
        int masaIdeal = (int) (estatura * 100)-100;
        if (sexo == 'H')
            return masaIdeal;
        else if (sexo == 'M')
            return masaIdeal - 10;
        return masaIdeal;
    }
    // Método toString para convertir a texto
    public String toString() {
        // Define tres decimales para el IMC
        DecimalFormat tresDigitos = new DecimalFormat("0.000");
        return "IMC: "+tresDigitos.format(calcularIMC())+"\t\tMasa Ideal: "+calcularMasaIdeal()+" kg";
    }
}
// Clase Principal con el main
class Principal {
    public static void main(String[]args){
        // Se define la contraseña
        String password = "Pdh7-trg";
        String passwordU;
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Ingresa la contraseña:");
            // Guarda la contraseña ingresada por el usuario
            passwordU = s.next();
            if (Objects.equals(passwordU, password)){
                // Crea dos objetos de la clase (hombre y mujer) y los valores de sus atributos
                Persona p1 = new Persona(1.70f,70f,'H');
                Persona p2 = new Persona(1.70f,60f,'M');
                // Imprime los datos de los objetos creados
                System.out.println("\nHombre\t\t"+p1+"\n"+"Mujer\t\t"+p2);
            }
        } while (!Objects.equals(passwordU, password));
    }
}
