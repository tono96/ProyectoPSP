package Modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Clase Modelo que implementa los metodos que operan con la base de datos y
 * datos del sistema
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */

public class ModeloLogica {
	AgenciaVuelosDAOJDBC dao = new AgenciaVuelosDAOJDBC();
	/**
	 * Constructor por defecto
	 */

	public ModeloLogica() {

	}
	/**
	 * Metodo que añade un ticket a la base de datos
	 * 
	 * @param ticket
	 * @return true si es añadido, false, si no.
	 */

	public boolean AddTicket(Ticket ticket) {
		dao.AddTicket(ticket);
		return true;
	}
	/**
	 * Metodo que añade un administrador a la base de datos
	 * 
	 * @param admin
	 * @return true si es añadido, false, si no.
	 */

	public boolean AddAdmin(Administrador admin) {
		dao.AddAdmin(admin);
		return true;
	}
	/**
	 * Metodo que obtiene todos lo casos de la base de datos
	 * 
	 * @return Array de casos.
	 */

	public ArrayList<Ticket> CargarDatosCasos(){
		return dao.CargarDatosCasos();
	}
	/**
	 * Motodo que obtiene todos los ticket con el mismo id de caso de la base de
	 * datos
	 * 
	 * @param idCaso
	 * @return array con los tickets
	 */

	public ArrayList<Ticket> CargarDatosTicketsCaso(int idCaso){
		
		return dao.CargarDatosTicketsCaso(idCaso);
	}
	/**
	 * Metodo que obtiene los casos de un administrador
	 * 
	 * @param id_Admin
	 * @return array con los casos
	 */

	public ArrayList<Ticket> CargarDatosCasosAdmin(int id_Admin){
		return dao.CargarDatosCasosAdmin(id_Admin);
	}
	/**
	 * Metodo que comprueba si el administrador existe
	 * 
	 * @param adr
	 * @return true si existe, false, si no.
	 */

	public boolean ComprobarAdmin(Administrador adr) {
		return dao.ComprobarAdmin(adr);

	}
	/**
	 * Metodo una lista de tickets pendientes que hay en un caso de un administrador
	 * 
	 * @param idadmin
	 * @return Arraylist de tickets
	 */

	public ArrayList<Ticket> CargarDatosPendientes(int idadmin) {
		return dao.CargarDatosPendientes(idadmin);
	}
	/**
	 * Metodo que obtiene los datos de un ticket
	 * 
	 * @param idticket
	 * @return Un ticket
	 */

	public Ticket devuelveDatosTickets(int idticket) {
		return dao.devuelveDatosTickets(idticket);
	}
	/**
	 * Metodo que obtiene los tickets que se encuentran abiertos
	 * 
	 * @return Array de tickets
	 */


	public ArrayList<Ticket> CargarDatosTicketsPendientes(){ //no es pendiente es abierto
		return dao.CargarDatosTicketsPendientes();
	}
	/**
	 * Metodo que obtiene los datos de los tickets de un caso.
	 * 
	 * @param idcaso
	 * @return Array de tickets
	 */

	public ArrayList<Ticket> CargarDatosTicketsPendientes(int idcaso){ //no es pendiente es abierto
		return dao.CargarDatosTicketsPendientes(idcaso);
	}	
	/**
	 * Metodo que obtiene una lista de tickets pendientes
	 * 
	 * @return array de tickets
	 */

	public ArrayList<Ticket> CargarDatosAdminPendientes(){
		return dao.CargarDatosAdminPendientes();
	}
	/**
	 * Meotodo que obtiene los administradores de la base de datos
	 * 
	 * @return Array de administradores
	 */

	public ArrayList<Administrador> CargarDatosAdministradores(){
		return dao.CargarDatosAdministradores();
	}
	/**
	 * Metodo que obtiene el numero de casos que hay
	 * 
	 * @return numero de casos
	 */

	public int code() {
		return dao.TotalRegistros();
	}
	/**
	 * Metodo que comprueba si hay algun ticket abierto en un caso
	 * 
	 * @param idcaso
	 * @return true si hay abierto, false si no hay
	 */

	public boolean ComprobarAbierto(int t) {
	 return dao.ComprobarAbierto(t);
	}
	/**
	 * Metodo que obtiene una lista de tickets pendientes de un caso concreto
	 * 
	 * @param idcaso
	 * @return Array de tickets
	 */

	public ArrayList<Ticket> CargarDatosTicketsP(int idcaso) {
		return dao.CargarDatosTicketsP(idcaso);
	}
	/**
	 * Metodo qel numero de idadmin con casos pendientes
	 * 
	 * @param idcaso
	 * @return Array de tickets
	 */
	public int ConatidAdmin() {
		return dao.ConatidAdmin();
	}
	public boolean ComprobarID(int id, int idcaso) {
		return dao.ComprobarID(id, idcaso);
	}
	public boolean Responder(String respuesta, int id, int idcaso) {
		return dao.Responder(respuesta, id, idcaso);
	}
	public int Contid(int idadmin) {
		return dao.ContTickets(idadmin);
	}
	public int ContarAdmins() {
		return dao.ContarAdmins();
	}
}
