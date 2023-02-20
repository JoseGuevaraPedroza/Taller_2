package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Producto> menuBase;
	private HashMap<String, Pedido>  pedidos = new HashMap<String, Pedido>();
 public Restaurante() {
	// TODO Auto-generated constructor stub
}
public ArrayList<Producto> getMenuBase()
{}
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
