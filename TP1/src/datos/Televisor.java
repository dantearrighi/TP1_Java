package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Televisor extends Electrodomestico {

	public boolean sintonizadorTDT;
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
	public ArrayList<Televisor> GetAllTele()
	{
		
		ArrayList<Televisor> ElectroDevArray = new ArrayList<Televisor>();
		try {
			
			
			String SQLCons= "Select id_electro, descripcion, color_elect, consumo_elect, peso_elect, Resol_tele, Sintoniz_tele, precio_elect FROM Electrodomestico WHERE Resol_tele is not null ORDER BY descripcion";
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			ResultSet rta = stmt.executeQuery();
		
					 	while(rta.next())
						{			Televisor ElectroDev = new Televisor();
									ElectroDev.setDescripcion(rta.getString("descripcion"));
									ElectroDev.setColor(rta.getString("color_elect"));							
									ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
									ElectroDev.setIdElect(rta.getInt("id_electro")); 
									ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
									ElectroDev.setPeso(rta.getFloat("peso_elect"));
									ElectroDev.setPulgadas(rta.getInt("Resol_tele"));
									ElectroDev.setSintonizadorTDT(rta.getBoolean("Sintoniz_tele"));
						ElectroDevArray.add(ElectroDev);
									rta.next();
						}
								
								} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						return ElectroDevArray;}
	
	
	public Televisor GetOne(int pId)
	{
		Televisor ElectroDev = new Televisor();
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
						
						ElectroDev.setColor(rta.getString("color_elect"));
						ElectroDev.setDescripcion(rta.getString("descripcion"));
						ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
						ElectroDev.setIdElect(rta.getInt("id_electro"));
						ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
						ElectroDev.setPeso(rta.getFloat("peso_elect"));
						ElectroDev.setSintonizadorTDT(rta.getBoolean("Sintoniz_tele"));
						ElectroDev.setPulgadas(rta.getInt("Resol_tele"));
		}
						rta.close();
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
								}
		
		return ElectroDev;		
	}

	public ArrayList<Televisor> GetXConsumoTele (char pConsumo)
	{
		ArrayList<Televisor> ElectroDevArray = new ArrayList<Televisor>();
		try {
			
			
			String SQLCons= "Select * FROM Electrodomestico WHERE (carga_lava is not null AND consumo_elect="+pConsumo+"ORDER BY descripcion";
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setString(1, Character.toString(pConsumo));
			ResultSet rta = stmt.executeQuery();
		
					 	while(rta.next())
						{			Televisor ElectroDev = new Televisor();
									ElectroDev.setDescripcion(rta.getNString("descripcion"));
									ElectroDev.setColor(rta.getNString("color_elect"));							
									ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
									ElectroDev.setIdElect(rta.getInt("id_electro")); 
									ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
									ElectroDev.setPeso(rta.getFloat("peso_elect"));
									ElectroDev.setPulgadas(rta.getInt("Resol_tele"));
									ElectroDev.setSintonizadorTDT(rta.getBoolean("Sintoniz_tele"));
						ElectroDevArray.add(ElectroDev);
									rta.next();
						}
								
								} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						return ElectroDevArray;}
				
		
	
	public ArrayList<Televisor> GetXPreciosTele(float pMin, float pMax)
					{
					
					ArrayList<Televisor> ElectroDevArray = new ArrayList<Televisor>();
					try {
					String SQLCons= "Select * FROM Electrodomestico WHERE (precio>=? AND precio<=? AND Resol_tele is not null)ORDER BY descripcion";
					ConexionBD conecta = new ConexionBD();
					conecta.OpenConection();
					PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
					stmt.setFloat(1, pMin);
					stmt.setFloat(2, pMax);
					ResultSet rta = stmt.executeQuery();
					
					while(rta.next())
					{
						Televisor ElectroDev = new Televisor();
											ElectroDev.setDescripcion(rta.getNString("descripcion"));
											ElectroDev.setColor(rta.getNString("color_elect"));							
											ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
											ElectroDev.setIdElect(rta.getInt("id_electro")); 
											ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
											ElectroDev.setPeso(rta.getFloat("peso_elect"));
											ElectroDev.setPulgadas(rta.getInt("Resol_tele"));
											ElectroDev.setSintonizadorTDT(rta.getBoolean("Sintoniz_tele"));
											ElectroDevArray.add(ElectroDev);
						}
											} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
								return ElectroDevArray;	}
							
					

					
						
					
	public ArrayList<Televisor> GetxPrecioYConsumoTele(float pMin, float pMax, char pConsumo)
		{
		
		ArrayList<Televisor> ElectroDevArray = new ArrayList<Televisor>();
		try {
		String SQLCons= "Select * FROM Electrodomestico WHERE (precio>=? AND precio<=? AND consumo_elect=? AND Resol_tele is not null)ORDER BY descripcion";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setFloat(1, pMin);
		stmt.setFloat(2, pMax);
		stmt.setString(3, Character.toString(pConsumo));
		ResultSet rta = stmt.executeQuery();
		
		while(rta.next())
		{
			Televisor ElectroDev = new Televisor();
								ElectroDev.setDescripcion(rta.getNString("descripcion"));
								ElectroDev.setColor(rta.getNString("color_elect"));							
								ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
								ElectroDev.setIdElect(rta.getInt("id_electro")); 
								ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
								ElectroDev.setPeso(rta.getFloat("peso_elect"));
								ElectroDev.setPulgadas(rta.getInt("Resol_tele"));
								ElectroDev.setSintonizadorTDT(rta.getBoolean("Sintoniz_tele"));
								ElectroDevArray.add(ElectroDev);
			}
								} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					return ElectroDevArray;	}
}
