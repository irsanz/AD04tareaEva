package Entidades;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "conductor")

public class Conductor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="vehiculo")
	private String vehiculo;
	
	@OneToMany(mappedBy="conductor")
	List<Viaje> viajes = new ArrayList<>();
	
	public Conductor() {
	}

	public Conductor(String nombre, String vehiculo) {
		this.nombre = nombre;
		this.vehiculo = vehiculo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public List<Viaje>getViaje(){
		return viajes;
	}

	@Override
	public String toString() {
		return "Conductor [id=" + id + ", nombre=" + nombre + ", vehiculo=" + vehiculo + "]";
	}
}
