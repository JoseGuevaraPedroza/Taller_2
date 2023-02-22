package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {
	private HashMap<String, Combo> combos = new HashMap<String, Combo>();
	private HashMap<String, Ingrediente> ingredientes = new HashMap<String, Ingrediente>();
	private HashMap<String,Producto> menuBase = new HashMap<String, Producto>();
	public HashMap<Integer, Pedido>  pedidos = new HashMap<Integer, Pedido>();
	//---------------------------------
	public Pedido pedidoEnCurso;


public Restaurante() throws IOException 
{
	// TODO Auto-generated constructor stub
	
}

public void IniciarPedido(String nombreCliente, String direccionCliente) 
{
	Pedido pedido= new Pedido(nombreCliente, direccionCliente);
	this.pedidoEnCurso=pedido;
}

public void cerrarYGuardarPedido() 
{
	if(this.pedidoEnCurso != null) 
	{
		this.pedidos.put(this.pedidoEnCurso.getIdPedido(), pedidoEnCurso);
		this.pedidoEnCurso=null;
	}
}

public ArrayList<Combo> getCombos()
{
	ArrayList<Combo> combos=new ArrayList<Combo>();
	for(Combo p :this.combos.values()) 
	{
		combos.add(p);
	}
	return combos;
}
public ArrayList<Producto> getMenuBase()
{
	ArrayList<Producto> menu=new ArrayList<Producto>();
	for(Producto p :this.menuBase.values()) 
	{
		menu.add(p);
	}
	return menu;
}
public ArrayList<Ingrediente> getIngredientes()
{
	ArrayList<Ingrediente> ingredientes=new ArrayList<Ingrediente>();
	for(Ingrediente i :this.ingredientes.values()) 
	{
		ingredientes.add(i);
	}
	return ingredientes;
}

public void CargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException 
{
	cargarIngredientes(archivoIngredientes);
	cargarMenu(archivoMenu);
	cargarCombos(archivoCombos);
}

private void cargarIngredientes(File archivoIngredientes) throws IOException 
{
	String[] texto_archivo=File_loader.Cargar_archivo(archivoIngredientes);
	//for(String n : texto_archivo) {System.out.println(n);}
	for (int i = 0; i < texto_archivo.length; i+=2) 
	{
		String name = texto_archivo[i];
		int price = Integer.parseInt(texto_archivo[i+1]);
		Ingrediente ingrediente = new Ingrediente(name, price);
		this.ingredientes.put(name, ingrediente);
	}
}

private void cargarMenu(File archivoMenu) throws IOException 
{
	String[] texto_archivo=File_loader.Cargar_archivo(archivoMenu);
	for (int i = 0; i < texto_archivo.length; i+=2) 
	{
		String name = texto_archivo[i];
		int price = Integer.parseInt(texto_archivo[i+1]);
		Producto producto = new ProductoMenu(name, price);
		this.menuBase.put(name, producto);
	}
}

private void cargarCombos(File archivoCombos) throws IOException 
{
	String[] texto_archivo=File_loader.Cargar_archivo(archivoCombos);
	for (int i = 0; i < texto_archivo.length; i+=5) 
	{
		//obtener los datos necesarios para crear el nuevo combo
		String name = texto_archivo[i];
		double descuento = Double.parseDouble(texto_archivo[i+1].replace("%", ""));
		String[] product_names= new String[3];
		product_names[0]=texto_archivo[i+2];
		product_names[1]=texto_archivo[i+3];
		product_names[2]=texto_archivo[i+4];
		Combo combo = new Combo(name, descuento);
		//añadir productos al combo
		for(String item: product_names) 
		{combo.agregarItemACombo(this.menuBase.get(item));}
		//añadir combo al hashmap
		this.combos.put(name, combo);
	}
}
}
