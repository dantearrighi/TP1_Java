package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import negocio.ElectrodomesticoNegocio;
import datos.Electrodomestico;
import datos.Lavarropas;
import datos.Televisor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class Consultas extends JFrame {

	private JPanel contentPane;
	private JTextField txtPreMin;
	private JTextField txtPreMax;
	private JTable Jtable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultas frame = new Consultas();
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
	public Consultas() {
		setAutoRequestFocus(false);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 ButtonGroup grupo = new ButtonGroup();
		JRadioButton rbtnEletroGral = new JRadioButton("Electrodom\u00E9sticos General");
		rbtnEletroGral.setSelected(true);
		rbtnEletroGral.setBounds(67, 72, 207, 23);
		contentPane.add(rbtnEletroGral);
		
		JRadioButton rbtnTele = new JRadioButton("Televisores");
		rbtnTele.setBounds(303, 72, 124, 23);
		contentPane.add(rbtnTele);
		
		JRadioButton rbtnLava = new JRadioButton("Lavarropas");
		rbtnLava.setBounds(494, 72, 110, 23);
		contentPane.add(rbtnLava);
		grupo.add(rbtnLava);
		grupo.add(rbtnTele);
		grupo.add(rbtnEletroGral);
		
		JLabel lblConsultaDeElectrodomsticos = new JLabel("Consulta de Electrodom\u00E9sticos");
		lblConsultaDeElectrodomsticos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConsultaDeElectrodomsticos.setBounds(218, 27, 236, 14);
		contentPane.add(lblConsultaDeElectrodomsticos);
		
		JCheckBox chbxPrecio = new JCheckBox("Por Precio");
		chbxPrecio.setBounds(77, 98, 91, 23);
		contentPane.add(chbxPrecio);
		
		JCheckBox chbxConsumo = new JCheckBox("Por Consumo");
		chbxConsumo.setBounds(422, 98, 98, 23);
		contentPane.add(chbxConsumo);
		
		JComboBox cbxConsumo = new JComboBox();
		cbxConsumo.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		cbxConsumo.setBounds(526, 98, 45, 23);
		contentPane.add(cbxConsumo);
		
		txtPreMin = new JTextField();
		txtPreMin.setBounds(174, 99, 57, 20);
		contentPane.add(txtPreMin);
		txtPreMin.setColumns(10);
		
		txtPreMax = new JTextField();
		txtPreMax.setColumns(10);
		txtPreMax.setBounds(290, 99, 57, 20);
		contentPane.add(txtPreMax);
		
		JLabel lblMin = new JLabel("Min");
		lblMin.setBounds(241, 102, 33, 14);
		contentPane.add(lblMin);
		
		JLabel lblMax = new JLabel("Max");
		lblMax.setBounds(357, 102, 46, 14);
		contentPane.add(lblMax);
	
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				Controlador Consultas = new Controlador();
				switch(Consultas.ConsultaElec(rbtnEletroGral.isSelected(), rbtnLava.isSelected(), rbtnTele.isSelected(),chbxPrecio.isSelected(), chbxConsumo.isSelected()))
				{
				case 1:ArrayList<Electrodomestico> Elec;/*getall electro*/
						setearParaElectro(model);
											
						Elec=Consultas.GetAllEl();
						llenarModeloElectro(model, Elec);
							break;
							
				case 2:ArrayList<Electrodomestico> ElecC;/*electro por Consumo*/
						setearParaElectro(model);
						
						ElecC=Consultas.ElectxConsumo(cbxConsumo.getSelectedItem().toString().charAt(0));
						llenarModeloElectro(model, ElecC);
							break;
					
				case 3:ArrayList<Electrodomestico> ElecP;/*Electro por precio*/
						setearParaElectro(model);
					validarCamposCompletos();
						ElecP=Consultas.ElectxPrecio(Float.parseFloat(txtPreMin.getText()), Float.parseFloat(txtPreMax.getText()));
						llenarModeloElectro(model, ElecP);
							break;
				case 4:ArrayList<Electrodomestico> ElecCP;/*electro por precio y consumo*/
				setearParaElectro(model);
				validarCamposCompletos();
				ElecCP=Consultas.ElectxPrecioyConsumo(Float.parseFloat(txtPreMin.getText()), Float.parseFloat(txtPreMax.getText()),cbxConsumo.getSelectedItem().toString().charAt(0));
				llenarModeloElectro(model, ElecCP);
					break;
					
/*Es Tele*/		case 5:ArrayList<Televisor> Tele;/*get all tele*/
					setearParaTele(model);
						Tele=Consultas.GetAllTe();
					llenarModeloTele(model, Tele);
				break;
				
				case 6:ArrayList<Televisor> TeleC;/*Tele x Consumo*/
				setearParaTele(model);
					TeleC=Consultas.ElectxConsumoTele(cbxConsumo.getSelectedItem().toString().charAt(0));
				llenarModeloTele(model, TeleC);
				break;
				
				case 7:ArrayList<Televisor> TeleP;/* Tele x Precio*/
				setearParaTele(model);
				validarCamposCompletos();
					TeleP=Consultas.ElectxPrecioTele(Float.parseFloat(txtPreMin.getText()), Float.parseFloat(txtPreMax.getText()));
				llenarModeloTele(model, TeleP);
				break;
				
				case 8:ArrayList<Televisor> TeleCP;/*Tele x precio y consumo*/
				setearParaTele(model);
				validarCamposCompletos();
					TeleCP=Consultas.ElectxPrecioTele(Float.parseFloat(txtPreMin.getText()), Float.parseFloat(txtPreMax.getText()),cbxConsumo.getSelectedItem().toString().charAt(0));
				llenarModeloTele(model, TeleCP);
				break;
				
				
/*Es lava*/		case 9:ArrayList<Lavarropas> Lava;/*Get all lava*/
					setearParaLava(model);
						Lava=Consultas.GetAllLa();
					llenarModeloLava(model, Lava);
				break;
								
				case 10:ArrayList<Lavarropas> LavaC;/*Lava por consumo*/
				setearParaLava(model);
					LavaC=Consultas.ElectxConsumoLava(cbxConsumo.getSelectedItem().toString().charAt(0));
				llenarModeloLava(model, LavaC);
				break;
				
				case 11:ArrayList<Lavarropas> LavaP;/*Lava por precio*/
				setearParaLava(model);
				validarCamposCompletos();
					LavaP=Consultas.ElectxPrecioLava(Float.parseFloat(txtPreMin.getText()), Float.parseFloat(txtPreMax.getText()));
				llenarModeloLava(model, LavaP);
				break;
				
				case 12:ArrayList<Lavarropas> LavaCP;/*Lava por consumo y precio*/
				setearParaLava(model);
				validarCamposCompletos();
					LavaCP=Consultas.ElectxPrecioLava(Float.parseFloat(txtPreMin.getText()), Float.parseFloat(txtPreMax.getText()),cbxConsumo.getSelectedItem().toString().charAt(0));
				llenarModeloLava(model, LavaCP);
				break;
				default:break;
				}
				
				Jtable.setModel(model);
				 
				Jtable.setVisible(true);
			}

			private void validarCamposCompletos() {
				if(txtPreMin.getText().equals("")|| txtPreMax.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Por favor complete los campos necesarios");
										
				}
			}

			private void llenarModeloLava(DefaultTableModel model,
					ArrayList<Lavarropas> Lava) {
				Lavarropas Lavas = new Lavarropas();
				
				Object[] filaL = new Object[7];
				
				Iterator<Lavarropas> iteradorL = Lava.iterator();
				
				while(iteradorL.hasNext())
				{	Lavas = iteradorL.next();
					filaL[0]=Lavas.getIdElect();
					filaL[1]=Lavas.getDescripcion();
					filaL[2]=Lavas.getColor();
					filaL[3]=Lavas.getConsumoEnergetico();
					filaL[4]=Lavas.getPeso();
					filaL[5]=Lavas.getCarga();
					filaL[6]=Lavas.getPreciobase();
					model.addRow(filaL);
							
				};
			}

			private void setearParaLava(DefaultTableModel model) {
				
										model.addColumn("ID");
										model.addColumn("Descripcion");
										model.addColumn("Color");
										model.addColumn("Consumo Energético");
										model.addColumn("Peso");
										model.addColumn("Carga");
										model.addColumn("Precio");
										Jtable.getColumnModel().getColumn(3).setHeaderValue("ID");
										
										ArrayList<Lavarropas> Lava = new ArrayList<Lavarropas>();
			}

			private void llenarModeloTele(DefaultTableModel model,
					ArrayList<Televisor> Tele) {
				Televisor Telev = new Televisor();
				
				Object[] filaT = new Object[8];
				
				Iterator<Televisor> iteradorT = Tele.iterator();
				
				while(iteradorT.hasNext())
				{	Telev = iteradorT.next();
					filaT[0]=Telev.getIdElect();
					filaT[1]=Telev.getDescripcion();
					filaT[2]=Telev.getColor();
					filaT[3]=Telev.getConsumoEnergetico();
					filaT[4]=Telev.getPeso();
					filaT[5]=Telev.getPulgadas();
					filaT[6]=Telev.isSintonizadorTDT();
					filaT[7]=Telev.getPreciobase();
					model.addRow(filaT);
							
				};
			}

			private void setearParaTele(DefaultTableModel model) {
										
				
										model.addColumn("ID");
										model.addColumn("Descripcion");
										model.addColumn("Color");
										model.addColumn("Consumo Energético");
										model.addColumn("Peso");
										model.addColumn("Resolucion");
										model.addColumn("Sintonizador TDT");
										model.addColumn("Precio");
										
										
										
										ArrayList<Televisor> Tele = new ArrayList<Televisor>();
			}

			private void llenarModeloElectro(DefaultTableModel model,
					ArrayList<Electrodomestico> Elec) {
				Electrodomestico Electro = new Electrodomestico();
				
				Object[] fila = new Object[6];
				
				Iterator<Electrodomestico> iterador = Elec.iterator();
				
				while(iterador.hasNext())
				{	Electro = iterador.next();
					fila[0]=Electro.getIdElect();
					fila[1]=Electro.getDescripcion();
					fila[2]=Electro.getColor();
					fila[3]=Electro.getConsumoEnergetico();
					fila[4]=Electro.getPeso();
					fila[5]=Electro.getPreciobase();
					model.addRow(fila);
				}
			}

			private void setearParaElectro(DefaultTableModel model) {
										
								
										model.addColumn("ID");
										model.addColumn("Descripcion");
										model.addColumn("Color");
										model.addColumn("Consumo Energético");
										model.addColumn("Peso");
										model.addColumn("Precio");
																				
										ArrayList<Electrodomestico> Elec = new ArrayList<Electrodomestico>();
			}
			
		});
		btnBuscar.setBounds(291, 130, 89, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 662, 249);
		contentPane.add(scrollPane);
		
		Jtable = new JTable();
		scrollPane.setViewportView(Jtable);
		Jtable.setRowSelectionAllowed(false);
	}
}
