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

public class PanelBorrar extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelBorrar() {
		setLayout(null);
		
		JLabel lblIdProductoParaBorrar = new JLabel("Id del producto:");
		lblIdProductoParaBorrar.setBounds(21, 89, 88, 14);
		add(lblIdProductoParaBorrar);
		
		JSpinner spinnerIdProductoABorrar = new JSpinner();
		spinnerIdProductoABorrar.setBounds(124, 86, 93, 20);
		add(spinnerIdProductoABorrar);
		
		JButton btnBorrarProducto = new JButton("Borrar Producto");
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
					JOptionPane.showMessageDialog(null, "Producto borrado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "El producto no se pudo borrar correctamente");
				}
				
				spinnerIdProductoABorrar.setValue(2);
				
			}
		}
	});
		btnBorrarProducto.setBounds(267, 80, 133, 32);
		add(btnBorrarProducto);
		
		JLabel lblProveedorParaBorrar = new JLabel("Id del Proveedor:");
		lblProveedorParaBorrar.setBounds(21, 183, 88, 14);
		add(lblProveedorParaBorrar);
		
		JSpinner spinnerProveedorAVBorrar = new JSpinner();
		spinnerProveedorAVBorrar.setBounds(124, 180, 93, 20);
		add(spinnerProveedorAVBorrar);
		
		JButton btnBorrarProveedor = new JButton("Borrar Proveedor");
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
						JOptionPane.showMessageDialog(null, "Proveedor borrado correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "El proveedor no se pudo borrar correctamente");
					}
					
					spinnerProveedorAVBorrar.setValue(0);
					
				}
			}
		});
		
		btnBorrarProveedor.setBounds(267, 170, 133, 32);
		add(btnBorrarProveedor);

	}
}
