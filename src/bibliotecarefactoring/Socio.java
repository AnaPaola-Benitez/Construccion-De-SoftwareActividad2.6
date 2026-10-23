/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecarefactoring;

/**
 *
 * @author paolabenitezmorales
 */
// TÉCNICA SUGERIDA: EXTRACT CLASS
// REFACTOR: Socio conserva sus datos personales y delega el comportamiento telefónico en el objeto Telefono.
public class Socio {
    private String nombre;
    private String ciudad;
    private Telefono telefono;

    public Socio(String nombre, String ciudad, Telefono telefono) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }

    public String obtenerTelefonoCompleto() {
        return telefono.obtenerTelefonoCompleto();
    }

    public boolean esTelefonoLocal() {
        return telefono.esTelefonoLocal();
    }
}