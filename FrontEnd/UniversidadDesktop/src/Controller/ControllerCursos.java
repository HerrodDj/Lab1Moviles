/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import ModelView.TablaModelView2;
import View.ViewCursos;
import exceptions.GlobalException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import models.Carrera;
import models.Curso;
import models.Model;

/**
 *
 * @author demil
 */
public class ControllerCursos {

    public ControllerCursos(ViewCursos vc, TablaModelView2 model) throws GlobalException, SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        model.setTablaCursos(new ArrayList());
        this.domainModel = new Model();
        this.vc = vc;
        this.model = model;
        vc.setController(this);
        vc.setModel(model);
        this.buscarCursos();
    }

    public boolean insertarCurso(Curso curso) throws Exception {
        return domainModel.AddCurso(curso);
    }

    public void buscar(String a,int b) throws GlobalException, Exception {
       if(a.equals("")){
            this.buscarCursos();
        }else if(b==0){
            this.buscarCodCurso1(a);
        }else if(b==1){
            this.buscarNomCurso(a);
        }
    }
    
    public void buscarCarreras() throws GlobalException {
        List<Carrera> l = domainModel.allCarrera();
        JComboBox<String> f = this.vc.retornaBox();
        for(int i=0; i<l.size(); i++){
            String p = l.get(i).getCodigo();
            f.addItem(p);
        }
    }

    public List<Curso> buscarCursos() throws GlobalException, SQLException {
        List<Curso> l = domainModel.allCurso();
        model.setTablaCursos(l);
        return l;
    }
   

    public Curso buscarCodCurso(String cod) throws Exception {
        Curso cur = domainModel.buscarCodCurso(cod);
        return cur;
    }

    public boolean buscarNomCurso(String nom) throws Exception {
        Curso cur = domainModel.buscarNomCurso(nom);
        if (cur != null) {
            model.getCursos().clear();
            model.agregaCurso(cur);
            model.setTablaCursos(model.getCursos());
            return true;
        }
        model.setTablaCursos(new ArrayList<>());
        return false;
    }
    
    public boolean buscarCodCurso1(String cod) throws Exception {
        Curso cur = domainModel.buscarCodCurso(cod);
        if (cur != null) {
            model.getCursos().clear();
            model.agregaCurso(cur);
            model.setTablaCursos(model.getCursos());
            return true;
        }
        model.setTablaCursos(new ArrayList<>());
        return false;
    }

    public boolean updateCurso(Curso cur) throws SQLException, GlobalException {
        return domainModel.updateCurso(cur);
    }
    
    public boolean deleteCurso(String cod) throws SQLException{
        return domainModel.deleteCurso(cod);
    }

    public void enter() {
        try {
            this.vc.retornaBox().removeAllItems();
            this.buscarCarreras();
        } catch (GlobalException ex) {
            Logger.getLogger(ControllerCursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.show();
    }

    public void show() {
        vc.setVisible(true);
        vc.seeCarreras();
    }

    ViewCursos vc;
    Model domainModel;
    TablaModelView2 model;
}
