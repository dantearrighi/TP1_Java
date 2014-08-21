package datos;

public class Lavarropas extends Electrodomestico
{
	//Variables
	private float carga;
	private static float cargaDefault =5;

	//Get Set CARGA
	public float getCarga() {
		return carga;
	}

	public void setCarga(float carga) {
		this.carga = carga;
	}
	
	
	//Constructor 1
	public Lavarropas()
	{
		super();
		carga=cargaDefault;
	}
	
	//Constructor 2
	public Lavarropas(float pPrecio, float pPeso)
	{
		this();
		this.setPreciobase(pPrecio);
		this.setPeso(pPeso);
	}
	
	//Constructor 3
	public Lavarropas(float pPrecio, float pPeso, consumo pConsumo, String pColor, float pCarga)
	{
		this();
		this.setPreciobase(pPrecio);
		this.setCarga(pCarga);
		this.setColor(pColor);
		this.setConsumoEnergetico(pConsumo);
		this.setPeso(pPeso);
				
	}

	
	
}
