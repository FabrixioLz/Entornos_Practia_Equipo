package modelo;

public class Proovedor {
	private int idProveedor;
	private String nombre;
	private String direccion;
	private int telefono;
	
	public Proovedor() {
		this.idProveedor = -1;
		this.nombre = "ERROR";
		this.direccion = "ERROR";
		this.telefono = -1;
	}
	
	public Proovedor(int idProveedor, String nombre, String direccion, int telefono) {
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
