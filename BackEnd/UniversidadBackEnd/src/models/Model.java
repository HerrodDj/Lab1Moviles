/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Service.ServiceMethodsCarrera;
import Service.ServiceMethodsUsuario;
import exceptions.GlobalException;
import exceptions.NoDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author PC
 */
public class Model extends Observable {

    public Model() {
        this.su = new ServiceMethodsUsuario();
        this.sc = new ServiceMethodsCarrera();
    }

    public boolean getUser(String cedula, String password) throws GlobalException {
        return su.getUsuario(cedula, password);
    }

    public boolean AddCarrera(Carrera Ncarrera) throws NoDataException, Exception {
        return sc.insertarCarrera(Ncarrera);
    }

    public List<Carrera> allCarrera() throws GlobalException {
        return sc.buscarTodasCarreras();
    }

    ServiceMethodsUsuario su;
    ServiceMethodsCarrera sc;

}
