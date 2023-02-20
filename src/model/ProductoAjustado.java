package model;

import java.util.ArrayList;

public class ProductoAjustado implements Producto{
	
	//atributos
	private ProductoMenu base;
	
	public ArrayList<Ingrediente> agregados;
	public ArrayList<Ingrediente> eliminados;
	
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
