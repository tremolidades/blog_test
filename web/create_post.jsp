<%-- 
    Document   : create_post
    Created on : 23-05-2017, 19:52:40
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <title>Creación de Post</title>
    </head>
    <body>
        <div class="container">
		<h1>Creación de Post</h1><br>

                <form action="Post/ingresar" method="POST">

			<div class="form-group row">
		      <label for="inputPassword3" class="col-sm-2 col-form-label">Título</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" placeholder="Escriba Título del post" name="titulo" required>
		      </div>
		    </div>

			<div class="form-group row">
		      <label for="inputPassword3" class="col-sm-2 col-form-label">Cuerpo</label>
		      <div class="col-sm-10">
		        <textarea class="form-control" id="TextArea" name="cuerpo" placeholder="Escriba contenido del Post" required=""></textarea>
		      </div>
		    </div>

		    <div class="form-group row">
		      <div class="offset-sm-2 col-sm-10 ">
		        <button type="submit" class="btn btn-primary" style="float: right;">Crear Post</button>
		      </div>
		    </div>

		  </form>
	</div>
    </body>
</html>
