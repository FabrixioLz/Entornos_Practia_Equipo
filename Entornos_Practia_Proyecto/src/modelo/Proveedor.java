package modelo;
/**
 * Clase que contiene los distintos datos de un proveedor.
 * 
 * @author Rubén Castañares
 */
public class Proveedor {
	private int idProveedor;
	private String dni;
	private String nombre;
	private String tipo;
	private String direccion;
	private String telefono;
	/**
	 * Constructor por defecto.
	 * @author Rubén Castañares
	 */
	public Proveedor() {
		this.idProveedor = 0;
		this.dni = "ERROR";
		this.nombre = "ERROR";
		this.tipo = "ERROR";
		this.direccion = "ERROR";
		this.telefono = "ERROR";
	}
	/**
	 * Construtos por parametros.
	 * 
	 * @param idProveedor identificador del proveedor.
	 * @param dni dni del proveedor.
	 * @param nombre nombre del proveedor.
	 * @param tipo tipo del proveedor.
	 * @param direccion dirección del proveedor.
	 * @param telefono teléfono del proveedor.
	 * 
	 * @author Rubén Castañares
	 */
	public Proveedor(int idProveedor, String dni, String nombre, String tipo, String direccion, String telefono) {
		this.idProveedor = idProveedor;
		this.dni = dni;
		this.nombre = nombre;
		this.tipo = tipo;
		this.direccion = direccion;
		this.telefono = telefono;
	}	
	/**
	 * Obtiene el identificador del proveedor .
	 * @return id del proveedor.
	 * 
	 * @author Rubén Castañares
	 */
	public int getIdProveedor() {
		return idProveedor;
	}
	/**
	 * Establece el id en el proveedor.
	 * @param idProveedor (id que se asigna al proveedor).
	 * 
	 * @author Rubén Castañares
	 */
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	/**
	 * Obtiene el DNI del proveedor.
	 * @return DNI del proveedor.
	 * 
	 * @author Rubén Castañares
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Establece el dni en el proveedor.
	 * @param dni (dni que se asigna al proveedor).
	 * 
	 * @author Rubén Castañares
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * Obtiene el nombre del proveedor.
	 * @return nombre del proveedor.
	 * 
	 * @author Rubén Castañares
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establece el nombre en el proveedor.
	 * @param nombre (nombre que se asigna al proveedor).
	 * 
	 * @author Rubén Castañares
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene el tipo del proveedor.
	 * @return tipo del proveedor.
	 * 
	 * @author Rubén Castañares
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Establece el tipo en el proveedor.
	 * @param tipo (tipo que se asigna al proveedor).
	 * 
	 * @author Rubén Castañares
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Obtiene la dirección del proveedor.
	 * @return direección del proveedor.
	 * 
	 * @author Rubén Castañares
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Establece la direección en el proveedor.
	 * @param direccion (dirección que se asigna al proveedor).
	 * 
	 * @author Rubén Castañares
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Obtiene el teléfono del proveedor.
	 * @return teléfono del proveedor.
	 * 
	 * @author Rubén Castañares
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * -Establece el teléfono del proveedor.
	 * @param telefono (teléfono que se asigna al proveedor).
	 * 
	 * @author Rubén Castañares
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
	
	
}
