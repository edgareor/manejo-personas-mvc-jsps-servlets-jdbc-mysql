package datos;

import java.sql.SQLException;
import java.util.List;

import modelo.Persona;

public interface PersonasDAO {

	public List<Persona> select() throws SQLException;
	
	public List<Persona> selectById(int id) throws SQLException;

	public int insert(Persona per) throws SQLException;

	public int update(Persona per) throws SQLException;

	public int delete(Persona per) throws SQLException;

}
