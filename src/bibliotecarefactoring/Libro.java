/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecarefactoring;

/**
 *
 * @author paolabenitezmorales
 */
public class Libro {
    private String titulo;
    private String autor;
    // TÉCNICA SUGERIDA: INLINE CLASS
    // REFACTOR: El valor ISBN se almacena directamente en Libro porque Isbn solo envolvía un String.
    private String isbn;
    private String categoria;       // "NOVEDAD" o "NORMAL"
    private double multaPorDia;
    private double valorReposicion;

    public Libro(String titulo, String autor, String isbn, String categoria,
                 double multaPorDia, double valorReposicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.multaPorDia = multaPorDia;
        this.valorReposicion = valorReposicion;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public String getCategoria() { return categoria; }
    public double getMultaPorDia() { return multaPorDia; }
    public double getValorReposicion() { return valorReposicion; }

    // TÉCNICA SUGERIDA: MOVE METHOD
    // REFACTOR: La multa se calcula en Libro porque depende únicamente de sus datos (tarifa, categoría y reposición).
    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        double multa = diasRetraso * getMultaPorDia();
        if (getCategoria().equals("NOVEDAD")) {
            multa = multa * 2;
        }
        if (multa > getValorReposicion()) {
            multa = getValorReposicion();
        }
        return multa;
    }
}

