package modelo;

public class Persona {

	private int id_persona;
	private String nombre;
	private String apellido;
	private String rut;
	
	public Persona() {}

	public Persona(int id_persona) {
		this.id_persona = id_persona;
	}
	
	public Persona(String nombre, String apellido, String rut) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
	}
	
	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Override
	public String toString() {
		return "Persona [id_persona=" + id_persona + ", nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut
				+ "]";
	}
}
