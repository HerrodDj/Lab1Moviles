/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author demil
 */
public class TablaCarreras extends AbstractTableModel{
    
     public TablaCarreras(int[] cols,List<Carrera> carreras) {
        this.cols=cols;
        this.carreras = carreras;
        iniciarColNames();
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }
    
     @Override
    public int getColumnCount() {
        return cols.length;
    }
    
    @Override
    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    @Override
    public int getRowCount() {
        return carreras.size();
    }
    
     public Carrera getRowAt(int row) {
        return carreras.get(row);
    }

     @Override
    public Object getValueAt(int row, int col) {
        Carrera car = carreras.get(row);
        switch (cols[col]) {
            case CODIGO:
                return car.getCodigo();
            case NOMBRE:
               return car.getNombre();
            case TITULO:
                return car.getTitulo();   
            default:
                return "";
        }
    } 
    
    private void iniciarColNames(){
        colNames[CODIGO]= "Codigo";
        colNames[NOMBRE] = "Nombre";
        colNames[TITULO] = "Titulo";
    }
    
    private List<Carrera> carreras;
    int[] cols;
    public static final int CODIGO = 0;
    public static final int NOMBRE = 1;
    public static final int TITULO = 2;
    String[] colNames = new String[15];
    
}