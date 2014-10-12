package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Televisor extends Electrodomestico {

	private boolean sintonizadorTDT;
	private int pulgadas;
	
	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}

	public void setSintonizadorTDT(boolean sintonizadorTDT) {
		this.sintonizadorTDT = sintonizadorTDT;
	}

	public int getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}

	/*Constructor por defecto*/
	public Televisor()
	{
		super();
		sintonizadorTDT = false;
		pulgadas = 20;
	}
	/*Constructor con Precio y Peso*/
	public Televisor(float pPrecio, float pPeso)
	{
		this();
		this.setPeso(pPeso);
		this.setPreciobase(pPrecio);
	}
	/*Constructor con todos los atributos*/
	public Televisor(float pPrecio, float pPeso, char pConsumo, String pColor, boolean pSintonizador, int pPulgadas)
	{
		super();
		this.setColor(pColor);
		this.setConsumoEnergetico(pConsumo);
		this.setPeso(pPeso);
		this.setPreciobase(pPeso);
		this.setPulgadas(pPulgadas);
		this.setSintonizadorTDT(pSintonizador);
		
	}

	public int AddTelev(float pPrecio,float pPeso, String pColor, char pConsumo, boolean pSintonizador, int pPulgadas, String pDescripcion)
	{
		try{
			
		String SQLCons= "INSERT INTO Electrodomestico (descripcion, color_elect, consumo_elect, peso_elect ,precio_elect, Sintoniz_tele, Resol_tele) VALUES (?,?,?,?,?,?,?)";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1,pDescripcion);
		stmt.setString(2, pColor);
		stmt.setFloat(5, pPrecio);
		stmt.setFloat(4, pPeso);
		stmt.setObject(3, pConsumo,java.sql.Types.CHAR);
		stmt.setInt(6,pPulgadas);
		stmt.setBoolean(7, pSintonizador);



			stmt.execute(); 
			conecta.CloseConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Statement.RETURN_GENERATED_KEYS;
	}
	public void DeleteTelev(int pIdElec)
	{
		String SQLCons= "DELETE FROM Electrodomesticos where"+pIdElec+"=Electrodomesticos.id_electro";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		Statement stmt = null;
				try {
					stmt = conecta.Cone.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					ResultSet rta = stmt.executeQuery(SQLCons);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	public int UpdateTelev (Televisor Telev)
	{
		String SQLCons= "UPDATE Electrodomesticos SET (color_elect="+Telev.getColor()+", consumo_elect="+Telev.getConsumoEnergetico()+", precio_elect="+Telev.getPreciobase()+", peso_elect="+Telev.getPeso()+ ", Sintoniz_tele="+Telev.isSintonizadorTDT()+", Resol_tele="+Telev.getPulgadas()+") WHERE"+Telev.getIdElect()+"=Electrodomesticos.id_electro";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		Statement stmt = null;
				try {
					stmt = conecta.Cone.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					ResultSet rta = stmt.executeQuery(SQLCons);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Statement.RETURN_GENERATED_KEYS;
	}
	public Televisor[] GetAll()
	{
		Televisor[] ElectroDev = null;
		int i;
		String SQLCons= "Select * FROM Electrodomestico WHERE Resol_tele is not null";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		Statement stmt = null;
				try {
					stmt = conecta.Cone.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			/*	try {
					 ResultSet rta = stmt.executeQuery(SQLCons);
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				try {
					 ResultSet rta = stmt.executeQuery(SQLCons);
					for (i=0;i>stmt.getFetchSize();i++)
						{
							try {
								ElectroDev[i].setColor(rta.getNString("color_elect")); 
								ElectroDev[i].setConsumoEnergetico((char)rta.getObject("consumo_elect"));
								ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
								ElectroDev[i].setPreciobase(rta.getFloat("precio_elect"));
								ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
								ElectroDev[i].setSintonizadorTDT(rta.getBoolean("Sintoniz_tele"));
								ElectroDev[i].setPulgadas(rta.getInt("Resol_tele"));
								rta.next();
								} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return ElectroDev;		
	}
	public Televisor GetOne(int pId)
	{
		Televisor ElectroDev = null;
		
		String SQLCons= "Select * FROM Electrodomestico WHERE id_electro="+pId;
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		Statement stmt = null;
				try {
					stmt = conecta.Cone.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*try {
					 ResultSet rta = stmt.executeQuery(SQLCons);
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				try {   ResultSet rta = stmt.executeQuery(SQLCons);
						ElectroDev.setColor(rta.getNString("color_elect"));
						ElectroDev.setConsumoEnergetico((char)rta.getObject("consumo_elect"));
						ElectroDev.setIdElect(rta.getInt("id_electro"));
						ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
						ElectroDev.setPeso(rta.getFloat("peso_elect"));
						ElectroDev.setSintonizadorTDT(rta.getBoolean("Sintoniz_tele"));
						ElectroDev.setPulgadas(rta.getInt("Resol_tele"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
								}
		return ElectroDev;		
	}

	public Televisor[] GetxConsumo (char pConsumo)
	{
		Televisor[] ElectroDev = null;
		int i;
		String SQLCons= "Select * FROM Electrodomestico WHERE (Resol_tele is not null AND consumo_elect="+pConsumo+"ORDER BY descripcion";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		Statement stmt = null;
				try {
					stmt = conecta.Cone.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			/*	try {
					 ResultSet rta = stmt.executeQuery(SQLCons);
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				try {
					 ResultSet rta = stmt.executeQuery(SQLCons);
					for (i=0;i>stmt.getFetchSize();i++)
						{
							try {
								ElectroDev[i].setDescripcion(rta.getNString("descripcion"));
								ElectroDev[i].setColor(rta.getNString("color_elect"));							
								ElectroDev[i].consumoEnergetico = (char)rta.getObject("consumo_elect");
								ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
								ElectroDev[i].setPreciobase(rta.getFloat("precio_elect"));
								ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
								ElectroDev[i].setPulgadas(rta.getInt("Resol_tele"));
								ElectroDev[i].setSintonizadorTDT(rta.getBoolean("Sintoniz_tele"));
								} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return ElectroDev;
	}
	public Televisor[] GetxPrecios(float pMin, float pMax)
					{Televisor[] ElectroDev = null;
					int i;
					String SQLCons= "Select * FROM Electrodomestico WHERE (precio>="+pMin+"AND precio<="+pMax+"AND Resol_tele is not null)ORDER BY descripcion";
					ConexionBD conecta = new ConexionBD();
					conecta.OpenConection();
					Statement stmt = null;
							try {
								stmt = conecta.Cone.createStatement();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						/*	try {
								 ResultSet rta = stmt.executeQuery(SQLCons);
								} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							*/
							try {
								 ResultSet rta = stmt.executeQuery(SQLCons);
								for (i=0;i>stmt.getFetchSize();i++)
									{
										try {
											ElectroDev[i].setDescripcion(rta.getNString("descripcion"));
											ElectroDev[i].setColor(rta.getNString("color_elect"));							
											ElectroDev[i].consumoEnergetico = (char)rta.getObject("consumo_elect");
											ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
											ElectroDev[i].setPreciobase(rta.getFloat("precio_elect"));
											ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
											ElectroDev[i].setPulgadas(rta.getInt("Resol_tele"));
											ElectroDev[i].setSintonizadorTDT(rta.getBoolean("Sintoniz_tele"));
											rta.next();
											} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					return ElectroDev;
					
						
					}
	public Televisor[] GetxPrecioYConsumo(float pMin, float pMax, char pConsumo)
		{
		Televisor[] ElectroDev = null;
		int i;
		String SQLCons= "Select * FROM Electrodomestico WHERE (precio>="+pMin+"AND precio<="+pMax+"AND consumo_elect="+pConsumo+"AND Resol_tele is not null)ORDER BY descripcion";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		Statement stmt = null;
				try {
					stmt = conecta.Cone.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			/*	try {
					 ResultSet rta = stmt.executeQuery(SQLCons);
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				try {
					 ResultSet rta = stmt.executeQuery(SQLCons);
					for (i=0;i>stmt.getFetchSize();i++)
						{
							try {
								ElectroDev[i].setDescripcion(rta.getNString("descripcion"));
								ElectroDev[i].setColor(rta.getNString("color_elect"));							
								ElectroDev[i].consumoEnergetico = (char)rta.getObject("consumo_elect");
								ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
								ElectroDev[i].setPreciobase(rta.getFloat("precio_elect"));
								ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
								ElectroDev[i].setPulgadas(rta.getInt("Resol_tele"));
								ElectroDev[i].setSintonizadorTDT(rta.getBoolean("Sintoniz_tele"));
								rta.next();
								} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return ElectroDev;
		
		}
	
}
