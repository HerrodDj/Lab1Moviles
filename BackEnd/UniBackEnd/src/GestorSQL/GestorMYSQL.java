/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorSQL;

import static GestorSQL.GestorBaseDeDatos.SERVIDOR_POR_DEFECTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class GestorMYSQL extends GestorBaseDeDatos {

    private static final String MANEJADOR_DB = "com.mysql.jdbc.Driver";
    private static final String PROTOCOLO = "jdbc:mysql:";

    GestorMYSQL(String servidor)
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        super("Gestor MYSQL", servidor);
        Class.forName(MANEJADOR_DB).newInstance();
    }

    GestorMYSQL()
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        this(SERVIDOR_POR_DEFECTO);
    }

    @Override
    public Connection obtenerConexion(String baseDatos,
            String usuario, String claveAcceso)
            throws SQLException {
        cerrarConexion();
        String URL_conexion
                = String.format("%s//%s/%s", PROTOCOLO, URL_servidor, baseDatos);

        cnx = DriverManager.getConnection(URL_conexion, usuario, claveAcceso);
        return cnx;
    }

}