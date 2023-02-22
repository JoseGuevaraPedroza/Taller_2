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
		int precioBase=this.base.getPrecio();
		int precioAgregado=0;
		for (Ingrediente i: this.agregados) 
		{
			precioAgregado+=i.getCostoAdicional();
		}
		return precioBase+precioAgregado;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.base.getNombre();
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
