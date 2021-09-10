// Luis Enrique Paredes Cruz
// 621861
// Avance examen primer parcial
// Fecha en el formato que se quiera (día, mes, año)
// Periodo de tiempo (semana, mes, año -> 1 semana, 2 meses, 1 año, etc.)
// Función que procese estos datos e indique cuál será la siguiente fecha con base al periodo de tiempo

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;

class Fecha {
    // Método para definir el formato
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    // Método para obtener y calcular fechas
    public static void obtenerFecha() {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingresa una fecha en formato dd-mm-aaaa:");
        String fechaCadena = s.nextLine(); // Captura la fecha en String
        Date fechaConvertida = Fecha.StringADate(fechaCadena); // Convierte la fecha String a tipo Date
        if (fechaConvertida != null) {
            System.out.println("Fecha ingresada: "+Fecha.DateAString(fechaConvertida)+" = "+fechaConvertida); // Imprime la fecha en String
        } else
            System.out.println("Fecha no válida");
        // Guarda la fecha ingresada en el calendario
        Calendar calendar = Fecha.DateACalendar(fechaConvertida);
        // Variable para guardar el tipo de periodo
        String tipoPeriodo = Fecha.obtenerTipoPeriodo();
        // Variable para guardar el número del tipo de periodo
        int cantidadPeriodo;
        // Validación condicional del tipo de periodo ingresado y cálculo de la suma
        Scanner x = new Scanner(System.in);
        if (Objects.equals(tipoPeriodo, "semana")){
            System.out.println("Ingresa el número de semanas:");
            cantidadPeriodo = x.nextInt();
            calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH,cantidadPeriodo);
            System.out.println("La siguiente fecha es: "+Fecha.DateAString(calendar.getTime()));
        }
        else if (Objects.equals(tipoPeriodo, "mes")){
            System.out.println("Ingresa el número de meses:");
            cantidadPeriodo = x.nextInt();
            calendar.add(Calendar.MONTH,cantidadPeriodo);
            System.out.println("La siguiente fecha es: "+Fecha.DateAString(calendar.getTime()));
        }
        else if (Objects.equals(tipoPeriodo, "año")){
            System.out.println("Ingresa el número de años:");
            cantidadPeriodo = x.nextInt();
            calendar.add(Calendar.YEAR,cantidadPeriodo);
            System.out.println("La siguiente fecha es: "+Fecha.DateAString(calendar.getTime()));
        }
    }
    // Método para capturar el tipo de periodo que se sumará
    public static String obtenerTipoPeriodo() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nIngresa el tipo de periodo (semana, mes, año):");
        return s.next();
    }
    // Método para convertir tipo String a tipo Date
    public static Date StringADate(String fechaCadena) {
        Date fecha = null;
        try {
            fecha = sdf.parse(fechaCadena);
        } catch (ParseException e) {
            System.out.println("Error en el formato");
        }
        return fecha;
    }
    // Método para convertir tipo Date a tipo String
    public static String DateAString(Date fecha) {
        return sdf.format(fecha);
    }
    // Método para convertir tipo Date a tipo Calendar
    public static Calendar DateACalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
class Principal {
    public static void main(String[]args) {
        Fecha.obtenerFecha();
    }
}
