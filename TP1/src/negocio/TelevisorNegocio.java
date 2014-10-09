package negocio;

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
}
