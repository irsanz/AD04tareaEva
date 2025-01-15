package Objetos;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Aplicacion.Consola;
import Entidades.Conductor;
import Entidades.Viaje;

public class ConductorService {
	/**Crea un nuevo objeto y lo guarda en la base de datos.
	 * @throws IOException */

	public void nuevoConductor() throws IOException{
		//Crea sessionFactory y session
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
			    .configure("hibernate.cfg.xml")
			    .build();

			Metadata metadata = new MetadataSources(standardRegistry)
			    .addAnnotatedClass(Conductor.class)
			    .addAnnotatedClass(Viaje.class)
			    .getMetadataBuilder()
			    .build();
			
			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
			Session session = sessionFactory.openSession();
		
		try{
			String nombre;
			String vehiculo;
			// crea un objeto conductor
			System.out.println("Introduce nombre del conductor");
			nombre = Consola.readString();
			System.out.println("Introduce nombre del vehículo");
			vehiculo = Consola.readString();
			Conductor tempConductor = new Conductor(nombre, vehiculo);
			
			//empieza la transacción
			session.beginTransaction();
			
			//guarda el objeto conductor
			System.out.println("Guardando conductor");
			session.save(tempConductor);
			
			//realiza commit
			session.getTransaction().commit();
			
			System.out.println("Proceso terminado");
		} finally {
            session.close();
        }}
		}



