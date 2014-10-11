package negocio;

import datos.Electrodomestico;
import datos.Electrodomestico.consumo;
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
				 consumo pConsumoOK = Lavarr.comprobarConsumoEnergetico((char)pConsumo);
				 float pPrecioOK = Lavarr.precioFinal(pConsumo, pPeso, pPrecio);
				 
				 datos.Lavarropas ElectroDat = new datos.Lavarropas();
				 int iDElectro = ElectroDat.AddLavarrop(pDescripcion, pPrecioOK, pPeso, pColorOK, pConsumoOK, pCarga);
				 
				 return iDElectro;
				
			}
	
			public void DeleteLavarropa(int idElectro)
			{
				datos.Electrodomestico ElectroData = new Electrodomestico();
				
				ElectroData.DeleteElectro(idElectro);
				
			}

			public datos.Lavarropas UpdateElectro(int pIdLava, float pPrecio, float pPeso, String pColor, char pConsumo,float pCarga, String pDescripcion)
			{
				String pColorOk = this.comprobarColor(pColor);
				consumo pConsumoOk = this.comprobarConsumoEnergetico(pConsumo);
				float pPrecioOk = this.precioFinal(pConsumo, pPeso, pPrecio);
				datos.Lavarropas ElectroDat = new datos.Lavarropas(pDescripcion, pPrecioOk, pPeso, pConsumoOk, pColorOk, pCarga);
				ElectroDat.setIdElect(pIdLava);
				return ElectroDat;
			}

			public datos.Lavarropas[] GetxConsumo(consumo cConsumo)
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
			
			public Lavarropas[] GetxConsumoyPrec(float pMin, float pMax, consumo cConsumo)
		{

		Lavarropas ElectroDat = new Lavarropas();
		Lavarropas [] AllElectroDat = null;
		AllElectroDat = ElectroDat.GetxPrecioYConsumo(pMin, pMax, cConsumo);
		
		return AllElectroDat;
		
		}

}
