package contactos.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import contactos.swing.Contacto;

public class PruebaDeActualizarUnContacto {

	public static void main(String[] args) {
		ConexionBD.cargarElDriver();
		
		Connection connection = null;
		try{

			connection = ConexionBD.creaConexion();
			
			Contacto contacto = contactoAActualizar(connection);
			
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

	private static Contacto contactoAActualizar(Connection connection) throws SQLException {
		int id = 20;
		Contacto c = ContactoDAO.buscarPorID(connection, id);
		c.addDato( new DatoDeContacto("fax","trabajo","91999999") );
		return c;
	}

	

}
