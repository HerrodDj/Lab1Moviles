package Service;

import GestorSQL.GestorBaseDeDatos;
import models.Credenciales;
import exceptions.GlobalException;
import exceptions.NoDataException;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import models.Curso;

public class ServiceMethodsCurso implements Serializable {

    private static final String INSERTARCURSO = "{call crearCurso(?,?,?,?,?,?,?)}";
    private static final String ACTUALIZARCURSO = "{call actualizarCurso(?,?,?,?,?,?,?)}";
    private static final String ELIMINARCURSO = "{call eliminarCurso(?)}";
    private static final String BUSCARCURSOCODIGO = "{call buscarCursoCodigo(?)}";
    private static final String LISTARTODOCURSO = "{call listarTodoCurso()}";
    private static final String LISTARCURSOPORCARRERA = "{call listarCursoPorCarrera(?)}";

    private static ServiceMethodsCurso instancia = null;
    private final GestorBaseDeDatos bd;

    private static final String CONEXION
            = "jdbc:mysql://localhost/universidad";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    public ServiceMethodsCurso() throws InstantiationException, ClassNotFoundException, IllegalAccessException {

        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
    }

    public static ServiceMethodsCurso obtenerInstancia() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        if (instancia == null) {
            instancia = new ServiceMethodsCurso();
        }
        return instancia;

    }

    public boolean insertarCurso(Curso curso) throws GlobalException {
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    CallableStatement stm = cnx.prepareCall(INSERTARCURSO)) {
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
               
                bd.cerrarConexion();
                return true;

            }
        } catch (SQLException e) {
            throw new GlobalException("La base no se encuentra disponible");
        }

    }

    public Curso buscarCursoPorCodigo(String codigo) throws GlobalException, NoDataException, Exception {
        try {
            Curso cur = null;
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(BUSCARCURSOCODIGO)) {
                stm.setString(1, codigo);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    cur = new Curso(rs.getString("codigo"), rs.getString("nombre"),
                            rs.getInt("creditos"), rs.getInt("horas"),
                            rs.getString("carrera_Codigo"), rs.getInt("ciclo"), rs.getInt("anio"));
                }
            }
            bd.cerrarConexion();
            return cur;
        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }

    }
    
    

    public boolean actualizarCurso(Curso cur) throws SQLException, GlobalException {
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    CallableStatement stm = cnx.prepareCall(ACTUALIZARCURSO)) {
                stm.clearParameters();
                stm.setString(1, cur.getCodigo());
                stm.setString(2, cur.getNombre());
                stm.setInt(3, cur.getCreditos());
                stm.setInt(4, cur.getHorasSemanales());
                stm.setString(5, cur.getCodigoCarrera());
                stm.setInt(6, cur.getCiclo());
                stm.setInt(7, cur.getAnio());
                stm.executeUpdate();
                stm.close();
               
                bd.cerrarConexion();
                return true;
            }

        } catch (SQLException e) {
            throw new GlobalException("Error en base de datos");
        }
    }

    public boolean eliminarCurso(String cod) {
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(ELIMINARCURSO)) {
                stm.setString(1, cod);
                stm.executeUpdate();
            }
            bd.cerrarConexion();
        } catch (SQLException e) {
            return false;
        }
        return true;

    }

    public ArrayList<Curso> listarTodos() throws SQLException, GlobalException {
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(LISTARTODOCURSO)) {
                ResultSet rs = stm.executeQuery();
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
                stm.close();
                bd.cerrarConexion();
                return new ArrayList<>(map.values());
            }
        } catch (SQLException e) {
            throw new GlobalException("La base de datos no se encuentra disponible");
        }

    }

    public ArrayList<Curso> listarCursosPorCarrera(String carreraCodigo) throws SQLException, GlobalException {
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(LISTARCURSOPORCARRERA)) {
                stm.setString(1, carreraCodigo);
                ResultSet rs = stm.executeQuery();
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
                stm.close();
                bd.cerrarConexion();
                return new ArrayList<>(map.values());
            }
        } catch (SQLException e) {
            throw new GlobalException("La base de datos no se encuentra disponible");
        }
    }

}
