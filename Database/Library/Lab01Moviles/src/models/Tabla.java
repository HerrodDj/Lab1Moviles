/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author demil
 */
public class Tabla extends AbstractTableModel{
    
     public Tabla(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    

    @Override
    public int getRowCount() {
        return carreras.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carrera c = carreras.get(rowIndex);
        Object valor = null;
        switch (columnIndex) {
            case 0:
                valor = c.getCodigo();
                break;
            case 1:
                valor = c.getNombre();
                break;
            case 2:
                valor = c.getTitulo();
                break;
        }
        return valor;
    }
    
    
    
     @Override
     public String getColumnName(int column) {
        String columna = " ";
        switch (column) {
            case 0:
                columna = "Codigo";
                break;
            case 1:
                columna = "Nombre";
                break;
            case 2:
                columna = "Titulo";
                break;
        }
        return columna;
    }
    
    
    private ArrayList<Carrera> carreras;
    
}
