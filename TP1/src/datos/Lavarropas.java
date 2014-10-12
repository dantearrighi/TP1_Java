package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Lavarropas extends Electrodomestico
{
	//Variables
	private float carga;
	private static float cargaDefault =5;

	//Get Set CARGA
	public float getCarga() {
		return carga;
	}

	public void setCarga(float carga) {
		this.carga = carga;
	}
	
	//Constructor 1
	public Lavarropas()
	{
		super();
		carga=cargaDefault;
	}
	
	//Constructor 2
	public Lavarropas(float pPrecio, float pPeso)
	{
		this();
		this.setPreciobase(pPrecio);
		this.setPeso(pPeso);
	}
	
	//Constructor 3
	public Lavarropas(float pPrecio, float pPeso, char pConsumo, String pColor,  float pCarga, String pDescripcion)
	{
		this();
		this.setDescripcion(pDescripcion);
		this.setPreciobase(pPrecio);
		this.setCarga(pCarga);
		this.setColor(pColor);
		this.setConsumoEnergetico(pConsumo);
		this.setPeso(pPeso);
				
	}

	public int AddLavarrop(float pPrecio,float pPeso, String pColor, char pConsumo, float pCarga,String pDescripcion)
	{
		try{
			
		String SQLCons= "INSERT INTO Electrodomestico (descripcion, color_elect, consumo_elect, peso_elect ,precio_elect, carga_lava) VALUES (?,?,?,?,?,?)";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1,pDescripcion);
		stmt.setString(2, pColor);
		stmt.setFloat(5, pPrecio);
		stmt.setFloat(4, pPeso);
		stmt.setObject(3, pConsumo,java.sql.Types.CHAR);
		stmt.setFloat(6, pCarga);

			stmt.execute(); 
			conecta.CloseConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Statement.RETURN_GENERATED_KEYS;
	}
	public void DeleteLavarrop(int pIdElec)
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
	public int UpdateElect (Lavarropas Lavarr)
	{
		String SQLCons= "UPDATE Electrodomesticos SET ( descripcion="+Lavarr.getDescripcion()+",color_elect="+Lavarr.getColor()+", consumo_elect="+Lavarr.getConsumoEnergetico()+", precio_elect="+Lavarr.getPreciobase()+", peso_elect="+Lavarr.getPeso()+ ", carga_lava="+Lavarr.getCarga()+") WHERE"+Lavarr.getIdElect()+"=Electrodomesticos.id_electro";
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
	public Lavarropas[] GetAll()
	{
		Lavarropas[] ElectroDev = null;
		int i;
		String SQLCons= "Select * FROM Electrodomestico WHERE carga_lava is not null";
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
				try {
					ResultSet rta = stmt.executeQuery(SQLCons);
					for (i=0;i>stmt.getFetchSize();i++)
						{
							try {
								ElectroDev[i].setDescripcion(rta.getNString("descripcion"));
								ElectroDev[i].setColor(rta.getNString("color_elect")); 
								ElectroDev[i].setConsumoEnergetico((char)rta.getObject("consumo_elect"));
								ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
								ElectroDev[i].setPreciobase(rta.getFloat("precio_elect"));
								ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
								ElectroDev[i].setCarga(rta.getFloat("carga_lava"));
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
	public Lavarropas GetOne(int pId)
	{
		Lavarropas ElectroDev = new Lavarropas();
		try
		{
		String SQLCons= "SELECT * FROM Electrodomestico WHERE id_electro=?";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, pId);
		
						ResultSet rta = stmt.executeQuery();
						while(rta.next())
						{
						ElectroDev.setDescripcion(rta.getString("descripcion"));
						ElectroDev.setColor(rta.getString("color_elect"));
						ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
						ElectroDev.setIdElect(rta.getInt("id_electro"));
						ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
						ElectroDev.setPeso(rta.getFloat("peso_elect"));
						ElectroDev.setCarga(rta.getFloat("carga_lava"));
						}
						rta.close();
						stmt.close();
						/*rta.next();*/ /*Es un solo elemento*/
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
								}
		return ElectroDev;		
	}

	public Lavarropas[] GetxConsumo (char pConsumo)
	{
		Lavarropas[] ElectroDev = null;
		int i;
		String SQLCons= "Select * FROM Electrodomestico WHERE (carga_lava is not null AND consumo_elect="+pConsumo+"ORDER BY descripcion";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		Statement stmt = null;
				try {
					stmt = conecta.Cone.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				 * try {
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
								ElectroDev[i].setCarga(stmt.executeQuery(SQLCons).getFloat("carga_lava"));
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
	public Lavarropas[] GetxPrecios(float pMin, float pMax)
					{Lavarropas[] ElectroDev = null;
					int i;
					String SQLCons= "Select * FROM Electrodomestico WHERE (precio>="+pMin+"AND precio<="+pMax+"AND carga_lava is not null)ORDER BY descripcion";
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
							try {
								 ResultSet rta = stmt.executeQuery(SQLCons);
								for (i=0;i>stmt.getFetchSize();i++)
									{
										try {
											ElectroDev[i].setDescripcion(rta.getNString("descripcion"));
											ElectroDev[i].setColor(rta.getNString("color_elect"));							
											ElectroDev[i].consumoEnergetico = (char)rta.getObject("consumo_elect");
											ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
											ElectroDev[i].setPreciobase(rta.getFloat("precoio_elect"));
											ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
											ElectroDev[i].setCarga(rta.getFloat("carga_lava"));
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
	public Lavarropas[] GetxPrecioYConsumo(float pMin, float pMax, char pConsumo)
		{
		Lavarropas[] ElectroDev = null;
		int i;
		String SQLCons= "Select * FROM Electrodomestico WHERE (precio>="+pMin+"AND precio<="+pMax+"AND consumo_elect="+pConsumo+"AND carga_lava is not null)ORDER BY descripcion";
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
				try {
					 ResultSet rta = stmt.executeQuery(SQLCons);
					for (i=0;i>stmt.getFetchSize();i++)
						{
							try {
								ElectroDev[i].setDescripcion(rta.getNString("descripcion"));
								ElectroDev[i].setColor(rta.getNString("color_elect"));							
								ElectroDev[i].consumoEnergetico = (char)rta.getObject("consumo_elect");
								ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
								ElectroDev[i].setPreciobase(rta.getFloat("precoio_elect"));
								ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
								ElectroDev[i].setCarga(rta.getFloat("carga_lava"));
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
