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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import models.Curso;

/**
 *
 * @author demil
 */
public class ServiceMethodsCurso extends SQLConnection {

    private static final String INSERTARCURSO = "{call crearCurso(?,?,?,?,?,?,?)}";
    private static final String ACTUALIZARCURSO = "{call actualizarCurso(?,?,?,?,?,?,?)}";
    private static final String ELIMINARCURSO = "{call eliminarCurso(?)}";
    private static final String BUSCARCURSOCODIGO = "{call buscarCursoCodigo(?)}";
    private static final String LISTARTODOCURSO = "{call listarTodoCurso()}";
    private static final String LISTARCURSOPORCARRERA = "{call listarCursoPorCarrera(?)}";

    private static final String CONEXION
            = "jdbc:mysql://localhost/universidad";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root1234";

    public void insertarCurso(Curso Ncurso) throws GlobalException, NoDataException, Exception {
        try {
            Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
            CallableStatement stm = c.prepareCall(INSERTARCURSO);
            stm.clearParameters();
            stm.setString(1, Ncurso.getCodigo());
            stm.setString(2, Ncurso.getNombre());
            stm.setInt(3, Ncurso.getCreditos());
            stm.setInt(4, Ncurso.getHorasSemanales());
            stm.setString(5, Ncurso.getCodigoCarrera());
            stm.setInt(6, Ncurso.getCiclo());
            stm.setInt(7, Ncurso.getAnio());
            stm.executeUpdate();
            stm.close();
            c.close();
        } catch (SQLException e) {
            throw new GlobalException("La base de datos no se encuentra disponible");
        }
    }

    public Curso buscarCursoPorCodigo(String codigo) throws GlobalException, NoDataException, Exception {
        try {
            Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
            Curso cur = null;
            try (CallableStatement statement = c.prepareCall(BUSCARCURSOCODIGO)) {
                statement.setString(1, codigo);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    cur = new Curso(rs.getString("codigo"), rs.getString("nombre"),
                            rs.getInt("creditos"), rs.getInt("horas"),
                            rs.getString("carrera_Codigo"), rs.getInt("ciclo"), rs.getInt("anio"));
                }
            }
            disconnect();
            return cur;
        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }

    }

    public void actualizarCurso(Curso cur) throws SQLException, GlobalException {
        try {
            try (Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
                    CallableStatement statement = c.prepareCall(ACTUALIZARCURSO)) {
                statement.setString(1, cur.getCodigo());
                statement.setString(2, cur.getNombre());
                statement.setInt(3, cur.getCreditos());
                statement.setInt(4, cur.getHorasSemanales());
                statement.setString(5, cur.getCodigoCarrera());
                statement.setInt(6, cur.getCiclo());
                statement.setInt(6, cur.getAnio());
                statement.executeUpdate();
            }
            disconnect();
        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }
    }

    public boolean eliminarCurso(String cod) {
        try {
            Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
            try (CallableStatement statement = c.prepareCall(ELIMINARCURSO)) {
                statement.setString(1, cod);
                statement.executeUpdate();
            }
            disconnect();
        } catch (SQLException e) {
            return false;
        }
        return true;

    }

    public ArrayList<Curso> listarTodos() throws SQLException {
        Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
        CallableStatement statement = c.prepareCall(LISTARTODOCURSO);
        ResultSet rs = statement.executeQuery();
        Map<String, Curso> map = new HashMap();
        while (rs.next()) {
            String codigo = rs.getNString("codigo");
            if (map.isEmpty() || !map.containsKey(codigo)) {
                Curso cur = new Curso();
                cur.setCodigo(codigo);
                cur.setNombre(rs.getString("nombre"));
                cur.setCreditos(rs.getInt("creditos"));
                cur.setHorasSemanales(rs.getInt("horas"));
                cur.setCodigoCarrera(rs.getString("carrera_codigo"));
                cur.setCiclo(rs.getInt("ciclo"));
                cur.setAnio(rs.getInt("anio"));
                map.put(codigo, cur);

            }

        }
        statement.close();
        disconnect();
        return new ArrayList<>(map.values());

    }
    
    public ArrayList<Curso> listarCursosPorCarrera(String carreraCodigo) throws SQLException{
       Connection c = obtenerConexion(CONEXION, USUARIO, CLAVE);
        CallableStatement statement = c.prepareCall(LISTARCURSOPORCARRERA);
        statement.setString(1, carreraCodigo);
        ResultSet rs = statement.executeQuery();
        Map<String, Curso> map = new HashMap();
        while (rs.next()) {
            String codigo = rs.getNString("codigo");
            if (map.isEmpty() || !map.containsKey(codigo)) {
                Curso cur = new Curso();
                cur.setCodigo(codigo);
                cur.setNombre(rs.getString("nombre"));
                cur.setCreditos(rs.getInt("creditos"));
                cur.setHorasSemanales(rs.getInt("horas"));
                cur.setCodigoCarrera(rs.getString("carrera_codigo"));
                cur.setCiclo(rs.getInt("ciclo"));
                cur.setAnio(rs.getInt("anio"));
                map.put(codigo, cur);

            }

        }
        statement.close();
        disconnect();
        return new ArrayList<>(map.values());
    
    }

        

}
