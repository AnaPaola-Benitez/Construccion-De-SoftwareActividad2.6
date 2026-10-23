/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecarefactoring;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author paolabenitezmorales
 */
// TÉCNICA SUGERIDA: INTRODUCE LOCAL EXTENSION
// REFACTOR: FechaBiblioteca extiende Date y concentra el cálculo de días, el formato y la consulta de fin de semana.
public class FechaBiblioteca extends Date {
    private static final long serialVersionUID = 1L;

    public FechaBiblioteca(Date fecha) {
        super(fecha.getTime());
    }

    public int diasEntre(Date hasta) {
        double milisPorDia = 24.0 * 60 * 60 * 1000;
        return (int) Math.round((hasta.getTime() - getTime()) / milisPorDia);
    }

    public String formatearFecha() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this);
    }

    public boolean esFinDeSemana() {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(this);
        int dia = calendario.get(Calendar.DAY_OF_WEEK);
        return dia == Calendar.SATURDAY || dia == Calendar.SUNDAY;
    }
}