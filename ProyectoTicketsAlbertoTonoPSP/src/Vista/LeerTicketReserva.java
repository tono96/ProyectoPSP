package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controlador.LeerTickerRControlador;
import Modelo.ModeloLogica;
import Modelo.Ticket;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class LeerTicketReserva extends JFrame {

	private JPanel contentPane;
	ModeloLogica ml =  new ModeloLogica();
	//private DefaultListModel model =  new DefaultListModel();
	JList list;
	JList list_1; 
	LeerTickerRControlador listener =  new LeerTickerRControlador(ml, this);
    
	public LeerTicketReserva() {
		
		setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
		list.addMouseListener(listener);
		list.setBounds(45, 79, 52, 171);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Lista de casos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(110, -11, 233, 56);
		contentPane.add(lblNewLabel);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(listener);
		btnAceptar.setBounds(320, 227, 89, 23);
		contentPane.add(btnAceptar);
		
	
		
		
		JLabel lblIdCasos = new JLabel("Id casos");
		lblIdCasos.setBounds(45, 54, 52, 14);
		contentPane.add(lblIdCasos);
		
		JLabel lblAsuntosTicket = new JLabel("Asuntos ticket");
		lblAsuntosTicket.setBounds(188, 56, 82, 14);
		contentPane.add(lblAsuntosTicket);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(186, 83, 84, 156);
		contentPane.add(scrollPane);
		list_1 = new JList();
		scrollPane.setViewportView(list_1);
	}
	 
	 public void elementosJLIST() {
		 ArrayList<Ticket> listaTickets = listener.getListaCasosAbiertos();  
		
	       DefaultListModel lista = new DefaultListModel();
	        if (listaTickets != null) {
	            for (int i = 0; i < listaTickets.size(); i++) {
	                lista.addElement(listaTickets.get(i).getId_Caso()); 
	            }
	            list.setModel(lista);
	        } else {
	            JOptionPane.showMessageDialog(null, "Error SQL producido a la hora de cargar la lista de id de Casos", "Error SQL", JOptionPane.ERROR_MESSAGE);
	        }
	    } 
	 public String ObtenerIDCaso() {
	        return list.getSelectedValue().toString();  
	    }
	 public void elementosJLIST2(int id_caso) {
		 ArrayList<Ticket> listacasos =  listener.getListaCasos(id_caso);    
		 DefaultListModel lista2 = new DefaultListModel();  
	        if (listacasos != null) {
	        	for (int i = 0; i < listacasos.size(); i++) {
	                lista2.addElement(listacasos.get(i).getId() + " | " +listacasos.get(i).getAsunto()); 
	             
	            }
	            list_1.setModel(lista2);  
	        } else {
	            JOptionPane.showMessageDialog(null, "Error SQL producido a la hora de cargar la lista de Asuntos", "Error SQL", JOptionPane.ERROR_MESSAGE);
	        }
	    } 
	 public String ObtenerAsunto() {
	        return list_1.getSelectedValue().toString();        
	    }
}
