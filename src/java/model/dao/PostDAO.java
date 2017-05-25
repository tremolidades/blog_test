/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Post;
import util.Conexion;

public class PostDAO {

    Conexion con;

    public PostDAO() {
        con = new Conexion();
    }
   
    //  public void ingresar(Post p) {
    public void ingresar(Post p) {
        //String sql = "INSERT INTO post" +
        //             "(`usuario_id`,`titulo`,`cuerpo`,`postestado_id`) " +
        //             "VALUES (" + p.getUsuario_id() + ",'"+ p.getTitulo() + "','"+ p.getCuerpo() + "',"+ p.getPostestado_id() + ")";
        //System.out.print(p.getTitulo());
        String sql = "INSERT INTO post" +
                     "(`usuario_id`,`titulo`,`cuerpo`,`post_estado_id`) " +
                     "VALUES (" + 2 + ",'"+ p.getTitulo() + "','"+ p.getCuerpo() + "',"+ 2 + ")";
        
        con.update(sql);
    }
          
    public void modificar(Post p, int id) {
        String sql = "update post SET "
                   + "titulo = '" + p.getTitulo() + "',"
                   + "cuerpo ='" + p.getCuerpo()+ "' "
                   + "where id=" + id;
        con.update(sql);
    }

    public ArrayList<Post> listar() {
        ArrayList<Post> post = new ArrayList<Post>();
        ResultSet datos = null;
        try {
            String sql = "SELECT * FROM post";

            datos = con.query(sql);

            while (datos.next()) {
                Post p = new Post();
                p.setId(datos.getInt("id"));
                p.setUsuario_id(datos.getInt("usuario_id"));
                p.setTitulo(datos.getString("titulo"));
                p.setCuerpo(datos.getString("cuerpo"));
                p.setPostestado_id(datos.getInt("post_estado_id"));

                //agregar profesor a arraylist de post
                post.add(p);


            }
        } catch (SQLException ex) {
            System.out.println("Listar");
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return post;


    }

    public void eliminar(int id) {
        String sql = "DELETE FROM post WHERE id=" + id;
        con.update(sql);
    }

    public Post buscar(int id) {
        try {
            String sql = "SELECT * FROM post WHERE id = " + id;
            ResultSet datos = null;

            datos = con.query(sql);

            datos.next();

            Post p = new Post();
            p.setId(datos.getInt("id"));
            p.setUsuario_id(datos.getInt("usuario_id"));
            p.setTitulo(datos.getString("titulo"));
            p.setCuerpo(datos.getString("cuerpo"));
            p.setPostestado_id(datos.getInt("post_estado_id"));

            return p;
        } catch (SQLException ex) {
            System.out.println("Buscar");
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}
