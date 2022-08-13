package co.edu.utp.misiontic2022.c2.reto5.model.vo;

public class LiderVo {

	private Integer id;
	private String nombre;
	private String apellido;
	private String CiudadResidencia;

	public LiderVo() {

	}

	public LiderVo(Integer id, String nombre, String apellido, String ciudadResidencia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		CiudadResidencia = ciudadResidencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiudadResidencia() {
		return CiudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		CiudadResidencia = ciudadResidencia;
	}

}
