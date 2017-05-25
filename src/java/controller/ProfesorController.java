/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.ProfesorDAO;
import model.dto.Profesor;
import util.Ayudante;

public class ProfesorController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProfesorDAO profeDAO = new ProfesorDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        int id = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "eliminar":
                profeDAO.eliminar(id);
                response.sendRedirect("../listarProfesores.jsp");
                break;
            case "buscar":
                Profesor p = profeDAO.buscar(id);
                request.setAttribute("profesor", p);
                request.getRequestDispatcher("../modificarProfesor.jsp").forward(request, response);

        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombres = request.getParameter("txtNombres");
        String apellidos = request.getParameter("txtApellidos");
        String correo = request.getParameter("txtCorreo");
        String idUpdate = request.getParameter("txtId");
        
        System.out.print(idUpdate);
        ProfesorDAO profeDAO = new ProfesorDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        

        switch (accion) {
            case "ingresar":
                Profesor p = new Profesor();
                p.setNombres(nombres);
                p.setApellidos(apellidos);
                p.setCorreo(correo);
                //profeDAO.ingresar(p);
                break;
            case "modificar":
                Profesor pro = new Profesor();
                pro.setNombres(nombres);
                pro.setApellidos(apellidos);
                profeDAO.modificar(pro, Integer.parseInt(idUpdate));
                break;
            default:
                throw new AssertionError();
        }
        //Validaciones
        //Crear objeto profesor y cargar datos desde formulario

        //Redireccionar
        response.sendRedirect("../index.html");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
