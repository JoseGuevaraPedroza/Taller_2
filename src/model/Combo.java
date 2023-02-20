package model;

import java.util.ArrayList;

public class Combo implements Producto{

	private double descuento;
	private String nombreCombo;
	public ArrayList<Producto> itemsCombo = new ArrayList<Producto>();
	
	public Combo(String nombre, double descuento) 
	{
		this.nombreCombo = nombre;
		this.descuento = descuento;
	}
	
	public void agregarItemACombo(Producto itemCombo) 
	{
		this.itemsCombo.add(itemCombo);
	}
	
	public int getPrecio() 
	{
		int precioFinal=0;
		//calcular el precio final basado en los productos del combo
		
		return precioFinal;
	}

	@Override
	public String getNombre() {
		
		return this.nombreCombo;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}
}
