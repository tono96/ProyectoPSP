package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Modelo.ModeloLogica;
import Modelo.Ticket;
import Vista.CrearTicket;
import Vista.GenerarTicket;
import Vista.LeerTicketReserva;
import Vista.ListaTickets;
/**
 * Clase que controla las listas del los tickets
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */ 
public class ListaTicketsControlador extends MouseAdapter implements ActionListener{
	
	ModeloLogica modelo;
	ListaTickets ltr;
	CrearTicket ct;
	GenerarTicket gt;
	int idCaso;
	boolean abierto;
	
	public ListaTicketsControlador(ModeloLogica modelo, ListaTickets ltr){
		this.modelo = modelo;
		this.ltr = ltr;
	}
	 @Override
	    public void mouseClicked(MouseEvent me) {
	           String idcaso = ltr.ObtenerIDCaso();
	           idCaso = Integer.parseInt(idcaso);
	           if(modelo.ComprobarAbierto(idCaso)) {
					abierto = true;
					ltr.getList_1().setVisible(true);
					ltr.getLblListaDeTickets().setVisible(true);
					ltr.elementosJLIST2(idCaso);
				}else {
					abierto = false;
					 JOptionPane.showMessageDialog(null, "El caso está cerrado", "Caso cerrado", JOptionPane.INFORMATION_MESSAGE);
				}
	          
	    }
	@Override
	public void actionPerformed(ActionEvent eve) {
		String nombre = eve.getActionCommand();
		if (nombre.equals("Consultar ticket")) {
			if (abierto) {
				ltr.setVisible(false);
				ct = new CrearTicket(modelo);
				ct.setVisible(true);
				ct.getTextField_1().setText(ltr.ObtenerIDCaso());

				for (Ticket t : modelo.CargarDatosTicketsPendientes(Integer.parseInt(ltr.ObtenerIDCaso()))) {
					ct.getTextField().setText(Integer.toString(t.getId()));
					ct.getTextField_2().setText(Integer.toString(t.getId_Admin()));
					ct.getTextField_3().setText(t.getAsunto());
					ct.getTextField_5().setText(t.getFecha());
					ct.getTextField_4().setText(t.getDesc());
					if(t.getEstado().equals("Abierto")) {
						ct.getRdbtnAbierto().setSelected(true);
					}else if(t.getEstado().equals("Cerrado")) {
						ct.getRdbtnCerrado().setSelected(true);
					}
					if(t.getPrio().equals("Alta")) {
						ct.getRdbtnAlta().setSelected(true);
					}else if
					(t.getPrio().equals("Media")) {
						ct.getRdbtnMedia().setSelected(true);
					}else if(t.getPrio().equals("Baja")) {
						ct.getRdbtnBaja().setSelected(true);
					}
					if(t.getRespuesta().length()==0) {
						
					}else {
						 JOptionPane.showMessageDialog(null, "El ticket ha sido respondido \n Respuesta: "+ t.getRespuesta());
					}	
					
				}
				ct.getTextField().setEditable(false);
				ct.getTextField_1().setEditable(false);
			}
		} else if (nombre.equals("Crear Ticket")) {
			ltr.setVisible(false);
			ct = new CrearTicket(modelo);
			ct.setVisible(true);
			ct.getTextField_1().setEditable(false);
			ct.getTextField_1().setText(ltr.ObtenerIDCaso());
		}
	}
	  public ArrayList<Ticket> getListaTicketsCasos() {
	        return modelo.CargarDatosCasos();
	    }
	  public ArrayList<Ticket> getListaCasos(int idCaso) { 
		  return modelo.CargarDatosTicketsPendientes(idCaso);
	        
	    }

}
