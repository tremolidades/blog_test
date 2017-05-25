<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Post"%>
<%@page import="model.dao.PostDAO"%>
<%
  PostDAO pstDao = new PostDAO();
  ArrayList<Post> posts = pstDao.listar();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <title>Todos los Post</title>
    </head>
    <body>
        <div class="container container-fluid">
            <h1>Listar Post</h1><br>
            <a href="create_post.jsp">Crear</a>
            <table id="example" class="table table-striped table-bordered dataTable no-footer dtr-inline" cellspacing="0" width="100%" role="grid" aria-describedby="example_info" style="width: 100%;">
            <thead>
                <tr role="row">
                    <th class="sorting_asc" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="ID
                            : activate to sort column descending" style="width: 20px;" aria-sort="ascending">ID
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="titulo
                            : activate to sort column ascending" style="width: 185px;">Título</th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Cuerpo
                            : activate to sort column ascending" style="width: 157px;">Cuerpo</th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: 75px;" aria-label="Acción: activate to sort column ascending">Acción</th>
                </tr>
            </thead>
                 <tbody>
                <% for(Post p : posts){ %>

                    <tr role="row" class="odd">
                        <td tabindex="0" class="sorting_1"><%=p.getId() %></td>
                        <td><%=p.getTitulo() %></td>
                        <td><p><%=p.getCuerpo()%></p></td>
                        <td>
                            <a href="Post/buscar?id=<%=p.getId() %>" type="button" class="btn btn-warning" aria-label="Left Align">
                                <span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
                            </a>
                            <a type="button" href="Post/eliminar?id=<%=p.getId() %>" class="btn btn-danger" aria-label="Left Align">
                                <span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
                            </a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
            </table>

            <a href="index.jsp">Volver</a>
        </div>
    </body>
</html>
