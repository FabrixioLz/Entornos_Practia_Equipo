package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

import controlador.ConectandoBBDD;
import modelo.Producto;
import modelo.Proveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;

public class PanelBorrar extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelBorrar() {
		setLayout(null);
		
		JLabel lblIdProductoParaBorrar = new JLabel("Id del producto:");
		lblIdProductoParaBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProductoParaBorrar.setBounds(42, 107, 109, 14);
		add(lblIdProductoParaBorrar);
		
		JSpinner spinnerIdProductoABorrar = new JSpinner();
		spinnerIdProductoABorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerIdProductoABorrar.setBounds(187, 104, 114, 20);
		add(spinnerIdProductoABorrar);
		
		JButton btnBorrarProducto = new JButton("Borrar Producto");
		btnBorrarProducto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrarProducto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Producto productos = new Producto();
			productos.setIdProducto(Integer.parseInt(spinnerIdProductoABorrar.getValue().toString()));

			boolean correcto = false;

			int valor = JOptionPane.showConfirmDialog(null, "¿Desea borrrar este producto?");
			if (valor == JOptionPane.OK_OPTION) {
				ConectandoBBDD bd = new ConectandoBBDD();
				correcto = bd.borrarProducto(productos);
				if (correcto) {
					JOptionPane.showMessageDialog(null, "El producto no se pudo borrar correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Producto borrado correctamente");
				}
				
				spinnerIdProductoABorrar.setValue(2);
				
			}
		}
	});
		btnBorrarProducto.setBounds(353, 98, 133, 32);
		add(btnBorrarProducto);
		
		JLabel lblProveedorParaBorrar = new JLabel("Id del Proveedor:");
		lblProveedorParaBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProveedorParaBorrar.setBounds(42, 235, 109, 14);
		add(lblProveedorParaBorrar);
		
		JSpinner spinnerProveedorAVBorrar = new JSpinner();
		spinnerProveedorAVBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerProveedorAVBorrar.setBounds(187, 232, 114, 20);
		add(spinnerProveedorAVBorrar);
		
		JButton btnBorrarProveedor = new JButton("Borrar Proveedor");
		btnBorrarProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(Integer.parseInt(spinnerProveedorAVBorrar.getValue().toString()));

				boolean correcto = false;

				int valor = JOptionPane.showConfirmDialog(null, "¿Desea borrrar este proveedor?");
				if (valor == JOptionPane.OK_OPTION) {
					ConectandoBBDD bd = new ConectandoBBDD();
					correcto = bd.borrarProveedor(proveedor);
					if (correcto) {
						JOptionPane.showMessageDialog(null, "El proveedor no se pudo borrar correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "Proveedor borrado correctamente");
					}
					
					spinnerProveedorAVBorrar.setValue(0);
					
				}
			}
		});
		
		btnBorrarProveedor.setBounds(353, 226, 133, 32);
		add(btnBorrarProveedor);
		
		JLabel lblNewLabel = new JLabel("ELIMINAR  PRODUCTO");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(157, 53, 219, 14);
		add(lblNewLabel);
		
		JLabel lblBorrarProveedor = new JLabel("ELIMINAR PROVEEDOR");
		lblBorrarProveedor.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblBorrarProveedor.setBounds(157, 174, 219, 14);
		add(lblBorrarProveedor);

	}
}
