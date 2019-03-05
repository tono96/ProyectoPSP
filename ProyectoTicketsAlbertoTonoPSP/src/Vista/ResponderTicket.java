package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ResponderTicketcontroller;
import Modelo.ModeloLogica;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;

public class ResponderTicket extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JEditorPane editorPane; 

	public ResponderTicket() {
		setBounds(100, 100, 533, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		ModeloLogica modelo = new ModeloLogica();
		ResponderTicketcontroller listener = new ResponderTicketcontroller(modelo, this);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 515, 282);
		contentPanel.add(panel);
		
		JLabel label = new JLabel("N\u00BA Tickets");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 11, 63, 18);
		panel.add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(10, 29, 71, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 29, 82, 20);
		panel.add(textField_1);
		
		JLabel label_1 = new JLabel("N\u00BA Caso");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(91, 13, 56, 14);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(183, 29, 86, 20);
		panel.add(textField_2);
		
		JLabel label_2 = new JLabel("ID Admin");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(183, 14, 56, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Asunto:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(20, 57, 43, 18);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(65, 56, 110, 20);
		panel.add(textField_3);
		
		JLabel label_4 = new JLabel("Descripcion:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(281, 11, 71, 18);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(360, 11, 143, 111);
		panel.add(textField_4);
		
		JLabel label_7 = new JLabel("Fecha");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(193, 57, 46, 18);
		panel.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(242, 56, 110, 20);
		panel.add(textField_5);
		
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_4.setEditable(false);		
		textField_5.setEditable(false);
		
		JLabel lblRespuesta = new JLabel("Respuesta");
		lblRespuesta.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRespuesta.setBounds(20, 127, 110, 33);
		panel.add(lblRespuesta);
		
		 editorPane = new JEditorPane();
		editorPane.setBounds(10, 173, 493, 96);
		panel.add(editorPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(listener);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
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


	public JTextField getTextField_2() {
		return textField_2;
	}


	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}


	public JTextField getTextField_3() {
		return textField_3;
	}


	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}


	public JTextField getTextField_4() {
		return textField_4;
	}


	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}


	public JTextField getTextField_5() {
		return textField_5;
	}


	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}


	public JEditorPane getEditorPane() {
		return editorPane;
	}


	public void setEditorPane(JEditorPane editorPane) {
		this.editorPane = editorPane;
	}


	
}
