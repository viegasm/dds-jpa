package ar.edu.d2s;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Casa {

	public final static String PROPIETARIO = "propietario";
	public final static String HABITACIONES = "habitaciones";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String propietario;
	
	@OneToMany( cascade = CascadeType.ALL,mappedBy = "casa", orphanRemoval = true )
//	@JoinColumn(name="casa_id")
	@OrderColumn(name="pos")
	
	private List<Habitacion> habitaciones;

	

	
	protected Casa() {
		super();
	}

	public Casa(String propietario) {
		super();
		this.habitaciones = new ArrayList<Habitacion>();
		this.propietario = propietario;
	}

	public void addHabitacion(Habitacion h) {
		h.setCasa(this);
		this.habitaciones.add(h);
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}