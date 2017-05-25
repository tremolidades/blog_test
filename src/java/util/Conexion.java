/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private String socket = "localhost:3306";
    private String user = "root";
    private String pass = "h20152015";
    private String database = "mydb";

    private Connection con;
    private Statement st;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + socket + "/" + database;
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            Logger.getLogger(Conexion.class.getName()).log(Level.INFO, "Conexion exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al establecer la conexión : ClassNotFound");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al establecer la conexión : SQLExeption");
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al establecer la conexión : InstantiationException");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al establecer la conexión : IlegalAccessExeption");
        }
    }

    public void update(String sql) {
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error en sentencia SQL :  {0}", sql);
        }catch(Exception ex){
               Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error  :  {0}", ex.getMessage());
        }
    }

    public ResultSet query(String sql) {
        ResultSet datos = null;
        try {
            datos = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error en sentencia SQL :  {0}", sql);
        }

        return datos;
    }
}
