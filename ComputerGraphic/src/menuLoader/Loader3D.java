package menuLoader;

import coordinateSystem.Point;
import drawableObject.Line;
import drawer.Drawer;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;

public class Loader3D extends MenuLoaderInterface{
	public Loader3D(VBox content_box,Drawer drawer, ColorPicker color_picker) {
		super(content_box,drawer, color_picker);
		// TODO Auto-generated constructor stub
		//Contructor phai ke thua tu MenuLoaderInterface
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		drawer.draw(new Line(new Point(30,30),new Point(-50,50),colorPicker.getValue()));
		//Code o day 
	}

}
