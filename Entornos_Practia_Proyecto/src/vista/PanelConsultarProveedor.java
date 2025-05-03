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

public class PanelConsultarProveedor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableProveedores;
	private JComboBox comboBoxTipoProveedores;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
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

		modeloTabla.setColumnIdentifiers(new Object[] { "Nombre", "dni", "Direccion", "Tipo", "Telefono", "IdProveedor" });
		tableProveedores.setModel(modeloTabla);
		
		lblNewLabel = new JLabel("CONSULTA DE PROVEEDORES");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(152, 45, 289, 14);
		add(lblNewLabel);

		cargaCombo();
	}

	public void cargaTabla(ArrayList<Proveedor> arrProveedor) {
		modeloTabla.setRowCount(0);

		for (Proveedor pdor : arrProveedor) {
			modeloTabla.addRow(new Object[] { pdor.getNombre(), pdor.getDni(), pdor.getDireccion(), pdor.getTipo(),
					pdor.getTelefono(), pdor.getIdProveedor() });
		}
	}

	public void cargaCombo() {
		ArrayList<String> misProveedores = new ArrayList<>();
		ConectandoBBDD bd = new ConectandoBBDD();
		misProveedores = bd.consultarProveedor();
		for (int i = 0; i < misProveedores.size(); i++) {
			comboBoxTipoProveedores.addItem(misProveedores.get(i));
		}
	}
}
