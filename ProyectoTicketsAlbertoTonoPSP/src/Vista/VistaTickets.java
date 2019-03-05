package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.VistaTicketControlador;
import Modelo.ModeloLogica;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * Aquí se ejecuta el administrador de reservas
 */
public class VistaTickets extends JFrame {	
	private JPanel contentPane;
	ModeloLogica m;
	public VistaTickets(ModeloLogica m) {
        this.m = m;
        inic();

    }

    /**
     * Metodo usado para iniciar todos los elementos de la vista
     */
    public void inic() {
    	VistaTicketControlador listener = new VistaTicketControlador(m, this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 502, 274);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Generar Ticket");
		btnNewButton.addActionListener(listener);
		btnNewButton.setBounds(40, 116, 167, 54);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Leer Ticket");
		button.addActionListener(listener);
		button.setBounds(271, 116, 167, 54);
		panel.add(button);
		
		JLabel lblqueAccinDesea = new JLabel("\u00BFQue acci\u00F3n desea realizar?");
		lblqueAccinDesea.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblqueAccinDesea.setBounds(96, 33, 331, 61);
		panel.add(lblqueAccinDesea);
		
		JButton BtnEnviar = new JButton("Enviar Email");
		BtnEnviar.addActionListener(listener);
		BtnEnviar.setBounds(40, 201, 159, 60);
		panel.add(BtnEnviar);
		
		JButton btnRecibirEmail = new JButton("Recibir Email");
		btnRecibirEmail.addActionListener(listener);
		btnRecibirEmail.setBounds(271, 201, 159, 60);
		panel.add(btnRecibirEmail);
	}
}
