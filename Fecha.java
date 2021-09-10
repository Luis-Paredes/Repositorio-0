// Luis Enrique Paredes Cruz
// 621861
// Avance examen primer parcial
// Fecha en el formato que se quiera (d�a, mes, a�o)
// Periodo de tiempo (semana, mes, a�o -> 1 semana, 2 meses, 1 a�o, etc.)
// Funci�n que procese estos datos e indique cu�l ser� la siguiente fecha con base al periodo de tiempo

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;

class Fecha {
    // M�todo para definir el formato
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    // M�todo para obtener y calcular fechas
    public static void obtenerFecha() {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingresa una fecha en formato dd-mm-aaaa:");
        String fechaCadena = s.nextLine(); // Captura la fecha en String
        Date fechaConvertida = Fecha.StringADate(fechaCadena); // Convierte la fecha String a tipo Date
        if (fechaConvertida != null) {
            System.out.println("Fecha ingresada: "+Fecha.DateAString(fechaConvertida)+" = "+fechaConvertida); // Imprime la fecha en String
        } else
            System.out.println("Fecha no v�lida");
        // Guarda la fecha ingresada en el calendario
        Calendar calendar = Fecha.DateACalendar(fechaConvertida);
        // Variable para guardar el tipo de periodo
        String tipoPeriodo = Fecha.obtenerTipoPeriodo();
        // Variable para guardar el n�mero del tipo de periodo
        int cantidadPeriodo;
        // Validaci�n condicional del tipo de periodo ingresado y c�lculo de la suma
        Scanner x = new Scanner(System.in);
        if (Objects.equals(tipoPeriodo, "semana")){
            System.out.println("Ingresa el n�mero de semanas:");
            cantidadPeriodo = x.nextInt();
            calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH,cantidadPeriodo);
            System.out.println("La siguiente fecha es: "+Fecha.DateAString(calendar.getTime()));
        }
        else if (Objects.equals(tipoPeriodo, "mes")){
            System.out.println("Ingresa el n�mero de meses:");
            cantidadPeriodo = x.nextInt();
            calendar.add(Calendar.MONTH,cantidadPeriodo);
            System.out.println("La siguiente fecha es: "+Fecha.DateAString(calendar.getTime()));
        }
        else if (Objects.equals(tipoPeriodo, "a�o")){
            System.out.println("Ingresa el n�mero de a�os:");
            cantidadPeriodo = x.nextInt();
            calendar.add(Calendar.YEAR,cantidadPeriodo);
            System.out.println("La siguiente fecha es: "+Fecha.DateAString(calendar.getTime()));
        }
    }
    // M�todo para capturar el tipo de periodo que se sumar�
    public static String obtenerTipoPeriodo() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nIngresa el tipo de periodo (semana, mes, a�o):");
        return s.next();
    }
    // M�todo para convertir tipo String a tipo Date
    public static Date StringADate(String fechaCadena) {
        Date fecha = null;
        try {
            fecha = sdf.parse(fechaCadena);
        } catch (ParseException e) {
            System.out.println("Error en el formato");
        }
        return fecha;
    }
    // M�todo para convertir tipo Date a tipo String
    public static String DateAString(Date fecha) {
        return sdf.format(fecha);
    }
    // M�todo para convertir tipo Date a tipo Calendar
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
