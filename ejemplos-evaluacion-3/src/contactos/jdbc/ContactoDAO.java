package contactos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contactos.swing.Contacto;

public class ContactoDAO {

	public static List<Contacto> leeContactos(Connection connection) throws SQLException {
		Statement stmt = connection.createStatement();

		ResultSet rs = stmt.executeQuery("select id,nombre,apellidos from contacto");
		List<Contacto> contactos = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			String apellidos = rs.getString("apellidos");
			Contacto c = new Contacto();
			c.setNombre(nombre);
			c.setApellidos(apellidos);
			c.setId(id);
			contactos.add(c);
		}
		rs.close();
		stmt.close();
		return contactos;
	}

	public static void insertarContactoNuevo(Connection connection, Contacto contacto) throws SQLException {
		String sql = "INSERT INTO contacto(nombre,apellidos) values (?,?)";

		System.out.println("Voy a ejecutar:" + sql);

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, contacto.getNombre());
		stmt.setString(2, contacto.getApellidos());
		int filas = stmt.executeUpdate();
		stmt.close();

		System.out.println("Número de filas afectadas:" + filas);
	}

	public static boolean modificaContacto(Connection connection, Contacto contacto) throws SQLException {
		String sql = "UPDATE contacto SET nombre=?, apellidos=? where id=?";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, contacto.getNombre());
		stmt.setString(2, contacto.getApellidos());
		stmt.setInt(3, contacto.getId());
		int filas = stmt.executeUpdate();
		stmt.close();
		return filas == 1;

	}

	public static boolean borraContacto(Connection connection, Contacto contacto) throws SQLException {
		String sql = "DELETE FROM contacto WHERE id=?";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, contacto.getId());
		int filas = stmt.executeUpdate();
		stmt.close();
		return filas == 1;

	}

	/**
	 * 
	 * @param connection
	 * @param id
	 * @return El contacto de la base de datos, o si no existe NULL
	 * @throws SQLException
	 */
	public static Contacto buscarPorID(Connection connection, int id)  throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select id,nombre,apellidos from contacto where id=?");
		stmt.setInt(1,id);

		ResultSet rs = stmt.executeQuery();
		List<Contacto> contactos = new ArrayList<>();
		while (rs.next()) {
			int idLeido = rs.getInt("id");
			String nombre = rs.getString("nombre");
			String apellidos = rs.getString("apellidos");
			Contacto c = new Contacto();
			c.setNombre(nombre);
			c.setApellidos(apellidos);
			c.setId(idLeido);
			contactos.add(c);
		}
		
		rs.close();
		stmt.close();
		
		if( contactos.size() > 1 ){
			throw new IllegalStateException();
		}
		if( contactos.size() == 0 ){
			return null;
		}
		
		return contactos.get(0);
	}
}
