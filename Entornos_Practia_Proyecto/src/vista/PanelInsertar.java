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
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;

	public PanelInsertar() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(102, 28, 46, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setBounds(102, 66, 60, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setBounds(102, 104, 75, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(102, 146, 46, 14);
		add(lblNewLabel_3);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(220, 25, 86, 20);
		add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(220, 63, 86, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(220, 101, 86, 20);
		add(spinnerCantidad);

		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setBounds(220, 143, 86, 20);
		add(spinnerPrecio);

		JButton btnInsertar = new JButton("Insertar");
	
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto productos = new Producto(null, null, 0, 0);
				productos.setCod(textFieldCodigo.getText());
				productos.setNombre(textFieldNombre.getText());
				productos.setCantidad(Integer.parseInt(spinnerCantidad.getValue().toString()));
				productos.setPrecio(Integer.parseInt(spinnerPrecio.getValue().toString()));
				

				boolean correcto = false;

				int valor = JOptionPane.showConfirmDialog(null, "¿Desea introducir otro producto?");
				if (valor == JOptionPane.OK_OPTION) {
					ConectandoBBDD bd = new ConectandoBBDD();
					correcto = bd.insertarProductos(productos);
					if (correcto) {
						JOptionPane.showMessageDialog(null, "Insertado correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "El producto no se pudo insertar correctamente");
					}

					textFieldCodigo.setText("");
					textFieldNombre.setText("");
					spinnerCantidad.setValue(2);
					spinnerPrecio.setValue(2);
				}
			}
		});
		btnInsertar.setBounds(143, 174, 89, 23);
		add(btnInsertar);

}
}
