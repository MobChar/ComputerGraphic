package menuLoader;

import coordinateSystem.Point;
import drawableObject.Circle;
import drawableObject.Ellipse;
import drawableObject.Line;
import drawer.Drawer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
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
		Line myLine=new Line(new Point(0,0),new Point(0,50),colorPicker.getValue());
		
//		drawer.draw(myLine);
		float moveXSpeedPerSec=20;
		float moveYSpeedPerSec=-5;
		Circle circle = new Circle(new Point(0,10),20,colorPicker.getValue());
		Ellipse ellipse=new Ellipse(new Point(10,10),20,10,colorPicker.getValue());
		
//		drawer.remove(draw_object); Xoa ra khoi danh sach ve
		
		//Animation
		Timeline demoAnimate=new Timeline();
		demoAnimate.getKeyFrames().addAll(
		
				new KeyFrame(Duration.seconds(1),e -> {
//					circle.addTimelineTranform(new float[][] {
//						{(float) Math.cos(radianPerSec*Frame.deltaTime),(float) Math.sin(radianPerSec*Frame.deltaTime),0},
//						{-(float) Math.sin(radianPerSec*Frame.deltaTime),(float) Math.cos(radianPerSec*Frame.deltaTime),0},
//						{0,0,1}
//					});
					circle.addTimelineTranform(new float[][] {
						{(float) Math.cos(radianPerSec*Frame.deltaTime),(float) Math.sin(radianPerSec*Frame.deltaTime),0},
						{-(float) Math.sin(radianPerSec*Frame.deltaTime),(float) Math.cos(radianPerSec*Frame.deltaTime),0},
						{0,0,1}
					});
					ellipse.addTimelineTranform(new float[][] {
						{(float) Math.cos(radianPerSec*Frame.deltaTime),(float) Math.sin(radianPerSec*Frame.deltaTime),0},
						{-(float) Math.sin(radianPerSec*Frame.deltaTime),(float) Math.cos(radianPerSec*Frame.deltaTime),0},
						{0,0,1}
					});
				})
				,
				new KeyFrame(Duration.seconds(5),e -> {
					circle.addTimelineTranform(new float[][] {
						{1,0,0},
						{0,1,0},
						{(float) (Frame.deltaTime*moveXSpeedPerSec),(float) (Frame.deltaTime*moveYSpeedPerSec),1}
					});
				}
				)
				,
				new KeyFrame(Duration.seconds(20),e -> {
					circle.removeTimelineTransform(0);
				}
				)
		);
		
		
		
		drawer.draw(circle);
		
		drawer.draw(ellipse);
//		drawer.draw(myLine);
		demoAnimate.play();
		//Code o day 
	}

}
