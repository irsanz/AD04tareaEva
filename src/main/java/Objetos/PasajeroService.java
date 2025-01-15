package Objetos;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entidades.Pasajero;
import Aplicacion.Consola;
import Entidades.Conductor;
import Entidades.Viaje;

public class PasajeroService {
	/**Crea un nuevo objeto y lo guarda en la base de datos.*/
	public void nuevoPasajero() throws IOException {
		//Crea sessionFactory y session
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
			    .configure("hibernate.cfg.xml")
			    .build();

			Metadata metadata = new MetadataSources(standardRegistry)
				.addAnnotatedClass(Conductor.class)
				.addAnnotatedClass(Viaje.class)
			    .addAnnotatedClass(Pasajero.class)
			    .getMetadataBuilder()
			    .build();
			
			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
			Session session = sessionFactory.openSession();
		
		try{
			String nombre;
			String email;
			// crea un objeto pasajero
			System.out.println("Introduce nombre del pasajero");
			nombre = Consola.readString();
			System.out.println("Introduce el email del pasajero");
			email = Consola.readString();
			Pasajero tempPasajero = new Pasajero(nombre, email);
			System.out.println("Creando objeto pasajero");
			
			//empieza la transacción
			session.beginTransaction();
			
			//guarda el objeto pasajero
			System.out.println("Guardando pasajero");
			session.save(tempPasajero);
			
			//realiza commit
			session.getTransaction().commit();
			
			System.out.println("Proceso terminado");
		} finally {
            session.close();
        }
		}
	}






