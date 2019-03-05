package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.ModeloLogica;
import Vista.ResponderTicket;

public class ResponderTicketcontroller implements ActionListener{
	ResponderTicket rt;
	ModeloLogica modelo;
	
	public ResponderTicketcontroller(ModeloLogica modelo, ResponderTicket rt){
		this.modelo = modelo;
		this.rt = rt;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent eve) {
		
		String nombre = eve.getActionCommand();
		if (nombre.equals("OK")) {
			String respuesta = rt.getEditorPane().getText();
			int id = Integer.parseInt(rt.getTextField().getText());
			int idcaso = Integer.parseInt(rt.getTextField_1().getText());	
	

			modelo.Responder(respuesta, id, idcaso);
			rt.setVisible(false);
		}if (nombre.equals("Cancelar")) {
			
		}
		
	}
}
