package negocio;

import datos.Electrodomestico;
import datos.Lavarropas;

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

			public datos.Lavarropas UpdateElectro(int pIdLava, float pPrecio, float pPeso, String pColor, char pConsumo,float pCarga, String pDescripcion)
			{
				String pColorOk = this.comprobarColor(pColor);
				char pConsumoOk = this.comprobarConsumoEnergetico(pConsumo);
				float pPrecioOk = this.precioFinal(pConsumo, pPeso, pPrecio);
				datos.Lavarropas ElectroDat = new datos.Lavarropas(pPrecioOk, pPeso, pConsumoOk, pColorOk, pCarga,pDescripcion);
				ElectroDat.setIdElect(pIdLava);
				return ElectroDat;
			}

			public datos.Lavarropas[] GetxConsumo(char cConsumo)
			{
		
			datos.Lavarropas ElectroDat = new Lavarropas();
			Lavarropas [] AllElectroDat = null;
			AllElectroDat = ElectroDat.GetxConsumo(cConsumo);
			
			return AllElectroDat;
			
			}

			public Lavarropas[] GetxPrecios(float pMin, float pMax)
		{

		Lavarropas ElectroDat = new Lavarropas();
		Lavarropas [] AllElectroDat = null;
		AllElectroDat = ElectroDat.GetxPrecios(pMin, pMax);
		
		return AllElectroDat;
		
		}
			
			public Lavarropas[] GetxConsumoyPrec(float pMin, float pMax, char cConsumo)
		{

		Lavarropas ElectroDat = new Lavarropas();
		Lavarropas [] AllElectroDat = null;
		AllElectroDat = ElectroDat.GetxPrecioYConsumo(pMin, pMax, cConsumo);
		
		return AllElectroDat;
		
		}

}
