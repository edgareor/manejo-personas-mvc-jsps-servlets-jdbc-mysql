package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Persona;

// Clase de conexion a BD MySQL
public class PersonasDAOImpl{

	Connection conexionTransaccional = null;

	public PersonasDAOImpl() {
	}

	public PersonasDAOImpl(Connection conexionTransaccional) {
		this.conexionTransaccional = conexionTransaccional;
	}

	public List<Persona> select() throws SQLException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Persona per = null;
		List<Persona> perL = new ArrayList<Persona>();

		try {
			con = conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // Si se ingresa una conexion a la instancia, se usa esta ultima y no se crea una nueva
			stmt = con.prepareStatement("SELECT * FROM persona");

			rs = stmt.executeQuery();

			while (rs.next()) {
				per = new Persona();
				per.setId_persona(rs.getInt(1));
				per.setNombre(rs.getString(2));
				per.setApellido(rs.getString(3));
				per.setRut(rs.getString(4));

				perL.add(per);
			}
		} finally {
			if (this.conexionTransaccional == null) { // Si no se ingreso una conexion desde fuera, cerrar la conexion creada, por el contrario no cerrar si se ingresa una conexion de fuera.
				Conexion.close(con);
			}
			Conexion.close(stmt);
			Conexion.close(rs);
		}
		return perL;
	}
	
	public List<Persona> selectById(int id) throws SQLException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Persona per = null;
		List<Persona> perL = new ArrayList<Persona>();

		try {
			con = conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // Si se ingresa una conexion a la instancia, se usa esta ultima y no se crea una nueva
			stmt = con.prepareStatement("SELECT * FROM persona WHERE id_persona = ?");
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			while (rs.next()) {
				per = new Persona();
				per.setId_persona(rs.getInt(1));
				per.setNombre(rs.getString(2));
				per.setApellido(rs.getString(3));
				per.setRut(rs.getString(4));

				perL.add(per);
			}
		} finally {
			if (this.conexionTransaccional == null) { // Si no se ingreso una conexion desde fuera, cerrar la conexion creada, por el contrario no cerrar si se ingresa una conexion de fuera.
				Conexion.close(con);
			}
			Conexion.close(stmt);
			Conexion.close(rs);
		}
		return perL;
	}

	public int insert(Persona per) throws SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		int rows = 0; // Registros afectadps

		try {
			con = conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // Si se ingresa una conexion a la instancia, se usa esta ultima y no se crea una nueva;
			stmt = con.prepareStatement("INSERT INTO persona(nombre, apellido, rut) VALUE(?, ?, ?)");

			stmt.setString(1, per.getNombre());
			stmt.setString(2, per.getApellido());
			stmt.setString(3, per.getRut());

			rows = stmt.executeUpdate();
		} finally {
			if (this.conexionTransaccional == null) { // Si no se ingreso una conexion desde fuera, cerrar la conexion creada, por el contrario no cerrar si se ingresa una conexion de fuera.
				Conexion.close(con);
			}
			Conexion.close(stmt);
		}

		return rows;
	}

	public int update(Persona per) throws SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		int rows = 0; // Registros afectados

		try {
			con = conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // Si se ingresa una conexion a la instancia, se usa esta ultima y no se crea una nueva;
			stmt = con.prepareStatement("UPDATE persona SET nombre=?, apellido=?, rut=? WHERE id_persona=? ");
			stmt.setString(1, per.getNombre());
			stmt.setString(2, per.getApellido());
			stmt.setString(3, per.getRut());
			stmt.setInt(4, per.getId_persona());

			rows = stmt.executeUpdate();
		} finally {
			if (this.conexionTransaccional == null) { // Si no se ingreso una conexion desde fuera, cerrar la conexion creada, por el contrario no cerrar si se ingresa una conexion de fuera.
				Conexion.close(con);
			}
			Conexion.close(stmt);
		}
		return rows;
	}

	public int delete(Persona per) throws SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		int rows = 0; // Registros afectados

		try {
			con = conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection(); // Si se ingresa una conexion a la instancia, se usa esta ultima y no se crea una nueva;
			stmt = con.prepareStatement("DELETE FROM persona WHERE id_persona=?");

			stmt.setInt(1, per.getId_persona());

			rows = stmt.executeUpdate();
		} finally {
			Conexion.close(con);
			Conexion.close(stmt);
		}
		return rows;
	}
}
