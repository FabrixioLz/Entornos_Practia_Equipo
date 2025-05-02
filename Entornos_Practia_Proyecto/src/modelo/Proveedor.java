package modelo;

public class Proveedor {
	private int idProveedor;
	private String dni;
	private String nombre;
	private String tipo;
	private String direccion;
	private String telefono;
	
	public Proveedor() {
		this.idProveedor = 0;
		this.dni = "ERROR";
		this.nombre = "ERROR";
		this.tipo = "ERROR";
		this.direccion = "ERROR";
		this.telefono = "ERROR";
	}
	
	public Proveedor(int idProveedor, String dni, String nombre, String tipo, String direccion, String telefono) {
		this.idProveedor = idProveedor;
		this.dni = dni;
		this.nombre = nombre;
		this.tipo = tipo;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
	
	
}
