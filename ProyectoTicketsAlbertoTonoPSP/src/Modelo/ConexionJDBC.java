package Modelo;
 
import java.sql.*;

/**
 * Clase ConexionJDBC que implementa una conexion a la base de datos
 * 
 * @author Alberto Serrano y Antonio Ramayo
 * @Version 26/2/2019
 * 
 *
 */

public class ConexionJDBC {
	Connection conn;

	public ConexionJDBC() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/agenciavuelos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (ClassNotFoundException | SQLException ex) {
		System.out.println(ex+"ERROR");
		}

	}

	/**
	 * Permite retornar la conexión
	 * 
	 * @return la conexion
	 */
	 public Connection getConnection() {
		
	        return conn;
	    }
	/**
	 * Permite desconectar la conexión
	 *
	 */
	public void desconectar() {
		try {
			conn.close();
			
		} catch (Exception e) {
			
		}

	}
}
