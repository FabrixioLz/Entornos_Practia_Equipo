package modelo;

public class Producto {
	private int idProducto;
	private String nombre;
	private int cantidad;
	private float precio;
	
	public Producto() {
		this.idProducto = -1;
		this.nombre = "ERROR";
		this.cantidad = -1;
		this.precio = -1.1f;
	}
	
	public Producto(int idProducto, String nombre, int cantidad, float precio) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
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

	
	
}
