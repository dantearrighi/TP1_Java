package interfaz;

import datos.Electrodomestico;
import datos.Lavarropas;
import datos.Televisor;
import negocio.ElectrodomesticoNegocio;
import negocio.LavarropasNegocio;
import negocio.TelevisorNegocio;


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
}

