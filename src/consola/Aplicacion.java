package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Combo;
import model.Ingrediente;
import model.Pedido;
import model.Producto;
import model.ProductoAjustado;
import model.Restaurante;

public class Aplicacion {

	private Restaurante restaurante;
	private ArrayList<ProductoAjustado> itemsPedido= new ArrayList<ProductoAjustado>();
	private boolean running;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//instancias requeridas para el funcionamiento de la aplicacion
		BufferedReader rd= new BufferedReader(new InputStreamReader(System.in));
		Aplicacion app = new Aplicacion();
		app.restaurante= new Restaurante();
		//variables-------------------
		app.running = true;
		int opcion;
		
		// TODO Auto-generated method stub
		while(app.running) 
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
					ProductoAjustado pA= new ProductoAjustado(pMenu.get(op));
					this.restaurante.pedidoEnCurso.agregarProducto(pA);
					this.itemsPedido.add(pA);
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
					ProductoAjustado pA= new ProductoAjustado(pMenu.get(op));
					this.restaurante.pedidoEnCurso.agregarProducto(pA);
					this.itemsPedido.add(pA);
				}
				else if(opcion==3) 
				{
					System.out.println("Que elemento desea modificar:");
					for(ProductoAjustado p: this.itemsPedido) 
					{
						int index=this.itemsPedido.indexOf(p);
						System.out.println(index+"-"+p.getNombre()+" : "+ p.getPrecio());
					}
					int op=Integer.parseInt(rd.readLine());
					ProductoAjustado z= this.itemsPedido.get(op);
					System.out.println("Opciones:\n1. Agregar ingrediente.\n2. Eliminar ingrediente");
					int op2=Integer.parseInt(rd.readLine());
					if (op2 ==1) 
					{
						ArrayList<Ingrediente> pMenu=this.restaurante.getIngredientes();
						for(Ingrediente i: pMenu) 
						{
							int index=pMenu.indexOf(i);
							System.out.println(index+"-"+i.getNombre()+" : "+ i.getCostoAdicional());
						}
						System.out.println("Indice del elemento a agregar:");
						op2=Integer.parseInt(rd.readLine());
						z.agregados.add(pMenu.get(op2));
					}
					else if (op2 ==2) 
					{
						ArrayList<Ingrediente> pMenu=this.restaurante.getIngredientes();
						for(Ingrediente i: pMenu) 
						{
							int index=pMenu.indexOf(i);
							System.out.println(index+"-"+i.getNombre()+" : "+ i.getCostoAdicional());
						}
						System.out.println("Indice del elemento a eliminar:");
						op2=Integer.parseInt(rd.readLine());
						z.eliminados.add(pMenu.get(op2));
					}
				}
			}else 
			{
				System.out.println("Error: No hay pedidos en curso");
			}
				break;
		case 3:
			File savepath= new File("data/factura.txt");
			this.restaurante.pedidoEnCurso.guardarFactura(savepath);
			this.restaurante.cerrarYGuardarPedido();
			break;
		case 4:
			File save= new File("data/factura.txt");
			System.out.println("Indique el ID del pedido:");
			int op=Integer.parseInt(rd.readLine());
			Pedido p= this.restaurante.pedidos.get(op);
			p.guardarFactura(save);
			break;
		case 5:
			this.running=false;
			break;
		default:
			System.out.println("Error, escoja una opcion valida");
			break;
		}
	}

}
