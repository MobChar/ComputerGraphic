package drawer;

import java.util.ArrayList;
import java.util.List;

import coordinateSystem.CoordinateSystem;
import coordinateSystem.Point;
import drawableObject.Drawable;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Drawer {
	private PixelWriter writer;
	private List<Drawable> draw_list;
	public Drawer(PixelWriter writer) {
		this.writer=writer;
		draw_list=new ArrayList<Drawable>();
	}
	
	
	public void putPixel(float x, float y,Color color) {
		
		Point sp=CoordinateSystem.spaceToScreen(x,y);
		for(int i=0;i<CoordinateSystem.SPACE_SCREEN_RATIO*CoordinateSystem.SPACE_SCREEN_RATIO;i++) {
			writer.setColor((int)sp.x+i%CoordinateSystem.SPACE_SCREEN_RATIO,(int)sp.y -i/CoordinateSystem.SPACE_SCREEN_RATIO, color);
		}
	}
	
	public void draw(Drawable draw_object) {
		draw_list.add(draw_object);
	}
	public void clear() {
		draw_list.clear();
	}
	public void remove(Drawable draw_object) {
		draw_list.remove(draw_object);
	}
	public void remove(int index) {
		draw_list.remove(index);
	}
	public void render() {
		for(Drawable toDraw: draw_list) {
			toDraw.drawSelf(this);
		}
	}

}
