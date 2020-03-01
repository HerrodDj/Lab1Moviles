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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Carrera;

/**
 *
 * @author demil
 */
public class ServiceMethodsCarrera extends SQLConnection {

    private static final String INSERTARCARRERA = "{?=call  buscarFactura(?)}";
    private static final String EDITARCARRERA = "{?=call buscarProducto(?)}";
    private static final String ELIMINARCARRERA = "{call insertarDetalle(?,?,?,?)}";
    private static final String BUSCARCARRERA = "{call insertarFactura(?,?,?)}";

    private static final String CONEXION
            = "jdbc:mysql://localhost/universidad";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    public void insertarCarrera(Carrera Ncarrera) throws GlobalException, NoDataException, Exception {
        try {
            obtenerConexion(CONEXION, USUARIO, CLAVE);
            PreparedStatement stm = cnx.prepareStatement(INSERTARCARRERA);
            stm.clearParameters();
            stm.setString(1, Ncarrera.getCodigo());
            stm.setString(2, Ncarrera.getNombre());
            stm.setString(3, Ncarrera.getTitulo());
            if (stm.executeUpdate() != 1) {
                throw new GlobalException("No se pudo insertar la carrera");
            }
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
    }

    public Carrera BuscarCarreraNombre(String nombre) throws GlobalException, NoDataException, Exception {
        try {
            Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
            Carrera car;
            try (CallableStatement statement = c.prepareCall(BUSCARCARRERA)) {
                statement.setString(1, nombre);
                ResultSet rs = statement.executeQuery();
                car = new Carrera(rs.getString("codigo"),rs.getString("nombre"),rs.getString("titulo"),null);
            }
            disconnect();
            return car;
        } catch (SQLException e) {
            throw new GlobalException("No se pudo completar la operacion");
        }
    }
}
