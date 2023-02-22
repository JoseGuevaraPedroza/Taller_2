package model;

import java.util.ArrayList;

public class ProductoAjustado implements Producto{
	
	//atributos
	private Producto base;
	
	public ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
	public ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();
	
	public ProductoAjustado(Producto menuBase) 
	{
		this.base=menuBase;
	}
	
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
		String textoAgregados="";
		String textoEliminados="";
		for(Ingrediente i: this.agregados) 
		{
			textoAgregados+= i.getNombre()+",";
		}
		for(Ingrediente i: this.eliminados) 
		{
			textoEliminados+= i.getNombre()+",";
		}
		return this.getNombre()+"-"+this.getPrecio()+ "(Agregados: "+textoAgregados+")"+
		"(Eliminados: "+textoEliminados+")";
	}
	
}
