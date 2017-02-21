package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Screen {
	
	public static double width;
	public static double height;
	
	public static void start(){
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		width =  (dim.width / 4) * 3;
		height = (dim.height / 4) * 3;
	}
	
	
}
