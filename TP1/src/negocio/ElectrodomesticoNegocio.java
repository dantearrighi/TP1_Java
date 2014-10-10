package negocio;


public class ElectrodomesticoNegocio {
	
	private enum enumColor {ROJO,NEGRO,AZUL,BLANCO,GRIS};
	
	protected float precioFinal;
	
	private char comprobarConsumoEnergetico(char pLetra)
	{
	
	switch(pLetra)
	{
	case 'A': break;
	case 'B': break;
	case 'C': break;
	case 'D': break;
	case 'E': break;
	case 'F':break;
		default: pLetra='F';
				 break;
	}
		return pLetra;
	}
	
	private String comprobarColor(String pColor)

	{
		String ColorSelect;
		
		enumColor color = enumColor.valueOf(pColor);
		
		switch(color)
		{
		case ROJO: ColorSelect = "ROJO"; 
			break;
		case BLANCO: ColorSelect = "BLANCO"; 
			break;
		case NEGRO: ColorSelect = "NEGRO"; 
			break;
		case AZUL: ColorSelect = "AZUL"; 
			break;
		case GRIS: ColorSelect = "GRIS"; 
			break;
		default: ColorSelect= "BLANCO";
			break;
	
		}
		
		return ColorSelect;
		
	}
	
	protected float  precioFinal(char pConsumo, float pPeso, float pPrecioBase)
	{
		precioFinal = pPrecioBase;
		
		switch(pConsumo)
		{
		
		case 'A': precioFinal= 100; 
				break;
		case 'B': precioFinal= 80;
				break;
		case 'C': precioFinal= 60;
				break;
		case 'D': precioFinal= 50;
				break;
		case 'E': precioFinal= 30;
				break;
		case 'F': precioFinal= 10;
				break;
			default: precioFinal= 10;
					 break;
			
		}
		
		if(0<=pPeso && pPeso<=19)
		{
			precioFinal+=10;
		}
		else if(20<=pPeso && pPeso<=49)
		{
			precioFinal+=50;
		}
		else if (50<=pPeso && pPeso<=79)
		{
			precioFinal+=80;
			}
		else if (80<=pPeso)
		{
			precioFinal+=100;
		}
		
		
		
		return precioFinal;
		
	}


}
