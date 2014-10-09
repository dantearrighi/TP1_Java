package negocio;

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
	

}
