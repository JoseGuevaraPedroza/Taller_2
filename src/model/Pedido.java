package model;

import java.io.File;
import java.util.ArrayList;

public class Pedido {

	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido = new ArrayList<Producto>();
	
	public Pedido(String nombreCliente, String direccionCliente) {
		// TODO Auto-generated constructor stub
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.idPedido=Pedido.numeroPedidos+1;
		Pedido.numeroPedidos+=1;
	}
	
	public int getIdPedido() 
	{
		return this.idPedido;
	}
	
	public void agregarProducto(Producto nuevoItem) 
	{
		this.itemsPedido.add(nuevoItem);
	}
	
	public void guardarFactura(File archivo) 
	{
		int precioFactura=this.getPrecioTotalPedido();
		//generar texto de la factura
	}
	
	private int getPrecioNetoPedido() 
	{
		int precio=0;
		for (Producto p: this.itemsPedido) 
		{
			precio+=p.getPrecio();
		}
		return precio;
	}
	
	private int getPrecioTotalPedido() 
	{
		return this.getPrecioNetoPedido()+this.getPrecioIVAPedido();
	}
	
	private int getPrecioIVAPedido() 
	{
		int iva=(int) Math.round(this.getPrecioNetoPedido()*0.19);
		return iva;
	}
	
}
