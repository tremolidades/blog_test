<%@page import="model.dto.Comentarios"%>
<%
    Comentarios c = (Comentarios) request.getAttribute("post");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <title>Creación de Usuarios</title>
    </head>
    <body>
        <div class="container">
		<h1>Creación de Usuarios</h1><br>

                <form action="${pageContext.request.contextPath}/Comentarios/ingresar" method="POST">

			<div class="form-group row">
		      <label for="inputPassword3" class="col-sm-2 col-form-label">Título</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" placeholder="Escriba Título del Comentario" name="titulo" required>
		      </div>
		    </div>

                    <div class="form-group row">
		      <label for="inputPassword3" class="col-sm-2 col-form-label">Cuerpo</label>
		      <div class="col-sm-10">
		        <textarea class="form-control" id="TextArea" name="cuerpo" placeholder="Escriba contenido del Comentario" required=""></textarea>
		      </div>
		    </div>

		    <div class="form-group row">
		      <div class="offset-sm-2 col-sm-10 ">
		        <button type="submit" class="btn btn-primary" style="float: right;">Crear Comentario</button>
		      </div>
		    </div>
                    <input type="hidden" name="Post_id" value="<%=c.getPost_id() %>" />
                    <input type="hidden" name="Comentario_id" value="<%=c.getPost_id() %>" />

		  </form>
	</div>
    </body>
</html>
