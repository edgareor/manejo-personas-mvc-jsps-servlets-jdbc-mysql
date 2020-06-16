package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.PersonasDAOImpl;
import modelo.Persona;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			if (request.getParameter("accion") != null) { // Validar si existe parametro accion

				if ((request.getParameter("accion")).contentEquals("editar")) { // Si la accion es igual  a EDITAR
					int idPersona = Integer.valueOf(request.getParameter("idPersona"));
					List<Persona> pers = new PersonasDAOImpl().selectById(idPersona);
					System.out.println(pers.get(0));
					request.setAttribute("persona", pers.get(0));
					request.getRequestDispatcher("editarPersona.jsp").forward(request, response);
				} else if((request.getParameter("accion")).contentEquals("eliminar")) {
					int idPersona = Integer.valueOf(request.getParameter("idPersona"));
					Persona per = new Persona();
					per.setId_persona(idPersona);
					int rowAffects = new PersonasDAOImpl().delete(per);
					System.out.println(rowAffects);
					response.sendRedirect("index.jsp");
				}

			} else { // SI no existe parametro accion, listar personas

				List<Persona> personas = new PersonasDAOImpl().select();
				int totalPersonas = personas.size();
				System.out.println(personas);
				request.setAttribute("personas", personas);
				request.setAttribute("totalPersonas", totalPersonas);
				request.getRequestDispatcher("personas.jsp").forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");

		System.out.println(accion);

		if (accion.equals("insertar")) { // No usar la comparacion (accion == "insertar")

			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String rut = request.getParameter("rut");

			Persona per = new Persona();
			per.setNombre(nombre);
			per.setApellido(apellido);
			per.setRut(rut);

			System.out.println(per);

			try {
				int rowAffect = new PersonasDAOImpl().insert(per);
				System.out.println(rowAffect);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (accion.equals("modificar")) {
			
			System.out.println("entro a modificar");
			
			int id = Integer.parseInt(request.getParameter("idPersona"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String rut = request.getParameter("rut");

			Persona per = new Persona();
			per.setId_persona(id);
			per.setNombre(nombre);
			per.setApellido(apellido);
			per.setRut(rut);
			
			System.out.println(per);
			
			try {
				int rowAffect = new PersonasDAOImpl().update(per);
				System.out.println(rowAffect);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("No se proporciono ninguna acción");
		}

		// volver a listar los datos despues de insertar alguna persona.
		response.sendRedirect("index.jsp");
	}

}
