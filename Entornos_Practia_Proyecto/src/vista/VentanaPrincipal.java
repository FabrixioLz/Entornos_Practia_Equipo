package vista;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
/**
 * Ventana principal de la aplicación, cuenta con un menú desde el que puedes acceder a los distintos paneles
 * de insertar, consultar, modificar y borrar.
 * 
 * @author Rubén Castañares
 */
public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * Inicia la aplicación.
	 * 
	 * @author Rubén Castañares
	 */
	public void ejecutador() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Configuración de la ventana principal, un menú para moverse de un panel a otro.
	 * 
	 * @author Rubén Castañares
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 470);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("      GESTIÓN DE PRODUCTOS Y SUS PROVEEDORES      ");
		mnMenu.setBackground(new Color(240, 240, 240));
		mnMenu.setFont(new Font("Arial Black", Font.BOLD, 18));
		menuBar.add(mnMenu);

		PanelInsertarProducto PanelInsertar = new PanelInsertarProducto();
		PanelConsultarProducto PanelConsultar = new PanelConsultarProducto();

		JMenuItem mntmInsertarProducto = new JMenuItem("1. Insertar producto");
		mntmInsertarProducto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmInsertarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelInsertarProducto i = new PanelInsertarProducto();
				nuevoPanel(i);
			}
		});
		mnMenu.add(mntmInsertarProducto);

		JMenuItem mntmConsultarInventario = new JMenuItem("2. Consultar Inventario");
		mntmConsultarInventario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmConsultarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelConsultarProducto c = new PanelConsultarProducto();
				nuevoPanel(c);
			}
		});
		mnMenu.add(mntmConsultarInventario);

		JMenuItem mntmInsertarProveedor = new JMenuItem("3. Insertar Proveedor");
		mntmInsertarProveedor.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmInsertarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelInsertarProveedor ip = new PanelInsertarProveedor();
				nuevoPanel(ip);
			}
		});
		mnMenu.add(mntmInsertarProveedor);

		JMenuItem mntmConsultarProveedor = new JMenuItem("4. Consultar Proveedor");
		mntmConsultarProveedor.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmConsultarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelConsultarProveedor cp = new PanelConsultarProveedor();
				nuevoPanel(cp);
			}
		});
		mnMenu.add(mntmConsultarProveedor);

		JMenuItem mntmModificarProducto = new JMenuItem("5. Modificar Producto");
		mntmModificarProducto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelModificarProducto mp = new PanelModificarProducto();
				nuevoPanel(mp);
			}
		});
		mnMenu.add(mntmModificarProducto);
		
		JMenuItem mntmModificarProveedor = new JMenuItem("6. Modificar Proveedor");
		mntmModificarProveedor.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmModificarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelModificarProveedor mprov = new PanelModificarProveedor();
				nuevoPanel(mprov);
			}
		});
		mnMenu.add(mntmModificarProveedor);
		
		JMenuItem mntmBorrar = new JMenuItem("7. Borrar ");
		mntmBorrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelBorrar bp = new PanelBorrar();
				nuevoPanel(bp);
			}
		});
		mnMenu.add(mntmBorrar);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout());
		setContentPane(contentPane);

	}
	/**
	 * Método utilizado para cambiar el contenido del panel.
	 * Elimina, agrega, reemplaza y actualiza.
	 * @param panel (el panel que se va a mostrar en la ventana).
	 * 
	 * @author Rubén Castañares
	 */
	public void nuevoPanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.repaint();
		contentPane.revalidate();
	}

}
