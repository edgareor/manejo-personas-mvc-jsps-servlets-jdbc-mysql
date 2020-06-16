<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous" />
        <script src="https://kit.fontawesome.com/07096502a7.js" crossorigin="anonymous"></script>
        <title>Control de Personas</title>
    </head>
    <body>
    	
    	<%-- Agregar Cabecero de Pagina --%>
        <header id="main-header" class="py-2 bg-info text-white">
            <div class="container">
            	<div class="row">
            		<div class="col-md-6">
                	<h1> <i class="fas fa-file-alt"></i> Control de Personas</h1>
                	</div>
                </div>
            </div>
        </header>
        
        <%-- Agregar boton Agregar Persona --%>
        <section id="actions" class="py-4 mb-4 bg-ligth">
        	<div class="container">
        		<div class="row">
        			<div class="col-md-3">
        				<a href="#" class="btn btn-primary btn-block" data-toggle="modal" data-target="#agregarPersonaModal"> 
        					<i class="fas fa-plus"></i> Agregar Persona
        				</a>
        			</div>
        		</div>
        	</div>
        </section>
        
        <div class="modal fade" id="agregarPersonaModal">
        	<div class="modal-dialog modal-lg">
        		<div class="modal-content">
        			<div class="modal-header bg-info text-white">
        				<h5 class="modal-title">Agregar Persona</h5>
        				<button class="close" data-dismiss="modal">
        					<span>&times;</span>
        				</button>
        			</div>
        			<form class="was-validated" action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="post">
        				<div class="modal-body">
        					<div class="form-group ">
        						<label for="nombre">Nombre (*): </label>
        						<input type="text" class="form-control" name="nombre" required>
        					</div>
        					<div class="form-group ">
        						<label for="apellido">Apellido (*):</label>
        						<input type="text" class="form-control" name="apellido" required>
        					</div>
        					<div class="form-group ">
        						<label for="rut">Rut (*):</label>
        						<input type="text" class="form-control" name="rut" required>
        					</div>
        				</div>
        				<div class="modal-footer">
        					<button class="btn btn-primary" type="submit">Enviar</button>
        					<button class="btn btn-primary" type="reset">Limpiar</button>
        				</div>
        			</form>
        		</div>
        	</div>
        </div>
        
        <section id="personas">
        	<div class="container">
        		<div class="row">
        			<div class="col-md-9">
        				<div class="card">
       					 	<div class="card-header">
       					 		<h4>Listado de Personas</h4>
       					 		<table class="table table-striped">
       					 			<thead class="thead-dark">
       					 				<tr>
       					 					<th>#</th>
       					 					<th>Nombre</th>
       					 					<th>Apellido</th>
       					 					<th>Rut</th>
       					 					<th></th>
       					 				</tr>
       					 			</thead>
       					 			<tbody>
       					 				<c:forEach var="persona" items="${personas}" varStatus="status">	<%-- Con el atributo varStatus creamos una variable de tipo contador --%>
       					 					<tr>
        						    			<td>${status.count}</td> 	<%-- Despues este contador se usa para enumerar los registros, y no tomar en cuenta el numero proporcionado por la BD, por si el indicador de registro esta erroneo --%>
        						    			<td>${persona.nombre}</td>
        						    			<td>${persona.apellido}</td> 
        						    			<td>${persona.rut}</td>
        						    			<td><a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idPersona=${persona.id_persona}" class="btn btn-secondary">
        						    				<i class="fas fa-edit">Editar</i>
        						    			</a></td>
        						    		</tr>
        								</c:forEach>
       					 			</tbody>
       					 		</table>
        					</div>
        				</div>
        			</div>
        			
        			<%-- Tarjeta lateral --%>
        			<div class="col-md-3">
        				<div class="card text-center bg-success text-white mb-3">
        					<div class="card-body">
        						<h3> Total Personas</h3>
        						<h4 class="display-4">
        							<i class="fas fa-users"></i> ${totalPersonas}
        						</h4>
        					</div>
        				</div>
        			</div>
        		</div>
        	</div>
        </section>   
        
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
