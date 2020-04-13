package models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author demil
 */
public class TablaCursos extends AbstractTableModel {

    public TablaCursos(int[] cols, List<Curso> cursos) {
        this.cols = cols;
        this.cursos = cursos;
        iniciarColNames();
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int col) {
        return colNames[cols[col]];
    }

    @Override
    public int getRowCount() {
        return cursos.size();
    }

    public Curso getRowAt(int row) {
        return cursos.get(row);
    }

    @Override
    public Object getValueAt(int row, int col) {
        Curso cur = cursos.get(row);
        switch (cols[col]) {
            case CODIGO:
                return cur.getCodigo();
            case NOMBRE:
                return cur.getNombre();
            case CREDITOS:
                return cur.getCreditos();
            case HORAS:
                return cur.getHorasSemanales();
            case CARRERA_COD:
                return cur.getCodigoCarrera();
            case CICLO:
                return cur.getCiclo();
            case ANNIO:
                return cur.getAnio();
            default:
                return "";
        }
    }

    private void iniciarColNames() {
        colNames[CODIGO] = "Codigo";
        colNames[NOMBRE] = "Nombre";
        colNames[CREDITOS] = "Ceditos";
        colNames[HORAS] = "Horas";
        colNames[CARRERA_COD] = "Carrera";
        colNames[CICLO] = "Ciclo";
        colNames[ANNIO] = "Año";
    }

    private List<Curso> cursos;
    int[] cols;
    public static final int CODIGO = 0;
    public static final int NOMBRE = 1;
    public static final int CREDITOS = 2;
    public static final int HORAS = 3;
    public static final int CARRERA_COD = 4;
    public static final int CICLO = 5;
    public static final int ANNIO = 6;
    String[] colNames = new String[15];

}
