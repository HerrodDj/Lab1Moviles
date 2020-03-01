/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import static Service.SQLConnection.disconnect;
import exceptions.GlobalException;
import exceptions.NoDataException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Carrera;
import models.Curso;
import Service.SQLConnection;

/**
 *
 * @author demil
 */
public class ServiceMethodsCurso extends SQLConnection {

    private static final String INSERTARCURSO = "{?=call crearCurso(?,?,?,?,?,?,?)}";
    private static final String ACTUALIZARCURSO = "{?=call actualizarCurso(?,?,?,?,?,?,?)}";
    private static final String ELIMINARCURSO = "{call eliminarCurso(?)}";
    private static final String BUSCARCURSOCODIGO = "{call buscarCursoCodigo(?)}";
    private static final String LISTARTODOCURSO = "{call listarTodoCurso()}";
    private static final String LISTARCURSOPORCARRERA = "{call listarCursoPorCarrera(?)}";

    private static final String CONEXION
            = "jdbc:mysql://localhost/universidad";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root1234";

    public void insertarCurso(Curso curso) throws GlobalException, NoDataException, Exception {
        try {
            Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
            CallableStatement stm = c.prepareCall(INSERTARCURSO);
            stm.clearParameters();
            stm.setString(1, curso.getCodigo());
            stm.setString(2, curso.getNombre());
            stm.setInt(3, curso.getCreditos());
            stm.setInt(4, curso.getHorasSemanales());
            stm.setString(5, curso.getCodigoCarrera());
            stm.setInt(6, curso.getCiclo());
            stm.setInt(7, curso.getAnio());
            stm.executeUpdate();
            stm.close();
            c.close();

        } catch (SQLException e) {
            throw new GlobalException("La base de datos no se encuentra disponible");
        }
    }

    public Carrera BuscarCursoPorCodigo(String codigo) throws GlobalException, NoDataException, Exception {
        try {
            Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
            CallableStatement stm = c.prepareCall(BUSCARCURSOCODIGO);
            Carrera car;

            stm.setString(1, codigo);
            ResultSet rs = stm.executeQuery();
            car = new Carrera(rs.getString("codigo"), rs.getString("nombre"), rs.getString("titulo"), null);

            disconnect();
            return car;
        } catch (SQLException e) {
            throw new GlobalException("No se pudo completar la operacion");
        }
    }

}
