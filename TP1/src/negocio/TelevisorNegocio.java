package negocio;

import java.util.ArrayList;

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
	
	public Televisor getOne(int idElectro)
	{
		Televisor ElectroDev = new Televisor();
		ElectroDev = ElectroDev.GetOne(idElectro);
		return ElectroDev;
		
	}

	public boolean isTele (int idElectro)
	{
		Televisor ElectroDev = new Televisor();
		ElectroDev = ElectroDev.GetOne(idElectro);
		if(Integer.compare(ElectroDev.getPulgadas(), 0)==0) {
			return false;
		} else {
			return true;
		}	
		
		
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
	
	public ArrayList<Televisor> GetAllTe()
	{

	Televisor ElectroDat = new Televisor();
	ArrayList<Televisor> AllElectroDat = new ArrayList<Televisor>();
	AllElectroDat = ElectroDat.GetAllTele();
	return AllElectroDat;
	
	}
	
	public ArrayList<Televisor> GetXConsumoTele(char cConsumo)
	{

	Televisor ElectroDat = new Televisor();
	ArrayList<Televisor> AllElectroDat = new ArrayList<Televisor>();
	AllElectroDat = ElectroDat.GetXConsumoTele(cConsumo);
	
	return AllElectroDat;
	
	}

	
	
	public ArrayList<Televisor> GetxPreciosTele(float pMin, float pMax)
{

	Televisor ElectroDat = new Televisor();
	ArrayList<Televisor> AllElectroDat = new ArrayList<Televisor>();
	AllElectroDat = ElectroDat.GetXPreciosTele(pMin, pMax);
	
	return AllElectroDat;

}
	
	public ArrayList<Televisor> GetxConsumoyPrecTele(float pMin, float pMax, char cConsumo)
{

	Televisor ElectroDat = new Televisor();
	ArrayList<Televisor> AllElectroDat = new ArrayList<Televisor>();
	AllElectroDat = ElectroDat.GetxPrecioYConsumoTele(pMin, pMax, cConsumo);
	
	
	return AllElectroDat;

}
}
