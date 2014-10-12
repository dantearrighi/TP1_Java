package interfaz;

import negocio.ElectrodomesticoNegocio;
import negocio.LavarropasNegocio;


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
		
	}

}

