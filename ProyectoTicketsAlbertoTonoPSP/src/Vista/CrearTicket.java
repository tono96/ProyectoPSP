package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.CrearTicketController;
import Modelo.ModeloLogica;

public class CrearTicket extends JDialog implements Runnable {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblIdAdmin;
	private JLabel lblAsunto;
	private JTextField textField_3;
	private JLabel lblDescripcion;
	private JTextField textField_4;
	private JLabel lblPrioridad;
	private JRadioButton rdbtnAbierto;
	private JRadioButton rdbtnCerrado;
	private JRadioButton rdbtnBaja;
	private JRadioButton rdbtnMedia;
	private JRadioButton rdbtnAlta;
	private JLabel lblFecha;
	private JTextField textField_5;
	private ButtonGroup grupo1;
	private ButtonGroup grupo2;
	ModeloLogica m;
	CrearTicketController listener;
	static MulticastSocket ms = null;
	static byte[] buf = new byte[1000];
	static InetAddress grupo = null;
	static int Puerto = 12345;// Puerto multicast
	 public CrearTicket(ModeloLogica m) {
	        this.m = m;
	        initComponents();
	        
	    }
	public void  initComponents(){
		 setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);		
		 setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		System.out.println("Cliente Iniciado");
		 try {
			listener =  new CrearTicketController(m, this);
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
		JLabel lblNTickets = new JLabel("N\u00BA Tickets");
		lblNTickets.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNTickets.setBounds(10, 11, 63, 18);
		contentPane.add(lblNTickets);

		textField = new JTextField();
		textField.setBounds(10, 29, 71, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 29, 82, 20);
		contentPane.add(textField_1);

		JLabel lblNCaso = new JLabel("N\u00BA Caso");
		lblNCaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNCaso.setBounds(91, 13, 56, 14);
		contentPane.add(lblNCaso);

		textField_2 = new JTextField();
		textField_2.setBounds(183, 29, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		lblIdAdmin = new JLabel("ID Admin");
		lblIdAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdAdmin.setBounds(183, 14, 56, 14);
		contentPane.add(lblIdAdmin);

		lblAsunto = new JLabel("Asunto:");
		lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAsunto.setBounds(10, 71, 43, 18);
		contentPane.add(lblAsunto);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(58, 71, 110, 20);
		contentPane.add(textField_3);

		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescripcion.setBounds(183, 74, 71, 18);
		contentPane.add(lblDescripcion);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(254, 71, 170, 111);
		contentPane.add(textField_4);

		rdbtnAbierto = new JRadioButton("Abierto");
		rdbtnAbierto.setBounds(10, 176, 109, 23);
		contentPane.add(rdbtnAbierto);

		rdbtnCerrado = new JRadioButton("Cerrado");
		rdbtnCerrado.setBounds(10, 202, 109, 23);
		contentPane.add(rdbtnCerrado);

		 grupo1 = new ButtonGroup();
		grupo1.add(rdbtnAbierto);
		grupo1.add(rdbtnCerrado);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(10, 151, 63, 18);
		contentPane.add(lblEstado);

		lblPrioridad = new JLabel("Prioridad");
		lblPrioridad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrioridad.setBounds(116, 151, 63, 18);
		contentPane.add(lblPrioridad);

		rdbtnBaja = new JRadioButton("Baja");
		rdbtnBaja.setBounds(116, 176, 109, 23);
		contentPane.add(rdbtnBaja);

		rdbtnMedia = new JRadioButton("Media");
		rdbtnMedia.setBounds(116, 202, 109, 23);
		contentPane.add(rdbtnMedia);

		rdbtnAlta = new JRadioButton("Alta");
		rdbtnAlta.setBounds(116, 228, 109, 23);
		contentPane.add(rdbtnAlta);

		 grupo2 = new ButtonGroup();
		grupo2.add(rdbtnAlta);
		grupo2.add(rdbtnMedia);
		grupo2.add(rdbtnBaja);

		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBounds(56, 117, 63, 18);
		contentPane.add(lblFecha);

		textField_5 = new JTextField();
		textField_5.setBounds(101, 117, 110, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(239, 228, 89, 23);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 228, 89, 23);
		contentPane.add(btnCancelar);

		btnAceptar.addActionListener(listener);
		btnCancelar.addActionListener(listener);
		rdbtnAlta.addActionListener(listener);
		rdbtnBaja.addActionListener(listener);
		rdbtnMedia.addActionListener(listener);
		rdbtnAbierto.addActionListener(listener);
		rdbtnCerrado.addActionListener(listener);
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

	public JLabel getLblIdAdmin() {
		return lblIdAdmin;
	}

	public void setLblIdAdmin(JLabel lblIdAdmin) {
		this.lblIdAdmin = lblIdAdmin;
	}

	public JLabel getLblAsunto() {
		return lblAsunto;
	}

	public void setLblAsunto(JLabel lblAsunto) {
		this.lblAsunto = lblAsunto;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JLabel getLblDescripcion() {
		return lblDescripcion;
	}

	public void setLblDescripcion(JLabel lblDescripcion) {
		this.lblDescripcion = lblDescripcion;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JLabel getLblPrioridad() {
		return lblPrioridad;
	}

	public void setLblPrioridad(JLabel lblPrioridad) {
		this.lblPrioridad = lblPrioridad;
	}

	public JRadioButton getRdbtnAbierto() {
		return rdbtnAbierto;
	}

	public void setRdbtnAbierto(JRadioButton rdbtnAbierto) {
		this.rdbtnAbierto = rdbtnAbierto;
	}

	public JRadioButton getRdbtnCerrado() {
		return rdbtnCerrado;
	}

	public void setRdbtnCerrado(JRadioButton rdbtnCerrado) {
		this.rdbtnCerrado = rdbtnCerrado;
	}

	public JRadioButton getRdbtnBaja() {
		return rdbtnBaja;
	}

	public void setRdbtnBaja(JRadioButton rdbtnBaja) {
		this.rdbtnBaja = rdbtnBaja;
	}

	public JRadioButton getRdbtnMedia() {
		return rdbtnMedia;
	}

	public void setRdbtnMedia(JRadioButton rdbtnMedia) {
		this.rdbtnMedia = rdbtnMedia;
	}

	public JRadioButton getRdbtnAlta() {
		return rdbtnAlta;
	}

	public void setRdbtnAlta(JRadioButton rdbtnAlta) {
		this.rdbtnAlta = rdbtnAlta;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}
	public void run() {	
		 
				try {
				    ms = new MulticastSocket(Puerto);
					DatagramPacket p = new DatagramPacket(buf, buf.length);
					ms.receive(p);
				}catch (SocketException s) {
					System.out.println(s.getMessage());
				} catch (IOException e) {
					e.printStackTrace();
				}
				 
		}// run
	 public String Prioridad() {
		 rdbtnAlta.setActionCommand("Alta");
	     rdbtnBaja.setActionCommand("Baja");
	     rdbtnMedia.setActionCommand("Media");
	        return String.valueOf(grupo2.getSelection().getActionCommand());
	    }
	 public String Estado() {
		 rdbtnAbierto.setActionCommand("Abierto");
	     rdbtnCerrado.setActionCommand("Cerrado");
	     
	        return String.valueOf(grupo1.getSelection().getActionCommand());
	    }
	 
}
