package Main;

import Modelo.ModeloLogica;
import Vista.CrearTicket;
import Vista.VistaTickets;
/**
 * Main que crea un modelo e incia la vista ticket
 * @author Alberto Serrano y Antonio Ramayo
 * @version 26/2/2019
 */

public class Main {
	
	public static void main(String[] args) {
		//Creo el modelo
		ModeloLogica m = new ModeloLogica();
		//Creo la vista
		VistaTickets vt = new VistaTickets(m);
		//Muestro la vista
		vt.setVisible(true);
	}
}
