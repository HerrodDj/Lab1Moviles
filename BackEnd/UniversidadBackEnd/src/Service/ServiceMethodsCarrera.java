/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import exceptions.GlobalException;
import exceptions.NoDataException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Carrera;

/**
 *
 * @author demil
 */
public class ServiceMethodsCarrera extends SQLConnection {

private static final String INSERTARCARRERA = "{call crearCarrera(?,?,?)}";
    private static final String EDITARCARRERA = "{call actualizarCarrera(?,?,?)}";
    private static final String ELIMINARCARRERA = "{call eliminarCarrera(?)}";
    private static final String BUSCARCARRERA = "{call buscarCarreraCodigo(?)}";

    private static final String CONEXION
            = "jdbc:mysql://localhost/universidad";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    public void insertarCarrera(Carrera Ncarrera) throws GlobalException, NoDataException, Exception {
        try {
            Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
            CallableStatement stm = c.prepareCall(INSERTARCARRERA);
            stm.clearParameters();
            stm.setString(1, Ncarrera.getCodigo());
            stm.setString(2, Ncarrera.getNombre());
            stm.setString(3, Ncarrera.getTitulo());
            stm.executeUpdate();
            stm.close();
            c.close();
        } catch (SQLException e) {
            throw new GlobalException("La base de datos no se encuentra disponible");
        }
    }

    public Carrera BuscarCarreraCodigo(String cod) throws GlobalException, NoDataException, Exception {
        try {
            Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
            Carrera car = null;
            try (CallableStatement statement = c.prepareCall(BUSCARCARRERA)) {
                statement.setString(1, cod);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    car = new Carrera(rs.getString("codigo"), rs.getString("nombre"), rs.getString("titulo"), null);
                }
            }
            disconnect();
            return car;
        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }
    }

    public void actualizarCarrera(Carrera car1) throws SQLException, GlobalException {
        try {
            try (Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
                    CallableStatement statement = c.prepareCall(EDITARCARRERA)) {
                statement.setString(1, car1.getCodigo());
                statement.setString(2, car1.getNombre());
                statement.setString(3, car1.getTitulo());
                statement.executeUpdate();
            }
            disconnect();
        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }
    }

    public boolean eliminarCarrera(String cod) throws SQLException {
        try {
            Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
            try (CallableStatement statement = c.prepareCall(ELIMINARCARRERA)) {
                statement.setString(1, cod);
                statement.executeUpdate();
            }
            disconnect();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    
    
}
