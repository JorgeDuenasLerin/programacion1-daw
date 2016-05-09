package contactos.jdbc;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contactos.swing.Contacto;

public class DatoDeContactoDAO {

	public static List<DatoDeContacto> leeDatosDeContacto(Connection connection, int idContacto) throws SQLException {
		PreparedStatement stmt = connection
				.prepareStatement("select tipo,ambito,valor from DatosDeContacto where idContacto=?");

		stmt.setInt(1, idContacto);

		ResultSet rs = stmt.executeQuery();
		List<DatoDeContacto> datosDeContacto = new ArrayList<>();

		while (rs.next()) {
			String tipo = rs.getString("tipo");
			String ambito = rs.getString("ambito");
			String valor = rs.getString("valor");
			datosDeContacto.add(new DatoDeContacto(idContacto, tipo, ambito, valor));
		}
		rs.close();
		stmt.close();
		return datosDeContacto;
	}

	public static void insertarDatoDeContactoNuevo(Connection connection, DatoDeContacto dc) throws SQLException {
		String sql = "INSERT INTO DatosDeContacto(idContacto,tipo,ambito,valor) values (?,?,?,?)";

		System.out.println("Voy a ejecutar:" + sql);

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, dc.getIdContacto());
		stmt.setString(2, dc.getTipo());
		stmt.setString(3, dc.getAmbito());
		stmt.setString(4, dc.getValor());

		int filas = stmt.executeUpdate();

		stmt.close();

		System.out.println("Número de filas afectadas:" + filas);

	}

	public static int borraDatosDeContacto(Connection connection, int idContacto) throws SQLException {
		String sql = "DELETE FROM DatosDeContacto WHERE idContacto=?";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, idContacto);
		int filas = stmt.executeUpdate();
		stmt.close();
		return filas;
	}

	
	
	
	public static void main(String[] args) {
		
	}

}
