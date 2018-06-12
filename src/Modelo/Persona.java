package Modelo;

public class Persona {

	private String nombre;
	private String apellido;
	private int telefono;

	public Persona(String nombre, String apellido, int tf) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = tf;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}