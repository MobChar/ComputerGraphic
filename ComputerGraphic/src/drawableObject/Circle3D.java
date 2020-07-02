package drawableObject;

import coordinateSystem.Point;
import coordinateSystem.Transform;
import drawer.Drawer;
import javafx.scene.paint.Color;

public class Circle3D extends DrawableObject{
	private Point center;
	private Color color;
	private int radius;
	
	public Circle3D(Point center,int radius, Color color) {
		this.center=center;
		this.color=color;
		this.radius=radius;
	}
	
	@Override
	public void drawSelf(Drawer drawer) {
		super.drawSelf(drawer);
		
		 int x = 0, y = radius;
         int decesionParameter = 3 - 2 * radius;
         
         float[] ret=Transform.transform3x3(center.x, center.y, tranformMatrix);
         
         // ret[0], ret[1]: toa do tam
         putCirclePixel(drawer,ret[0],ret[1], x, y);
         drawer.putPixel(ret[0],ret[1],this.color);
         while (y >= x)
         {
             x++;
             if (decesionParameter > 0)
             {
                 y--;
                 decesionParameter = decesionParameter + 4 * (x - y) + 10;
             }
             else
                 decesionParameter = decesionParameter + 4 * x + 6;
             
            
             putCirclePixel(drawer,ret[0],ret[1], x, y);
         }
	}
	
	private void putCirclePixel(Drawer drawer,float trans_center_x, float trans_center_y,int x, int y) {
    	drawer.putPixel(trans_center_x+x, trans_center_y+y,color);
    	drawer.putPixel(trans_center_x-x, trans_center_y+y,color);
    	drawer.putPixel(trans_center_x+x, trans_center_y-y,color);
    	drawer.putPixel(trans_center_x-x, trans_center_y-y,color);
    	drawer.putPixel(trans_center_x+y, trans_center_y+x,color);
    	drawer.putPixel(trans_center_x-y, trans_center_y+x,color);
    	drawer.putPixel(trans_center_x+y, trans_center_y-x,color);
    	drawer.putPixel(trans_center_x-y, trans_center_y-x,color);
    
//		  putpixel(xc_+x, yc_+y, WHITE);
//          putpixel(xc_-x, yc_+y, WHITE);
//          putpixel(xc_+x, yc_-y, WHITE);
//          putpixel(xc_-x, yc_-y, WHITE);
//          putpixel(xc_+y, yc_+x, WHITE);
//          putpixel(xc_-y, yc_+x, WHITE);
//          putpixel(xc_+y, yc_-x, WHITE);
//          putpixel(xc_-y, yc_-x, WHITE);
	}
}
