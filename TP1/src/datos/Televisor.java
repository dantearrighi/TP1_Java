package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import datos.Electrodomestico.consumo;

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
	public Televisor(float pPrecio, float pPeso, consumo pConsumo, String pColor, boolean pSintonizador, int pPulgadas)
	{
		super();
		this.setColor(pColor);
		this.setConsumoEnergetico(pConsumo);
		this.setPeso(pPeso);
		this.setPreciobase(pPeso);
		this.setPulgadas(pPulgadas);
		this.setSintonizadorTDT(pSintonizador);
		
	}

	public int AddLavarrop(float pPrecio,float pPeso, String pColor, consumo pConsumo, boolean pSintonizador, int pPulgadas)
	{
		String SQLCons= "INSERT INTO Electrodomesticos (color_elect, consumo_elect, peso_elect ,precio_elect, Sintoniz_tele, Resol_tele) VALUES ("+ pColor +","+ pConsumo + "," + pPeso+ "," + pPrecio+","+pSintonizador+","+pPulgadas;
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
	public int UpdateElect (Televisor Telev)
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
								ElectroDev[i].setSintonizadorTDT(stmt.executeQuery(SQLCons).getBoolean("Sintoniz_tele"));
								ElectroDev[i].setPulgadas(stmt.executeQuery(SQLCons).getInt("Resol_tele"));
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
						ElectroDev.setSintonizadorTDT(stmt.executeQuery(SQLCons).getBoolean("Sintoniz_tele"));
						ElectroDev.setPulgadas(stmt.executeQuery(SQLCons).getInt("Resol_tele"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
								}
		return ElectroDev;		
	}

}
