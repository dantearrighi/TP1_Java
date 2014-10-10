package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import datos.Electrodomestico.consumo;

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
	public Lavarropas(float pPrecio, float pPeso, consumo pConsumo, String pColor, float pCarga)
	{
		this();
		this.setPreciobase(pPrecio);
		this.setCarga(pCarga);
		this.setColor(pColor);
		this.setConsumoEnergetico(pConsumo);
		this.setPeso(pPeso);
				
	}

	public int AddLavarrop(float pPrecio,float pPeso, String pColor, consumo pConsumo, float pCarga)
	{
		String SQLCons= "INSERT INTO Electrodomesticos (color_elect, consumo_elect, peso_elect ,precio_elect, carga_lava) VALUES ("+ pColor +","+ pConsumo + "," + pPeso+ "," + pPrecio+","+pCarga;
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
		String SQLCons= "UPDATE Electrodomesticos SET (color_elect="+Lavarr.getColor()+", consumo_elect="+Lavarr.getConsumoEnergetico()+", precio_elect="+Lavarr.getPreciobase()+", peso_elect="+Lavarr.getPeso()+ ", carga_lava="+Lavarr.getCarga()+") WHERE"+Lavarr.getIdElect()+"=Electrodomesticos.id_electro";
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
				try {
					 ResultSet rta = stmt.executeQuery(SQLCons);
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					for (i=0;i>stmt.getFetchSize();i++)
						{
							try {
								ElectroDev[i].setColor(stmt.executeQuery(SQLCons).getNString("color_elect")); 
								ElectroDev[i].setConsumoEnergetico((Electrodomestico.consumo)stmt.executeQuery(SQLCons).getObject("consumo_elect"));
								ElectroDev[i].setIdElect(stmt.executeQuery(SQLCons).getInt("id_electro")); 
								ElectroDev[i].setPreciobase(stmt.executeQuery(SQLCons).getFloat("precio_elect"));
								ElectroDev[i].setPeso(stmt.executeQuery(SQLCons).getFloat("peso_elect"));
								ElectroDev[i].setCarga(stmt.executeQuery(SQLCons).getFloat("carga_lava"));
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
		Lavarropas ElectroDev = null;
		
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
				try {
					 ResultSet rta = stmt.executeQuery(SQLCons);
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
						ElectroDev.setColor(stmt.executeQuery(SQLCons).getNString("color_elect"));
						ElectroDev.setConsumoEnergetico((Electrodomestico.consumo)stmt.executeQuery(SQLCons).getObject("consumo_elect"));
						ElectroDev.setIdElect(stmt.executeQuery(SQLCons).getInt("id_electro"));
						ElectroDev.setPreciobase(stmt.executeQuery(SQLCons).getFloat("precio_elect"));
						ElectroDev.setPeso(stmt.executeQuery(SQLCons).getFloat("peso_elect"));
						ElectroDev.setCarga(stmt.executeQuery(SQLCons).getFloat("carga_lava"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
								}
		return ElectroDev;		
	}

	
}
