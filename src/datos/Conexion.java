package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

//Clase de conexion a BD MySQL
public class Conexion {

	// Configurar Pool de Conexiones, especificando datos de conexion a la BD.
	public static DataSource getDataSource() {

		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("admin");
		
		ds.setInitialSize(50); // Definimos el tamano del pool de conexiones

		return ds;
	}

	// Obtener conexion a la BD
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
	
	// Sobrecarga de metodo "close" para cerrar objetos introducidos.

	// Metodo para cerrar objetos de tipo ResultSet
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Metodo para cerrar objetos de tipo PreparedStatement
	public static void close(PreparedStatement smtp) {
		try {
			smtp.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Metodo para cerrar objetos de tipo Connection
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
