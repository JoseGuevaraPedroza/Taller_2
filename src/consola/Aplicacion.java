package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Combo;
import model.Producto;
import model.Restaurante;

public class Aplicacion {

	private Restaurante restaurante;
	private ArrayList<Producto> itemsPedido= new ArrayList<Producto>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//instancias requeridas para el funcionamiento de la aplicacion
		BufferedReader rd= new BufferedReader(new InputStreamReader(System.in));
		Aplicacion app = new Aplicacion();
		app.restaurante= new Restaurante();
		//variables-------------------
		boolean running = true;
		int opcion;
		
		// TODO Auto-generated method stub
		while(running) 
		{
			app.mostrarMenu();
			opcion = Integer.parseInt(rd.readLine());
			app.ejecutarOpcion(opcion);
		}
	}
	public void mostrarMenu() 
	{
		System.out.println("0.Cargar información del restaurante");
		System.out.println("1. Iniciar nuevo pedido\n2.Agregar un elemento a un pedido");
		System.out.println("3.Cerrar pedido y generar factura\n4.Consultar pedido por ID");
		System.out.println("5.Salir");
	}
	
	public void ejecutarOpcion(int opcionSeleccionada) throws IOException 
	{
		BufferedReader rd= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ejecutando....");
		switch (opcionSeleccionada) {
		case 0:
			File ingredientes = new File("data/ingredientes.txt"),
			menu = new File("data/menu.txt"), combos = new File("data/combos.txt");
			this.restaurante.CargarInformacionRestaurante(ingredientes, menu, combos);
			break;
		
		case 1:
			System.out.println("Iniciando nuevo pedido.\nPor favor introduzca el nombre y la dirección del cliente");
			System.out.println("Ingrese el nombre: ");
			String name=rd.readLine();
			System.out.println("Ingrese la direccion: ");
			String direccion=rd.readLine();
			this.restaurante.IniciarPedido(name, direccion);
			break;
		
		case 2:
			if(this.restaurante.pedidoEnCurso != null) 
			{
				System.out.println("Agregar elementos al pedido n" + this.restaurante.pedidoEnCurso.getIdPedido());
				System.out.println("Agregar:\n1. Producto del menu\n2. Combo\n3. Modificar ingredientes de producto");
				int opcion=Integer.parseInt(rd.readLine());
				if(opcion == 1) 
				{
					ArrayList<Producto> pMenu=this.restaurante.getMenuBase();
					for(Producto p: pMenu) 
					{
						int index=pMenu.indexOf(p);
						System.out.println(index+"-"+p.getNombre()+" : "+ p.getPrecio());
					}
					System.out.println("Indice del elemento a agregar:");
					int op=Integer.parseInt(rd.readLine());
					this.restaurante.pedidoEnCurso.agregarProducto(pMenu.get(op));
					this.itemsPedido.add(pMenu.get(op));
				}
				else if(opcion == 2) 
				{
					ArrayList<Combo> pMenu=this.restaurante.getCombos();
					for(Producto p: pMenu) 
					{
						int index=pMenu.indexOf(p);
						System.out.println(index+"-"+p.getNombre()+" : "+ p.getPrecio());
					}
					System.out.println("Indice del elemento a agregar:");
					int op=Integer.parseInt(rd.readLine());
					this.restaurante.pedidoEnCurso.agregarProducto(pMenu.get(op));
					this.itemsPedido.add(pMenu.get(op));
				}
				else if(opcion==3) 
				{
					for(Producto p: this.itemsPedido) 
					{
						int index=this.itemsPedido.indexOf(p);
						System.out.println(index+"-"+p.getNombre()+" : "+ p.getPrecio());
					}
				}
			}else 
			{
				System.out.println("Error: No hay pedidos en curso");
			}
				break;
		default:
			System.out.println("Error, escoja una opcion valida");
			break;
		}
	}

}
