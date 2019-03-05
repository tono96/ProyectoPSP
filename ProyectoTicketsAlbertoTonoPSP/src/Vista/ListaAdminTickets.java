package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ListaAdminticketController;
import Modelo.ModeloLogica;
import Modelo.Ticket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListaAdminTickets extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JList list_1;
	private JList list_2;
	private JLabel lblListaDeCasos;
	private JLabel lblNewLabel;
	private JLabel lblListaDe; 
	ModeloLogica modelo =  new ModeloLogica();
	ListaAdminticketController listener = new ListaAdminticketController(modelo, this);
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	/**
	 * Create the frame.
	 */
	public ListaAdminTickets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Tickets pendientes");
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 503, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 lblNewLabel = new JLabel("Lista Administradores");
		lblNewLabel.setBounds(46, 22, 113, 18);
		panel.add(lblNewLabel);
		
		 lblListaDeCasos = new JLabel("Lista de Casos");
		lblListaDeCasos.setVisible(false);
		lblListaDeCasos.setBounds(179, 22, 74, 18);
		panel.add(lblListaDeCasos);
		
		lblListaDe = new JLabel("Lista de Tickets");
		lblListaDe.setVisible(false);
		lblListaDe.setBounds(292, 22, 82, 18);
		panel.add(lblListaDe);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(listener);
		btnNewButton.setBounds(393, 250, 100, 26);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Seleccionar caso");
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(listener);
		btnNewButton_1.setBounds(235, 250, 139, 26);
		panel.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 50, 65, 188);
		panel.add(scrollPane);
		
		 list = new JList();
		 scrollPane.setViewportView(list);
		 
		 scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(184, 53, 69, 186);
		 panel.add(scrollPane_1);
		 
		  list_1 = new JList();
		  scrollPane_1.setViewportView(list_1);
		  
		  JScrollPane scrollPane_2 = new JScrollPane();
		  scrollPane_2.setBounds(302, 53, 94, 188);
		  panel.add(scrollPane_2);
		  
		  list_2 = new JList();
		  scrollPane_2.setViewportView(list_2);
		  list_2.addMouseListener(listener);
		  list_2.setVisible(false);
		  
		  list_1.setVisible(false);
		 list.addMouseListener(listener);
	}
	
	public JList getList() {
		return list;
	}
	public void setList(JList list) {
		this.list = list;
	}
	public JList getList_1() {
		return list_1;
	}
	public void setList_1(JList list_1) {
		this.list_1 = list_1;
	}
	public JList getList_2() {
		return list_2;
	}
	public void setList_2(JList list_2) {
		this.list_2 = list_2;
	}
	public ModeloLogica getModelo() {
		return modelo;
	}
	public void setModelo(ModeloLogica modelo) {
		this.modelo = modelo;
	}
	public ListaAdminticketController getListener() {
		return listener;
	}
	public void setListener(ListaAdminticketController listener) {
		this.listener = listener;
	}
	
	public JLabel getLblListaDeCasos() {
		return lblListaDeCasos;
	}
	public void setLblListaDeCasos(JLabel lblListaDeCasos) {
		this.lblListaDeCasos = lblListaDeCasos;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}
	public JLabel getLblListaDe() {
		return lblListaDe;
	}
	public void setLblListaDe(JLabel lblListaDe) {
		this.lblListaDe = lblListaDe;
	}
	
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	public void elementosJLIST() {
		 ArrayList<Ticket> listaTickets = listener.getListaAdminPendientes();
	
	       DefaultListModel lista = new DefaultListModel();
	        if (listaTickets != null) {
	            for (int i = 0; i < listaTickets.size(); i++) {
	                lista.addElement(listaTickets.get(i).getId_Admin()); 
	            }
	            list.setModel(lista);
	        } else {
	            JOptionPane.showMessageDialog(null, "Error SQL producido a la hora de cargar la lista de id de Casos", "Error SQL", JOptionPane.ERROR_MESSAGE);
	        }
	    } 
	 public String ObtenerIDAdmin() {
	        return list.getSelectedValue().toString();  
	    }
	 public void elementosJLIST2(int id_admin) {
		 ArrayList<Ticket> listacasos =  listener.getListaCasosPendientes(id_admin);  
		 DefaultListModel lista2 = new DefaultListModel();  
	        if (listacasos != null) {
	        	for (int i = 0; i < listacasos.size(); i++) {
	                lista2.addElement(listacasos.get(i).getId_Caso()); 	       
	            }
	            list_1.setModel(lista2);  
	        } else {
	            JOptionPane.showMessageDialog(null, "Error SQL producido a la hora de cargar la lista de Asuntos", "Error SQL", JOptionPane.ERROR_MESSAGE);
	        }
	    } 
	 public String ObtenerAsunto() {
	        return list_1.getSelectedValue().toString();        
	    }
	 public void elementosJLIST3(int idcaso) {
		 ArrayList<Ticket> listacasos =  listener.getListaTicketsPendientes(idcaso);
		 DefaultListModel lista2 = new DefaultListModel();  
	        if (listacasos != null) {
	        	for (int i = 0; i < listacasos.size(); i++) {
	                lista2.addElement(listacasos.get(i).getId());          
	            }
	            list_2.setModel(lista2);  
	        } else {
	            JOptionPane.showMessageDialog(null, "Error SQL producido a la hora de cargar la lista de Asuntos", "Error SQL", JOptionPane.ERROR_MESSAGE);
	        }
	    } 
	 public String ObtenerID() {
	        return list_2.getSelectedValue().toString();        
	    }
}
