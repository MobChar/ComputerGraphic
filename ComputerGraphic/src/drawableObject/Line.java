package drawableObject;

import java.util.ArrayList;

import coordinateSystem.Point;
import coordinateSystem.Transform;
import drawer.Drawer;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Line extends DrawableObject{
	
	private Point start, end;
	private Color color;
	
	private Label text=null;
	
	public Line(Point start, Point end,Color color) {
		this.start=start;
		this.end=end;
		this.color=color;
		
	
	}
	
	public void setPointText(Label label) {
		this.text=label;
	}
	
	

	
	@Override
	public void drawSelf(Drawer drawer) {
		super.drawSelf(drawer);
		
			if(text!=null) {
				float[] ret1=Transform.transform3x3(start.x,start.y, tranformMatrix);
				float[] ret2=Transform.transform3x3(end.x,end.y, tranformMatrix);
				text.setText(String.format("X1: %.1f Y1: %.1f, X2: %.1f Y2: %.1f",ret1[0],ret1[1],ret2[0],ret2[1]));
			}
		
			int x0=start.x,x1=end.x,y0=start.y,y1=end.y;
		  	int dx = Math.abs(x1 - x0);
	        int dy = Math.abs(y1 - y0);
	 
	        int sx = x0 < x1 ? 1 : -1; 
	        int sy = y0 < y1 ? 1 : -1; 
	 
	        int err = dx-dy;
	        int e2;
	 
	        while (true) 
	        {
	        	
	        	
	        	float[] ret=Transform.transform3x3(x0, y0, tranformMatrix);
	        	drawer.putPixel(ret[0],ret[1],color);
	        
	 
	            if (x0 == x1 && y0 == y1) 
	                break;
	 
	            e2 = 2 * err;
	            if (e2 > -dy) 
	            {
	                err = err - dy;
	                x0 = x0 + sx;
	            }
	 
	            if (e2 < dx) 
	            {
	                err = err + dx;
	                y0 = y0 + sy;
	            }
	        }
	}

}
