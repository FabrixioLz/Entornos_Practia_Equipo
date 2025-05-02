package vista;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ConectandoBBDD;
import modelo.Producto;
import modelo.Proveedor;

import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class PanelModificarProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombreModificado;

	/**
	 * Create the panel.
	 */
	public PanelModificarProducto() {
		setLayout(null);
		
		JSpinner spinnerIdProductoAModificar = new JSpinner();
		spinnerIdProductoAModificar.setBounds(284, 98, 85, 20);
		add(spinnerIdProductoAModificar);
		
		JLabel lblNombreModificado = new JLabel("Nombre: ");
		lblNombreModificado.setBounds(112, 138, 65, 14);
		add(lblNombreModificado);
		
		textFieldNombreModificado = new JTextField();
		textFieldNombreModificado.setBounds(284, 135, 150, 20);
		add(textFieldNombreModificado);
		textFieldNombreModificado.setColumns(10);
		
		JLabel lblCantidadModificada = new JLabel("Cantidad:");
		lblCantidadModificada.setBounds(112, 175, 65, 14);
		add(lblCantidadModificada);
		
		JLabel lblPrecioModificado = new JLabel("Precio: ");
		lblPrecioModificado.setBounds(112, 213, 46, 14);
		add(lblPrecioModificado);
		
		JSpinner spinnerPrecioModificado = new JSpinner();
		spinnerPrecioModificado.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		spinnerPrecioModificado.setBounds(284, 210, 85, 20);
		add(spinnerPrecioModificado);
		
		JLabel lblIdProveedorModificado = new JLabel("Id del proveedor:");
		lblIdProveedorModificado.setBounds(112, 249, 95, 14);
		add(lblIdProveedorModificado);
		
		JLabel lblIdProductoAModificar = new JLabel("Id a modificar: ");
		lblIdProductoAModificar.setBounds(112, 101, 85, 14);
		add(lblIdProductoAModificar);
		
		JSpinner spinnerIdProveedorModificado = new JSpinner();
		spinnerIdProveedorModificado.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		spinnerIdProveedorModificado.setBounds(284, 241, 85, 20);
		add(spinnerIdProveedorModificado);
		
		JSpinner spinnerCantidadModificada = new JSpinner();
		spinnerCantidadModificada.setBounds(284, 172, 85, 20);
		add(spinnerCantidadModificada);
		
		JButton btnModificar = new JButton("Modificar");
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto productos = new Producto();
				productos.setIdProducto(Integer.parseInt(spinnerIdProductoAModificar.getValue().toString()));
				productos.setNombre(textFieldNombreModificado.getText());
				productos.setCantidad(Integer.parseInt(spinnerCantidadModificada.getValue().toString()));
				productos.setPrecio(Float.parseFloat(spinnerPrecioModificado.getValue().toString()));
				productos.setIdProveedor(Integer.parseInt(spinnerIdProveedorModificado.getValue().toString()));

				boolean correcto = false;

				int valor = JOptionPane.showConfirmDialog(null, "¿Desea modificar este producto?");
				if (valor == JOptionPane.OK_OPTION) {
					ConectandoBBDD bd = new ConectandoBBDD();
					correcto = bd.modificarProducto(productos);
					if (correcto) {
						JOptionPane.showMessageDialog(null, "El producto no se pudo modificar correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "Modificado correctamente");
					}
					
					spinnerIdProductoAModificar.setValue(2);
					textFieldNombreModificado.setText("");
					spinnerCantidadModificada.setValue(2);
					spinnerPrecioModificado.setValue(2);
					spinnerIdProveedorModificado.setValue(2);
				}
			}
		});
		btnModificar.setBounds(190, 289, 104, 32);
		add(btnModificar);
		
		

	}
}
