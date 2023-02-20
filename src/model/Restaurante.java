package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Producto> menuBase;
	private HashMap<String, Pedido>  pedidos = new HashMap<String, Pedido>();
 public Restaurante() {
	// TODO Auto-generated constructor stub
}
public ArrayList<Producto> getMenuBase() throws IOException
{
	ArrayList<Producto> result = new ArrayList<Producto>();
	File path = new File("data/menu.txt");
	String[] texto_archivo=File_loader.Cargar_archivo(path);
	for (int i = 0; i < texto_archivo.length; i=+2) 
	{
		String name = texto_archivo[i];
		int price = Integer.parseInt(texto_archivo[i+1]);
		Producto p = new ProductoMenu(name, price);
	}
	return result;
}
public ArrayList<Ingrediente> getIngredientes()
{}
public void CargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) 
{}

private void cargarIngredientes(File archivoIngredientes) 
{}

private void cargarMenu(File archivoMenu) 
{}

private void cargarCombos(File archivoCombos) 
{}
}
