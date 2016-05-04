package contactos.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import contactos.swing.Contacto;

public class ActualizarUnContacto {

	public static void main(String[] args) {
		ConexionBD.cargarElDriver();
		
		Connection connection = null;
		try{

			connection = ConexionBD.creaConexion();
			
			Contacto contacto = contactoAActualizar();
			
			boolean ok = ContactoDAO.modificaContacto(connection, contacto);
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

	private static Contacto contactoAActualizar() {
		Contacto c = new Contacto();
		c.setId(3);
		c.setNombre("María");
		c.setApellidos("Díaz Pérez");
		return c;
	}

	

}
