package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.LeerTickerRControlador;
import Controlador.ListaTicketsControlador;
import Modelo.ModeloLogica;
import Modelo.Ticket;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ListaTickets extends JFrame {

	private JPanel contentPane;
	private JList list;
	ModeloLogica ml =  new ModeloLogica();
	ListaTicketsControlador listener =  new ListaTicketsControlador(ml, this);
	private JList list_1;
	JLabel lblListaDeTickets;
	/**
	 * Create the frame.
	 */
	public ListaTickets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 447, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblListaDeCasos = new JLabel("LISTA DE CASOS");
		lblListaDeCasos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblListaDeCasos.setBounds(42, 13, 167, 38);
		panel.add(lblListaDeCasos);
		
		JButton btnNewButton = new JButton("Consultar ticket");
		btnNewButton.addActionListener(listener);
		btnNewButton.setBounds(294, 215, 141, 25);
		panel.add(btnNewButton);
		
		lblListaDeTickets = new JLabel("LISTA DE TICKETS");
		lblListaDeTickets.setVisible(false);
		lblListaDeTickets.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblListaDeTickets.setBounds(196, 13, 167, 38);
		panel.add(lblListaDeTickets);
		
		JButton btnCrearTicket = new JButton("Crear Ticket");
		btnCrearTicket.addActionListener(listener);
		btnCrearTicket.setBounds(294, 177, 141, 25);
		panel.add(btnCrearTicket);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 62, 69, 161);
		panel.add(scrollPane);
		
		 list = new JList();
		 scrollPane.setViewportView(list);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(178, 61, 92, 159);
		 panel.add(scrollPane_1);
		 
		 list_1 = new JList();
		 scrollPane_1.setViewportView(list_1);
		 list_1.setVisible(false);
		 list.addMouseListener(listener);
	}
	 public void elementosJLIST() {
		 ArrayList<Ticket> listaTickets = listener.getListaTicketsCasos();  
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
	public JList getList_1() {
		return list_1;
	}
	public void setList_1(JList list_1) {
		this.list_1 = list_1;
	}
	public JLabel getLblListaDeTickets() {
		return lblListaDeTickets;
	}
	public void setLblListaDeTickets(JLabel lblListaDeTickets) {
		this.lblListaDeTickets = lblListaDeTickets;
	}
}
