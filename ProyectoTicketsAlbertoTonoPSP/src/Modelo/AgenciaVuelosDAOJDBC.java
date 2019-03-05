package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
/**
 * Clase Dominio, realiza las acciones con la base de datos
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */

public class AgenciaVuelosDAOJDBC implements DAO{
	/**
	 * Metodo que añade un ticket a la base de datos
	 * 
	 * @param ticket
	 * @return true si es añadido, false, si no.
	 */

	@Override
	public boolean AddTicket(Ticket t) {
		Statement stm = null;

		try {
			ConexionJDBC conn = new ConexionJDBC();
			Connection conex = conn.getConnection();
			stm = conex.createStatement();
			String sql = ("insert into tickets(id, id_caso, id_Admin, fecha, asunto, prioridad, descripcion, estado) "
					+ "values (" + t.getId() + "," + t.getId_Caso() + "," + t.getId_Admin() + ""
					+ ",'" + t.getFecha() + "','" + t.getAsunto() + "','" + t.getPrio()+ "', '" + t.getDesc() + "','" + t.getEstado() + "')");
			
			stm.executeUpdate(sql);
			
			stm.close();
	            return true;
	        } catch (SQLException e) {
	            return false;
	        }
	}
	

	@Override
	public boolean AddAdmin(Administrador admin) {
		Statement stm = null;

		try {
			ConexionJDBC conn = new ConexionJDBC();
			Connection conex = conn.getConnection();
			stm = conex.createStatement();
			String sql = "insert into administrador(id, nombre) values (" + admin.getId() + ",'"+ admin.getNombre()+"')";
			stm.executeUpdate(sql);
			stm.close();
			return true;
		 } catch (Exception e) {
	           
	            return false;
	        }
	}
	/**
	 * Metodo que obtiene todos lo casos de la base de datos
	 * 
	 * @return Array de casos.
	 */
	@Override
	public ArrayList<Ticket> CargarDatosCasos() {
		ArrayList<Ticket> lista = new ArrayList<Ticket>();
		Statement stm = null;
        try {
        	ConexionJDBC conn = new ConexionJDBC();
			Connection conex = conn.getConnection();
			stm = conex.createStatement();
            String sql = "select distinct id_caso from tickets";
			ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
            	int casoid = rst.getInt("id_caso");
            	Ticket t = new Ticket(casoid);
            	lista.add(t);
            }
            rst.close();
            stm.close();
            return lista;
        } catch (SQLException e) {
           return null;
        }
        
	}
	/**
	 * Motodo que obtiene todos los ticket con el mismo id de caso de la base de
	 * datos
	 * 
	 * @param idCaso
	 * @return array con los tickets
	 */

	@Override
	public ArrayList<Ticket> CargarDatosTicketsCaso(int idCaso) {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		ArrayList<Ticket> listtickets = new ArrayList<Ticket>();
		try {
			stmt = conex.createStatement();
			String query = "select * from tickets where id_caso =" + idCaso ;
			
			set = stmt.executeQuery(query);
			while (set.next()) {
				int casoid = set.getInt("id_caso");
				String nombre = set.getString("Asunto");
				Ticket t = new Ticket(casoid, nombre);
				listtickets.add(t);
			}
			set.close();
			stmt.close();
			return listtickets;
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * Metodo que obtiene los casos de un administrador
	 * 
	 * @param id_Admin
	 * @return array con los casos
	 */

	@Override
	public ArrayList<Ticket> CargarDatosCasosAdmin(int id_Admin) {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		ArrayList<Ticket> listaCasos = new ArrayList<Ticket>();

		try {
			stmt = conex.createStatement();
			String query = "Select id_caso from tickets where id_Admin  = " + id_Admin;
			set = stmt.executeQuery(query);
			while (set.next()) {
				int idadmin = set.getInt("id_Admin");
				Ticket t = new Ticket(idadmin);
				listaCasos.add(t);
			}
			set.close();
			stmt.close();
			return listaCasos;
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * Metodo que comprueba si el administrador existe
	 * 
	 * @param adr
	 * @return true si existe, false, si no.
	 */

	@Override
	public boolean ComprobarAdmin(Administrador adr) {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt; 
		ResultSet set;
		boolean existe = false;

	        try {
	        	stmt = conex.createStatement();
				String query = "select id from administrador where id = " + adr.getId();
				set = stmt.executeQuery(query);
	            if (set.next()) {
	            	existe = true;
	            }else {
	            	existe = false;
	            }
	        } catch (SQLException e) {
	        	 return existe;
	        }
			return existe;
	}
	/**
	 * Metodo que obtiene los datos de un ticket
	 * 
	 * @param idticket
	 * @return Un ticket
	 */

	@Override
	public Ticket devuelveDatosTickets(int idticket) {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt; 
		ResultSet set;
        Ticket tickets = new Ticket();
        try {
        	stmt = conex.createStatement();
			String query = "select * from tickets where id = " + idticket;
			set = stmt.executeQuery(query);
            
            if(set.next()){
            	tickets.setId(set.getInt(1));
            	tickets.setId_Caso(set.getInt(2));
            	tickets.setId_Admin(set.getInt(3));
            	tickets.setFecha(set.getString(4));
            	tickets.setAsunto(set.getString(5));
            	tickets.setPrio(set.getString(6));
            	tickets.setDesc(set.getString(7));
            	tickets.setEstado(set.getString(8));
            }
            return tickets;
        } catch (Exception e) {
            return null;
        }
    
	}
	/**
	 * Metodo que obtiene los tickets que se encuentran abiertos
	 * 
	 * @return Array de tickets
	 */

	@Override
	public ArrayList<Ticket> CargarDatosTicketsPendientes() {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		ArrayList<Ticket> listticketsp = new ArrayList<Ticket>();
		try {
			stmt = conex.createStatement();
			String query = "select distinct id_caso from tickets where estado = 'Abierto'"; 
			set = stmt.executeQuery(query);
			while (set.next()) {
				int casoid = set.getInt("id_caso");
				Ticket t = new Ticket(casoid);
				listticketsp.add(t);
			}
			set.close();
			stmt.close();
			return listticketsp;
		} catch (Exception ex) {	
			return null;
		}
	}
	/**
	 * Metodo que obtiene los datos de los tickets de un caso.
	 * 
	 * @param idcaso
	 * @return Array de tickets
	 */

	public ArrayList<Ticket> CargarDatosTicketsPendientes(int idcaso) {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		ArrayList<Ticket> listticketsp = new ArrayList<Ticket>();
		try {
			stmt = conex.createStatement();
			String query = "select * from tickets where id_caso =" + idcaso; 
			
			set = stmt.executeQuery(query);
			while (set.next()) {
				int casoid = set.getInt("id_caso");
			   	int id = set.getInt("id");
			 	int id_Admin = set.getInt("id_Admin");
			 	String fecha = set.getString("fecha");
			   	String asunto =  set.getString("asunto");
			   	String prio =  set.getString("prioridad");
			   	String desc =  set.getString("descripcion");
			   	String estado =  set.getString("estado");
			   	String respuesta =  set.getString("respuesta");
				Ticket t = new Ticket(id, casoid, id_Admin, fecha, asunto, prio, desc, estado, respuesta);
				listticketsp.add(t);
			}
			set.close();
			stmt.close();
			return listticketsp;
		} catch (Exception ex) {

			return null;
		}
	}
	/**
	 * Meotodo que obtiene los administradores de la base de datos
	 * 
	 * @return Array de administradores
	 */


	@Override
	public ArrayList<Administrador> CargarDatosAdministradores() {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		ArrayList<Administrador> listadmin = new ArrayList<Administrador>();

		try {
			stmt = conex.createStatement();
			String query = "select id from administrador";
			set = stmt.executeQuery(query);
			while (set.next()) {
				int id = set.getInt("id");
				String Name = set.getString("Nombre");
				Administrador t = new Administrador(id, Name);
				listadmin.add(t);
			}
			set.close();
			stmt.close();
			return listadmin;
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * Metodo que obtiene el numero de casos que hay
	 * 
	 * @return numero de casos
	 */

	public int TotalRegistros() {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		
		int registros = 0;
		try {
			stmt = conex.createStatement();
			String sql = "SELECT count(id_caso) FROM tickets";
			set = stmt.executeQuery(sql);
			if (set.next()) {
				registros = set.getInt(1);
			}
			stmt.close();
			conex.close();
			return registros;
		} catch (SQLException e) {
			return -1;
		} 
	}
	/**
	 * Metodo que comprueba si hay algun ticket abierto en un caso
	 * 
	 * @param idcaso
	 * @return true si hay abierto, false si no hay
	 */

	public boolean ComprobarAbierto(int idcaso) {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		boolean abierto;
		try {	
		stmt = conex.createStatement();
			String query = "select id_caso from tickets where estado = 'Cerrado' and id_caso="+idcaso; 
			set = stmt.executeQuery(query);
			 if (set.next()) {
				 abierto = false;
	            }else {
	            	abierto = true;
	            }
			set.close();
			stmt.close();
			return abierto;
		} catch (Exception ex) {	
			return false;
		}
	}
	/**
	 * Metodo una lista de tickets pendientes que hay en un caso de un administrador
	 * 
	 * @param idadmin
	 * @return Arraylist de tickets
	 */

	public ArrayList<Ticket> CargarDatosPendientes(int idadmin) {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		ArrayList<Ticket> listticketsp = new ArrayList<Ticket>();
		try {
			stmt = conex.createStatement();
			String query = "select distinct id_caso from tickets where estado = 'Pendiente' and id_Admin="+idadmin; 
			set = stmt.executeQuery(query);
			while (set.next()) {
				int casoid = set.getInt("id_caso");
				Ticket t = new Ticket(casoid);
				listticketsp.add(t);
			}
			set.close();
			stmt.close();
			return listticketsp;
		} catch (Exception ex) {	
			return null;
		}
	}
	/**
	 * Metodo que obtiene una lista de tickets pendientes
	 * 
	 * @return array de tickets
	 */
	
	public ArrayList<Ticket> CargarDatosAdminPendientes() {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		ArrayList<Ticket> listticketsp = new ArrayList<Ticket>();
		try {
			stmt = conex.createStatement();
			String query = "select distinct id_Admin from tickets where estado = 'Pendiente'"; 
			set = stmt.executeQuery(query);
			while (set.next()) {
			 	int id_Admin = set.getInt("id_Admin");
				Ticket t = new Ticket(id_Admin);
				listticketsp.add(t);
			}
			set.close();
			stmt.close();
			return listticketsp;
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * Metodo que obtiene una lista de tickets pendientes de un caso concreto
	 * 
	 * @param idcaso
	 * @return Array de tickets
	 */

	public ArrayList<Ticket> CargarDatosTicketsP(int idcaso) {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		ArrayList<Ticket> listticketsp = new ArrayList<Ticket>();
		try {
			stmt = conex.createStatement();
			String query = "select distinct id from tickets where estado = 'Pendiente' and id_Caso="+idcaso; 
			set = stmt.executeQuery(query);
			while (set.next()) {
				int id = set.getInt("id");
				Ticket t = new Ticket(id);
				listticketsp.add(t);
			}
			set.close();
			stmt.close();
			return listticketsp;
		} catch (Exception ex) {	
			return null;
		}
	}
	public int ConatidAdmin() {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		
		int registros = 0;
		try {
			stmt = conex.createStatement();
			String sql = "SELECT id_Admin FROM tickets where estado = 'Pendiente' group by id_Admin";
			set = stmt.executeQuery(sql);
			if (set.next()) {
				registros = set.getInt(1);
			}
			stmt.close();
			conex.close();
			return registros;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		} 
	}
	public int ContTickets(int idadmin) {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		
		int registros = 0;
		try {
			stmt = conex.createStatement();
			String sql = "SELECT count(id) FROM tickets where estado = 'Pendiente' and id_Admin="+ idadmin+ " group by id_Admin";
			set = stmt.executeQuery(sql);
			if (set.next()) {
				registros = set.getInt(1);
			}
			stmt.close();
			conex.close();
			return registros;
		} catch (SQLException e) {
			System.out.println(e);
			return -1;
		} 
	}

	
	public boolean ComprobarID(int id, int idcaso) {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt; 
		ResultSet set;
		boolean existe = false;

	        try {
	        	stmt = conex.createStatement();
				String query = "select id from tickets where id = " + id + " and id_caso = "+idcaso;
				set = stmt.executeQuery(query);
	            if (set.next()) {
	            	existe = true;
	            }else {
	            	existe = false;
	            }
	        } catch (SQLException e) {
	        	 return existe;
	        }
			return existe;
	}
	public int ContarAdmins() {
		ConexionJDBC conn = new ConexionJDBC();
		Connection conex = conn.getConnection();
		Statement stmt;
		ResultSet set;
		
		int registros = 0;
		try {
			stmt = conex.createStatement();
			String sql = "SELECT count(id_Admin) FROM tickets where estado = 'Pendiente' group by id_Admin";
			set = stmt.executeQuery(sql);
			if (set.next()) {
				registros = set.getInt(1);
			}
			stmt.close();
			conex.close();
			return registros;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		} 
	}
	
	public boolean Responder(String respuesta, int id, int idcaso) {
		Statement stm = null;
		try {
			ConexionJDBC conn = new ConexionJDBC();
			Connection conex = conn.getConnection();
			stm = conex.createStatement();			
			String sql = "UPDATE tickets SET respuesta='" + respuesta + "' WHERE id=" + id + " and id_caso = "+ idcaso ;
			String sql1 = "UPDATE tickets SET estado='Abierto' WHERE id=" + id + " and id_caso = "+ idcaso ;
			stm.executeUpdate(sql);	stm.executeUpdate(sql1);
			stm.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
