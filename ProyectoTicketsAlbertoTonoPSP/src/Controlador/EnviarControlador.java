package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.swing.JOptionPane;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import Vista.VistaEnviar;

public class EnviarControlador implements ActionListener{
	VistaEnviar ve;
	
	public EnviarControlador(VistaEnviar ve) {
		this.ve = ve;
		
	}
	@Override
	public void actionPerformed(ActionEvent eve) {
		String nombre = eve.getActionCommand();
		if (nombre.equals("Enviar")) {
			 AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();
			  try {
					startTls(client);
				} catch (UnrecoverableKeyException | InvalidKeyException | KeyStoreException | NoSuchAlgorithmException
						| InvalidKeySpecException | IOException e) {
					e.printStackTrace();
				}
		}
	}
	private void startTls(final AuthenticatingSMTPClient client) throws SSLException, IOException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
		

		// datos del usuario y del servidor
		String server = "smtp.gmail.com";
		String username = "pruebaalbertotono@gmail.com";
		String password = "147258asd147258";
		int puerto = 587;
		String remitente = "no_reply@agencia.com";

		try {
			int respuesta;

			// Creación de la clave para establecer un canal seguro
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(null, null);
			KeyManager km = kmf.getKeyManagers()[0];

			// nos conectamos al servidor SMTP
			client.connect(server, puerto);
			// se establece la clave para la comunicación segura
			client.setKeyManager(km);

			respuesta = client.getReplyCode();
			if (!SMTPReply.isPositiveCompletion(respuesta)) {
				client.disconnect();
				System.err.println("CONEXIÓN RECHAZADA.");
				System.exit(1);
			}

			// se envía el commando EHLO
			client.ehlo(server);// necesario


			// NECESITA NEGOCIACIÓN TLS - MODO NO IMPLICITO
			// Se ejecuta el comando STARTTLS y se comprueba si es true
			if (client.execTLS()) {
				
				// se realiza la autenticación con el servidor
				if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, password)) {
					String destino1 = "pruebaalbertotono@gmail.com";
					String asunto = ve.getTextField().getText();
					String mensaje = ve.getTextField_1().getText();
					// se crea la cabecera
					SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destino1, asunto);

					// el nombre de usuario y el email de origen coinciden
					client.setSender(remitente);
					client.addRecipient(destino1);
				
					// se envia DATA
					Writer writer = client.sendMessageData();
					if (writer == null) { // fallo
						System.out.println("FALLO AL ENVIAR DATA.");
						System.exit(1);
					}

					writer.write(cabecera.toString()); // cabecera
					writer.write(mensaje);// luego mensaje
					writer.close();
				
					boolean exito = client.completePendingCommand();
					
					if (!exito) { // fallo d
						System.out.println("FALLO AL FINALIZAR TRANSACCIÓN.");
						System.exit(1);
					} else				
					JOptionPane.showMessageDialog(null, "MENSAJE ENVIADO CON EXITO.");
				} else
					System.out.println("USUARIO NO AUTENTICADO.");
			} else
				System.out.println("FALLO AL EJECUTAR  STARTTLS.");

		} catch (IOException e) {
			System.err.println("Could not connect to server.");
			e.printStackTrace();
			System.exit(1);
		}
		try {
			client.disconnect();
		} catch (IOException f) {
			f.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Fin de envío");
		ve.setVisible(false);
	}
}
