package co.edu.utp.misiontic2022.c2.reto5.views;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import co.edu.utp.misiontic2022.c2.reto5.controller.ReportesController;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.CompraHomecenterVo;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderVo;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.ProyectoCaribeVo;

public class ConsultaModelo {

	private static final ReportesController reportesController;
	static {
		reportesController = new ReportesController();
	}

	public DefaultTableModel liderProyecto() throws SQLException {

		String[] columnas = { "ID", "NOMBRE", "APELLIDO", "CIUDAD DE RESIDENCIA" };
		DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		List<LiderVo> lideres = reportesController.obtenerInformacionInformacionLideres();
		String[] filas = new String[4];
		for (LiderVo lider : lideres) {
			filas[0] = Integer.toString(lider.getId());
			filas[1] = lider.getNombre();
			filas[2] = lider.getApellido();
			filas[3] = lider.getCiudadResidencia();
			modelo.addRow(filas);
		}

		return modelo;
	}
	
	public DefaultTableModel proyectoCaribe() throws SQLException {

		String[] columnas = { "ID PROYECTO", "CONSTRUCTORA", "NUMERO DE HABITACIONES", "CIUDAD" };
		DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		List<ProyectoCaribeVo> proyectos = reportesController.obtenerProyectosCaribe();
		String[] filas = new String[4];
		for (ProyectoCaribeVo proyecto : proyectos) {
			filas[0] = Integer.toString(proyecto.getId());
			filas[1] = proyecto.getConstructora();
			filas[2] = Integer.toString(proyecto.getNumeroHabitaciones());
			filas[3] = proyecto.getCiudad();
			modelo.addRow(filas);
		}

		return modelo;
	}
	
	public DefaultTableModel compraHomecenterSalento() throws SQLException {

		String[] columnas = { "ID_COMPRA", "CONSTRUCTORA", "BANCO VINCULADO"};
		DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		List<CompraHomecenterVo> compras = reportesController.obtenerComprasHomecenterSalento();
		String[] filas = new String[4];
		for (CompraHomecenterVo compra : compras) {
			filas[0] = Integer.toString(compra.getId());
			filas[1] = compra.getConstructora();
			filas[2] = compra.getBanco();
			modelo.addRow(filas);
		}

		return modelo;
	}
}
