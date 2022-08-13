package co.edu.utp.misiontic2022.c2.reto5.model.vo;

public class CompraHomecenterVo {

	private int id;
	private String constructora;
	private String banco;

	public CompraHomecenterVo() {
		super();
	}

	public CompraHomecenterVo(int id, String constructora, String banco) {
		super();
		this.id = id;
		this.constructora = constructora;
		this.banco = banco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConstructora() {
		return constructora;
	}

	public void setConstructora(String constructora) {
		this.constructora = constructora;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

}
