/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import exceptions.GlobalException;
import exceptions.NoDataException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Carrera;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class ServiceMethodsCarrera implements Serializable {

    private static final String INSERTARCARRERA = "{call crearCarrera(?,?,?)}";
    private static final String EDITARCARRERA = "{call actualizarCarrera(?,?,?)}";
    private static final String ELIMINARCARRERA = "{call eliminarCarrera(?)}";
    private static final String BUSCARCARRERACODIGO = "{call buscarCarreraCodigo(?)}";
    private static final String BUSCARCARRERANOMBRE = "{call buscarCarreraNombre(?)}";
    private static final String BUSCARCARRERAALL = "{call listarTodaCarrera()}";

    private static ServiceMethodsCarrera instancia = null;
    private final GestorBaseDeDatos bd;

    private static final String CONEXION
            = "jdbc:mysql://localhost/universidad";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    public ServiceMethodsCarrera() throws InstantiationException, ClassNotFoundException, IllegalAccessException {

        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
    }

    public static ServiceMethodsCarrera obtenerInstancia() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        if (instancia == null) {
            instancia = new ServiceMethodsCarrera();
        }
        return instancia;

    }

    public boolean insertarCarrera(Carrera Ncarrera) throws GlobalException, NoDataException, Exception {
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(INSERTARCARRERA)) {
                stm.clearParameters();
                stm.setString(1, Ncarrera.getCodigo());
                stm.setString(2, Ncarrera.getNombre());
                stm.setString(3, Ncarrera.getTitulo());
                stm.executeUpdate();
                stm.close();
                bd.cerrarConexion();
                return true;
            }
        } catch (SQLException e) {
            throw new GlobalException("La base de datos no se encuentra disponible");
        }
    }

    public List<Carrera> buscarTodasCarreras() throws GlobalException {
        List<Carrera> Nc = new ArrayList();
        try {
            Carrera car = null;
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(BUSCARCARRERAALL)) {
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    car = new Carrera(rs.getString("codigo"), rs.getString("nombre"), rs.getString("titulo"), null);
                    Nc.add(car);
                }
            }
            bd.cerrarConexion();
        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }
        return Nc;
    }

    public Carrera BuscarCarreraCodigo(String codigo) throws GlobalException, NoDataException, Exception {
        try {
            Carrera car = null;
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(BUSCARCARRERACODIGO)) {
                stm.setString(1, codigo);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    car = new Carrera(rs.getString("codigo"), rs.getString("nombre"), rs.getString("titulo"), null);
                }
            }
            bd.cerrarConexion();
            return car;
        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }
    }
    
        public Carrera BuscarCarreraNombre(String nombre) throws GlobalException, NoDataException, Exception {
        try {
            Carrera car = null;
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(BUSCARCARRERANOMBRE)) {
                stm.setString(1, nombre);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    car = new Carrera(rs.getString("codigo"), rs.getString("nombre"), rs.getString("titulo"), null);
                }
            }
            bd.cerrarConexion();
            return car;
        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }
    }

    public boolean actualizarCarrera(Carrera car1) throws SQLException, GlobalException {
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(EDITARCARRERA)) {
                stm.setString(1, car1.getCodigo());
                stm.setString(2, car1.getNombre());
                stm.setString(3, car1.getTitulo());
                stm.executeUpdate();
            }
            bd.cerrarConexion();
            return true;
        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }
    }

    public boolean eliminarCarrera(String cod) throws SQLException {
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(ELIMINARCARRERA)) {

                stm.setString(1, cod);
                stm.executeUpdate();
            }
            bd.cerrarConexion();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

}
