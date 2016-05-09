package contactos.jdbc;

import static contactos.jdbc.ConexionBD.cargarElDriver;
import static contactos.jdbc.ConexionBD.creaConexion;

import java.sql.Connection;
import java.sql.SQLException;

import contactos.swing.Contacto;



public class PruebaDeInsertarContacto {

	public static void main(String[] args) {
		cargarElDriver();
		
		Connection connection = null;
		try{

			connection = creaConexion();
			
			Contacto contacto = contactoAInsertar();
			
			ContactoDAO.insertarContactoNuevo(connection, contacto);
			for( Contacto c : ContactoDAO.leeContactos(connection) ){
				System.out.println(c);
			}
			
			
			connection.close();
		}
		catch( SQLException e ){
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null && !connection.isClosed() ) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	
	private static Contacto contactoAInsertar() {
		String nombre = "Un nombre";
		String apellidos = "Un apellido";
		Contacto contacto = new Contacto();
		contacto.setNombre(nombre);
		contacto.setApellidos(apellidos);
		contacto.addDato( new DatoDeContacto(0, "email", "personal", "email@personal" ) );
		contacto.addDato( new DatoDeContacto(0, "email", "trabajo", "email@trabajo" ) );
		
		return contacto;
	}
}
