package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Producto;
import modelo.Proveedor;

public class ConectandoBBDD {
	public boolean insertarProductos(Producto p) {

		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
			Statement consulta = conexion.createStatement();
			consulta.executeUpdate("insert into producto (nombre, cantidad, precio, idProveedor) " + "values ('" + p.getNombre()
					+ "','" + p.getCantidad() + "'," + p.getPrecio() + "," + p.getIdProveedor() + "); ");

			conexion.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertarProveedor(Proveedor prov) {

		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
			Statement consulta = conexion.createStatement();
			consulta.executeUpdate("insert into proveedor (nombre, dni, direccion, tipo, telefono, idProveedor) "
					+ "values ('" + prov.getNombre() + "','" + prov.getDni() + "','" + prov.getDireccion() + "','" + prov.getTipo() + "',"
					+ prov.getTelefono() + "," + prov.getIdProveedor() + "); ");

			conexion.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<String> consultarProveedor() {

		ArrayList<String> misProveedores = new ArrayList<>();
		Connection conexion;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
			Statement consulta = conexion.createStatement();

			ResultSet registro = consulta.executeQuery("select distinct tipo from proveedor ");

			while (registro.next()) {
				misProveedores.add(registro.getString("tipo"));
			}
			conexion.close();
			return misProveedores;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> consultarProducto() {

		ArrayList<String> misProductos = new ArrayList<>();
		Connection conexion;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
			Statement consulta = conexion.createStatement();

			ResultSet registro = consulta.executeQuery("select distinct nombre from producto ");

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
				p.setIdProveedor(Integer.parseInt(registro.getString("IdProveedor")));
				arrProductos.add(p);
			}
			conexion.close();
			return arrProductos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Proveedor> consultarProveedorPorTipo(String tipo) {
		ArrayList<Proveedor> arrProveedor = new ArrayList<>();
		Proveedor pdor = null;
		Connection conexion;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
			Statement consulta = conexion.createStatement();

			ResultSet registro = consulta.executeQuery("select * from proveedor " + "where tipo='" + tipo + "'");

			while (registro.next()) {
				pdor = new Proveedor();
				pdor.setNombre(registro.getString("nombre"));
				pdor.setDni(registro.getString("dni"));
				pdor.setDireccion(registro.getString("direccion"));
				pdor.setTipo(registro.getString("tipo"));
				pdor.setTelefono(registro.getString("telefono"));
				pdor.setIdProveedor(Integer.parseInt(registro.getString("idProveedor")));
				arrProveedor.add(pdor);
			}
			conexion.close();
			return arrProveedor;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	 public boolean modificarProducto(Producto miProducto) {
	        Connection conexion;

	        try {
	            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
	            Statement consulta = conexion.createStatement();
	            System.out.println("update producto set nombre = '" + miProducto.getNombre() 
	            		+ "', cantidad = '" + miProducto.getCantidad() 
	            		+ "', precio = '" + miProducto.getPrecio()
	            		+ "', idProveedor = '" + miProducto.getIdProveedor() 
	            		+ "', precio = " + miProducto.getPrecio()
	            		+ " where idProducto = " + miProducto.getIdProducto());

	            int valor = consulta.executeUpdate("update producto set nombre = '" + miProducto.getNombre() 
        				+ "', cantidad = '" + miProducto.getCantidad() 
        				+ "', precio = '" + miProducto.getPrecio()
        				+ "', idProveedor = '" + miProducto.getIdProveedor() 
        				+ "', precio = " + miProducto.getPrecio()
        				+ " where idProducto = " + miProducto.getIdProducto());

	            if (valor == 1) {
	                System.out.println("Producto modificado correctamente");
	            } else {
	                System.out.println("No existe un producto con dicho id");
	            }
	            conexion.close();

	        } catch (SQLException ex) {
	            ex.printStackTrace();
			}
			return false;
		}

	 public boolean borrarProducto(Producto miProducto) {
		 
	        Connection conexion;

	        try {
	            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
	            Statement consulta = conexion.createStatement();

	                int valor = consulta.executeUpdate("delete from producto where idProducto="
	                        + miProducto.getIdProducto());

	                if (valor == 1) {
	                    System.out.println("Producto borrado correctamente");
	                } else {
	                    System.out.println("No existe un producto con ese id ");
	                }
	            
	            conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return false;
	    }

	 public boolean borrarProveedor(Proveedor miProveedor) {
		 
	        Connection conexion;

	        try {
	            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdinventario", "root", "");
	            Statement consulta = conexion.createStatement();

	                int valor = consulta.executeUpdate("delete from proveedor where idProveedor="
	                        + miProveedor.getIdProveedor());

	                if (valor == 1) {
	                    System.out.println("Proveedor borrado correctamente");
	                } else {
	                    System.out.println("No existe un proveedor con ese id ");
	                }
	            
	            conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return false;
	    }
}
