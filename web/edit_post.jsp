<%@page import="model.dto.Post"%>
<%
    Post p = (Post) request.getAttribute("post");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../resources/css/bootstrap.min.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
        <h1>Editar Post</h1><br>
        
        <form action="${pageContext.request.contextPath}/Post/modificar" method="POST">
            <div class="form-group row">
		      <label for="inputPassword3" class="col-sm-2 col-form-label">Título</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" value="<%=p.getTitulo() %>" name="titulo" required>
		      </div>
		    </div>

			<div class="form-group row">
		      <label for="inputPassword3" class="col-sm-2 col-form-label">Cuerpo</label>
		      <div class="col-sm-10">
		        <textarea class="form-control" id="TextArea" name="cuerpo" required=""><%=p.getCuerpo()%></textarea>
		      </div>
		    </div>

		    <div class="form-group row">
		      <div class="offset-sm-2 col-sm-10 ">
		        <button class="btn btn-primary" style="float: right;" type="hidden" name="id" value="<%=p.getId() %>">Crear Post</button>
		      </div>
		    </div>

            <a href="list_post.jsp">Volver</a>
        </form>
    </div>
    </body>
</html>
