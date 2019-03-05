package Vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.GenerarTicketControlador;
import Controlador.VistaTicketControlador;
import Modelo.ModeloLogica;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GenerarTicket extends JFrame {

	private JPanel contentPane;

	ModeloLogica modelo;
	public GenerarTicket(ModeloLogica modelo) {
        this.modelo = modelo;
        inic();

    }

    /**
     * Metodo usado para iniciar todos los elementos de la vista
     */
    public void inic() {
    	GenerarTicketControlador listener = new GenerarTicketControlador(modelo, this);
    	  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setVisible(true);
          setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Crear caso");
		btnNewButton.addActionListener(listener);
		btnNewButton.setBounds(32, 92, 138, 59);
		contentPane.add(btnNewButton);
		
		JButton btnContinuarCaso = new JButton("Continuar caso");
		btnContinuarCaso.addActionListener(listener);
	
		btnContinuarCaso.setBounds(245, 92, 138, 59);
		contentPane.add(btnContinuarCaso);
		
		JLabel lblNewLabel = new JLabel("\u00BFQu\u00E9 desea hacer?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(66, 28, 263, 52);
		contentPane.add(lblNewLabel);
	}
}
