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
		setBounds(100, 100, 542, 378);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menú");
		menuBar.add(mnMenu);
		
		PanelInsertar PanelInsertar= new PanelInsertar();
		PanelConsultar PanelConsultar= new PanelConsultar();
		
		JMenuItem mntmInsertarProducto = new JMenuItem("Insertar producto");
		mntmInsertarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelInsertar i = new PanelInsertar();
				nuevoPanel(i);
			} 
		});
		mnMenu.add(mntmInsertarProducto);
		
		JMenuItem mntmConsultarInventario = new JMenuItem("Consultar Inventario");
		mntmConsultarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelConsultar c = new PanelConsultar();
				nuevoPanel(c);
			} 
		});
		mnMenu.add(mntmConsultarInventario);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnMenu.add(mntmNewMenuItem_2);
		
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
