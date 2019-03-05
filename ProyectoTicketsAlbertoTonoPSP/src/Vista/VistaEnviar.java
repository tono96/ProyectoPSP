package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.EnviarControlador;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VistaEnviar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	EnviarControlador listener = new EnviarControlador(this);
	/**
	 * Create the frame.
	 */
	public VistaEnviar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(147, 36, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 97, 226, 81);
		panel.add(textField_1);
	
		btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(listener);
		btnNewButton.setBounds(56, 191, 116, 38);
		panel.add(btnNewButton);
		
		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(97, 39, 44, 16);
		panel.add(lblAsunto);
		
		JLabel lblMensaje = new JLabel("Mensaje");
		lblMensaje.setBounds(70, 68, 56, 16);
		panel.add(lblMensaje);
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
}
