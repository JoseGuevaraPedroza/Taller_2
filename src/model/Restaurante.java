package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Producto> menuBase;
	private HashMap<String, Pedido>  pedidos = new HashMap<String, Pedido>();


public Restaurante() throws IOException 
{
	// TODO Auto-generated constructor stub
	
}

public ArrayList<Producto> getMenuBase()
{
	
}
public ArrayList<Ingrediente> getIngredientes()
{
}

public void CargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) 
{

}

private void cargarIngredientes(File archivoIngredientes) throws IOException 
{
	ArrayList<Ingrediente> result = new ArrayList<Ingrediente>();
	String[] texto_archivo=File_loader.Cargar_archivo(archivoIngredientes);
	for (int i = 0; i < texto_archivo.length; i=+2) 
	{
		String name = texto_archivo[i];
		int price = Integer.parseInt(texto_archivo[i+1]);
		Ingrediente p = new Ingrediente(name, price);
		result.add(p);
	}
	this.ingredientes=result;
}

private void cargarMenu(File archivoMenu) throws IOException 
{
	ArrayList<Producto> result = new ArrayList<Producto>();
	String[] texto_archivo=File_loader.Cargar_archivo(archivoMenu);
	for (int i = 0; i < texto_archivo.length; i=+2) 
	{
		String name = texto_archivo[i];
		int price = Integer.parseInt(texto_archivo[i+1]);
		Producto p = new ProductoMenu(name, price);
		result.add(p);
	}
	this.menuBase=result;
}

private void cargarCombos(File archivoCombos) 
{}
}
