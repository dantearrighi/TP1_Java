package negocio;

import datos.Electrodomestico;
import datos.Lavarropas;

import datos.Televisor;

public class TelevisorNegocio extends ElectrodomesticoNegocio{

	protected float precioFinal(char pConsumo, float pPeso, float pPrecioBase, int pPulgadas, boolean pSintoniz)
	{
		float precFinal = super.precioFinal(pConsumo, pPeso, pPrecioBase);
				if(pPulgadas>40)
				{
					precFinal= precFinal*(13/10);
					
				}
				
				if(pSintoniz==true)
				{
					precFinal+=50;	
				}
	return precFinal;
	}
	
	public int AddTelevisor(float pPrecio,float pPeso, String pColor, char pConsumo, String pDescripcion, int pResolucion, boolean pSintoniz)
	{
			
		TelevisorNegocio TeleNeg = new TelevisorNegocio();

		 String pColorOK = TeleNeg.comprobarColor(pColor);
		 char pConsumoOK = TeleNeg.comprobarConsumoEnergetico((char)pConsumo);
		 float pPrecioOK = TeleNeg.precioFinal(pConsumo, pPeso, pPrecio);
		 
		 datos.Televisor ElectroDat = new datos.Televisor();
		 int iDElectro = ElectroDat.AddTelev(pPrecioOK, pPeso, pColorOK, pConsumoOK, pSintoniz, pResolucion, pDescripcion);
		 
		 return iDElectro;
		
	}

	public void DeleteTelev(int idElectro)
	{
		Televisor ElectroData = new Televisor();
		
		ElectroData.DeleteTelev(idElectro);
		
	}

	public Televisor UpdateElectro(int idTv, float pPrecio, float pPeso, String pColor, char pConsumo, int pResolucion, boolean pSintoniz, String pDescripcion)
	{
		String pColorOk = this.comprobarColor(pColor);
		char pConsumoOk = this.comprobarConsumoEnergetico(pConsumo);
		float pPrecioOk = this.precioFinal(pConsumo, pPeso, pPrecio);
		Televisor ElectroDat = new Televisor(pPrecioOk, pPeso, pConsumoOk, pColorOk, pSintoniz, pResolucion);
		ElectroDat.setIdElect(idTv);
		return ElectroDat;
	}
	
	public datos.Televisor[] GetxConsumo(char cConsumo)
	{

	datos.Televisor ElectroDat = new Televisor();
	Televisor [] AllElectroDat = null;
	AllElectroDat = ElectroDat.GetxConsumo(cConsumo);
	
	return AllElectroDat;
	
	}

	public Televisor[] GetxPrecios(float pMin, float pMax)
{

	Televisor ElectroDat = new Televisor();
	Televisor [] AllElectroDat = null;
	AllElectroDat = ElectroDat.GetxPrecios(pMin, pMax);
	
	return AllElectroDat;

}
	
	public Televisor[] GetxConsumoyPrec(float pMin, float pMax, char cConsumo)
{

	Televisor ElectroDat = new Televisor();
	Televisor [] AllElectroDat = null;
	AllElectroDat = ElectroDat.GetxPrecioYConsumo(pMin, pMax, cConsumo);
	
	return AllElectroDat;

}
}
