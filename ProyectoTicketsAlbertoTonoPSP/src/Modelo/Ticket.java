package Modelo;

import java.io.Serializable;
/**
 * Pojo Ticket, implementa Serializable.
 * 
 * @author Alberto Serrano y Antonio Ramayo
 * @version 26/2/2019
 *
 */
 
public class Ticket implements Serializable {


	private int id;
    private int id_Caso;
    private int id_Admin;
    private String fecha;
    private String asunto;
    private String prio;
    private String desc;
    private String estado;
    private String respuesta;
	/**
	 * Constructor por defecto
	 */

    public Ticket() {
    }
    /**
	 * Contructor con parametros.
	 * 
	 * @param id_Caso
	 */

    public Ticket(int id_Caso) {
    	this.id_Caso = id_Caso;
    	this.id_Admin = id_Caso;
    	this.id = id_Caso;
    }
    /**
	 * Constructor con parametros
	 * 
	 * @param id
	 * @param id_Caso
	 * @param asunto
	 */

    public Ticket(int id, int id_Caso, String asunto) {
    	this.id = id;
    	this.id_Caso = id_Caso;
    	this.asunto = asunto;
    	this.respuesta = asunto;
    }
    /**
	 * Constructor con parametros
	 * 
	 * @param id_Caso
	 * @param Asunto
	 */

    public Ticket(int id_Caso, String Asunto) {
    	this.id_Caso = id_Caso;
    	this.asunto = Asunto;
    }
    /**
	 * Constructor con parametros
	 * 
	 * @param id
	 * @param id_Caso
	 * @param id_Admin
	 * @param fecha
	 * @param asunto
	 * @param prio
	 * @param desc
	 * @param estado
	 */

	public Ticket(int id, int id_Caso, int id_Admin, String fecha, String asunto, String prio, String desc,
			String estado) {
		super();
		this.id = id;
		this.id_Caso = id_Caso;
		this.id_Admin = id_Admin;
		this.fecha = fecha;
		this.asunto = asunto;
		this.prio = prio;
		this.desc = desc;
		this.estado = estado;
	}

	public Ticket(int id, int id_Caso, int id_Admin, String fecha, String asunto, String prio, String desc,
			String estado, String respuesta) {
		super();
		this.id = id;
		this.id_Caso = id_Caso;
		this.id_Admin = id_Admin;
		this.fecha = fecha;
		this.asunto = asunto;
		this.prio = prio;
		this.desc = desc;
		this.estado = estado;
		this.respuesta = respuesta;
	}
	
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	/**
	 * Devuelve el id del ticket
	 * 
	 * @return id del Ticket
	 */

	public int getId() {
		return id;
	}

	/**
	 * Modifica el id del Ticket
	 * 
	 * @param id
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el id del caso
	 * 
	 * @return id_caso
	 */

	public int getId_Caso() {
		return id_Caso;
	}

	/**
	 * Modifica el id del caso
	 * 
	 * @param id_Caso
	 */

	public void setId_Caso(int id_Caso) {
		this.id_Caso = id_Caso;
	}

	/**
	 * Obtiene el id del administrador
	 * 
	 * @return id_Admin
	 */

	public int getId_Admin() {
		return id_Admin;
	}

	/**
	 * Modifica el id del administrador
	 * 
	 * @param id_Admin
	 */

	public void setId_Admin(int id_Admin) {
		this.id_Admin = id_Admin;
	}

	/**
	 * Obtiene la fecha
	 * 
	 * @return fecha
	 */

	public String getFecha() {
		return fecha;
	}

	/**
	 * Modifica la fecha
	 * 
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el asunto
	 * 
	 * @return asunto
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * Modifica el asunto
	 * 
	 * @param asunto
	 */

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * Obtiene la prioridad
	 * 
	 * @return prioridad
	 */

	public String getPrio() {
		return prio;
	}

	/**
	 * Modifica la prioridad
	 * 
	 * @param prio
	 */

	public void setPrio(String prio) {
		this.prio = prio;
	}

	/**
	 * Obtiene la descripcion
	 * 
	 * @return descripcion
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Modifica la descripcion
	 * 
	 * @param desc
	 */

	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Obtiene el estado
	 * 
	 * @return estado
	 */

	public String getEstado() {
		return estado;
	}

	/**
	 * Modifica el estado
	 * 
	 * @param estado
	 */

	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Metodo para imprimir los datos de un ticket
	 */

	@Override
	public String toString() {
		return "Ticket id=" + id + "\n id_Caso=" + id_Caso + "\n id_Admin=" + id_Admin + "\n fecha=" + fecha
				+ "\n asunto=" + asunto + "\n prio=" + prio + "\n desc=" + desc + "\n estado=" + estado;
	}

}
