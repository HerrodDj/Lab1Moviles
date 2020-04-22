/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import Service.ServiceMethodsCarrera;
import Service.ServiceMethodsCurso;
import Service.ServiceMethodsUsuario;
import exceptions.GlobalException;
import exceptions.NoDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author PC
 */
public class Model extends Observable {

    public Model() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        this.su = new ServiceMethodsUsuario();
        this.sc = new ServiceMethodsCarrera();
        this.scu = new ServiceMethodsCurso();
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
    
    public Carrera buscarCodCarrera(String cod) throws NoDataException, Exception{
        Carrera Nc = sc.BuscarCarreraCodigo(cod);
        return Nc;
    }
    
    public Carrera buscarNomCarrera(String nom) throws NoDataException, Exception{
        Carrera Nc = sc.BuscarCarreraNombre(nom);
        return Nc;
    }
    
    public boolean updateCarrera(Carrera eC) throws SQLException, GlobalException{
        return sc.actualizarCarrera(eC);
    }
    
    public boolean deleteCarrera(String cod) throws SQLException{
        return sc.eliminarCarrera(cod);
    }

    
     public boolean AddCurso(Curso curso) throws NoDataException, Exception {
        return scu.insertarCurso(curso);
    }
    
     public List<Curso> allCurso() throws SQLException, GlobalException {
        return scu.listarTodos();
    }

    public Curso buscarCodCurso(String cod) throws NoDataException, Exception {
        return scu.buscarCursoPorCodigo(cod);
    }
    
     public Curso buscarNomCurso(String nom) throws NoDataException, Exception {
        return scu.buscarCursoPorNombre(nom);
    }

    public boolean updateCurso(Curso cur) throws SQLException, GlobalException {
        return scu.actualizarCurso(cur);
    }

    public boolean deleteCurso(String cod) {
        return scu.eliminarCurso(cod);
    }
    
    ServiceMethodsUsuario su;
    ServiceMethodsCarrera sc;
    ServiceMethodsCurso scu;

   

   

  

}
