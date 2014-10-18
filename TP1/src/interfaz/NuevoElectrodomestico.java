package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoElectrodomestico extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdTele;
	private JTextField txtDescripTele;
	private JTextField txtColorTele;
	private JTextField txtPrecioBTele;
	private JTextField txtIdElec;
	private JTextField txtDescripElec;
	private JTextField txtColorElec;
	private JTextField txtPrecioBElect;
	private JTextField txtIdLava;
	private JTextField txtDescripLava;
	private JTextField txtColorLava;
	private JTextField txtPesoLava;
	private JTextField txtPrecioBLava;
	private JTextField txtCargaLava;
	private JTextField txtResol;
	private JTextField txtPesoTele;
	private JTextField txtPesoElect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoElectrodomestico frame = new NuevoElectrodomestico();
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
	public NuevoElectrodomestico() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoElectrodomstico = new JLabel("Nuevo Electrodom\u00E9stico");
		lblNuevoElectrodomstico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNuevoElectrodomstico.setBounds(169, 22, 195, 14);
		contentPane.add(lblNuevoElectrodomstico);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 51, 513, 249);
		contentPane.add(tabbedPane);
		
		JPanel Electrodomestico = new JPanel();
		Electrodomestico.setToolTipText("");
		tabbedPane.addTab("Electrodom\u00E9stico", null, Electrodomestico, null);
		Electrodomestico.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 508, 221);
		Electrodomestico.add(panel);
		
		JLabel label = new JLabel("ID");
		label.setBounds(10, 11, 11, 14);
		panel.add(label);
		
		txtIdElec = new JTextField();
		txtIdElec.setEnabled(false);
		txtIdElec.setColumns(10);
		txtIdElec.setBounds(31, 8, 86, 20);
		panel.add(txtIdElec);
		
		JLabel label_1 = new JLabel("Descripcion");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(10, 68, 95, 14);
		panel.add(label_1);
		
		txtDescripElec = new JTextField();
		txtDescripElec.setColumns(10);
		txtDescripElec.setBounds(115, 65, 383, 20);
		panel.add(txtDescripElec);
		
		txtColorElec = new JTextField();
		txtColorElec.setColumns(10);
		txtColorElec.setBounds(115, 109, 143, 20);
		panel.add(txtColorElec);
		
		JLabel label_2 = new JLabel("Color");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(10, 112, 60, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Peso");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(285, 112, 60, 14);
		panel.add(label_3);
		
		JLabel lblPrecioBase = new JLabel("Precio Base");
		lblPrecioBase.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioBase.setBounds(285, 148, 72, 27);
		panel.add(lblPrecioBase);
		
		txtPrecioBElect = new JTextField();
		txtPrecioBElect.setColumns(10);
		txtPrecioBElect.setBounds(355, 151, 143, 20);
		panel.add(txtPrecioBElect);
		
		JComboBox<Object> cbxConsumoElec = new JComboBox<Object>();
		cbxConsumoElec.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		cbxConsumoElec.setBounds(135, 151, 50, 20);
		panel.add(cbxConsumoElec);
		
		JLabel label_5 = new JLabel("Consumo Energetico");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setBounds(10, 154, 125, 14);
		panel.add(label_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 488, 2);
		panel.add(separator);
		
		JLabel lblPrecioFinal = new JLabel("Precio Final");
		lblPrecioFinal.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblPrecioFinal.setBounds(298, 196, 86, 14);
		panel.add(lblPrecioFinal);
		
		JLabel lblPreciofinalelectro = new JLabel("000");
		lblPreciofinalelectro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblPreciofinalelectro.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreciofinalelectro.setBounds(426, 196, 72, 14);
		panel.add(lblPreciofinalelectro);
		
		JLabel label_12 = new JLabel("$  ");
		label_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setBounds(370, 196, 58, 14);
		panel.add(label_12);
		
		txtPesoElect = new JTextField();
		txtPesoElect.setColumns(10);
		txtPesoElect.setBounds(355, 109, 116, 20);
		panel.add(txtPesoElect);
		
		JLabel label_17 = new JLabel("Kg.");
		label_17.setBounds(481, 112, 27, 14);
		panel.add(label_17);
		
		JPanel Televisor = new JPanel();
		tabbedPane.addTab("Televisor", null, Televisor, null);
		Televisor.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 11, 14);
		Televisor.add(lblId);
		
		txtIdTele = new JTextField();
		txtIdTele.setEnabled(false);
		txtIdTele.setBounds(31, 8, 86, 20);
		Televisor.add(txtIdTele);
		txtIdTele.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripcion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 68, 95, 14);
		Televisor.add(lblNewLabel);
		
		txtDescripTele = new JTextField();
		txtDescripTele.setBounds(115, 65, 383, 20);
		Televisor.add(txtDescripTele);
		txtDescripTele.setColumns(10);
		
		txtColorTele = new JTextField();
		txtColorTele.setBounds(115, 109, 143, 20);
		Televisor.add(txtColorTele);
		txtColorTele.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColor.setBounds(10, 112, 58, 14);
		Televisor.add(lblColor);
		
		JLabel lblNewLabel_1 = new JLabel("Peso");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(285, 112, 60, 14);
		Televisor.add(lblNewLabel_1);
		
		JLabel lblPrecio = new JLabel("Precio Base");
		lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio.setBounds(285, 148, 72, 27);
		Televisor.add(lblPrecio);
		
		txtPrecioBTele = new JTextField();
		txtPrecioBTele.setBounds(355, 151, 143, 20);
		Televisor.add(txtPrecioBTele);
		txtPrecioBTele.setColumns(10);
		
		JComboBox cbxConsumoTele = new JComboBox();
		cbxConsumoTele.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		cbxConsumoTele.setBounds(135, 151, 50, 20);
		Televisor.add(cbxConsumoTele);
		
		JLabel lblConsumoEnergetico = new JLabel("Consumo Energetico");
		lblConsumoEnergetico.setHorizontalAlignment(SwingConstants.LEFT);
		lblConsumoEnergetico.setBounds(10, 154, 131, 14);
		Televisor.add(lblConsumoEnergetico);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 55, 488, 2);
		Televisor.add(separator_1);
		
		JLabel label_4 = new JLabel("Precio Final");
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_4.setBounds(319, 198, 86, 14);
		Televisor.add(label_4);
		
		JLabel label_13 = new JLabel("$  ");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_13.setBounds(370, 198, 58, 14);
		Televisor.add(label_13);
		
		JLabel lblPrecioFinalTele = new JLabel("000");
		lblPrecioFinalTele.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioFinalTele.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblPrecioFinalTele.setBounds(426, 198, 72, 14);
		Televisor.add(lblPrecioFinalTele);
		
		JLabel lblResolucin = new JLabel("Resoluci\u00F3n");
		lblResolucin.setBounds(10, 195, 86, 14);
		Televisor.add(lblResolucin);
		
		txtResol = new JTextField();
		txtResol.setBounds(115, 189, 45, 20);
		Televisor.add(txtResol);
		txtResol.setColumns(10);
		
		txtPesoTele = new JTextField();
		txtPesoTele.setColumns(10);
		txtPesoTele.setBounds(355, 109, 116, 20);
		Televisor.add(txtPesoTele);
		
		JLabel label_16 = new JLabel("Kg.");
		label_16.setBounds(481, 112, 27, 14);
		Televisor.add(label_16);
		
		JCheckBox chckbxSintonizadorTdt = new JCheckBox("Sintonizador TDT");
		chckbxSintonizadorTdt.setBounds(184, 182, 136, 32);
		Televisor.add(chckbxSintonizadorTdt);
		
		JPanel Lavarropa = new JPanel();
		tabbedPane.addTab("Lavarropa", null, Lavarropa, null);
		Lavarropa.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 508, 221);
		Lavarropa.add(panel_1);
		
		JLabel label_6 = new JLabel("ID");
		label_6.setBounds(10, 11, 11, 14);
		panel_1.add(label_6);
		
		txtIdLava = new JTextField();
		txtIdLava.setEnabled(false);
		txtIdLava.setColumns(10);
		txtIdLava.setBounds(31, 8, 86, 20);
		panel_1.add(txtIdLava);
		
		JLabel label_7 = new JLabel("Descripcion");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setBounds(10, 68, 60, 14);
		panel_1.add(label_7);
		
		txtDescripLava = new JTextField();
		txtDescripLava.setColumns(10);
		txtDescripLava.setBounds(115, 65, 383, 20);
		panel_1.add(txtDescripLava);
		
		txtColorLava = new JTextField();
		txtColorLava.setColumns(10);
		txtColorLava.setBounds(115, 109, 143, 20);
		panel_1.add(txtColorLava);
		
		JLabel label_8 = new JLabel("Color");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setBounds(10, 112, 28, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Peso");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setBounds(285, 112, 60, 14);
		panel_1.add(label_9);
		
		txtPesoLava = new JTextField();
		txtPesoLava.setColumns(10);
		txtPesoLava.setBounds(355, 109, 116, 20);
		panel_1.add(txtPesoLava);
		
		JLabel lblPrecioBase_1 = new JLabel("Precio Base");
		lblPrecioBase_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioBase_1.setBounds(285, 148, 72, 27);
		panel_1.add(lblPrecioBase_1);
		
		txtPrecioBLava = new JTextField();
		txtPrecioBLava.setColumns(10);
		txtPrecioBLava.setBounds(355, 151, 143, 20);
		panel_1.add(txtPrecioBLava);
		
		JComboBox cbxConsumoLava = new JComboBox();
		cbxConsumoLava.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		cbxConsumoLava.setBounds(135, 151, 50, 20);
		panel_1.add(cbxConsumoLava);
		
		JLabel label_11 = new JLabel("Consumo Energetico");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setBounds(10, 154, 127, 14);
		panel_1.add(label_11);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 55, 488, 2);
		panel_1.add(separator_2);
		
		JLabel label_14 = new JLabel("Precio Final");
		label_14.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_14.setBounds(298, 196, 86, 14);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("$  ");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_15.setBounds(370, 196, 58, 14);
		panel_1.add(label_15);
		
		JLabel lblPrecioFinalLava = new JLabel("000");
		lblPrecioFinalLava.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioFinalLava.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblPrecioFinalLava.setBounds(426, 196, 72, 14);
		panel_1.add(lblPrecioFinalLava);
		
		JLabel lblCargaMxima = new JLabel("Carga M\u00E1xima");
		lblCargaMxima.setBounds(10, 198, 107, 14);
		panel_1.add(lblCargaMxima);
		
		txtCargaLava = new JTextField();
		txtCargaLava.setBounds(115, 195, 40, 20);
		panel_1.add(txtCargaLava);
		txtCargaLava.setColumns(10);
		
		JLabel lblKg = new JLabel("Kg.");
		lblKg.setBounds(165, 198, 46, 14);
		panel_1.add(lblKg);
		
		JLabel lblKg_1 = new JLabel("Kg.");
		lblKg_1.setBounds(481, 112, 27, 14);
		panel_1.add(lblKg_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NuevoElectrodomestico.this.dispose();
			
			}
		});
		btnCancelar.setBounds(434, 311, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Controlador cont = new Controlador();
			String tipoElec = "";
			/*Aplicar un metodo para evitar el default*/
			switch(tabbedPane.getSelectedIndex())
			{
			case 0: cont.NuevoElectro(Float.parseFloat(txtPrecioBElect.getText()), Float.parseFloat(txtPesoElect.getText()), txtColorElec.getText().toString(),cbxConsumoElec.getSelectedItem().toString().charAt(0), txtDescripElec.getText().toString()); 
					tipoElec ="Electrodomestico";
					break;
			case 1: cont.NuevoTele(Float.parseFloat(txtPrecioBTele.getText()), Float.parseFloat(txtPesoTele.getText()), txtColorTele.getText().toString(),cbxConsumoTele.getSelectedItem().toString().charAt(0), txtDescripTele.getText().toString(), Integer.parseInt(txtResol.getText().toString()),(chckbxSintonizadorTdt.isSelected())); 
					tipoElec = "Televisor";
					break;
			
			case 2: cont.NuevoLavarr(Float.parseFloat(txtPrecioBLava.getText()), Float.parseFloat(txtPesoLava.getText()), txtColorLava.getText().toString(),cbxConsumoLava.getSelectedItem().toString().charAt(0), txtDescripLava.getText().toString(),Float.parseFloat(txtCargaLava.getText())); 
				tipoElec="Lavarropas";
				break;
			default: break;
			}
			JOptionPane.showMessageDialog(null, "Se añadió un nuevo "+tipoElec+" al registro.");
			dispose();
			
			}
		});
		btnGuardar.setBounds(335, 311, 89, 23);
		contentPane.add(btnGuardar);
	}
}
