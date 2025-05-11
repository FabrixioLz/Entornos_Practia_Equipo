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
import javax.swing.JLabel;
import java.awt.Font;
/**
 * Panel que permite al ususario poder consultar los productos que hay dentro de la base de datos,
 * según su nombre.
 * 
 * @author Rubén Castañares
 */
public class PanelConsultarProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxProductos;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JTable tableProductos;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 * Diseño del panel, en el hay un combobox para seleccionar el producto y una tabla que muestra sus datos.
	 * Cuando se cambia de un producto a otro, la tabla se actualiza automáticamente. 
	 * 
	 * @author Rubén Castañares
	 */
	public PanelConsultarProducto() {
		setLayout(null);
		
		comboBoxProductos = new JComboBox();
		comboBoxProductos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxProductos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ArrayList<Producto> arrProductos = new ArrayList<>();
				ConectandoBBDD bd = new ConectandoBBDD();
				arrProductos = bd.consultarProductoPorNombre(comboBoxProductos.getSelectedItem().toString());
				cargaTabla(arrProductos);
			}
		});
		
		comboBoxProductos.setBounds(177, 81, 208, 22);
		add(comboBoxProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 129, 485, 167);
		add(scrollPane);
		
		tableProductos = new JTable();
		tableProductos.setForeground(new Color(0, 0, 255));
		scrollPane.setViewportView(tableProductos);
		
		modeloTabla.setColumnIdentifiers(new Object[] { "idProducto", "Nombre", "Cantidad", "Precio", "idProveedor" });
		tableProductos.setModel(modeloTabla);
		
		lblNewLabel = new JLabel("CONSULTA DE PRODUCTOS");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(163, 31, 288, 14);
		add(lblNewLabel);
		
		cargaCombo();
		
	}
	/**
	 * Se cargan los datos del producto en la tabla.
	 * @param arrProductos (lista de los productos).
	 * 
	 * @author Rubén Castañares
	 */
	public void cargaTabla(ArrayList<Producto> arrProductos) {
		modeloTabla.setRowCount(0);

		for (Producto p: arrProductos) {
			modeloTabla.addRow(new Object[] { p.getIdProducto(), p.getNombre(), p.getCantidad(), p.getPrecio(), p.getIdProveedor() });
		}
	}
	
	/**
	 * El JComboBox se carga con los nombres de los productos de la base de datos.
	 * 
	 * @author Rubén Castañares
	 */
	public void cargaCombo() {
		ArrayList<String> misProductos = new ArrayList<>();
		ConectandoBBDD bd = new ConectandoBBDD();
		misProductos = bd.consultarProducto();
		for (int i = 0; i < misProductos.size(); i++) {
			comboBoxProductos.addItem(misProductos.get(i));
		}
	}
}
