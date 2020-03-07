/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Service.ServiceMethodsUsuario;
import exceptions.GlobalException;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author PC
 */
public class Model extends Observable{
    
    public Model() {
        this.carreras = new ArrayList<>();
        this.tabla = new Tabla(carreras);
        this.su = new ServiceMethodsUsuario();
    }
    
    public void actualizarTabla(ArrayList<Carrera> nC) {
        this.carreras = nC;
        this.tabla = new Tabla(nC);
        this.commit();
    }
    
    
    public Usuario getUser(String cedula, String password) throws GlobalException{
        return su.getUsuario(cedula, password);
    }
    
    
    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }
    public void commit(){
        setChanged();
        notifyObservers();       
    }

    private Tabla tabla;
    private ArrayList<Carrera> carreras;
    ServiceMethodsUsuario su;
    
}
