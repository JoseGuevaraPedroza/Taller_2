package model;

public class ProductoMenu implements Producto{
	
	private String nombre;
	private int precioBase;
	public ProductoMenu(String nombre, int precioBase) 
	{
		this.nombre=nombre;
		this.precioBase=precioBase;
	}
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
