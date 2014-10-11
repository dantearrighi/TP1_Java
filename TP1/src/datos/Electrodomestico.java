package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Electrodomestico {
	/*Attributes of the laundry machine*/
	private float preciobase;
	private String color ;
	protected consumo consumoEnergetico ;
	private float peso; 
	public enum consumo {A,B,C,D,E,F}; 
	private int IdElect;
	private String descripcion;
	
	private static String colorDefault = "BLANCO";
	private static float precioDefault = 10;
	private static float pesoDefault= 5;
	private static consumo consumoDefault = consumo.F;
	
	
	
	/*Fin variables*/

	public float getPreciobase() {
		return preciobase;
	}
	public void setPreciobase(float preciobase) {
		this.preciobase = preciobase;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public consumo getConsumoEnergetico() {
		return consumoEnergetico;
	}
	public void setConsumoEnergetico(consumo consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	/*Default constructor*/
	public Electrodomestico()
	{
		this.setColor(colorDefault);
		this.setConsumoEnergetico(consumoDefault);
		this.setPeso(pesoDefault);
		this.setPreciobase(precioDefault);
		this.setDescripcion(descripcion);
	}
	public int getIdElect() {
		return IdElect;
	}
	public void setIdElect(int idElect) {
		IdElect = idElect;
	}
	/* Constructor whit price y weight*/
	public Electrodomestico(float pPrecio, float pPeso)	
	{
	this();
	this.setPreciobase(pPrecio);
	this.setPeso(pPeso);
	}
	
	/*Constructor all attributes*/
	public Electrodomestico(float pPrecio, float pPeso,String pColor, consumo pConsumo, String pDescripcion)
	{	this();
		this.setDescripcion(pDescripcion);
		this.setColor(pColor);
		this.setConsumoEnergetico(pConsumo);
		this.setPeso(pPeso);
		this.setPreciobase(pPrecio);
	}

	
	/*SQL Region*/
public int AddElectro(float pPrecio,float pPeso, String pColor, consumo pConsumo, String pDescripcion)
{
	String SQLCons= "INSERT INTO Electrodomesticos (descripcion, color_elect, consumo_elect, peso_elect ,precio_elect) VALUES ("+pDescripcion+","+ pColor +","+ pConsumo + "," + pPeso+ "," + pPrecio;
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
public void DeleteElectro(int pIdElec)
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
public int UpdateElect (Electrodomestico Electro)
{
	String SQLCons= "UPDATE Electrodomesticos SET (color_elect="+Electro.getColor()+", descripcion="+Electro.getDescripcion()+", consumo_elect="+Electro.getConsumoEnergetico()+", precio_elect="+Electro.getPreciobase()+", peso_elect="+Electro.getPeso()+ ") WHERE"+Electro.getIdElect()+"=Electrodomesticos.id_electro";
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
public Electrodomestico[] GetAll()
{
	Electrodomestico[] ElectroDev = null;
	int i;
	String SQLCons= "Select * FROM Electrodomestico";
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
							ElectroDev[i].consumoEnergetico = (Electrodomestico.consumo)rta.getObject("consumo_elect");
							ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
							ElectroDev[i].setPreciobase(rta.getFloat("precoio_elect"));
							ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
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
public Electrodomestico GetOne(int pId)
{
	Electrodomestico ElectroDev = null;
	
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
			try {
				 	ResultSet rta = stmt.executeQuery(SQLCons);
					ElectroDev.setDescripcion(rta.getNString("descripcion"));
				    ElectroDev.setColor(rta.getNString("color_elect"));
					ElectroDev.setConsumoEnergetico((Electrodomestico.consumo)rta.getObject("consumo_elect"));
					ElectroDev.setIdElect(rta.getInt("id_electro"));
					ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
					ElectroDev.setPeso(rta.getFloat("peso_elect"));
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
							}
	return ElectroDev;		
}
public Electrodomestico[] GetxConsumo (consumo pConsumo)
{
	Electrodomestico[] ElectroDev = null;
	int i;
	String SQLCons= "Select * FROM Electrodomestico WHERE consumo_elect="+pConsumo+"ORDER BY descripcion";
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
							ElectroDev[i].consumoEnergetico = (Electrodomestico.consumo)rta.getObject("consumo_elect");
							ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
							ElectroDev[i].setPreciobase(rta.getFloat("precoio_elect"));
							ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
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
public Electrodomestico[] GetxPrecios(float pMin, float pMax)
				{Electrodomestico[] ElectroDev = null;
				int i;
				String SQLCons= "Select * FROM Electrodomestico WHERE (precio>="+pMin+"AND precio<="+pMax+")ORDER BY descripcion";
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
										ElectroDev[i].consumoEnergetico = (Electrodomestico.consumo)rta.getObject("consumo_elect");
										ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
										ElectroDev[i].setPreciobase(rta.getFloat("precoio_elect"));
										ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
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
public Electrodomestico[] GetxPrecioYConsumo(float pMin, float pMax, consumo pConsumo)
	{
	Electrodomestico[] ElectroDev = null;
	int i;
	String SQLCons= "Select * FROM Electrodomestico WHERE (precio>="+pMin+"AND precio<="+pMax+"AND consumo_elect="+pConsumo+")ORDER BY descripcion";
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
							ElectroDev[i].consumoEnergetico = (Electrodomestico.consumo)rta.getObject("consumo_elect");
							ElectroDev[i].setIdElect(rta.getInt("id_electro")); 
							ElectroDev[i].setPreciobase(rta.getFloat("precoio_elect"));
							ElectroDev[i].setPeso(rta.getFloat("peso_elect"));
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

	
	
	
	