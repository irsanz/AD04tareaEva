package Entidades;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "viaje")
public class Viaje {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	@Column(name="ciudadDestino")
	private String ciudad_destino;
	
	@Column(name="ciudadOrigen")
	private String ciudad_origen;
	
	@Column(name="fechaHora")
	private Timestamp fecha_hora;

	@Column (name="plazasDisponibles")
	private int plazas_disponibles;
		
    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;
    
	@OneToMany (mappedBy="viaje", cascade=CascadeType.ALL)
	private List <Reserva> reservas = new ArrayList<>();
	
	public Viaje(String ciudadDestino, String ciudadOrigen, Timestamp fechaHora, int plazasDisponibles, int conductor_id) {
	}


	public Viaje(int id, String ciudad_destino, String ciudad_origen, Timestamp fecha_hora, int plazas_disponibles,
			String conductorId) {
		super();
		this.ciudad_destino = ciudad_destino;
		this.ciudad_origen = ciudad_origen;
		this.fecha_hora = fecha_hora;
		this.plazas_disponibles = plazas_disponibles;

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCiudad_destino() {
		return ciudad_destino;
	}


	public void setCiudad_destino(String ciudad_destino) {
		this.ciudad_destino = ciudad_destino;
	}


	public String getCiudad_origen() {
		return ciudad_origen;
	}


	public void setCiudad_origen(String ciudad_origen) {
		this.ciudad_origen = ciudad_origen;
	}


	public Timestamp getFecha_hora() {
		return fecha_hora;
	}



	    public void setFecha_hora(String fechaHoraString) {
	        this.fecha_hora = Timestamp.valueOf(fechaHoraString);
	    }
	
	public int getPlazas_disponibles() {
		return plazas_disponibles;
	}


	public void setPlazas_disponibles(int plazas_disponibles) {
		this.plazas_disponibles = plazas_disponibles;
	}
	
	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}


	@Override
	public String toString() {
		return "Viaje [id=" + id + ", ciudad_destino=" + ciudad_destino + ", ciudad_origen=" + ciudad_origen
				+ ", fecha_hora=" + fecha_hora + ", plazas_disponibles=" + plazas_disponibles + ", conductor="
				+ conductor + ", reservas=" + reservas + "]";
	}
}
