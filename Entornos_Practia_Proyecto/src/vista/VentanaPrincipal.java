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

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
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
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 413);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menú");
		menuBar.add(mnMenu);

		PanelInsertarProducto PanelInsertar = new PanelInsertarProducto();
		PanelConsultarProducto PanelConsultar = new PanelConsultarProducto();

		JMenuItem mntmInsertarProducto = new JMenuItem("Insertar producto");
		mntmInsertarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelInsertarProducto i = new PanelInsertarProducto();
				nuevoPanel(i);
			}
		});
		mnMenu.add(mntmInsertarProducto);

		JMenuItem mntmConsultarInventario = new JMenuItem("Consultar Inventario");
		mntmConsultarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelConsultarProducto c = new PanelConsultarProducto();
				nuevoPanel(c);
			}
		});
		mnMenu.add(mntmConsultarInventario);

		JMenuItem mntmInsertarProveedor = new JMenuItem("Insertar Proveedor");
		mntmInsertarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelInsertarProveedor ip = new PanelInsertarProveedor();
				nuevoPanel(ip);
			}
		});
		mnMenu.add(mntmInsertarProveedor);

		JMenuItem mntmConsultarProveedor = new JMenuItem("Consultar Proveedor");
		mntmConsultarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelConsultarProveedor cp = new PanelConsultarProveedor();
				nuevoPanel(cp);
			}
		});
		mnMenu.add(mntmConsultarProveedor);

		JMenuItem mntmModificarProducto = new JMenuItem("Modificar Producto");
		mntmModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelModificarProducto mp = new PanelModificarProducto();
				nuevoPanel(mp);
			}
		});
		mnMenu.add(mntmModificarProducto);
		
		JMenuItem mntmModificarProveedor = new JMenuItem("Modificar Proveedor");
		
		mnMenu.add(mntmModificarProveedor);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar ");
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

	public void nuevoPanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.repaint();
		contentPane.revalidate();
	}

}
