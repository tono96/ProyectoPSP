package Vista; 

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.AdminSistemasController;
import Modelo.ModeloLogica;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminSistemas extends JFrame {

	private JPanel contentPane;
	ModeloLogica modelo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminSistemas frame = new adminSistemas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adminSistemas() {
		AdminSistemasController listener = new AdminSistemasController(modelo, this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Responder Ticket");
		btnNewButton.addActionListener(listener);
		btnNewButton.setBounds(24, 108, 156, 57);
		panel.add(btnNewButton);
		
		JButton btnLeerTicket = new JButton("Leer Ticket");
		btnLeerTicket.addActionListener(listener);
		btnLeerTicket.setBounds(226, 108, 156, 57);
		panel.add(btnLeerTicket);
	}
}
