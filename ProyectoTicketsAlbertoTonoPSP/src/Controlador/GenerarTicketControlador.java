package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import Modelo.ModeloLogica;
import Modelo.Ticket;
import Vista.CrearTicket;
import Vista.GenerarTicket;
import Vista.LeerTicketReserva;
/**
 * Clase que controla la vista para continuar las vistas
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */
public class GenerarTicketControlador implements ActionListener {
	GenerarTicket gt;
	LeerTicketReserva ltr;
	CrearTicket ct;
	Ticket t;
	ModeloLogica modelo;
	public GenerarTicketControlador(ModeloLogica m,GenerarTicket gt) {
		this.gt = gt;
		this.modelo = m;
		
	}

	public void actionPerformed(ActionEvent eve) {

		String nombre = eve.getActionCommand();
		if (nombre.equals("Continuar caso")) {
			ltr = new LeerTicketReserva();
			gt.setVisible(false);
			ltr.setVisible(true);
			ltr.elementosJLIST();
		}else if (nombre.equals("Crear caso")) {	
			ct = new CrearTicket(modelo);
			ct.setVisible(true);	
			ct.getTextField_1().setEditable(false);
			ct.getTextField_5().setEditable(false);
			Calendar c = Calendar.getInstance();
			String dia = Integer.toString(c.get(Calendar.DATE));
			int mes = c.get(Calendar.MONTH);
			String annio = Integer.toString(c.get(Calendar.YEAR));
			String fecha = ""+dia+"/"+(mes+1)+"/"+annio;
			ct.getTextField_5().setText(fecha);
			ct.getTextField_1().setText(Integer.toString(modelo.code()+1));
			ct.getTextField().setEditable(false);
			int rnd = (int) (Math.random()*100);
			if(modelo.ComprobarID(rnd, (modelo.code()+1))) {
				ct.getTextField().setText(Integer.toString(rnd));
			}else {
				int rnd2 = (int) (Math.random()*100);
				ct.getTextField().setText(Integer.toString(rnd2));
			}
			
			
		}
	}
}
