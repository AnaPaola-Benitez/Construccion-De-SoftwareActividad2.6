/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecarefactoring;

/**
 *
 * @author paolabenitezmorales
 */
import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Socio socio;
    // TÉCNICA SUGERIDA: MOVE FIELD
    // REFACTOR: El plazo pertenece al préstamo; Socio ya no almacena un dato que solo usa Prestamo.
    private int diasPlazoPrestamo;
    private FechaBiblioteca fechaPrestamo;
    private FechaBiblioteca fechaDevolucion;

    public Prestamo(Libro libro, Socio socio, int diasPlazoPrestamo, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;
        this.socio = socio;
        this.diasPlazoPrestamo = diasPlazoPrestamo;
        this.fechaPrestamo = new FechaBiblioteca(fechaPrestamo);
        this.fechaDevolucion = new FechaBiblioteca(fechaDevolucion);
    }

    // TÉCNICA SUGERIDA: HIDE DELEGATE
    // REFACTOR: Main obtiene ciudad y teléfono desde Prestamo; también se oculta la cadena usada para leer el autor.
    public String getCiudadSocio() { return socio.getCiudad(); }
    public String getTelefonoSocio() { return socio.obtenerTelefonoCompleto(); }
    public String getAutorLibro() { return libro.getAutor(); }

    // TÉCNICA SUGERIDA: INTRODUCE FOREIGN METHOD
    // REFACTOR: sumarDias(Date, int) agrega la operación que falta a java.util.Date sin modificar esa clase.
    private static Date sumarDias(Date fecha, int dias) {
        return new Date(fecha.getTime() + dias * 24L * 60 * 60 * 1000);
    }

    public FechaBiblioteca calcularFechaVencimiento() {
        return new FechaBiblioteca(sumarDias(fechaPrestamo, diasPlazoPrestamo));
    }

    public int calcularDiasRetraso() {
        return calcularFechaVencimiento().diasEntre(fechaDevolucion);
    }

    public void imprimirResumen() {
        FechaBiblioteca vencimiento = calcularFechaVencimiento();
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Socio: " + socio.getNombre());
        System.out.println("Prestado: " + fechaPrestamo.formatearFecha());
        System.out.println("Vence: " + vencimiento.formatearFecha());
        System.out.println("Vence en fin de semana: " + vencimiento.esFinDeSemana());
        System.out.println("Devuelto: " + fechaDevolucion.formatearFecha());
    }
}