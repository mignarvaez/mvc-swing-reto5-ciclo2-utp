package co.edu.utp.misiontic2022.c2.reto5.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderVo;
import co.edu.utp.misiontic2022.c2.reto5.utils.JDBCUtilities;

public class LiderDao {

	public List<LiderVo> obtenerInformacionLideres() throws SQLException {

		List<LiderVo> lideres = new ArrayList<>();
		try (var connection = JDBCUtilities.getConnection();
				var statement = connection.prepareStatement(
						"SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia;");
				var rset = statement.executeQuery();) {

			while (rset.next()) {
				var lider = new LiderVo();
				lider.setId(rset.getInt("ID_Lider"));
				lider.setNombre(rset.getString("Nombre"));
				lider.setApellido(rset.getString("Primer_Apellido"));
				lider.setCiudadResidencia(rset.getString("Ciudad_Residencia"));
				lideres.add(lider);
			}
			return lideres;
		}

	}
}
