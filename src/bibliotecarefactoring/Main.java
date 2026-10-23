/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecarefactoring;

/**
 *
 * @author paolabenitezmorales
 */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        // TÉCNICA SUGERIDA: REMOVE MIDDLE MAN
        // REFACTOR: Recepcion solo reenviaba llamadas a Catalogo; Main ahora usa directamente al objeto que realiza el trabajo.
        Catalogo catalogo = new Catalogo();

        catalogo.agregar(new Libro("Java Basico", "R. Perez", "978-1-11111-111-1", "NOVEDAD", 5, 300));
        catalogo.agregar(new Libro("Estructuras de Datos", "M. Diaz", "978-2-22222-222-2", "NORMAL", 3, 400));
        System.out.println("Libros registrados: " + catalogo.total());

        Libro libro = catalogo.buscarPorTitulo("java basico");
        Socio socio = new Socio("Ana Lopez", "Merida", new Telefono("999", "1234567"));

        Date fechaPrestamo = new GregorianCalendar(2026, Calendar.OCTOBER, 1).getTime();
        Date fechaDevolucion = new GregorianCalendar(2026, Calendar.OCTOBER, 22).getTime();
        Prestamo prestamo = new Prestamo(libro, socio, 14, fechaPrestamo, fechaDevolucion);

        System.out.println("-----------------------------");
        prestamo.imprimirResumen();
        System.out.println("-----------------------------");

        // TÉCNICA SUGERIDA: HIDE DELEGATE
        // REFACTOR: Main consulta los detalles del socio a través de Prestamo, sin acceder a Socio directamente.
        System.out.println("Ciudad del socio: " + prestamo.getCiudadSocio());
        System.out.println("Telefono del socio: " + prestamo.getTelefonoSocio());
        System.out.println("Autor del libro: " + prestamo.getAutorLibro());

        int retraso = prestamo.calcularDiasRetraso();
        System.out.println("Dias de retraso: " + retraso);
        System.out.println("Multa: $" + libro.calcularMulta(retraso));
        System.out.println("ISBN: " + libro.getIsbn());
        System.out.println("Telefono local: " + socio.esTelefonoLocal());
    }
}