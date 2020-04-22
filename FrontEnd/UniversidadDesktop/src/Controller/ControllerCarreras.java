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
import javax.swing.JComboBox;
import models.Carrera;
import models.Curso;
import models.Model;

/**
 *
 * @author demil
 */
public class ControllerCarreras {

    public ControllerCarreras(ViewCarreras vc, TablaModelView model) throws SQLException, GlobalException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        model.setTablaCarreras(new ArrayList());
        this.domainModel = new Model();
        this.vc = vc;
        this.model = model;
        vc.setController(this);
        vc.setModel(model);
        this.buscarCarreras();
    }

    public boolean insertarCarrera(Carrera carrera) throws Exception {
        return domainModel.AddCarrera(carrera);
    }

    public void buscar(String a, int b) throws GlobalException, Exception {
        if(a.equals("")){
            this.buscarCarreras();
        }else if(b==0){
            this.buscarCodCarrera1(a);
        }else if(b==1){
            this.buscarNomCarrera(a);
        }
    }
    
    public void buscarCursoPorCarCod(String cod) throws SQLException, GlobalException{
        List<Curso> l = domainModel.allCurso();
        JComboBox<String> f = this.vc.retornaBox();
        for(int i=0; i<l.size(); i++){
            String p = l.get(i).getCodigo();
            f.addItem(p);
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
    

    public boolean buscarNomCarrera(String nom) throws Exception {
        Carrera car = domainModel.buscarNomCarrera(nom);
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
