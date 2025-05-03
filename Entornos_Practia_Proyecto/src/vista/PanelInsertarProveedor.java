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
import java.awt.Font;

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
		lblNombreProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreProveedor.setBounds(108, 78, 69, 14);
		add(lblNombreProveedor);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDNI.setBounds(110, 124, 46, 14);
		add(lblDNI);

		JLabel lblDirección = new JLabel("Dirección:");
		lblDirección.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDirección.setBounds(108, 167, 69, 14);
		add(lblDirección);

		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelfono.setBounds(108, 251, 69, 14);
		add(lblTelfono);

		textNombreProveedor = new JTextField();
		textNombreProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNombreProveedor.setColumns(10);
		textNombreProveedor.setBounds(229, 76, 202, 20);
		add(textNombreProveedor);
		
		textDNI = new JTextField();
		textDNI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDNI.setBounds(229, 121, 202, 20);
		add(textDNI);
		textDNI.setColumns(10);

		textDireccionProveedor = new JTextField();
		textDireccionProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDireccionProveedor.setColumns(10);
		textDireccionProveedor.setBounds(229, 164, 202, 20);
		add(textDireccionProveedor);

		textTelProveedor = new JTextField();
		textTelProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTelProveedor.setColumns(10);
		textTelProveedor.setBounds(229, 248, 127, 20);
		add(textTelProveedor);

		textTipoProveedor = new JTextField();
		textTipoProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTipoProveedor.setColumns(10);
		textTipoProveedor.setBounds(229, 205, 202, 20);
		add(textTipoProveedor);

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 12));

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

		btnInsertar.setBounds(184, 301, 101, 34);
		add(btnInsertar);

		JLabel lblTipoProveedor = new JLabel("Tipo:");
		lblTipoProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoProveedor.setBounds(110, 208, 46, 14);
		add(lblTipoProveedor);
		
		JLabel lblNewLabel = new JLabel("INSERTAR NUEVO PROVEEDOR");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(120, 37, 303, 14);
		add(lblNewLabel);
		
		
		
		

	}
}
