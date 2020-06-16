<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous" />
        <script src="https://kit.fontawesome.com/07096502a7.js" crossorigin="anonymous"></script>
        <title>Editar Persona</title>
    </head>
<body>

    	<%-- Agregar Cabecero de Pagina --%>
        <header id="main-header" class="py-2 mb-4 bg-info text-white">
            <div class="container">
            	<div class="row">
            		<div class="col-md-6">
                	<h1> <i class="fas fa-file-alt"></i> Editar Personas</h1>
                	</div>
                </div>
            </div>
        </header>
        
        <%-- Formulario para editar personas --%>
        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idPersona=${persona.id_persona}" method="post" class="was-validated">
        
        <section id="details">
        	<div class="container">
        		<div class="row">
        			<div class="col">
        				<div class="card">
        					<div class="card-header">
        						<h4>Editar Persona</h4>
        					</div>
        					<div class="card-body">
        					<div class="form-group ">
        						<label for="nombre">Nombre (*): </label>
        						<input type="text" class="form-control" name="nombre" required value="${persona.nombre}">
        					</div>
        					<div class="form-group ">
        						<label for="apellido">Apellido (*):</label>
        						<input type="text" class="form-control" name="apellido" required value="${persona.apellido}">
        					</div>
        					<div class="form-group ">
        						<label for="rut">Rut (*):</label>
        						<input type="text" class="form-control" name="rut" required value="${persona.rut}">
        					</div>
        					</div>
        				</div>
        			</div>
        		</div>
        	</div>
        </section>
        
        <%-- Boton de Volver y de Guardar información --%>
        <section id="actions" class="py-4 mb-4 bg-light">
        	<div class="container">
        		<div class="row">
        			<div class="col-md-3">
        				<a href="index.jsp" class="btn btn-ligth btn-block"><i class="fas fa-arrow-left"></i> Regresar al inicio</a>
        			</div>
        			<div class="col-md-3">
        				<button type="submit" class="btn btn-success btn-block">
        					<i class="fas fa-check"></i> Guardar Cliente
        				</button>
        			</div>
        			<div class="col-md-3">
        				<a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idPersona=${persona.id_persona}" class="btn btn-danger btn-block">
        					<i class="fas fa-user-minus"></i> Eliminar Cliente
        				</a>
        			</div>
        		</div>
        	</div>
        </section>
        
        </form>

        <%-- Agregar pie de página --%>
        <footer id="pie-pagina" class="bg-warning text-white mt-5 p-5">
        	<div class="container">
        		<div class="col">
        			<p class="lead text-center">
        				Copyright &copy; Edgar Ojeda
        			</p>
        		</div>
        	</div>
        </footer>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>