package Entidades;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "pasajero")

public class Pasajero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="email")
	private String email;
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn (name = "pasajero_id")
	List <Reserva> reservas = new ArrayList<>();
	
	public Pasajero() {
	}

	public Pasajero(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pasajero [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}

	
	
}