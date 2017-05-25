<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Post"%>
<%@page import="model.dao.PostDAO"%>
<%@page import="model.dto.Comentarios"%>
<%@page import="model.dao.ComentariosDAO"%>

<%
  PostDAO pstDao = new PostDAO();
  ArrayList<Post> posts = pstDao.listar();
  ComentariosDAO comDao = new ComentariosDAO();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
    </head>
    <body>
        <h1>Blog</h1>
        <h3>Noticias</h3>
        <table>
            <% for(Post p : posts){ %>
            <tr>
                <th>
                    <%=p.getTitulo() %>
                </th>
            </tr>
            <tr>
                <td><%=p.getCuerpo() %></td>
            </tr>
            <% ArrayList<Comentarios> coms = comDao.listar(p.getId());
               for(Comentarios c : coms){ %>
            <tr>
                <td><%=c.getComentario() %></td>
            </tr>
            <% } %>
            <tr>
                <td><a href="Comentario/ingresar?id=<%=p.getId() %>">Comentar</a></td>
            </tr>
            <tr></tr>
            <% } %>
        </table>
        
        <a href="index.jsp">Volver</a>
    </body>
</html>