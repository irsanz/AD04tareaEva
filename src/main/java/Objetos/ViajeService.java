package Objetos;
import java.io.IOException;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Aplicacion.Consola;
import Entidades.Conductor;
import Entidades.Reserva;
import Entidades.Viaje;

public class ViajeService {
	/**Crea un nuevo objeto y lo guarda en la base de datos.*/

		//Crea sessionFactory y session
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
			    .configure("hibernate.cfg.xml")
			    .build();

			Metadata metadata = new MetadataSources(standardRegistry)
			    .addAnnotatedClass(Viaje.class)
			    .addAnnotatedClass(Reserva.class)
			    .addAnnotatedClass(Conductor.class)
			    .getMetadataBuilder()
			    .build();
			
			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
			Session session = sessionFactory.openSession();
			public void nuevoViaje() throws IOException{
			try{
				String ciudadDestino;
				String ciudadOrigen;
				Timestamp fechaHora;
				int plazasDisponibles;
				int conductor_id;
				ConductorService conductorService = new ConductorService();
				
				// crea un objeto viaje
				System.out.println("Introduce la ciudad de destino");
				ciudadDestino = Consola.readString();
				System.out.println("Introduce la ciudad de origen");
				ciudadOrigen = Consola.readString();
				System.out.println("Introduce la fecha y la hora");
				fechaHora = Timestamp.valueOf(Consola.readString());
				System.out.println("Introduce las plazas disponibles");
				plazasDisponibles = Consola.readInt();
				System.out.println("Introduce el ID del conductor");
				conductor_id = Consola.readInt();
				
			
					
				Viaje viajes = new Viaje(ciudadDestino,ciudadOrigen,fechaHora,plazasDisponibles, conductor_id);
				session.beginTransaction();
				Conductor conductor = session.get(Conductor.class, conductor_id);
				conductor.getViaje().add(viajes);
				viajes.setConductor(conductor);
				session.persist(viajes);
				
				session.getTransaction().commit();
								
				System.out.println("Proceso terminado");
			} finally {
	            session.close();}
	/**	try{
			// crea un objeto viaje
			String fechaHoraString = "2025-03-03 21:00:00"; // Adjust date and time as needed
            Timestamp fechaHora = Timestamp.valueOf(fechaHoraString);
            Viaje tempViaje = new Viaje("Madrid", "Barcelona", fechaHora, 20, 1);

			//empieza la transacción
			session.beginTransaction();
			
			//guarda el objeto viaje
			System.out.println("Guardando viaje");
			session.save(tempViaje);
			
			//realiza commit
			session.getTransaction().commit();
			
			System.out.println("Proceso terminado");
		} finally {
            session.close();
        }
		
			
				// TODO Auto-generated method stub
				return null;*/
			

				// TODO Auto-generated method stub
				
			}
	}

