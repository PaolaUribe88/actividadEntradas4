package actividadEntradas4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import actividadEntradas4.Asiento;
import actividadEntradas4.Boleto;
import actividadEntradas4.Cliente;
import actividadEntradas4.Venta;

public class MainConsola {
	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Boleto> boletos = new ArrayList<Boleto>();
	private static ArrayList<Venta> ventas = new ArrayList<Venta>();
	private static ArrayList<Asiento> asientos = new ArrayList<Asiento>();
	
	// constantes para el menu
    public final static int OPCION_MENU_ENTRADAS_DISPONIBLES = 1;
    public final static int OPCION_MENU_COMPRAR_BOLETOS = 2;
    public final static int OPCION_MENU_ENTRADAS_VENDIDAS = 3;
    public final static int OPCION_MENU_VENTA_RECAUDADA = 4;
    public final static int OPCION_MENU_SALIR = 5;


	public static void main(String[] args) {
		inicializar();
		menu();
	}
		private static void inicializar() {

		for (int i = 1; i <= 30; i++) {
		Asiento asiento = new Asiento(i, true, "PALCO");
		asientos.add(asiento);
		}

		for (int i = 31; i <= 60; i++) {
		Asiento asiento = new Asiento(i, true, "PLATEA");
		asientos.add(asiento);
		}

		for (int i = 61; i <= 100; i++) {
		Asiento asiento = new Asiento(i, true, "GALERIA");
		asientos.add(asiento);
		}

		}

	
	private static void menu() {
		int opcionSeleccionada;		
		
		do {
			opcionSeleccionada = menuOpciones();
			
			System.out.printf(" Ud Ha seleccionado la opcion %d \n", opcionSeleccionada);
			System.out.println();
			
			switch (opcionSeleccionada) {
            	case OPCION_MENU_ENTRADAS_DISPONIBLES:
            		boletosDisponibles();
                	break ;
            	case OPCION_MENU_COMPRAR_BOLETOS :
            		comprarBoleto();
                	break;     	
            	case OPCION_MENU_ENTRADAS_VENDIDAS:
            		boletosVendidos();
                	break;         
            	case OPCION_MENU_VENTA_RECAUDADA:
            		verVentaRecaudada();
                	break;
            	case OPCION_MENU_SALIR:
            	
					break;	
        
        } 
		}while(opcionSeleccionada!= OPCION_MENU_SALIR);
		
		
	}
	private static int menuOpciones() {
		System.out.println("\nMENU TEATRO PUNTO TICKET \n****************************");
        System.out.println("[1.] BOLETOS DISPONIBLES ");
        System.out.println("[2.] COMPRAR BOLETOS ");
        System.out.println("[3.] BOLETOS VENDIDOS ");
        System.out.println("[4.] VENTAS TOTALES RECAUDADAS");
        System.out.println("[5.] SALIR ");
        System.out.println("==================================\n");
        System.out.println("[Seleccione su opción]\n");
        
        int opcionSeleccionada = scanner.nextInt();
		return opcionSeleccionada;
		
	
	}
	private static void comprarBoleto() {
		
					
			// CREACION DE CLIENTE
		
			scanner.nextLine();
			System.out.println("Ingrese Nombre del cliente");
			String nombre = scanner.nextLine();
			
			System.out.println("Ingrese Apellido del cliente");
			String apellido = scanner.nextLine();
			
			System.out.println("Ingrese RUT del cliente");
			String rut = scanner.nextLine();
			
				
			System.out.println("Ingrese tipo de asiento preferido \n");
			System.out.println("[1.] 'Palco'   - $100.000");
			System.out.println("[2.] 'Platea'  - $60.000");
			System.out.println("[3.] 'Galeria' - $30.000");
			int preferenciaAsiento = scanner.nextInt();
			String tipoAsiento = "";

			switch(preferenciaAsiento) {
				case 1:
					tipoAsiento = "PALCO";
					break;
				case 2:
					tipoAsiento = "PLATEA";
					break;
				case 3:
					tipoAsiento = "GALERIA";
					break;
			}
			
			Cliente cliente = new Cliente(rut, nombre, apellido);
			
			// CREACION DE VENTA PARA EL CLIENTE
			LocalDate fecha = LocalDate.now();
			
			final String NOMBRE_EVENTO = "FULLSTACK LA MUERTE";
			
			final LocalDate fechaEvento = LocalDate.of(2022, 5, 1);
			boolean estadoBoleto = false;
			for (Asiento asiento : asientos) {
				if(asiento.getTipo() == tipoAsiento) {
					// chequea el valor del asiento segun tipo, retorna valor y lo guarda en variable "valor"
					
					int valor = asiento.checkTipoBoleto();
					
					if (asiento.isEstado() == true) {
						asiento.setEstado(false);
						Boleto boleto = new Boleto(valor,estadoBoleto,fechaEvento,NOMBRE_EVENTO,asiento);
						Venta venta = new Venta(fecha,boleto,cliente);
						ventas.add(venta);
						
						break;	
					}
				}
			}
			
				
	     }

	private static void verVentaRecaudada() {
	int valorTotal = 0;
		
		for (Venta venta : ventas) {
			valorTotal += venta.getBoleto().getValor();
		}
		System.out.println("SU TOTAL ES : "+valorTotal);
		
	}
	private static void boletosDisponibles() {
		int boletosDisponiblesPalco = 30;
		int boletosDisponiblesPlatea = 30;
		int boletosDisponiblesGaleria = 40;
		
		for (Asiento asiento : asientos) {
			if(asiento.isEstado() == false){
				if(asiento.getTipo() == "PALCO") {
					boletosDisponiblesPalco--;
				}else if(asiento.getTipo() == "PLATEA") {
					boletosDisponiblesPlatea--;
				}else {
					boletosDisponiblesGaleria--;
				}
			}
		}
		System.out.println("Boletos disponibles 'Palco': "+ boletosDisponiblesPalco);
		System.out.println("Boletos disponibles 'Platea': "+ boletosDisponiblesPlatea);
		System.out.println("Boletos disponibles 'Galeria': "+ boletosDisponiblesGaleria);
		
	}
	
	
	private static void boletosVendidos() {
		System.out.println("Nombre Evento| Valor Boleto| Fecha evento| Nombre Cliente| Numero Asiento| Tipo de Asiento");
		System.out.println("===========================================================================================\n");

		for (Venta listaVenta : ventas) {
			
			System.out.print(listaVenta.getBoleto().getNomEvento()+"|");
			System.out.print(" "+listaVenta.getBoleto().getValor()+"|");
			System.out.print(" "+listaVenta.getBoleto().getFechaEvento()+"|");
			System.out.print(" "+listaVenta.getCliente().getNombre()+" "+listaVenta.getCliente().getApellido()+"|");
			System.out.print(" "+listaVenta.getBoleto().getAsiento().getAsiento()+"|");
			System.out.print(" "+listaVenta.getBoleto().getAsiento().getTipo()+" |\n");
		}
	}



}
