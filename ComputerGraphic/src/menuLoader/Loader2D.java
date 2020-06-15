package menuLoader;

import coordinateSystem.Point;
import drawableObject.Circle;
import drawableObject.Line;
import drawer.Drawer;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import mainPane.Frame;


public class Loader2D extends MenuLoaderInterface{
	public Loader2D(VBox content_box,Drawer drawer, ColorPicker color_picker) {
		super(content_box,drawer, color_picker);
		// TODO Auto-generated constructor stub
		//Contructor phai ke thua tu MenuLoaderInterface
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		float radianPerSec=5f;
//		Line myLine=new Line(new Point(0,0),new Point(0,50),colorPicker.getValue());
//		myLine.addTimelineTranform(new float[][] {
//			{(float) Math.cos(radianPerSec*Frame.deltaTime),(float) Math.sin(radianPerSec*Frame.deltaTime),0},
//			{-(float) Math.sin(radianPerSec*Frame.deltaTime),(float) Math.cos(radianPerSec*Frame.deltaTime),0},
//			{0,0,1}
//		},10);
//		drawer.draw(myLine);
		
		
		float moveXSpeedPerSec=40;
		float moveYSpeedPerSec=-5;
		Circle circle = new Circle(new Point(0,0),20,colorPicker.getValue());
		circle.addTimelineTranform(new float[][] {
			{1,0,0},
			{0,1,0},
			{(float) (Frame.deltaTime*moveXSpeedPerSec),(float) (Frame.deltaTime*moveYSpeedPerSec),1}
		},10);
		
		circle.addTimelineTranform(new float[][] {
		{(float) Math.cos(radianPerSec*Frame.deltaTime),(float) Math.sin(radianPerSec*Frame.deltaTime),0},
		{-(float) Math.sin(radianPerSec*Frame.deltaTime),(float) Math.cos(radianPerSec*Frame.deltaTime),0},
		{0,0,1}
	},15);
	
		
		
		drawer.draw(circle);
		
		//Code o day 
	}

}
