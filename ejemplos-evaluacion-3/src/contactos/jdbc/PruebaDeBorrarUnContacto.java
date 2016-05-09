package contactos.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import contactos.swing.Contacto;

public class PruebaDeBorrarUnContacto {

	public static void main(String[] args) {
		ConexionBD.cargarElDriver();
		
		Connection connection = null;
		try{

			connection = ConexionBD.creaConexion();
			
			Contacto contacto = contactoABorrar();
			
			boolean ok = ContactoDAO.borraContacto(connection, contacto);
			System.out.println(ok);
			
			
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
	
	private static Contacto contactoABorrar() {
		Contacto c = new Contacto();
		c.setId(18);
		return c;
	}

	
}
