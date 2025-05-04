package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ConectandoBBDD;
import modelo.Producto;

import javax.swing.JSpinner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;
/**
 * Panel que permite al usuario introducir nuevos productos en la base de datos.
 * 
 * @author Rubén Castañares
 */
public class PanelInsertarProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	/**
	 * Diseño del panel, e él hay JLabels, textFields, JSpinners y un JButton,
	 * necesarios para poder introducir los datos.
	 * 
	 * @author Rubén Castañares
	 */
	public PanelInsertarProducto() {
		setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(102, 113, 60, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(102, 152, 75, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(103, 190, 46, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Id del Proveedor: ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(102, 225, 102, 14);
		add(lblNewLabel_3_1);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNombre.setBounds(258, 110, 146, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerCantidad.setBounds(258, 149, 146, 20);
		add(spinnerCantidad);

		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerPrecio.setBounds(258, 187, 146, 20);
		add(spinnerPrecio);
		
		JSpinner spinnerIdProveedor = new JSpinner();
		spinnerIdProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerIdProveedor.setBounds(258, 223, 146, 20);
		add(spinnerIdProveedor);


		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		/**
		 * Cuando el usuario pulsa el boton de insertar, se recogen todos los datos ingresados 
		 * y se introducen en la base de datos.
		 * Cuando se pulsa el boton insertar aparece un cuadro de confirmación.
		 * 
		 * @author Rubén Castañares
		 */
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto productos = new Producto();
				productos.setNombre(textFieldNombre.getText());
				productos.setCantidad(Integer.parseInt(spinnerCantidad.getValue().toString()));
				productos.setPrecio(Float.parseFloat(spinnerPrecio.getValue().toString()));
				productos.setIdProveedor(Integer.parseInt(spinnerIdProveedor.getValue().toString()));
				

				boolean correcto = false;

				int valor = JOptionPane.showConfirmDialog(null, "¿Desea introducir el producto?");
				if (valor == JOptionPane.OK_OPTION) {
					ConectandoBBDD bd = new ConectandoBBDD();
					correcto = bd.insertarProductos(productos);
					if (correcto) {
						JOptionPane.showMessageDialog(null, "Insertado correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "El producto no se pudo insertar correctamente");
					}

					textFieldNombre.setText("");
					spinnerCantidad.setValue(2);
					spinnerPrecio.setValue(2);
					spinnerIdProveedor.setValue(2);
				}
			}
		});
		btnInsertar.setBounds(160, 269, 96, 32);
		add(btnInsertar);
		
		JLabel lblNewLabel = new JLabel("INSERTAR NUEVO PRODUCTO");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(102, 58, 279, 14);
		add(lblNewLabel);
		
		
}
}
