package co.edu.utp.misiontic2022.c2.reto5.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.reto5.model.vo.ProyectoCaribeVo;
import co.edu.utp.misiontic2022.c2.reto5.utils.JDBCUtilities;

public class ProyectoCaribeDao {
	
	public List<ProyectoCaribeVo> obtenerProyectosCaribe() throws SQLException {

		List<ProyectoCaribeVo> proyectosCaribe = new ArrayList<>();
		try (var connection = JDBCUtilities.getConnection();
				var statement = connection.prepareStatement(
						"SELECT "
						+ "ID_Proyecto, Constructora,Numero_Habitaciones,Ciudad "
						+ "FROM  "
						+ "Proyecto  "
						+ "WHERE  "
						+ "Ciudad IN(\"Santa Marta\",\"Cartagena\",\"Barranquilla\") "
						+ "ORDER BY "
						+ "Ciudad;");
				var rset = statement.executeQuery();) {

			while (rset.next()) {
				var proyectoCaribe = new ProyectoCaribeVo();
				proyectoCaribe.setId(rset.getInt("ID_Proyecto"));
				proyectoCaribe.setConstructora(rset.getString("Constructora"));
				proyectoCaribe.setNumeroHabitaciones(rset.getInt("Numero_Habitaciones"));
				proyectoCaribe.setCiudad(rset.getString("Ciudad"));
				proyectosCaribe.add(proyectoCaribe);
			}
			return proyectosCaribe;
		}

	}
}
