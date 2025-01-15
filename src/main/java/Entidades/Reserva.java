package Entidades;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	@Column(name="fechaReserva")
	private Timestamp fecha_reserva;

	@Column (name="plazasReservadas")
	private int plazas_reservadas;
	
	@Column (name="viajeId")
	private int viaje_id;
	
	@Column (name="pasajeroId")
	private int pasajero_id;

	@ManyToOne
    @JoinColumn(name = "viaje_id")
	private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "pasajero_id")
    private Pasajero pasajero;
    
	public Reserva() {
	}


	public Reserva(Timestamp fecha_reserva, int plazas_reservadas, int viaje_id, int pasajero_id) {
		super();
		this.fecha_reserva = fecha_reserva;
		this.plazas_reservadas = plazas_reservadas;
		this.viaje_id = viaje_id;
		this.pasajero_id = pasajero_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Timestamp getFecha_reserva() {
		return fecha_reserva;
	}


	public void setFecha_reserva(Timestamp fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}


	public int getPlazas_reservadas() {
		return plazas_reservadas;
	}


	public void setPlazas_reservadas(int plazas_reservadas) {
		this.plazas_reservadas = plazas_reservadas;
	}


	public int getViaje_id() {
		return viaje_id;
	}


	public void setViaje_id(int viaje_id) {
		this.viaje_id = viaje_id;
	}


	public int getPasajero_id() {
		return pasajero_id;
	}


	public void setPasajero_id(int pasajero_id) {
		this.pasajero_id = pasajero_id;
	}


	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fecha_reserva=" + fecha_reserva + ", plazas_reservadas=" + plazas_reservadas
				+ ", viaje_id=" + viaje_id + ", pasajero_id=" + pasajero_id + "]";
	}
	

}
	
		