/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class SQLConnection {
    protected static Connection cnx;
    private static final String CONNECTOR = "com.mysql.jdbc.Driver";
    private static final String PROTOCOLO = "jdbc:mysql:";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DATA_BASE = "jdbc:mysql://localhost/universidad";

    public SQLConnection() {
        cnx = null;
    }

    protected static void connection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(CONNECTOR);
            cnx=DriverManager.getConnection(DATA_BASE, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Falle" + e.getMessage());
            System.exit(-1);
        }   
    }

    public Connection obtenerConexion(String baseDatos,String usuario, String claveAcceso)throws SQLException {
        try{
           this.disconnect();
            cnx = DriverManager.getConnection(DATA_BASE, usuario, claveAcceso);
            return cnx;
        }catch(SQLException e){
            System.err.println("No se pudo conectar" + e.getMessage());
        }
        return null;
    }
    
    
    protected static void disconnect() throws SQLException {
        if (!cnx.isClosed()) {
            cnx.close();
        }
    }
}
