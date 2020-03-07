/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import static Service.SQLConnection.disconnect;
import exceptions.GlobalException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Usuario;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class ServiceMethodsUsuario extends SQLConnection{
    
    private static final String GETUSUARIO = "{call getUsuario(?, ?)}";

    private static final String CONEXION
            = "jdbc:mysql://localhost/universidad";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    
    public Usuario getUsuario(String cedula, String password) throws GlobalException{
            try {
            Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
            Usuario u = null;
            try (CallableStatement statement = c.prepareCall(GETUSUARIO)) {
                statement.setString(1, cedula);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    u = new Usuario(rs.getString("cedula"), rs.getString("nombre"),
                            rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("contrasenia"));
                }
            }
            disconnect();
            return u;
        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }
    }
    
    
    
    
}
