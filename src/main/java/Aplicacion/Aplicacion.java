package Aplicacion;
import java.io.IOException;
import Objetos.ConductorService;
import Objetos.ViajeService;
import Objetos.PasajeroService;
import Objetos.ReservaService;

public class Aplicacion {

	public static void main(String[] args) {
		
		ConductorService conductorService = new ConductorService();
		ViajeService viajeService = new ViajeService();
		ReservaService reservaService = new ReservaService();
		PasajeroService pasajeroService = new PasajeroService();
		
	System.out.println("===Menú de Gestión de viajes compartidos===");
	System.out.println("1. Crear conductor");
	System.out.println("2. Crear viaje");
	System.out.println("3. Buscr viajes disponibles");
	System.out.println("4. Crear pasajero");
	System.out.println("5. Crear reserva");
	System.out.println("6. Cancelar reserva");
	System.out.println("7. Listar viajes");
	System.out.println("8. Salir");
	
	try {
		int seleccion = Consola.readInt();
		switch (seleccion) {
		case 1: conductorService.nuevoConductor();
		case 2: viajeService.nuevoViaje();
		case 4: pasajeroService.nuevoPasajero();
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
