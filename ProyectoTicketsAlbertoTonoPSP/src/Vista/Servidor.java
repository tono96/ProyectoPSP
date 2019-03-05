package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CrearTicketController;
import Modelo.ModeloLogica;
import Modelo.Ticket;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Servidor extends JFrame implements Runnable{

	private JPanel contentPane;
	// private Cola cola;
	JTextArea textArea;
	Servidor s; 
	 DatagramSocket socket;
	 byte[] receiveBuffer = new byte[65535];
	 static InetAddress grupo = null;
	 ModeloLogica modelo;
	 int puerto = 14780;
	 DatagramPacket p; 
	 CrearTicketController ct;
	 CrearTicket ct1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
					/*ModeloLogica modelo = new ModeloLogica();
					 CrearTicket ct1 = new CrearTicket(modelo);
					CrearTicketController ct = null;*/
					new Thread(frame).start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 final PC pc = new PC(); 
		  
	        // Create producer thread 
	        Thread t1 = new Thread(new Runnable() 
	        { 
	            @Override
	            public void run() 
	            { 
	                try
	                { 
	                    pc.produce(); 
	                } 
	                catch(InterruptedException e) 
	                { 
	                    e.printStackTrace(); 
	                } 
	            } 
	        }); 
	  
	        // Create consumer thread 
	        Thread t2 = new Thread(new Runnable() 
	        { 
	            @Override
	            public void run() 
	            { 
	                try
	                { 
	                    pc.consume(); 
	                } 
	                catch(InterruptedException e) 
	                { 
	                    e.printStackTrace(); 
	                } 
	            } 
	        }); 
	  
	        // Start both threads 
	        t1.start(); 
	        t2.start(); 
	        try {
	        // t1 finishes before t2 
	        t1.join(); 
	       
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    } 
	

	/**
	 * Create the frame.
	 * @throws SocketException 
	 */
	public Servidor() throws SocketException {
		//cola = new Cola();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		modelo = new ModeloLogica();
		socket = new DatagramSocket(12345);
		p = new DatagramPacket(receiveBuffer, receiveBuffer.length);	
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 592, 353);
		contentPane.add(panel);
		panel.setLayout(null);
		textArea = new JTextArea();
		textArea.setBounds(12, 13, 568, 327);
		panel.add(textArea);
		textArea.setText("servidor iniciado en puerto "+socket.getLocalPort()+"------------");
	}
	@Override
	public void run() {
		while(true) {	
			try {	
			System.out.println("Entra");
			socket.receive(p); 
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveBuffer);
            ObjectInputStream in = new ObjectInputStream(bais);
			Ticket t = (Ticket) in.readObject();
			
		if(modelo.AddTicket(t)) {
			JOptionPane.showMessageDialog(
				    null, 
				    "Añadido a la base de datos", 
				    "Añadido",
				    JOptionPane.INFORMATION_MESSAGE); 
		}else {
			JOptionPane.showMessageDialog(
				    null, 
				    "ERROR AL AÑADIR A LA BASE DE DATOS", 
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE); 
		}
			textArea.setText("\nTicket recibido: "+ t.toString());	
			
			
			} catch (IOException e) {				
				System.out.println(e);			
			} catch (ClassNotFoundException e) {		
				e.printStackTrace();
			}
		}
		
	}
	 public static class PC {
		   	ModeloLogica modelo = new ModeloLogica(); 			
		    // Size of list is 2. 
		    LinkedList<Integer> list = new LinkedList<>(); 
		    
		    int capacity = modelo.CargarDatosAdminPendientes().size();
		    
		    // Function called by producer thread 
		    public void produce() throws InterruptedException { 
		    	System.out.println(capacity); 
		    	int value = modelo.ConatidAdmin(); 
		        while (true) 
		        { 
		            synchronized (this) 
		            { 
		            	 
		                // producer thread waits while list 
		                // is full 
		                while (list.size()==capacity) 
		                    wait(); 

		                System.out.println("Id Admin " + value); 

		                // to insert the jobs in the list 
		                list.add(value++); 

		                // notifies the consumer thread that 
		                // now it can start consuming 
		                notify(); 

		                // makes the working of program easier 
		                // to  understand 
		                Thread.sleep(1000); 
		            } 
		        } 
		    } 
		  
		        // Function called by consumer thread 
				public void consume() throws InterruptedException { 
					int value = modelo.ConatidAdmin()-1; 
		            while (true) 
		            { 
		                synchronized (this) 
		                {   
		                    // consumer thread waits while list 
		                    // is empty 
		                   // while (list.size()==1) 
		                        wait(); 
		  
		                    //to retrive the ifrst job in the list 
		                   // value =  1;
		                    value++;		               
		                    int val = modelo.Contid(value);
		  
		                    System.out.println("casos pendientes "+ val); 
		  
		                    // Wake up producer thread 
		                    notify(); 
		  
		                    // and sleep 
		                    Thread.sleep(1000); 
		                } 
		            } 
		        } 
		    } 
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
}
