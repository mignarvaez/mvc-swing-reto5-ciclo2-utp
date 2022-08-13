package co.edu.utp.misiontic2022.c2.reto5.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ConsultaModelo consultaModelo;
	private JScrollPane scrollPane;
	private TablaOscura tablaOscura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

		consultaModelo = new ConsultaModelo();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Reto 5");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setBackground(new Color(30, 30, 30));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		scrollPane.setSize(606, 388);
		scrollPane.setLocation(89, 138);
		contentPane.add(scrollPane);
		tablaOscura = new TablaOscura();
		scrollPane.setViewportView(tablaOscura);

		JComboBox<String> cbxOpcion = new JComboBox<>();
		cbxOpcion.setFont(new Font("Arial Black", Font.PLAIN, 11));
		cbxOpcion.setBounds(293, 81, 285, 28);
		cbxOpcion.setModel(new DefaultComboBoxModel<String>(new String[] { "Seleccione una opción",
				"Información de lideres", "Casas campestres del Caribe", "Compras Homecenter Salento" }));
		cbxOpcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarConsulta(cbxOpcion.getSelectedIndex());
			}
		});
		contentPane.setLayout(null);
		cbxOpcion.setSelectedIndex(0);
		contentPane.add(cbxOpcion);

		JLabel lblTitulo = new JLabel("Reto 5: Consultas\r\n");
		lblTitulo.setForeground(SystemColor.controlHighlight);
		lblTitulo.setBounds(283, 28, 217, 42);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		contentPane.add(lblTitulo);

		JLabel lblOpcionConsulta = new JLabel("Eliga la consulta:");
		lblOpcionConsulta.setForeground(SystemColor.controlHighlight);
		lblOpcionConsulta.setBounds(135, 72, 148, 42);
		lblOpcionConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcionConsulta.setFont(new Font("Arial Black", Font.PLAIN, 14));
		contentPane.add(lblOpcionConsulta);

		tablaOscura.setBounds(92, 141, 599, 374);
		tablaOscura.fixTable(scrollPane);

		JLabel lblLogoUtp = new JLabel();
		lblLogoUtp.setSize(100, 65);
		lblLogoUtp.setLocation(25, 28);
		lblLogoUtp.setIcon(new ImageIcon(new ImageIcon("src/main/resources/logoUTP.png").getImage()
				.getScaledInstance(100, 65, Image.SCALE_SMOOTH)));
		contentPane.add(lblLogoUtp);

		JLabel lblLogoMintic = new JLabel();
		lblLogoMintic.setSize(100, 65);
		lblLogoMintic.setLocation(653, 28);
		lblLogoMintic.setIcon(new ImageIcon(new ImageIcon("src/main/resources/logoMintic.png").getImage()
				.getScaledInstance(100, 65, Image.SCALE_SMOOTH)));
		contentPane.add(lblLogoMintic);

	}

	private void listarConsulta(int consulta) {

		switch (consulta) {
		case 1:
			try {
				tablaOscura.setModel(consultaModelo.liderProyecto());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(contentPane, "Sucedio un error con la base de datos.", "Reto 5",
						JOptionPane.ERROR_MESSAGE);
				System.err.println(e);
			}
			break;
		case 2:
			try {
				tablaOscura.setModel(consultaModelo.proyectoCaribe());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(contentPane, "Sucedio un error con la base de datos.", "Reto 5",
						JOptionPane.ERROR_MESSAGE);
				System.err.println(e);
			}
			break;
		case 3:
			try {
				tablaOscura.setModel(consultaModelo.compraHomecenterSalento());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(contentPane, "Sucedio un error con la base de datos.", "Reto 5",
						JOptionPane.ERROR_MESSAGE);
				System.err.println(e);
			}
			break;
		default:
			String[] emptyHeader = { "" };
			tablaOscura.setModel(new DefaultTableModel(null, emptyHeader));
			break;
		}
	}
}
