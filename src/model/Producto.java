package model;

public abstract interface Producto {
	
	public int getPrecio();
	public String getNombre();
	public String generarTextoFactura();
}
