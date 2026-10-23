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
// REFACTOR: Telefono reúne código de área, número y las operaciones propias del teléfono.
public class Telefono {
    private String codigoArea;
    private String numero;

    public Telefono(String codigoArea, String numero) {
        this.codigoArea = codigoArea;
        this.numero = numero;
    }

    public String obtenerTelefonoCompleto() {
        return "(" + codigoArea + ") " + numero;
    }

    public boolean esTelefonoLocal() {
        return codigoArea.equals("999");
    }
}