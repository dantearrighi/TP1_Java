package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



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
		String SQLCons= "DELETE FROM Electrodomesticos where ?=id_electro";
		try {
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, pIdElec);
		int rta = stmt.executeUpdate();
		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	public int UpdateElect (Lavarropas Lavarr)
	{
		String SQLCons= "UPDATE Electrodomestico SET descripcion=? ,color_elect=?, consumo_elect=?, precio_elect=?, peso_elect=?, carga_lava=? WHERE id_electro=?";
		try{
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setString(2, Lavarr.getColor());
			stmt.setObject(3, Lavarr.getConsumoEnergetico(),java.sql.Types.CHAR);
			stmt.setFloat(4, Lavarr.getPreciobase());
			stmt.setFloat(5, Lavarr.getPeso());
			stmt.setFloat(6, Lavarr.getCarga());
			stmt.setString(1, Lavarr.getDescripcion());
			stmt.setInt(7, Lavarr.getIdElect());
			int rta = stmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Statement.RETURN_GENERATED_KEYS;
	}
	public ArrayList<Lavarropas> GetAllLava()
	{
		ArrayList<Lavarropas> ElectroDevArray = new ArrayList<Lavarropas>();
		try {
			
		
		String SQLCons= "Select id_electro, descripcion, color_elect, consumo_elect, peso_elect, carga_lava, precio_elect FROM Electrodomestico WHERE carga_lava is not null ORDER BY descripcion";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		ResultSet rta = stmt.executeQuery();
	
				 	while(rta.next())
					{			Lavarropas ElectroDev = new Lavarropas();
								ElectroDev.setDescripcion(rta.getString("descripcion"));
								ElectroDev.setColor(rta.getString("color_elect"));							
								ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
								ElectroDev.setIdElect(rta.getInt("id_electro")); 
								ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
								ElectroDev.setPeso(rta.getFloat("peso_elect"));
								ElectroDev.setCarga(rta.getFloat("carga_lava"));
					ElectroDevArray.add(ElectroDev);
								rta.next();
					}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return ElectroDevArray;
			
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

	public ArrayList<Lavarropas> GetXConsumoLava (char pConsumo)
	{
		
		ArrayList<Lavarropas> ElectroDevArray = new ArrayList<Lavarropas>();
		try {
			
		
		String SQLCons= "Select * FROM Electrodomestico WHERE (carga_lava is not null AND consumo_elect="+pConsumo+"ORDER BY descripcion";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1, Character.toString(pConsumo));
		ResultSet rta = stmt.executeQuery();
	
				 	while(rta.next())
					{			Lavarropas ElectroDev = new Lavarropas();
								ElectroDev.setDescripcion(rta.getNString("descripcion"));
								ElectroDev.setColor(rta.getNString("color_elect"));							
								ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
								ElectroDev.setIdElect(rta.getInt("id_electro")); 
								ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
								ElectroDev.setPeso(rta.getFloat("peso_elect"));
								ElectroDev.setCarga(rta.getFloat("carga_lava"));
					ElectroDevArray.add(ElectroDev);
								rta.next();
					}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return ElectroDevArray;
	}
	public ArrayList<Lavarropas> GetXPreciosLava(float pMin, float pMax)
					{
		
		ArrayList<Lavarropas> ElectroDevArray = new ArrayList<Lavarropas>();
					
		try{
		String SQLCons= "Select * FROM Electrodomestico WHERE (precio>=? AND precio<=? AND carga_lava is not null)ORDER BY descripcion";
		
		ConexionBD conecta = new ConexionBD();
		
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setFloat(1, pMin);
		stmt.setFloat(2, pMax);
		ResultSet rta = stmt.executeQuery();
	
				 	while(rta.next())
					{		
				 	Lavarropas ElectroDev = new Lavarropas();			
					ElectroDev.setDescripcion(rta.getNString("descripcion"));
					ElectroDev.setColor(rta.getNString("color_elect"));							
					ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
					ElectroDev.setIdElect(rta.getInt("id_electro")); 
					ElectroDev.setPreciobase(rta.getFloat("precoio_elect"));
					ElectroDev.setPeso(rta.getFloat("peso_elect"));
					ElectroDev.setCarga(rta.getFloat("carga_lava"));
					}
											} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					return ElectroDevArray;
					}
					
						
					
	public ArrayList<Lavarropas> GetxPrecioYConsumoLava(float pMin, float pMax, char pConsumo)
		{
		
		ArrayList<Lavarropas> ElectroDevArray = new ArrayList<Lavarropas>();
		
		try{
		String SQLCons= "Select * FROM Electrodomestico WHERE (precio>=? AND precio<=? AND consumo_elect=? AND carga_lava is not null)ORDER BY descripcion";
		
		ConexionBD conecta = new ConexionBD();
		
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setFloat(1, pMin);
		stmt.setFloat(2, pMax);
		stmt.setString(3, Character.toString(pConsumo));
		ResultSet rta = stmt.executeQuery();
	
				 	while(rta.next())
					{		
				 	Lavarropas ElectroDev = new Lavarropas();			
					ElectroDev.setDescripcion(rta.getNString("descripcion"));
					ElectroDev.setColor(rta.getNString("color_elect"));							
					ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
					ElectroDev.setIdElect(rta.getInt("id_electro")); 
					ElectroDev.setPreciobase(rta.getFloat("precoio_elect"));
					ElectroDev.setPeso(rta.getFloat("peso_elect"));
					ElectroDev.setCarga(rta.getFloat("carga_lava"));
					}
											} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					return ElectroDevArray;
					}	
}
