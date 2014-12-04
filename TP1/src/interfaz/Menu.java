package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*Comentario Cualquiera ahi*/
public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCasaDeElectrodomesticos = new JLabel("Casa de Electrodomesticos");
		lblCasaDeElectrodomesticos.setForeground(Color.BLUE);
		lblCasaDeElectrodomesticos.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblCasaDeElectrodomesticos.setBounds(173, 11, 286, 42);
		contentPane.add(lblCasaDeElectrodomesticos);
		
		JButton btnNewElec = new JButton("Agregar Nuevo Electrodomestico");
		btnNewElec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoElectrodomestico frmNuevoElec = new NuevoElectrodomestico();
			
				frmNuevoElec.setVisible(true);
				
			}
		});
		btnNewElec.setBounds(196, 149, 240, 42);
		contentPane.add(btnNewElec);
		
		JButton btnBajaModif = new JButton("Baja o Modificacion de Electrodomestico");
		btnBajaModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaModificacion frmBajaModif = new BajaModificacion();
				
				frmBajaModif.setVisible(true);
			}
		});
		btnBajaModif.setBounds(196, 212, 240, 42);
		contentPane.add(btnBajaModif);
		
		JButton btnConsultaImpCons = new JButton("Consulta por Importes / Consumo");
		btnConsultaImpCons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaz.Consultas frmConsulta = new Consultas();
				frmConsulta.setVisible(true);
			}
		});
		btnConsultaImpCons.setBounds(196, 274, 240, 42);
		contentPane.add(btnConsultaImpCons);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				Menu.this.dispose();
			}
		});
		btnSalir.setBounds(543, 354, 89, 23);
		contentPane.add(btnSalir);
	}
}
