package negocio;

import java.util.ArrayList;

import datos.Electrodomestico;
import datos.Lavarropas;



public class ElectrodomesticoNegocio {
	
	private enum enumColor {ROJO,NEGRO,AZUL,BLANCO,GRIS};
	
	protected float precioFinal;
	
	protected char comprobarConsumoEnergetico(char pConsumo)
	{
	char cLetra;
	switch(pConsumo)
	{
	case 'A': cLetra='A'; break;
	case 'B': cLetra='B'; break;
	case 'C': cLetra='C'; break;
	case 'D': cLetra='D'; break;
	case 'E': cLetra='E'; break;
	case 'F': cLetra='F'; break;
	default:  cLetra='F'; break;
	}
		return cLetra;
	}
	
	protected String comprobarColor(String pColor)

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
		
		case 'A': precioFinal+= 100; 
				break;
		case 'B': precioFinal+= 80;
				break;
		case 'C': precioFinal+= 60;
				break;
		case 'D': precioFinal+= 50;
				break;
		case 'E': precioFinal+= 30;
				break;
		case 'F': precioFinal+= 10;
				break;
			default: precioFinal+= 10;
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

	public int AddElectro(float pPrecio,float pPeso, String pColor, char pConsumo, String pDescripcion)
	{
			
		ElectrodomesticoNegocio Electro = new ElectrodomesticoNegocio();

		 String pColorOK = Electro.comprobarColor(pColor);
		 float pPrecioOK = Electro.precioFinal(pConsumo, pPeso, pPrecio);
		 
		 if(pPrecio==0 && pPeso==0 && pConsumo ==' '  && pColor=="")
		 {
				 
		 datos.Electrodomestico ElectroDat = new Electrodomestico();
		 int iDElectro = ElectroDat.AddElectro(pPrecioOK, pPeso, pColorOK, pConsumo, pDescripcion);
		 
		 return iDElectro;
		 }else if(pPrecio!=0 && pPeso!=0 && pConsumo ==' '  && pColor=="")
		 {
			 datos.Electrodomestico ElectroDat = new Electrodomestico(pPrecio,pPeso);
			 int iDElectro = ElectroDat.AddElectro(pPrecioOK, pPeso, pColorOK, pConsumo, pDescripcion);
			 
			 return iDElectro;}
		 else
		 {
			 datos.Electrodomestico ElectroDat = new Electrodomestico(pPrecio,pPeso, pColor, pConsumo, pDescripcion);
			 int iDElectro = ElectroDat.AddElectro(pPrecioOK, pPeso, pColorOK, pConsumo, pDescripcion);
			 
			 return iDElectro;
		 }
	 
	 
	}

	public int seteaConsumo(char pConsumo)
	{
		int rta=0;
		switch(pConsumo)
		{case 'A'&'a': rta=0; break;
		 case 'B'&'b': rta=1; break;
		 case 'C'&'c': rta=2; break;
		 case 'D'&'d': rta=3; break;
		 case 'E'&'e': rta=4; break;
		 case 'F'&'f': rta=5; break;
		 default:break;
		 		}
	return rta;
	}
	
	public void DeleteElectro(int idElectro)
	{
		datos.Electrodomestico ElectroData = new Electrodomestico();
		
		ElectroData.DeleteElectro(idElectro);
		
	}
	public Electrodomestico getOne(int idElectro)
	{
		Electrodomestico ElectroDev = new Electrodomestico();
		ElectroDev = ElectroDev.GetOne(idElectro);
		return ElectroDev;
		
	}

	public Electrodomestico UpdateElectro(int pIdElect, float pPrecio, float pPeso, String pColor, char pConsumo, String pDescripcion)
	{
		String pColorOk = this.comprobarColor(pColor);
		float pPrecioOk = this.precioFinal(pConsumo, pPeso, pPrecio);
		Electrodomestico ElectroDat = new Electrodomestico(pPrecioOk, pPeso, pColorOk, pConsumo, pDescripcion);
		ElectroDat.setIdElect(pIdElect);
		ElectroDat.UpdateElect(ElectroDat);
		return ElectroDat;
	}

	public ArrayList<Electrodomestico> GetAllEl()
	{

	Electrodomestico ElectroDat = new Electrodomestico();
	ArrayList<Electrodomestico> AllElectroDat = new ArrayList<Electrodomestico>();
	AllElectroDat = ElectroDat.GetAll();
	
	return AllElectroDat;
	
	}
	
	public ArrayList<Electrodomestico> GetxConsumo(char cConsumo)
		{
	
		Electrodomestico ElectroDat = new Electrodomestico();
		ArrayList<Electrodomestico> AllElectroDat = new ArrayList<Electrodomestico>();
		AllElectroDat = ElectroDat.GetxConsumo(cConsumo);
		
		return AllElectroDat;
		
		}

	public ArrayList<Electrodomestico> GetxPrecios(float pMin, float pMax)
	{

	Electrodomestico ElectroDat = new Electrodomestico();
	ArrayList<Electrodomestico> AllElectroDat = new ArrayList<Electrodomestico>();
	AllElectroDat = ElectroDat.GetxPrecios(pMin, pMax);
	
	return AllElectroDat;
	
	}
	public ArrayList<Electrodomestico> GetxConsumoyPrec(float pMin, float pMax, char cConsumo)
	{

	Electrodomestico ElectroDat = new Electrodomestico();
	ArrayList<Electrodomestico> AllElectroDat = new ArrayList<Electrodomestico>();
	AllElectroDat = ElectroDat.GetxPrecioYConsumo(pMin, pMax, cConsumo);
	
	return AllElectroDat;
	
	}
	
}

