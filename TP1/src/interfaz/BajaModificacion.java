package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JButton;

import datos.Electrodomestico;
import datos.Lavarropas;
import datos.Televisor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaModificacion extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDescripcion;
	private JTextField txtColor;
	private JTextField txtPrecioB;
	private JTextField txtPeso;
	private JTextField txtResolCarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaModificacion frame = new BajaModificacion();
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
	public BajaModificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 66, 508, 221);
		contentPane.add(panel);
		
		JLabel label = new JLabel("ID");
		label.setBounds(10, 11, 11, 14);
		panel.add(label);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(31, 8, 86, 20);
		panel.add(txtId);
		
		JLabel label_1 = new JLabel("Descripcion");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(10, 68, 95, 14);
		panel.add(label_1);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setEnabled(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(115, 65, 383, 20);
		panel.add(txtDescripcion);
		
		txtColor = new JTextField();
		txtColor.setEditable(false);
		txtColor.setEnabled(false);
		txtColor.setColumns(10);
		txtColor.setBounds(115, 109, 143, 20);
		panel.add(txtColor);
		
		JLabel label_2 = new JLabel("Color");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(10, 112, 60, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Peso");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(285, 112, 60, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Precio Base");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setBounds(285, 148, 72, 27);
		panel.add(label_4);
		
		txtPrecioB = new JTextField();
		txtPrecioB.setEnabled(false);
		txtPrecioB.setEditable(false);
		txtPrecioB.setColumns(10);
		txtPrecioB.setBounds(355, 151, 143, 20);
		panel.add(txtPrecioB);
		
		JComboBox<Object> cbxConsumo = new JComboBox<Object>();
		cbxConsumo.setBounds(135, 151, 50, 20);
		panel.add(cbxConsumo);
		
		JLabel label_5 = new JLabel("Consumo Energetico");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setBounds(10, 154, 125, 14);
		panel.add(label_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 488, 2);
		panel.add(separator);
		
		JLabel label_6 = new JLabel("Precio Final");
		label_6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_6.setBounds(298, 196, 86, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("000");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_7.setBounds(426, 196, 72, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("$  ");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_8.setBounds(370, 196, 58, 14);
		panel.add(label_8);
		
		txtPeso = new JTextField();
		txtPeso.setEnabled(false);
		txtPeso.setEditable(false);
		txtPeso.setColumns(10);
		txtPeso.setBounds(355, 109, 116, 20);
		panel.add(txtPeso);
		
		JLabel label_9 = new JLabel("Kg.");
		label_9.setBounds(481, 112, 27, 14);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Resoluci\u00F3n");
		label_10.setVisible(false);
		label_10.setBounds(10, 195, 86, 14);
		panel.add(label_10);
		
		txtResolCarga = new JTextField();
		txtResolCarga.setVisible(false);
		txtResolCarga.setEnabled(false);
		txtResolCarga.setEditable(false);
		txtResolCarga.setColumns(10);
		txtResolCarga.setBounds(115, 189, 45, 20);
		panel.add(txtResolCarga);
		
		JCheckBox chkSintonizador = new JCheckBox("Sintonizador TDT");
		chkSintonizador.setVisible(false);
		chkSintonizador.setEnabled(false);
		chkSintonizador.setBounds(184, 182, 136, 32);
		panel.add(chkSintonizador);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador controla = new Controlador();
				int ID = controla.elegirElectroaMostrar(Integer.parseInt(txtId.getText()));
				switch(ID)
				{
				case 0: txtResolCarga.setVisible(false);
						label_10.setVisible(false);
						chkSintonizador.setVisible(false);						
						Electrodomestico ElectroMostrar = new Electrodomestico();
						ElectroMostrar = controla.mostrarElectro(Integer.parseInt(txtId.getText()));
						txtId.setEnabled(false);
						txtColor.setText(ElectroMostrar.getColor());
						txtDescripcion.setText(ElectroMostrar.getDescripcion());
						txtPeso.setText(String.valueOf(ElectroMostrar.getPeso()));
						txtPrecioB.setText(String.valueOf(ElectroMostrar.getPreciobase()));
						
						break;
				case 1: txtResolCarga.setVisible(true);
						label_10.setText("Resolucion");
						chkSintonizador.setVisible(true);
						Televisor TeleMostrar = new Televisor();
						TeleMostrar = controla.mostrarelectro((Integer.parseInt(txtId.getText())));
						txtId.setEnabled(false);
						txtColor.setText(TeleMostrar.getColor());
						txtColor.setEnabled(true);
						txtDescripcion.setText(TeleMostrar.getDescripcion());
						txtDescripcion.setEnabled(true);
						txtPeso.setText(String.valueOf(TeleMostrar.getPeso()));
						txtPeso.setEnabled(true);
						txtPrecioB.setText(String.valueOf(TeleMostrar.getPreciobase()));
						txtPrecioB.setEnabled(true);
						chkSintonizador.setSelected(TeleMostrar.isSintonizadorTDT());
						txtResolCarga.setText(String.valueOf(TeleMostrar.getPulgadas()));
						txtResolCarga.setEnabled(true);
						break;
				case 2:	txtResolCarga.setVisible(true);
						label_10.setText("Carga");
						label_10.setVisible(true);
						chkSintonizador.setVisible(false);
						Lavarropas LavaMostrar = new Lavarropas();
						LavaMostrar = controla.mostrarLava((Integer.parseInt(txtId.getText())));
						txtId.setEnabled(false);
						txtColor.setText(LavaMostrar.getColor());
						txtColor.setEnabled(true);
						txtDescripcion.setText(LavaMostrar.getDescripcion());
						txtDescripcion.setEnabled(true);
						txtPeso.setText(String.valueOf(LavaMostrar.getPeso()));
						txtPeso.setEnabled(true);
						txtPrecioB.setText(String.valueOf(LavaMostrar.getPreciobase()));
						txtPrecioB.setEnabled(true);
						txtResolCarga.setText(String.valueOf(LavaMostrar.getCarga()));
						txtResolCarga.setEnabled(true);
						break;	
				default:break;
						
				}
				
				
			}
		});
		btnBuscar.setBounds(127, 7, 72, 23);
		panel.add(btnBuscar);
		
		JLabel lblBajamodificacionDeElectrodomesticos = new JLabel("Baja-Modificacion de Electrodomesticos");
		lblBajamodificacionDeElectrodomesticos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBajamodificacionDeElectrodomesticos.setBounds(108, 11, 310, 14);
		contentPane.add(lblBajamodificacionDeElectrodomesticos);
		
		JButton btnModificar = new JButton("Guardar");
		btnModificar.setBounds(329, 311, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(428, 311, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(230, 311, 89, 23);
		contentPane.add(btnEliminar);
	}
}
