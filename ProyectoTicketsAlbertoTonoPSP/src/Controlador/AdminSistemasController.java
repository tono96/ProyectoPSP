package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Modelo.ModeloLogica;
import Modelo.Ticket;
import Vista.CrearTicket;
import Vista.GenerarTicket;
import Vista.ListaAdminTickets;
import Vista.ListaTickets;
import Vista.adminSistemas;
/**
 * Clase que controla la vista del administrador de sistemas 
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */
public class AdminSistemasController implements ActionListener {
	ModeloLogica modelo;
	adminSistemas adm;
	GenerarTicket gt;
	ListaAdminTickets lta;
	int idCaso;
	boolean abierto;
	/**
	 * Es el contructor del controlador y recive la vista y el modelo
	 * @param modelo
	 * @param adm
	 */
	public AdminSistemasController(ModeloLogica modelo, adminSistemas adm){ 
		this.modelo = modelo;
		this.adm = adm;
	}
	/**
	 * Metodo que que le da funcionalidad a los botones
	 */
	@Override
	public void actionPerformed(ActionEvent eve) {
		String nombre = eve.getActionCommand();
		lta = new ListaAdminTickets();
		if (nombre.equals("Responder Ticket")) {
			lta.setVisible(true);
			lta.elementosJLIST();
		}if (nombre.equals("Leer Ticket")) {
			adm.setVisible (false);
			lta.setVisible(true);
			lta.elementosJLIST();
		}
		
	}
	 
	 
}
