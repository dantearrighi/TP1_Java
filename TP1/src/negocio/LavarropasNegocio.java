package negocio;

import java.util.ArrayList;

import datos.Electrodomestico;
import datos.Lavarropas;
import datos.Televisor;

public class LavarropasNegocio extends ElectrodomesticoNegocio
{
			protected float precioFinal(char pConsumo, float pPeso, float pPrecioBase, float pCarga)
			{
				float PrecFinal = super.precioFinal(pConsumo, pPeso, pPrecioBase);
				
				
				if(30<pCarga)
				{
					PrecFinal+=50;
				}
							
				
				return PrecFinal;
			}
			
			public int AddLavarropa(float pPrecio,float pPeso, String pColor, char pConsumo, String pDescripcion, float pCarga)
			{
					
				LavarropasNegocio Lavarr = new LavarropasNegocio();

				 String pColorOK = Lavarr.comprobarColor(pColor);
				 char pConsumoOK = Lavarr.comprobarConsumoEnergetico((char)pConsumo);
				 float pPrecioOK = Lavarr.precioFinal(pConsumo, pPeso, pPrecio);
				 
								 
				 if(pPrecio==0 && pPeso==0 && pConsumo ==' '  && pColor=="")
				 {
						 
				 datos.Lavarropas ElectroDat = new Lavarropas();
				 int iDElectro = ElectroDat.AddElectro(pPrecioOK, pPeso, pColorOK, pConsumo, pDescripcion);
				 
				 return iDElectro;
				 }else if(pPrecio!=0 && pPeso!=0 && pConsumo ==' '  && pColor=="")
				 {
					 datos.Lavarropas ElectroDat = new Lavarropas(pPrecioOK,pPeso);
					 int iDElectro = ElectroDat.AddElectro(pPrecioOK, pPeso, pColorOK, pConsumoOK, pDescripcion);
					 
					 return iDElectro;}
				 else
				 {
					 datos.Lavarropas ElectroDat = new Lavarropas(pPrecioOK, pPeso, pConsumoOK, pColorOK, pCarga, pDescripcion);
					 int iDElectro = ElectroDat.AddElectro(pPrecioOK, pPeso, pColorOK, pConsumoOK, pDescripcion);
					 
					 return iDElectro;
				 }
				
			}
	
			public void DeleteLavarropa(int idElectro)
			{
				datos.Electrodomestico ElectroData = new Electrodomestico();
				
				ElectroData.DeleteElectro(idElectro);
				
			}

			public Lavarropas getOne(int idElectro)
			{
				Lavarropas ElectroDev = new Lavarropas();
				ElectroDev = ElectroDev.GetOne(idElectro);
				return ElectroDev;
				
			}
			
			public boolean isLava (int idElectro)
			{
				Lavarropas ElectroDev = new Lavarropas();
				ElectroDev = ElectroDev.GetOne(idElectro);
				float carga = 0;
				if(Float.compare(ElectroDev.getCarga(), carga)==0) {
					return false;
				} else {
					return true;
				}	
				
				
			}
			
			public datos.Lavarropas UpdateElectro(int pIdLava, float pPrecio, float pPeso, String pColor, char pConsumo,float pCarga, String pDescripcion)
			{
				String pColorOk = this.comprobarColor(pColor);
				char pConsumoOk = this.comprobarConsumoEnergetico(pConsumo);
				float pPrecioOk = this.precioFinal(pConsumo, pPeso, pPrecio);
				datos.Lavarropas ElectroDat = new datos.Lavarropas(pPrecioOk, pPeso, pConsumoOk, pColorOk, pCarga,pDescripcion);
				ElectroDat.setIdElect(pIdLava);
				return ElectroDat;
			}

			public ArrayList<Lavarropas> GetAllLa()
			{
		
			Lavarropas ElectroDat = new Lavarropas();
			ArrayList<Lavarropas> AllElectroDat = new ArrayList<Lavarropas>();
			AllElectroDat = ElectroDat.GetAllLava();
			
			return AllElectroDat;
			
			}
			
			public ArrayList<Lavarropas> GetXConsumoLava(char cConsumo)
			{
		
			Lavarropas ElectroDat = new Lavarropas();
			ArrayList<Lavarropas> AllElectroDat = new ArrayList<Lavarropas>();
			AllElectroDat = ElectroDat.GetXConsumoLava(cConsumo);
			
			return AllElectroDat;
			
			}

			public ArrayList<Lavarropas> GetxPreciosLava(float pMin, float pMax)
		{

		Lavarropas ElectroDat = new Lavarropas();
		ArrayList<Lavarropas> AllElectroDat = new ArrayList<Lavarropas>();
		AllElectroDat = ElectroDat.GetXPreciosLava(pMin, pMax);
		
		return AllElectroDat;
		
		}
			
			public ArrayList<Lavarropas> GetxConsumoyPrecLava(float pMin, float pMax, char cConsumo)
		{

		Lavarropas ElectroDat = new Lavarropas();
		ArrayList<Lavarropas> AllElectroDat = new ArrayList<Lavarropas>();
		AllElectroDat = ElectroDat.GetxPrecioYConsumoLava(pMin, pMax, cConsumo);
		
		return AllElectroDat;
		
		}

}
