package web.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the visitante database table.
 * 
 */
@Entity
@NamedQuery(name="Visitante.findAll", query="SELECT v FROM Visitante v")
public class Visitante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String documento;

	private int eps;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	private String genero;

	private String nombre;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empresa")
	private Empresa empresaBean;

	public Visitante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public int getEps() {
		return this.eps;
	}

	public void setEps(int eps) {
		this.eps = eps;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empresa getEmpresaBean() {
		return this.empresaBean;
	}

	public void setEmpresaBean(Empresa empresaBean) {
		this.empresaBean = empresaBean;
	}

}