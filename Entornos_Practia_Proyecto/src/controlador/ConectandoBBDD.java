package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Producto;

public class ConectandoBBDD {
	public boolean insertarProductos(Producto p) {
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
			Statement consulta = conexion.createStatement();
			consulta.executeUpdate("insert into producto (nombre, cantidad, precio) " + "values ('"
					+ p.getNombre()  + "','" + p.getCantidad() + "'," + p.getPrecio() + "); ");

			conexion.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<String> consultarProducto() {

		ArrayList<String> misProductos = new ArrayList<>();
		Connection conexion;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
			Statement consulta = conexion.createStatement();

			ResultSet registro = consulta.executeQuery("select nombre from producto ");

			while (registro.next()) {
				misProductos.add(registro.getString("nombre"));
			}
			conexion.close();
			return misProductos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Producto> consultarProductoPorNombre(String nombre) {
		ArrayList<Producto> arrProductos = new ArrayList<>();
		Producto p = null;
		Connection conexion;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
			Statement consulta = conexion.createStatement();

			ResultSet registro = consulta.executeQuery("select * from producto " + "where nombre='" + nombre + "'");

			while (registro.next()) {
				p = new Producto();
				p.setIdProducto(Integer.parseInt(registro.getString("idProducto")));
				p.setNombre(registro.getString("nombre"));
				p.setCantidad(Integer.parseInt(registro.getString("cantidad")));
				p.setPrecio(Float.parseFloat(registro.getString("precio")));
				arrProductos.add(p);
			}
			conexion.close();
			return arrProductos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
