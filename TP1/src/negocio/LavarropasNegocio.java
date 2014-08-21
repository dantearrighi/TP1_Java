package negocio;

public class LavarropasNegocio extends ElectrodomesticoNegocio
{
			protected float precioFinal(char pConsumo, float pPeso, float pPrecioBase, float pCarga)
			{
				super.precioFinal(pConsumo, pPeso, pPrecioBase);
				
				
				if(30<pCarga)
				{
					super.precioFinal+=50;
				}
							
				
				return precioFinal;
			}
	

}
