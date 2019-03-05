package Modelo;

/**
 * Pojo Administrador con todo sus atributos
 * 
 * @author Alberto Serrano y Antonio Ramayo
 *
 */

public class Administrador {
	   private int id;
	    private String nombre;
		/**
		 * Obtiene el id del administrador
		 * 
		 * @return id
		 */

	    public int getId() {
	        return id;
	    }
	    /**
		 * Obtiene el nombre del administrador
		 * 
		 * @return nombre
		 */

	    public String getNombre() {
	        return nombre;
	    }
		/**
		 * Modifica el id del administrador
		 * 
		 * @param id
		 */

	    public void setId(int id) {
	        this.id = id;
	    }

		/**
		 * Modifica el nombre del administrador
		 * 
		 * @param nombre
		 */

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
		/**
		 * Constructor administrador con paramatros.
		 * 
		 * @param id
		 * @param nombre
		 */

		public Administrador(int id, String nombre) {
		
			this.id = id;
			this.nombre = nombre;
		}
		/**
		 * Constructor Administrador con parametro
		 * 
		 * @param id
		 */
		public Administrador(int id) {
		
			this.id = id;
	
		}
	    
}
