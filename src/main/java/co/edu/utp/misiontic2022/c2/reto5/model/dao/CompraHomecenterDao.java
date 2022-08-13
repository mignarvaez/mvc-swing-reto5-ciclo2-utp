package co.edu.utp.misiontic2022.c2.reto5.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.reto5.model.vo.CompraHomecenterVo;
import co.edu.utp.misiontic2022.c2.reto5.utils.JDBCUtilities;

public class CompraHomecenterDao {

	public List<CompraHomecenterVo> obtenerComprasHomecenterSalento() throws SQLException {

		List<CompraHomecenterVo> compras = new ArrayList<>();
		try (var connection = JDBCUtilities.getConnection();
				var statement = connection
						.prepareStatement("SELECT  " + "	C.ID_Compra, P.Constructora, P.Banco_Vinculado  " + "FROM  "
								+ "	Proyecto P INNER JOIN Compra C ON P.ID_Proyecto=C.ID_Proyecto "
								+ "WHERE UPPER(P.ciudad) = \"SALENTO\" AND UPPER(C.Proveedor) == \"HOMECENTER\";");
				var rset = statement.executeQuery();) {

			while (rset.next()) {
				var compra = new CompraHomecenterVo();
				compra.setId(rset.getInt("ID_Compra"));
				compra.setConstructora(rset.getString("Constructora"));
				compra.setBanco(rset.getString("Banco_Vinculado"));
				compras.add(compra);
			}
			return compras;
		}

	}
}
