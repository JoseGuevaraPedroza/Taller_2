package model;

import java.io.File;
import java.util.ArrayList;

public class Pedido {

	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido = new ArrayList<Producto>();
	
	public Pedido(String nombreCliente, String direccionCliente) {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdPedido() 
	{
		return this.idPedido;
	}
	
	public void agregarProducto(Producto nuevoItem) 
	{
		
	}
	
	public void guardarFactura(File archivo) 
	{
		
	}
	
	private int getPrecioNetoPedido() 
	{
		
	}
	
	private int getPrecioTotalPedido() 
	{
		
	}
	
	private int getPrecioIVAPedido() 
	{
		
	}
	
}
