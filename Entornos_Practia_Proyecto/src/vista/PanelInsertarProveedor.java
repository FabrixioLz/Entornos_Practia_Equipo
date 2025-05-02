package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ConectandoBBDD;
import modelo.Proveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;

public class PanelInsertarProveedor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textNombreProveedor;
	private JTextField textDireccionProveedor;
	private JTextField textTelProveedor;
	private JTextField textTipoProveedor;
	private JTextField textDNI;

	/**
	 * Create the panel.
	 */
	public PanelInsertarProveedor() {
		setLayout(null);

		JLabel lblNombreProveedor = new JLabel("Nombre:");
		lblNombreProveedor.setBounds(87, 42, 69, 14);
		add(lblNombreProveedor);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(87, 80, 46, 14);
		add(lblDNI);

		JLabel lblDirección = new JLabel("Dirección:");
		lblDirección.setBounds(87, 114, 69, 14);
		add(lblDirección);

		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(87, 183, 69, 14);
		add(lblTelfono);

		textNombreProveedor = new JTextField();
		textNombreProveedor.setColumns(10);
		textNombreProveedor.setBounds(189, 39, 202, 20);
		add(textNombreProveedor);
		
		textDNI = new JTextField();
		textDNI.setBounds(189, 77, 202, 20);
		add(textDNI);
		textDNI.setColumns(10);

		textDireccionProveedor = new JTextField();
		textDireccionProveedor.setColumns(10);
		textDireccionProveedor.setBounds(189, 111, 202, 20);
		add(textDireccionProveedor);

		textTelProveedor = new JTextField();
		textTelProveedor.setColumns(10);
		textTelProveedor.setBounds(189, 180, 127, 20);
		add(textTelProveedor);

		textTipoProveedor = new JTextField();
		textTipoProveedor.setColumns(10);
		textTipoProveedor.setBounds(189, 142, 202, 20);
		add(textTipoProveedor);

		JButton btnInsertar = new JButton("Insertar");

		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proveedor proveedor = new Proveedor();
				proveedor.setNombre(textNombreProveedor.getText());
				proveedor.setDni(textDNI.getText());
				proveedor.setDireccion(textDireccionProveedor.getText());
				proveedor.setTipo(textTipoProveedor.getText());
				proveedor.setTelefono(textTelProveedor.getText());

				boolean correcto = false;

				int valor = JOptionPane.showConfirmDialog(null, "¿Desea introducir este proveedor?");
				if (valor == JOptionPane.OK_OPTION) {
					ConectandoBBDD bd = new ConectandoBBDD();
					correcto = bd.insertarProveedor(proveedor);
					if (correcto) {
						JOptionPane.showMessageDialog(null, "Insertado correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "El proveedor no se pudo insertar correctamente");
					}
					
					textNombreProveedor.setText("");
					textDNI.setText("");
					textDireccionProveedor.setText("");
					textTipoProveedor.setText("");
					textTelProveedor.setText("");
				}
			}
		});

		btnInsertar.setBounds(189, 243, 101, 34);
		add(btnInsertar);

		JLabel lblTipoProveedor = new JLabel("Tipo:");
		lblTipoProveedor.setBounds(87, 147, 46, 14);
		add(lblTipoProveedor);
		
		
		
		

	}
}
