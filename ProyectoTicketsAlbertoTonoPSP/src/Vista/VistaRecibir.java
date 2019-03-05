package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class VistaRecibir extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;
	public VistaRecibir() {
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
		
		textField = new JTextField();
		textField.setBounds(178, 54, 203, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 100, 333, 131);
		panel.add(scrollPane);
		
		 textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JLabel lblMensajes = new JLabel("Mensajes");
		lblMensajes.setBounds(122, 57, 46, 14);
		panel.add(lblMensajes);
		
		JLabel lblInformacionMensaje = new JLabel("Informacion Mensaje");
		lblInformacionMensaje.setBounds(51, 75, 143, 14);
		panel.add(lblInformacionMensaje);
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JTextPane getTextPane() {
		return textPane;
	}
	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}
	
}
