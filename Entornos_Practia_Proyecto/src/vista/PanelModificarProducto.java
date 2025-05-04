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
import java.awt.Font;
/**
 * Panel que permite al ususario modificar datos de los productos.
 * 
 * @author Rubén Castañares
 */
public class PanelModificarProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombreModificado;

	/**
	 * Diseño del panel, en él hay JLabels, textFields, JSpinners y un JButon,
	 * necesarios para poder modificar los datos.
	 * 
	 * @author Rubén Castañares
	 */
	public PanelModificarProducto() {
		setLayout(null);
		
		JSpinner spinnerIdProductoAModificar = new JSpinner();
		spinnerIdProductoAModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerIdProductoAModificar.setBounds(256, 98, 150, 20);
		add(spinnerIdProductoAModificar);
		
		JLabel lblNombreModificado = new JLabel("Nombre: ");
		lblNombreModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreModificado.setBounds(112, 138, 65, 14);
		add(lblNombreModificado);
		
		textFieldNombreModificado = new JTextField();
		textFieldNombreModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNombreModificado.setBounds(256, 135, 150, 20);
		add(textFieldNombreModificado);
		textFieldNombreModificado.setColumns(10);
		
		JLabel lblCantidadModificada = new JLabel("Cantidad:");
		lblCantidadModificada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidadModificada.setBounds(112, 175, 65, 14);
		add(lblCantidadModificada);
		
		JLabel lblPrecioModificado = new JLabel("Precio: ");
		lblPrecioModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecioModificado.setBounds(112, 213, 65, 14);
		add(lblPrecioModificado);
		
		JSpinner spinnerPrecioModificado = new JSpinner();
		spinnerPrecioModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerPrecioModificado.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		spinnerPrecioModificado.setBounds(256, 210, 150, 20);
		add(spinnerPrecioModificado);
		
		JLabel lblIdProveedorModificado = new JLabel("Id del proveedor:");
		lblIdProveedorModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProveedorModificado.setBounds(112, 249, 104, 14);
		add(lblIdProveedorModificado);
		
		JLabel lblIdProductoAModificar = new JLabel("Id a modificar: ");
		lblIdProductoAModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProductoAModificar.setBounds(112, 101, 104, 14);
		add(lblIdProductoAModificar);
		
		JSpinner spinnerIdProveedorModificado = new JSpinner();
		spinnerIdProveedorModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerIdProveedorModificado.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		spinnerIdProveedorModificado.setBounds(256, 246, 150, 20);
		add(spinnerIdProveedorModificado);
		
		JSpinner spinnerCantidadModificada = new JSpinner();
		spinnerCantidadModificada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerCantidadModificada.setBounds(256, 172, 150, 20);
		add(spinnerCantidadModificada);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		/**
		 * Cuando el usuario pulsa el boton de modificar, aparece un cuadro de confirmación,
		 * si pulsa si los datos se modifican, si no no ocurre nada.
		 * Primero pide el id del producto que se quiere modificar.
		 * 
		 * @author Rubén Castañares
		 */
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
		btnModificar.setBounds(176, 306, 104, 32);
		add(btnModificar);
		
		JLabel lblNewLabel = new JLabel("MODIFICACIÓN DE PRODUCTOS");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(112, 49, 322, 14);
		add(lblNewLabel);
		
		

	}
}
