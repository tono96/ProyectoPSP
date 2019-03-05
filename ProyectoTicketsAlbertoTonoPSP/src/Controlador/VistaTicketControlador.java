package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;

import javax.mail.Session;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;

import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import Modelo.ModeloLogica;
import Vista.GenerarTicket;
import Vista.ListaTickets;
import Vista.VistaEnviar;
import Vista.VistaRecibir;
import Vista.VistaTickets;
/**
 * Clase que controla la vista principal del admin reserva
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */
public class VistaTicketControlador implements ActionListener {
	VistaTickets vt;
	GenerarTicket gt;
	ListaTickets lt;
	ModeloLogica modelo;

	// DATOS DEL SERVIDOR al que enviar mensaje
	
    private static DatagramSocket clientSocket;

    
    public void abrirSocket() throws SocketException{   	
    	 clientSocket = new DatagramSocket();
    } 
    
    public DatagramSocket getDatagramSocket(){
    	return clientSocket;
    }
    
	public VistaTicketControlador(ModeloLogica m,VistaTickets vt){
		this.modelo =m;
		this.vt=vt;
	}
	@Override
	public void actionPerformed(ActionEvent eve) {
		
		String nombre = eve.getActionCommand();
		if (nombre.equals("Generar Ticket")) {
			gt = new GenerarTicket(modelo);
			vt.setVisible(false);
			gt.setVisible(true);
		}
		if (nombre.equals("Leer Ticket")) {
			lt =  new ListaTickets();
			vt.setVisible(false);
			lt.setVisible(true);
			lt.elementosJLIST();
		}
		if (nombre.equals("Enviar Email")) {
			VistaEnviar ve = new VistaEnviar();
			ve.setVisible(true);
			    
			}
		if (nombre.equals("Recibir Email")) {
			VistaRecibir vr = new VistaRecibir();
			vr.setVisible(true);
			String server = "pop.gmail.com", username = "pruebaalbertotono@gmail.com", password = "147258asd147258";
			int puerto = 995;
			POP3SClient pop3 = new POP3SClient(true);
			try {
				pop3.connect(server, puerto);
				System.out.println("Conexion realizada "+ server);
				if(!pop3.login(username, password)) {
					System.out.println("error login");
				}else {
					POP3MessageInfo[] men = pop3.listMessages();
					vr.getTextField().setText("Nº de mensajes : " +men.length);
					for(int i=0; i<men.length; i++) {
						System.out.println("Mensaje: " + (i+1));
						POP3MessageInfo msginfo =  men[i];
						//System.out.println("IDentificador: "+ msginfo.identifier + " Number; " + msginfo.number + " Tamaño: " + msginfo.size);
						POP3MessageInfo pmi =  pop3.listUniqueIdentifier(i+1);
						//System.out.println("IDentificador: "+ pmi.identifier + " Number: " + pmi.number + " Tamaño: " + pmi.size);
						//BufferedReader reader = (BufferedReader)pop3.retrieveMessageTop(msginfo.number,0);
					 BufferedReader reader = (BufferedReader)pop3.retrieveMessage(msginfo.number);
						String linea;
						while ((linea = reader.readLine())!=null)
							vr.getTextPane().setText(linea.toString()+"\n");
						reader.close();
					}
				
					pop3.logout();
					pop3.disconnect();
				}
			}catch (IOException e){
				System.out.println(e.getMessage());
			}
				    
				}

			
		}
		
	
}