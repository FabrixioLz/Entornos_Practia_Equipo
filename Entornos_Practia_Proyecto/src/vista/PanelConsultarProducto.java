package vista;

import javax.swing.JPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import controlador.ConectandoBBDD;
import modelo.Producto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class PanelConsultarProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxProductos;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JTable tableProductos;

	/**
	 * Create the panel.
	 */
	public PanelConsultarProducto() {
		setLayout(null);
		
		comboBoxProductos = new JComboBox();
		comboBoxProductos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ArrayList<Producto> arrProductos = new ArrayList<>();
				ConectandoBBDD bd = new ConectandoBBDD();
				arrProductos = bd.consultarProductoPorNombre(comboBoxProductos.getSelectedItem().toString());
				cargaTabla(arrProductos);
			}
		});
		comboBoxProductos.setBounds(173, 44, 208, 22);
		add(comboBoxProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 93, 447, 196);
		add(scrollPane);
		
		tableProductos = new JTable();
		tableProductos.setForeground(new Color(0, 0, 255));
		scrollPane.setViewportView(tableProductos);
		
		modeloTabla.setColumnIdentifiers(new Object[] { "idProducto", "Nombre", "Cantidad", "Precio", "idProveedor" });
		tableProductos.setModel(modeloTabla);
		cargaCombo();
		

	}
	public void cargaTabla(ArrayList<Producto> arrProductos) {
		modeloTabla.setRowCount(0);

		for (Producto p: arrProductos) {
			modeloTabla.addRow(new Object[] { p.getIdProducto(), p.getNombre(), p.getCantidad(), p.getPrecio(), p.getIdProveedor() });
		}
	}
	
	public void cargaCombo() {
		ArrayList<String> misProductos = new ArrayList<>();
		ConectandoBBDD bd = new ConectandoBBDD();
		misProductos = bd.consultarProducto();
		for (int i = 0; i < misProductos.size(); i++) {
			comboBoxProductos.addItem(misProductos.get(i));
		}
	}
}
