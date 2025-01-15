package Objetos;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entidades.Reserva;

public class ReservaService {
	/**Crea un nuevo objeto y lo guarda en la base de datos.*/
	public static void main(String[] args) {
		//Crea sessionFactory y session
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
			    .configure("hibernate.cfg.xml")
			    .build();

			Metadata metadata = new MetadataSources(standardRegistry)
			    .addAnnotatedClass(Reserva.class)
			    .getMetadataBuilder()
			    .build();
			
			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
			Session session = sessionFactory.openSession();
		
		try{
			// crea un objeto reserva
			String fechaReservaString = "2025-03-03 21:00:00"; // Adjust date and time as needed
            Timestamp fechaReserva = Timestamp.valueOf(fechaReservaString);
            Reserva tempReserva = new Reserva(fechaReserva, 4, 1, 1);

			//empieza la transacción
			session.beginTransaction();
			
			//guarda el objeto reserva
			System.out.println("Guardando reserva");
			session.save(tempReserva);
			
			//realiza commit
			session.getTransaction().commit();
			
			System.out.println("Proceso terminado");
		} finally {
            session.close();
        }
		}
	}

