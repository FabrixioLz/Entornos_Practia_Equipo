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
	 * Constructor por defecto
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
	 * @param idProducto identidicador del producto
	 * @param nombre nombre del producto
	 * @param cantidad cantidad dispobible de ese producto
	 * @param precio precio del producto
	 * @param idProveedor identidicador del proveedor que gestiona ese producto
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

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

}
