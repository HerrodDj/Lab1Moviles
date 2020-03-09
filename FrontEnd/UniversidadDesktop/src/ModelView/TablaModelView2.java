/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import models.Curso;
import models.TablaCursos;

/**
 *
 * @author demil
 */
public class TablaModelView2 extends java.util.Observable{

    public TablaModelView2(ArrayList<Curso> carreras) {
        this.cursos = carreras;
    }

    public TablaModelView2() {
        this.cursos=new ArrayList();
    }
    
     public TablaCursos getTabla() {
        return tabla;
    }

    public void setTabla(TablaCursos tabla) {
        this.tabla = tabla;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void agregaCurso(Curso c){
        cursos.add(c);
     }
    
    public void setTablaCursos(List<Curso> c) {
        int cols[] = {TablaCursos.CODIGO, TablaCursos.NOMBRE, TablaCursos.CREDITOS,TablaCursos.HORAS,TablaCursos.CARRERA_COD,TablaCursos.CICLO,TablaCursos.ANNIO};
        this.tabla = new TablaCursos(cols,c);
        commit();
    }
     
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.commit();   
    }
     
    public void commit(){
        setChanged();
        notifyObservers();       
    }
   
    
    List<Curso> cursos;
    TablaCursos tabla;
}
