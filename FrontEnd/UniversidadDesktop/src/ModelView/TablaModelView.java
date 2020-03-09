/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import models.Carrera;
import models.TablaCarreras;

/**
 *
 * @author demil
 */
public class TablaModelView extends java.util.Observable{

    public TablaModelView(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public TablaModelView() {
        this.carreras=new ArrayList();
    }
    
     public TablaCarreras getTabla() {
        return tabla;
    }

    public void setTabla(TablaCarreras tabla) {
        this.tabla = tabla;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    public void agregaCarrera(Carrera c){
        carreras.add(c);
     }
    
    public void setTablaCarreras(List<Carrera> c) {
        int cols[] = {TablaCarreras.CODIGO, TablaCarreras.NOMBRE, TablaCarreras.TITULO};
        this.tabla = new TablaCarreras(cols,c);
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
   
    
    List<Carrera> carreras;
    TablaCarreras tabla;
}
