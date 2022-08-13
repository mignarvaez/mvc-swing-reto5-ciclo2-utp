package co.edu.utp.misiontic2022.c2.reto5.views;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

	private static final long serialVersionUID = 1L;

	public ScrollBarCustom() {
		setUI(new ModernScrollBarUI());
		setPreferredSize(new Dimension(8, 8));
		setForeground(new Color(48, 144, 216));
		setBackground(new Color(30, 30, 30));
		setUnitIncrement(16);
	}
}
