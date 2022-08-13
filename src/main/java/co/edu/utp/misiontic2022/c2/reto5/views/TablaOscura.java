package co.edu.utp.misiontic2022.c2.reto5.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TablaOscura extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TablaOscura() {
		getTableHeader().setDefaultRenderer(new TablaEncabezadoOscuro());
		getTableHeader().setPreferredSize(new Dimension(0, 35));
		setDefaultRenderer(Object.class, new TablaCeldaOscura());
		setRowHeight(30);
		getTableHeader().setReorderingAllowed(false);
	}

	private class TablaEncabezadoOscuro extends DefaultTableCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			com.setBackground(new Color(30, 30, 30));
			com.setForeground(new Color(200, 200, 200));
			com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
			return com;
		}
	}

	public void fixTable(JScrollPane scroll) {
		scroll.setVerticalScrollBar(new ScrollBarCustom());
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 30, 30));
		scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
		scroll.getViewport().setBackground(new Color(30, 30, 30));
		scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));
	}

	private class TablaCeldaOscura extends DefaultTableCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if (isCellSelected(row, column)) {
				if (row % 2 == 0) {
					com.setBackground(new Color(33, 103, 153));
				} else {
					com.setBackground(new Color(29, 86, 126));
				}

			} else {
				if (row % 2 == 0) {
					com.setBackground(new Color(50, 50, 50));
				} else {
					com.setBackground(new Color(30, 30, 30));
				}
			}
			com.setForeground(new Color(200, 200, 200));
			setBorder(new EmptyBorder(0, 5, 0, 5));
			return com;
		}
	}
}
