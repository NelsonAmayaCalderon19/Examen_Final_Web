package web.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the accesovisitante database table.
 * 
 */
@Entity
@NamedQuery(name="Accesovisitante.findAll", query="SELECT a FROM Accesovisitante a")
public class Accesovisitante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private int temperatura;

	private int visitante;

	public Accesovisitante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getVisitante() {
		return this.visitante;
	}

	public void setVisitante(int visitante) {
		this.visitante = visitante;
	}

}