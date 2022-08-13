package co.edu.utp.misiontic2022.c2.reto5.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {

	// Atributos de clase para gestión de conexión con la base de datos
	private static final String UBICACION_DB = "src/main/resources/ProyectosConstruccion.db";

	/**
	 * Método que crea de manera estatica la conexión a la base de datos
	 * 
	 * @return La base de datos creada
	 * @throws SQLException Lanza una excepción si se encuentra un problema al
	 *                      intentar realizar la conexión
	 */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:sqlite:" + UBICACION_DB;
		return DriverManager.getConnection(url);
	}
}
