/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class ServiceMethodsUsuario implements Serializable{
    
    // Los procedimientos almacenados
     private static final String GETUSUARIO = "{call getUsuario(?, ?)}";

    
     private static ServiceMethodsUsuario instancia = null;
    private final GestorBaseDeDatos bd;
    
    private static final String CONEXION
            = "jdbc:mysql://localhost/universidad";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    public ServiceMethodsUsuario() throws InstantiationException, ClassNotFoundException, IllegalAccessException{
        
        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
    }
    
    public static ServiceMethodsUsuario obtenerInstancia() throws InstantiationException, ClassNotFoundException, IllegalAccessException{
    if (instancia == null) {
            instancia = new ServiceMethodsUsuario();
        }
        return instancia;
    
    }
    
    public boolean getUsuario(String usuario, String password){
        boolean r=false;
        try{
        try(Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
              PreparedStatement stm =cnx.prepareStatement(GETUSUARIO)){
            stm.clearParameters();
            stm.setString(1, usuario);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            r = rs.next();
        
        }
        
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
            
        }
        bd.cerrarConexion();
        return r;
    
    
    }

    
}
