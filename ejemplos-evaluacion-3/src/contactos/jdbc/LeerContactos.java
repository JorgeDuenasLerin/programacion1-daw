package contactos.jdbc;

import static contactos.jdbc.ConexionBD.*;
import static contactos.jdbc.ContactoDAO.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contactos.swing.Contacto;

public class LeerContactos {

	public static void main(String[] args) {

		cargarElDriver();

		Connection connection = null;
		try {
			connection = creaConexion();
			System.out.println("Conexión establecida");

			List<Contacto> contactos = leeContactos(connection);
			
			for( Contacto c : contactos ){
				System.out.println(c);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && !connection.isClosed() ) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	
}
