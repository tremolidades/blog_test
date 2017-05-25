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
import model.dto.Comentarios;
import util.Conexion;

public class ComentariosDAO {

    Conexion con;

    public ComentariosDAO() {
        con = new Conexion();
    }
   
    //  public void ingresar(Comentarios p) {
    public void ingresar(Comentarios c) {
        String sql = "INSERT INTO comentarios" +
                     "(`usuario_id`,`comentario_estado_id`,`post_id`,`comentariosestado_id`) " +
                     "VALUES (" + c.getUsuario_id() + ",'"+ c.getComentario_estado_id() + "','"+ c.getPost_id() + "',"+ c.getComentario() + ")";
        con.update(sql);
    }
          
    public void modificar(Comentarios c, int post_id) {
        String sql = "update comentarios SET "
                   + "comentario = '" + c.getComentario() + "',"
                   + "comentario_estado_id ='" + c.getComentario_estado_id()+ "' "
                   + "where id=" + post_id;
        con.update(sql);
    }

    public ArrayList<Comentarios> listar(int id) {
        ArrayList<Comentarios> comentarios = new ArrayList<Comentarios>();
        ResultSet datos = null;
        try {
            String sql = "SELECT * FROM comentarios WHERE id=" + id;

            datos = con.query(sql);

            while (datos.next()) {
                Comentarios c = new Comentarios();
                c.setId(datos.getInt("id"));
                c.setUsuario_id(datos.getInt("usuario_id"));
                c.setComentario_estado_id(datos.getInt("comentario_estado_id"));
                c.setPost_id(datos.getInt("post_id"));
                c.setComentario(datos.getString("comentario"));

                //agregar profesor a arraylist de comentarios
                comentarios.add(c);


            }
        } catch (SQLException ex) {
            Logger.getLogger(ComentariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return comentarios;


    }

    public void eliminar(int id) {
        String sql = "DELETE FROM comentarios WHERE id=" + id;
        con.update(sql);
    }

    public Comentarios buscar(int id) {
        try {
            String sql = "SELECT * FROM comentarios WHERE id = " + id;
            ResultSet datos = null;

            datos = con.query(sql);

            datos.next();

            Comentarios c = new Comentarios();
            c.setId(datos.getInt("id"));
            c.setUsuario_id(datos.getInt("usuario_id"));
            c.setComentario_estado_id(datos.getInt("comentario_estado_id"));
            c.setPost_id(datos.getInt("post_id"));
            c.setComentario(datos.getString("comentario"));

            return c;
        } catch (SQLException ex) {
            Logger.getLogger(ComentariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}
