package datos;

public class Electrodomestico {
	/*Attributes of the laundry machine*/
	private float preciobase;
	private String color ;
	private consumo consumoEnergetico ;
	private float peso; 
	protected enum consumo {A,B,C,D,E,F}; 
	
	private static String colorDefault = "BLANCO";
	private static float precioDefault = 10;
	private static float pesoDefault= 5;
	private static consumo consumoDefault = consumo.F;
	
	
	
	/*Fin variables*/

	public float getPreciobase() {
		return preciobase;
	}
	public void setPreciobase(float preciobase) {
		this.preciobase = preciobase;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public consumo getConsumoEnergetico() {
		return consumoEnergetico;
	}
	public void setConsumoEnergetico(consumo consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	/*Default constructor*/
	public Electrodomestico()
	{
		this.setColor(colorDefault);
		this.setConsumoEnergetico(consumoDefault);
		this.setPeso(pesoDefault);
		this.setPreciobase(precioDefault);
	}
	/* Constructor whit price y weight*/
	public Electrodomestico(float pPrecio, float pPeso)	
	{
	this();
	this.setPreciobase(pPrecio);
	this.setPeso(pPeso);
	}
	
	/*Constructor all attributes*/
	public Electrodomestico(float pPrecio, float pPeso,String pColor, consumo pConsumo)
	{	this();
		this.setColor(pColor);
		this.setConsumoEnergetico(pConsumo);
		this.setPeso(pPeso);
		this.setPreciobase(pPrecio);
	}
}
	
	
	
	