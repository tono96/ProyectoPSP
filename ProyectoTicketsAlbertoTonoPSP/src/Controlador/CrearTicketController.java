package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Modelo.Administrador;
import Modelo.ModeloLogica;
import Modelo.Ticket;
import Vista.CrearTicket;
import Vista.GenerarTicket;
import Vista.Servidor;
import Vista.VistaTickets;
/**
 * Clase que controla el formulario para enviar tickets
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */
public class CrearTicketController implements ActionListener{
	CrearTicket ct;
	ModeloLogica modelo;
	 VistaTickets vt;
		static InetAddress grupo = null;
		static int Puerto = 12347;// Puerto 
		boolean repetir = true;
		private DatagramSocket clientSocket;
		private InetAddress IPAddress;
		VistaTicketControlador vtc;
		DatagramPacket packet = null;

	public CrearTicketController(DatagramSocket clientSocket, DatagramPacket packet) {
		this.clientSocket = clientSocket;
		this.packet = packet;
	
	}
	/**
	 * Es el contructor del controlador y recive la vista y el modelo
	 * @param modelo
	 * @param ct
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public CrearTicketController(ModeloLogica modelo, CrearTicket ct) throws SocketException, UnknownHostException {
		this.ct = ct;
		this.modelo = modelo;
		vt = new VistaTickets(modelo);
		IPAddress = InetAddress.getByName("localhost");
		vtc = new VistaTicketControlador(modelo, vt);
		clientSocket = new DatagramSocket();
		System.out.println(clientSocket.getLocalPort());
	}
/**
 *  Metodo que que le da funcionalidad a los botones
 */
	@Override
	public void actionPerformed(ActionEvent eve) {
		
		String nombre = eve.getActionCommand();
		if (nombre.equals("Aceptar")) {
			enviar();
			ct.setVisible(false);
		}if (nombre.equals("Cancelar")) {
			ct.setVisible(false);
		}
		
	}
	/**
	 * Metodo que se usa para enviar el ticket a traves del socket UDP
	 */
	  public void enviar() {
		  try {	
		 //puerto por el que escucha
				int id_Caso = modelo.code()+1;
				int id = Integer.parseInt(ct.getTextField().getText());
				int id_Admin = Integer.parseInt(ct.getTextField_2().getText());
				Administrador admin = new Administrador(id_Admin);
				Calendar c = Calendar.getInstance();
				String dia = Integer.toString(c.get(Calendar.DATE));
				int mes =c.get(Calendar.MONTH);
				String annio = Integer.toString(c.get(Calendar.YEAR));
				String fecha = "" + dia + "/" + mes + 1 + "/" + annio;
				String asunto = ct.getTextField_3().getText();
				String prio = ct.Prioridad();
				String desc = ct.getTextField_4().getText();
				String estado;
				 if(ct.Estado()=="Abierto") {
					 estado="Pendiente";
				 }else {
					 estado = ct.Estado();
				 }
				Ticket t = new Ticket(id, id_Caso, id_Admin, fecha, asunto, prio, desc, estado);		
		  ByteArrayOutputStream bs = new ByteArrayOutputStream();
          ObjectOutputStream ob = new ObjectOutputStream(bs);
          ob.writeObject(t);
          ob.close();	  
          byte[] ticketParaEnviar = bs.toByteArray();	           
		  DatagramPacket envio = new DatagramPacket(ticketParaEnviar, ticketParaEnviar.length, IPAddress, 12345);
		  System.out.println(envio);
		  System.out.println(clientSocket);
	      clientSocket.send(envio);   
	      clientSocket.close(); 
	  } catch (UnknownHostException ex) {
          System.out.println("Error eviarUDP" + ex);
      } catch (IOException ex) {
      	ex.printStackTrace();
      }
	    }
}
