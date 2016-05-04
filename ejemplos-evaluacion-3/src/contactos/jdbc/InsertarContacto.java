package contactos.jdbc;

import static contactos.jdbc.ConexionBD.*;
import static contactos.jdbc.ContactoDAO.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import contactos.swing.Contacto;



public class InsertarContacto {

	public static void main(String[] args) {
		cargarElDriver();
		
		Connection connection = null;
		try{

			connection = creaConexion();
			
			Contacto contacto = contactoAInsertar();
			
			insertarContactoNuevo(connection, contacto);
			System.out.println( leeContactos(connection) );
			
			
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
		Scanner in = new Scanner(System.in);
		System.out.println("Nombre del nuevo contacto:");
		String nombre = in.nextLine();
		System.out.println("Apellidos del nuevo contacto:");
		String apellidos = in.nextLine();
		Contacto contacto = new Contacto();
		contacto.setNombre(nombre);
		contacto.setApellidos(apellidos);
		return contacto;
	}
}
