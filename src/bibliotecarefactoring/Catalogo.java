/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecarefactoring;

/**
 *
 * @author paolabenitezmorales
 */
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Libro> libros = new ArrayList<>();

    public void agregar(Libro libro) {
        libros.add(libro);
    }

    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public int total() {
        return libros.size();
    }
}
