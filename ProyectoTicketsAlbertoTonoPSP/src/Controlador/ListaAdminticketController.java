package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.ModeloLogica;
import Modelo.Ticket;
import Vista.CrearTicket;
import Vista.GenerarTicket;
import Vista.ListaAdminTickets;
import Vista.ResponderTicket;
import Vista.adminSistemas;
/**
 * Clase que controla la lista 
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */
public class ListaAdminticketController extends MouseAdapter implements ActionListener{
	ModeloLogica modelo;
	adminSistemas adm;
	ResponderTicket ct;
	GenerarTicket gt;
	ListaAdminTickets lta;
	int idAdmin;
	int idCaso=0;
	public ListaAdminticketController(ModeloLogica modelo, ListaAdminTickets lta){
		this.modelo = modelo;
		this.lta = lta;
	}
	 @Override
	    public void mouseClicked(MouseEvent me) {
	
	           String idadmin = lta.ObtenerIDAdmin();
	           idAdmin = Integer.parseInt(idadmin);
					lta.getList_1().setVisible(true);
					lta.getLblListaDeCasos().setVisible(true);
					lta.elementosJLIST2(idAdmin);
					lta.getBtnNewButton_1().setVisible(true);
						
	          
	    }
	@Override
	public void actionPerformed(ActionEvent eve) {
		String nombre = eve.getActionCommand();

		if (nombre.equals("Aceptar")) {
			ct = new ResponderTicket();
			ct.setVisible(true);
			ct.getTextField().setText(lta.ObtenerID());
			ct.getTextField_1().setText(lta.ObtenerAsunto());
			ct.getTextField_2().setText(lta.ObtenerIDAdmin());
			for (Ticket t : modelo.CargarDatosTicketsPendientes(Integer.parseInt(lta.ObtenerID()))) {
				ct.getTextField_3().setText(t.getAsunto());
				ct.getTextField_5().setText(t.getFecha());
				ct.getTextField_4().setText(t.getDesc());

			}
			ct.getTextField().setEditable(false);
			ct.getTextField_1().setEditable(false);
			ct.getTextField_2().setEditable(false);
			ct.getTextField_3().setEditable(false);
			ct.getTextField_4().setEditable(false);
			ct.getTextField_5().setEditable(false);
		}
		if (nombre.equals("Seleccionar caso")) {
			
			 idCaso =Integer.parseInt(lta.ObtenerAsunto());
			 lta.getList_2().setVisible(true);
				lta.getLblListaDe().setVisible(true);
			lta.elementosJLIST3(idCaso);
		}
	}
	 public ArrayList<Ticket> getListaAdminPendientes() {
	        return modelo.CargarDatosAdminPendientes(); 
	    }
	 public ArrayList<Ticket> getListaCasosPendientes(int idamin) {
	        return modelo.CargarDatosPendientes(idamin); 
	    }
	 public ArrayList<Ticket> getListaTicketsPendientes(int idcaso) {
	        return modelo.CargarDatosTicketsP(idcaso);
	    }
}
