package vista;

import javax.swing.JPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import controlador.ConectandoBBDD;
import modelo.Producto;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelConsultar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JComboBox comboBoxProductos;
	DefaultTableModel modeloTabla = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public PanelConsultar() {
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
		comboBoxProductos.setBounds(121, 24, 185, 22);
		add(comboBoxProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 57, 388, 147);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		cargaCombo();

	}
	public void cargaTabla(ArrayList<Producto> arrProductos) {
		modeloTabla.setRowCount(0);

		for (Producto p: arrProductos) {
			modeloTabla.addRow(new Object[] { p.getNombre(), p.getCod(), p.getCantidad(), p.getPrecio(), });
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
