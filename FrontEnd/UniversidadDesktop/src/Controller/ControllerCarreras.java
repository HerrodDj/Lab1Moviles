/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ModelView.TablaModelView;
import View.ViewCarreras;
import exceptions.GlobalException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Carrera;
import models.Model;

/**
 *
 * @author demil
 */
public class ControllerCarreras {

    public ControllerCarreras(ViewCarreras vc, TablaModelView model) {
        model.setTablaCarreras(new ArrayList());
        this.domainModel = new Model();
        this.vc = vc;
        this.model = model;
        vc.setController(this);
        vc.setModel(model);
    }

    public boolean insertarCarrera(Carrera carrera) throws Exception {
        return domainModel.AddCarrera(carrera);
    }

    public void buscar(String a) throws GlobalException, Exception {
        switch (a) {
            case "":
                this.buscarCarreras();
                break;
            default:
                this.buscarCodCarrera1(a);
        }
    }

    public List<Carrera> buscarCarreras() throws GlobalException {
        List<Carrera> l = domainModel.allCarrera();
        model.setTablaCarreras(l);
        return l;
    }

    public Carrera buscarCodCarrera(String cod) throws Exception {
        Carrera car = domainModel.buscarCodCarrera(cod);
        return car;
    }

    public boolean buscarCodCarrera1(String cod) throws Exception {
        Carrera car = domainModel.buscarCodCarrera(cod);
        if (car != null) {
            model.getCarreras().clear();
            model.agregaCarrera(car);
            model.setTablaCarreras(model.getCarreras());
            return true;
        }
        model.setTablaCarreras(new ArrayList<>());
        return false;
    }

    public boolean updateCarrera(Carrera car) throws SQLException, GlobalException {
        return domainModel.updateCarrera(car);
    }
    
    public boolean deleteCarrera(String cod) throws SQLException{
        return domainModel.deleteCarrera(cod);
    }

    public void enter() {
        this.show();
    }

    public void show() {
        vc.setVisible(true);
    }

    ViewCarreras vc;
    Model domainModel;
    TablaModelView model;
}
