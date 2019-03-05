package Modelo;

import java.util.ArrayList;
/**
 * Interfaz DAO
 * 
 * @author Alberto Serrano y Antonio Ramayo
 */

public interface DAO {
	/**
	 * Metodo que añade un ticket a la base de datos
	 * 
	 * @param ticket
	 * @return true si es añadido, false, si no.
	 */
	public boolean AddTicket(Ticket ticket); // Recoge el ticket por parametro y lo añade a la base de datos

	/**
	 * Metodo que añade un administrador a la base de datos
	 * 
	 * @param admin
	 * @return true si es añadido, false, si no.
	 */
	public boolean AddAdmin(Administrador admin); // Recoge el administrados a por parametro y lo añade a la base de
													// datos

	/**
	 * Metodo que obtiene todos lo casos de la base de datos
	 * 
	 * @return Array de casos.
	 */
	public ArrayList<Ticket> CargarDatosCasos(); // Guarda en un arraylist los datos de los casos

	/**
	 * Motodo que obtiene todos los ticket con el mismo id de caso de la base de
	 * datos
	 * 
	 * @param idCaso
	 * @return array con los tickets
	 */
	public ArrayList<Ticket> CargarDatosTicketsCaso(int idCaso);

	/**
	 * Metodo que obtiene los casos de un administrador
	 * 
	 * @param id_Admin
	 * @return array con los casos
	 */
	public ArrayList<Ticket> CargarDatosCasosAdmin(int id_Admin);

	/**
	 * Metodo que comprueba si el administrador existe
	 * 
	 * @param adr
	 * @return true si existe, false, si no.
	 */

	public boolean ComprobarAdmin(Administrador adr); // Comprueba si el administrador existe o no

	/**
	 * Metodo que obtiene los datos de un ticket
	 * 
	 * @param idticket
	 * @return Un ticket
	 */
	public Ticket devuelveDatosTickets(int idticket);

	/**
	 * Metodo que obtiene los tickets que se encuentran abiertos
	 * 
	 * @return Array de tickets
	 */

	public ArrayList<Ticket> CargarDatosTicketsPendientes();

	/**
	 * Meotodo que obtiene los administradores de la base de datos
	 * 
	 * @return Array de administradores
	 */

	public ArrayList<Administrador> CargarDatosAdministradores();
}

