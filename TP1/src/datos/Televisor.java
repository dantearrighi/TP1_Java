package datos;

import datos.Electrodomestico.consumo;

public class Televisor extends Electrodomestico {

	private boolean sintonizadorTDT;
	private int pulgadas;
	
	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}

	public void setSintonizadorTDT(boolean sintonizadorTDT) {
		this.sintonizadorTDT = sintonizadorTDT;
	}

	public int getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}

	/*Constructor por defecto*/
	public Televisor()
	{
		super();
		sintonizadorTDT = false;
		pulgadas = 20;
	}
	/*Constructor con Precio y Peso*/
	public Televisor(float pPrecio, float pPeso)
	{
		this();
		this.setPeso(pPeso);
		this.setPreciobase(pPrecio);
	}
	/*Constructor con todos los atributos*/
	public Televisor(float pPrecio, float pPeso, consumo pConsumo, String pColor, boolean pSintonizador, int pPulgadas)
	{
		super();
		this.setColor(pColor);
		this.setConsumoEnergetico(pConsumo);
		this.setPeso(pPeso);
		this.setPreciobase(pPeso);
		this.setPulgadas(pPulgadas);
		this.setSintonizadorTDT(pSintonizador);
		
	}
}
