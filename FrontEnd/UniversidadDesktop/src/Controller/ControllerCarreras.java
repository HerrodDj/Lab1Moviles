/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ModelView.TablaModelView;
import View.ViewCarreras;
import exceptions.GlobalException;
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
        if (domainModel.AddCarrera(carrera)) {
            Carrera nC = carrera;
            model.agregaCarrera(nC);
            model.setTablaCarreras(model.getCarreras());
            return true;
        } else {
            return false;
        }
    }

    public List<Carrera> buscarCarreras() throws GlobalException {
        List<Carrera> l = domainModel.allCarrera();
        model.setTablaCarreras(l);
        return l;
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
