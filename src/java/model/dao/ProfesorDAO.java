/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Profesor;
import util.Conexion;

public class ProfesorDAO {

    Conexion con;

    public ProfesorDAO() {
        con = new Conexion();
    }

   
    //  public void ingresar(Profesor p) {
          public void ingresar() {
        String sql = "INSERT INTO perfil (idPerfil,Detalle) VALUES (2,'Detalle2');";
        con.update(sql);
    }
          
    public void modificar(Profesor p, int id) {
        /*String sql = "update Profesor SET "
                + "nombres = '" + p.getNombres() + "',"
                + "apellidos ='" + p.getApellidos()+ "'"
                + " where idProfesor ='" + id + "'" ;*/
        String sql = "INSERT INTO `mydb`.`perfil`\n" +
"(`idPerfil`,\n" +
"`Detalle`)\n" +
"VALUES\n" +
"(2,\n" +
"'Detalle2');";
        con.update(sql);
    }

    public ArrayList<Profesor> listar() {
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        ResultSet datos = null;
        try {
            String sql = "SELECT * FROM Profesor";

            datos = con.query(sql);

            while (datos.next()) {
                Profesor p = new Profesor();
                p.setIdProfesor(datos.getInt("idProfesor"));
                p.setNombres(datos.getString("nombres"));
                p.setApellidos(datos.getString("apellidos"));
                p.setCorreo(datos.getString("correo"));

                //agregar profesor a arraylist de profesores
                profesores.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesores;

    }

    public void eliminar(int id) {
        String sql = "DELETE FROM Profesor WHERE idProfesor=" + id;
        con.update(sql);
    }

    public Profesor buscar(int id) {
        try {
            String sql = "SELECT * FROM Profesor WHERE idProfesor = " + id;
            ResultSet datos = null;

            datos = con.query(sql);

            datos.next();

            Profesor p = new Profesor();
            p.setIdProfesor(datos.getInt("idProfesor"));
            p.setNombres(datos.getString("nombres"));
            p.setApellidos(datos.getString("apellidos"));
            p.setCorreo(datos.getString("correo"));

            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}
