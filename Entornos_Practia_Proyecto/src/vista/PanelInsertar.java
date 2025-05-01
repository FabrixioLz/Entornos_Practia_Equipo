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

public class PanelInsertar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;

	public PanelInsertar() {
		setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setBounds(102, 66, 60, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setBounds(102, 104, 75, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(102, 146, 46, 14);
		add(lblNewLabel_3);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(220, 63, 124, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(220, 101, 124, 20);
		add(spinnerCantidad);

		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setBounds(220, 143, 124, 20);
		add(spinnerPrecio);

		JButton btnInsertar = new JButton("Insertar");
	
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto productos = new Producto();
				productos.setNombre(textFieldNombre.getText());
				productos.setCantidad(Integer.parseInt(spinnerCantidad.getValue().toString()));
				productos.setPrecio(Float.parseFloat(spinnerPrecio.getValue().toString()));
				

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
				}
			}
		});
		btnInsertar.setBounds(161, 193, 89, 23);
		add(btnInsertar);

}
}
