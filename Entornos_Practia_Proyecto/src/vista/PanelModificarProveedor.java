package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ConectandoBBDD;
import modelo.Producto;
import modelo.Proveedor;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
/**
 * Panel que permite al ususario modificar datos de los proveedores.
 * 
 * @author Rubén Castañares
 */
public class PanelModificarProveedor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textDniModificado;
	private JTextField textNombreModificado;
	private JTextField textTipoModificado;
	private JTextField textDireccionModificada;
	private JTextField textTelefonoModificado;

	/**
	 * Diseño del panel, en él hay JLabels, textFields, JSpinners y un JButon,
	 * necesarios para poder modificar los datos.
	 * 
	 * @author Rubén Castañares
	 */
	public PanelModificarProveedor() {
		setLayout(null);
		
		JLabel lblIdProveedorAModifdicar = new JLabel("Id del proveedor:");
		lblIdProveedorAModifdicar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProveedorAModifdicar.setBounds(111, 105, 107, 14);
		add(lblIdProveedorAModifdicar);
		
		JLabel lblDniModificado = new JLabel("DNI:");
		lblDniModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDniModificado.setBounds(111, 136, 46, 14);
		add(lblDniModificado);
		
		textDniModificado = new JTextField();
		textDniModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDniModificado.setBounds(244, 133, 151, 20);
		add(textDniModificado);
		textDniModificado.setColumns(10);
		
		textNombreModificado = new JTextField();
		textNombreModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNombreModificado.setBounds(244, 164, 151, 20);
		add(textNombreModificado);
		textNombreModificado.setColumns(10);
		
		JLabel lblNombreModificado = new JLabel("Nombre:");
		lblNombreModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreModificado.setBounds(111, 167, 69, 14);
		add(lblNombreModificado);
		
		JLabel lblNewLabel_3 = new JLabel("MODIFICACIÓN DE PROVEEDORES");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_3.setBounds(102, 45, 312, 20);
		add(lblNewLabel_3);
		
		JLabel lblTipoModificado = new JLabel("Tipo:");
		lblTipoModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoModificado.setBounds(111, 205, 46, 14);
		add(lblTipoModificado);
		
		JLabel lblDireccionModificada = new JLabel("Dirección:");
		lblDireccionModificada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccionModificada.setBounds(109, 241, 71, 14);
		add(lblDireccionModificada);
		
		JLabel lblTelefonoModificado = new JLabel("Teléfono:");
		lblTelefonoModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefonoModificado.setBounds(111, 275, 71, 14);
		add(lblTelefonoModificado);
		
		textTipoModificado = new JTextField();
		textTipoModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTipoModificado.setBounds(244, 202, 151, 20);
		add(textTipoModificado);
		textTipoModificado.setColumns(10);
		
		textDireccionModificada = new JTextField();
		textDireccionModificada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDireccionModificada.setBounds(244, 238, 151, 20);
		add(textDireccionModificada);
		textDireccionModificada.setColumns(10);
		
		textTelefonoModificado = new JTextField();
		textTelefonoModificado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTelefonoModificado.setBounds(244, 272, 151, 20);
		add(textTelefonoModificado);
		textTelefonoModificado.setColumns(10);
		
		JSpinner spinnerIdProveedorAModificar = new JSpinner();
		spinnerIdProveedorAModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerIdProveedorAModificar.setBounds(244, 102, 151, 20);
		add(spinnerIdProveedorAModificar);
		
		JButton btnModificarProveedor = new JButton("Modificar:");
		btnModificarProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		/**
		 * Cuando el usuario pulsa el boton de modificar, aparece un cuadro de confirmación,
		 * si pulsa si los datos se modifican, si no no ocurre nada.
		 * Primero pide el id del proveedor que se quiere modificar.
		 * 
		 * @author Rubén Castañares
		 */
		btnModificarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(Integer.parseInt(spinnerIdProveedorAModificar.getValue().toString()));
				proveedor.setDni(textDniModificado.getText());
				proveedor.setNombre(textNombreModificado.getText());
				proveedor.setTipo(textTipoModificado.getText());
				proveedor.setDireccion(textDireccionModificada.getText());
				proveedor.setTelefono(textTelefonoModificado.getText());

				boolean correcto = false;

				int valor = JOptionPane.showConfirmDialog(null, "¿Desea modificar este proveedor?");
				if (valor == JOptionPane.OK_OPTION) {
					ConectandoBBDD bd = new ConectandoBBDD();
					correcto = bd.modificarProveedor(proveedor);
					if (correcto) {
						JOptionPane.showMessageDialog(null, "El proveedor no se pudo modificar correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "Modificado correctamente");
					}
					
					spinnerIdProveedorAModificar.setValue(2);
					textDniModificado.setText("");
					textNombreModificado.setText("");
					textTipoModificado.setText("");
					textDireccionModificada.setText("");
					textTelefonoModificado.setText("");
				}
			}
		});
		btnModificarProveedor.setBounds(179, 324, 102, 33);
		add(btnModificarProveedor);

	}
}
