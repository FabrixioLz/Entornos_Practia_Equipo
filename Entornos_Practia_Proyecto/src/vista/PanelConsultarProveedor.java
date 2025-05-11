package vista;

import javax.swing.JPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ConectandoBBDD;
import modelo.Proveedor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * Panel que permite al ususario poder consultar los proveedores que hay dentro de la base de datos,
 * según su tipo.
 * 
 * @author Rubén Castañares
 */

public class PanelConsultarProveedor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableProveedores;
	private JComboBox comboBoxTipoProveedores;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 * Diseño del panel, en el hay un combobox para seleccionar el proveedor y una tabla que muestra sus datos.
	 * Cuando se cambia de un proveedor a otro, la tabla se actualiza automáticamente. 
	 * 
	 * @author Rubén Castañares
	 */
	public PanelConsultarProveedor() {
		setLayout(null);

		comboBoxTipoProveedores = new JComboBox();
		comboBoxTipoProveedores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxTipoProveedores.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ArrayList<Proveedor> arrProveedor = new ArrayList<>();
				ConectandoBBDD bd = new ConectandoBBDD();
				arrProveedor = bd.consultarProveedorPorTipo(comboBoxTipoProveedores.getSelectedItem().toString());
				cargaTabla(arrProveedor);
			}
		});

		comboBoxTipoProveedores.setBounds(187, 96, 201, 22);
		add(comboBoxTipoProveedores);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 153, 483, 168);
		add(scrollPane);

		tableProveedores = new JTable();
		tableProveedores.setForeground(new Color(0, 0, 255));
		scrollPane.setViewportView(tableProveedores);

		modeloTabla.setColumnIdentifiers(new Object[] { "Nombre", "DNI", "Dirección", "Tipo", "Teléfono", "IdProveedor" });
		tableProveedores.setModel(modeloTabla);
		
		lblNewLabel = new JLabel("CONSULTA DE PROVEEDORES");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(152, 45, 289, 14);
		add(lblNewLabel);

		cargaCombo();
	}
	/**
	 * Se cargan los datos del proveedor en la tabla.
	 * @param arrProveedor (lista de los proveedores).
	 * 
	 * @author Rubén Castañares
	 */
	public void cargaTabla(ArrayList<Proveedor> arrProveedor) {
		modeloTabla.setRowCount(0);

		for (Proveedor pdor : arrProveedor) {
			modeloTabla.addRow(new Object[] { pdor.getNombre(), pdor.getDni(), pdor.getDireccion(), pdor.getTipo(),
					pdor.getTelefono(), pdor.getIdProveedor() });
		}
	}
	
	/**
	 * El JComboBox se carga con los tipos de los proveedores de la base de datos.
	 * 
	 * @author Rubén Castañares
	 */
	public void cargaCombo() {
		ArrayList<String> misProveedores = new ArrayList<>();
		ConectandoBBDD bd = new ConectandoBBDD();
		misProveedores = bd.consultarProveedor();
		for (int i = 0; i < misProveedores.size(); i++) {
			comboBoxTipoProveedores.addItem(misProveedores.get(i));
		}
	}
}
