package interfaz;

import datos.Electrodomestico;
import datos.Lavarropas;
import datos.Televisor;
import negocio.ElectrodomesticoNegocio;
import negocio.LavarropasNegocio;
import negocio.TelevisorNegocio;
import java.util.*;

 public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			
	}
	
	/*Deberia devolver un int para el ID*/
	public void NuevoElectro(float pPrecio,float pPeso, String pColor, char pConsumo, String pDescripcion)
	{
			ElectrodomesticoNegocio ElectroNew = new ElectrodomesticoNegocio();
		ElectroNew.AddElectro(pPrecio, pPeso, pColor, pConsumo, pDescripcion);
		
	}
	/*Deberia devolver un int para el ID*/
	public void NuevoLavarr(float pPrecio,float pPeso, String pColor, char pConsumo, String pDescripcion, float pCarga)
	{
		LavarropasNegocio LavarNew = new LavarropasNegocio();
		LavarNew.AddLavarropa(pPrecio, pPeso, pColor, pConsumo, pDescripcion, pCarga);
	}
	/*Deberia devolver un int para el ID*/
	public void NuevoTele(float pPrecio,float pPeso, String pColor, char pConsumo, String pDescripcion, int pResolucion, boolean pSintoniz)
	{
		TelevisorNegocio TeleNew = new TelevisorNegocio();
		TeleNew.AddTelevisor(pPrecio, pPeso, pColor, pConsumo, pDescripcion, pResolucion, pSintoniz);
	}

	public int elegirElectroaMostrar(int idElec)
	{
		TelevisorNegocio Telev = new TelevisorNegocio();
		LavarropasNegocio Lava = new LavarropasNegocio();
		int op;
		boolean rta1 = Telev.isTele(idElec);
		boolean rta2 = Lava.isLava(idElec);
		
		if(rta1 == true)
		{
			op=1;
			return op; 
		}
		else if(rta2 == true)
		{
			op=2;
			return op;
		}
		else
		{
			op=0;
			return op;
		}
	}

	public Electrodomestico mostrarElectro(int idElec)
	{
		Electrodomestico Electro = new Electrodomestico();
		ElectrodomesticoNegocio ElectroNeg = new ElectrodomesticoNegocio();
		Electro = ElectroNeg.getOne(idElec);
		return Electro;
	}
	
	public Lavarropas mostrarLava(int idElec)
	{
		Lavarropas Electro = new Lavarropas();
		LavarropasNegocio ElectroNeg = new LavarropasNegocio();
		Electro = ElectroNeg.getOne(idElec);
		return Electro;
	}
	
	public Televisor mostrarelectro(int idElec)
	{
		Televisor Electro = new Televisor();
		TelevisorNegocio ElectroNeg = new TelevisorNegocio();
		Electro = ElectroNeg.getOne(idElec);
		return Electro;
	}

	public ArrayList<Electrodomestico> GetAllEl()
	 {
		 ArrayList<Electrodomestico> Electro = new ArrayList<Electrodomestico>();
		 ElectrodomesticoNegocio ElecNeg = new ElectrodomesticoNegocio();
		 Electro=ElecNeg.GetAllEl();
		 	 
		 return Electro;
	 }
	 public ArrayList<Televisor> GetAllTe()
	 {
		 ArrayList<Televisor> Electro = new ArrayList<Televisor>();
		 TelevisorNegocio TelNeg = new TelevisorNegocio();
		 Electro=TelNeg.GetAllTe();
		 	 
		 return Electro;
	 }
		 public ArrayList<Lavarropas> GetAllLa()
		 {
			 ArrayList<Lavarropas> Electro = new ArrayList<Lavarropas>();
			 LavarropasNegocio LavaNeg = new LavarropasNegocio();
			 Electro=LavaNeg.GetAllLa();
			 	 
			 return Electro;
		 }
	
	
	 public ArrayList<Electrodomestico> ElectxConsumo(char pConsumo)
	 {
		 ArrayList<Electrodomestico> Electro = new ArrayList<Electrodomestico>();
		 ElectrodomesticoNegocio ElecNeg = new ElectrodomesticoNegocio();
		 Electro=ElecNeg.GetxConsumo(pConsumo);
		 	 
		 return Electro;
	 }
	 public ArrayList<Televisor> ElectxConsumoTele(char pConsumo)
	 {
		 ArrayList<Televisor> Electro = new ArrayList<Televisor>();
		 TelevisorNegocio TelNeg = new TelevisorNegocio();
		 Electro=TelNeg.GetXConsumoTele(pConsumo);
		 	 
		 return Electro;
	 }
		 public ArrayList<Lavarropas> ElectxConsumoLava(char pConsumo)
		 {
			 ArrayList<Lavarropas> Electro = new ArrayList<Lavarropas>();
			 LavarropasNegocio LavaNeg = new LavarropasNegocio();
			 Electro=LavaNeg.GetXConsumoLava(pConsumo);
			 	 
			 return Electro;
		 }
		 
		 public ArrayList<Electrodomestico> ElectxPrecio(float pMin, float pMax)
		 {
			 ArrayList<Electrodomestico> Electro = new ArrayList<Electrodomestico>();
			 ElectrodomesticoNegocio ElecNeg = new ElectrodomesticoNegocio();
			 Electro=ElecNeg.GetxPrecios(pMin, pMax);
			 	 
			 return Electro;
		 }
		 public ArrayList<Televisor> ElectxPrecioTele(float pMin, float pMax)
		 {
			 ArrayList<Televisor> Electro = new ArrayList<Televisor>();
			 TelevisorNegocio TelNeg = new TelevisorNegocio();
			 Electro=TelNeg.GetxPreciosTele(pMin, pMax);
			 	 
			 return Electro;
		 }
		 public ArrayList<Lavarropas> ElectxPrecioLava(float pMin, float pMax)
		 {
			 ArrayList<Lavarropas> Electro = new ArrayList<Lavarropas>();
			 LavarropasNegocio LavaNeg = new LavarropasNegocio();
			 Electro=LavaNeg.GetxPreciosLava(pMin, pMax);
			 	 
			 return Electro;
		 }
		 
		 public ArrayList<Electrodomestico> ElectxPrecioyConsumo(float pMin, float pMax, char pConsumo)
		 {
			 ArrayList<Electrodomestico> Electro = new ArrayList<Electrodomestico>();
			 ElectrodomesticoNegocio ElecNeg = new ElectrodomesticoNegocio();
			 Electro=ElecNeg.GetxConsumoyPrec(pMin, pMax, pConsumo);
			 	 
			 return Electro;
		 }
		 public ArrayList<Televisor> ElectxPrecioTele(float pMin, float pMax, char pConsumo)
		 {
			 ArrayList<Televisor> Electro = new ArrayList<Televisor>();
			 TelevisorNegocio TelNeg = new TelevisorNegocio();
			 Electro=TelNeg.GetxConsumoyPrecTele(pMin, pMax, pConsumo);
			 	 
			 return Electro;
		 }
		 public ArrayList<Lavarropas> ElectxPrecioLava(float pMin, float pMax, char pConsumo)
		 {
			 ArrayList<Lavarropas> Electro = new ArrayList<Lavarropas>();
			 LavarropasNegocio LavaNeg = new LavarropasNegocio();
			 Electro=LavaNeg.GetxConsumoyPrecLava(pMin, pMax, pConsumo);
			 	 
			 return Electro;
		 }
		 
		 public int ConsultaElec(boolean elect, boolean lava, boolean tele, boolean precio, boolean consumo)
		 {
			 int rta=0;
			 if(Boolean.compare(lava, true)==0)
			 {
				 if(Boolean.compare(precio, true)==0)
				 {
					 rta=11;/* Indica Consulta de Lavarropa por rango de precios*/
					 if(Boolean.compare(consumo, true)==0)
					 {
						 rta=12;/*Consulta Lava x precio y Consumo*/
					 }
				 }
				 else if(Boolean.compare(consumo, true)==0)
				 {
					 rta=10;/* Indica Consulta de Lavarropa por consumo*/
				 }
				 else
				 {
					 rta=9;/* Indica Consulta de Lavarropa*/
				 }
			 }
			 else if(Boolean.compare(tele, true)==0)
			 {
				 if(Boolean.compare(precio, true)==0)
				 {
					 rta=7;/* Indica Consulta de Televisor por rango de precios*/
					 if(Boolean.compare(consumo, true)==0)
					 {
						 rta=8; /*Consulta tele por precio y consumo*/
					 }
				 }
				 else if(Boolean.compare(consumo, true)==0)
				 {
					 rta=6;/* Indica Consulta de Televisor por consumo*/
				 }
				 else
				 {
					 rta=5;/* Indica Consulta de Televisor*/
				 }
			 }
			 else
			 {
				 if(Boolean.compare(precio, true)==0)
				 {
					 rta=3;/* Indica Consulta de Electro por rango de precios*/
					 if(Boolean.compare(consumo, true)==0)
					 {
						 rta=4;/*Consulta electro por precio y consumo*/
					 }
				 }
				 else if(Boolean.compare(consumo, true)==0)
				 {
					 rta=2;/* Indica Consulta de Electro por consumo*/
				 }
				 else
				 {
					 rta=1;/* Indica Consulta de Electro*/
				 }
			 }
			 return rta;
				 
		 }
 
 

}