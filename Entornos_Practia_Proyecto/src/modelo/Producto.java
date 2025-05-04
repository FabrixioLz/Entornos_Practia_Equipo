package modelo;

/**
 * Clase que contiene los distintos datos de un producto.
 * 
 * @author Ruben Castañares
 */
public class Producto {
	private int idProducto;
	private String nombre;
	private int cantidad;
	private float precio;
	private int idProveedor;
	/**
	 * Constructor por defecto.
	 * 
	 * @author Ruben Castañares
	 */
	public Producto() {
		this.idProducto = 0;
		this.nombre = "ERROR";
		this.cantidad = -1;
		this.precio = -1.1f;
		this.idProveedor = 0;

	}
	
	/**
	 * Constructor por parámetros.
	 * 
	 * @param idProducto identidicador del producto.
	 * @param nombre nombre del producto.
	 * @param cantidad cantidad dispobible de ese producto.
	 * @param precio precio del producto.
	 * @param idProveedor identidicador del proveedor que gestiona ese producto.
	 * 
	 * @author Rubén Castañares
	 */
	public Producto(int idProducto, String nombre, int cantidad, float precio, int idProveedor) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.idProveedor = idProveedor;
	}
	/**
	 * Obtiene el id del producto.
	 * @return id del producto.
	 * 
	 * @author Rubén Castañares
	 */
	public int getIdProducto() {
		return idProducto;
	}
	/**
	 * Establece el id en el producto.
	 * @param idProducto (id que se asigna al producto).
	 * 
	 * @author Rubén Castañares
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * Obtiene el nombre del producto.
	 * @return el nombre del producto.
	 * 
	 * @author Rubén Castañares
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establece el nombre en el producto.
	 * @param nombre (nombre que se asigna al producto).
	 * 
	 * @author Rubén Castañares
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene la cantidad del producto.
	 * @return la cantidad del producto.
	 * 
	 * @author Rubén Castañares
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * Establece la cantidad en el producto.
	 * @param cantidad (cantidad que se asigna al producto).
	 * 
	 * @author Rubén Castañares
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * Obtiene el precio del producto.
	 * @return el precio del producto.
	 * 
	 * @author Rubén Castañares
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * Establece el precio en el producto.
	 * @param precio (precio que se asigna al producto).
	 * 
	 * @author Rubén Castañares
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/**
	 * Obtiene el id del proveedor del producto.
	 * @return el id del proveedor del producto.
	 * 
	 * @author Rubén Castañares
	 */
	public int getIdProveedor() {
		return idProveedor;
	}
	/**
	 * Establece el id del proveedor en el producto.
	 * @param idProveedor (idProveedor que se asigna al producto).
	 * 
	 * @author Rubén Castañares
	 */
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

}
