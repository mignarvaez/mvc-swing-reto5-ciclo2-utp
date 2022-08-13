package co.edu.utp.misiontic2022.c2.reto5.controller;

import java.sql.SQLException;
import java.util.List;

import co.edu.utp.misiontic2022.c2.reto5.model.dao.CompraHomecenterDao;
import co.edu.utp.misiontic2022.c2.reto5.model.dao.LiderDao;
import co.edu.utp.misiontic2022.c2.reto5.model.dao.ProyectoCaribeDao;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.CompraHomecenterVo;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderVo;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.ProyectoCaribeVo;


public class ReportesController {


	private final LiderDao liderDao;
	private final ProyectoCaribeDao proyectoCaribeDao;
	private final CompraHomecenterDao compraHomecenterDao;

	public ReportesController() {

		this.liderDao = new LiderDao();
		this.proyectoCaribeDao = new ProyectoCaribeDao();
		this.compraHomecenterDao = new CompraHomecenterDao();
	}


	public List<LiderVo> obtenerInformacionInformacionLideres() throws SQLException {
		return liderDao.obtenerInformacionLideres();
	}
	
	public List<ProyectoCaribeVo> obtenerProyectosCaribe() throws SQLException {
		return proyectoCaribeDao.obtenerProyectosCaribe();
	}
	
	public List<CompraHomecenterVo>obtenerComprasHomecenterSalento() throws SQLException{
		return compraHomecenterDao.obtenerComprasHomecenterSalento();
	}
}
