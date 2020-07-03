package menuLoader;

import coordinateSystem.Point;
import coordinateSystem.Point3D;
import drawableObject.Circle3D;
import drawableObject.Ellipse3D;
import drawableObject.Line;
import drawer.Drawer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SphereLoader {
	protected Drawer drawer;
	protected ColorPicker colorPicker;
	protected VBox contentBox;
	public SphereLoader(VBox content_box,Drawer drawer, ColorPicker color_picker) {
		this.drawer=drawer;
		this.colorPicker=color_picker;
		this.contentBox=content_box;
		// TODO Auto-generated constructor stub
		
		Label x = new Label("X:");
		TextField ipX = new TextField();
		Label y = new Label("Y:");
		TextField ipY = new TextField();
		Label z = new Label("Z:");
		TextField ipZ = new TextField();
		Label r = new Label("R:");
		TextField ipR = new TextField();
		GridPane root = new GridPane(); 
		Button ok = new Button("Draw");
		
		ok.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		root.setPadding(new Insets(25, 25, 25, 25));
		root.setVgap(20);
		root.setHgap(20);
		root.setAlignment(Pos.CENTER);
		
		root.add(x,0,0);
		root.add(ipX,1,0);
		
		root.add(y,0,1);
		root.add(ipY,1,1);
		
		root.add(z,0,2);
		root.add(ipZ,1,2);
		
		root.add(r,0,3);
		root.add(ipR,1,3);
		
		root.add(ok,1,4);
		Scene scene = new Scene(root, 300, 300);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
				
//		ok.setOnAction((e)->{
//			drawer.draw(new Circle3D(new Point(Integer.valueOf(ipX.getText()), Integer.valueOf(ipY.getText())), Integer.valueOf(ipR.getText()), colorPicker.getValue()));
//    		drawer.draw(new Ellipse3D(new Point(Integer.valueOf(ipX.getText()), Integer.valueOf(ipY.getText())), Integer.valueOf(ipR.getText()), Integer.valueOf(ipR.getText()) / 4, colorPicker.getValue()));
//		});
		
		ok.setOnAction((e)->{
			Point3D p = new Point3D(Integer.parseInt(ipX.getText()), Integer.parseInt(ipY.getText()), Integer.parseInt(ipZ.getText()));
			// Kill the Oy coordinate
			int X_p_2D = (int) (p.x - (p.y * Math.sqrt(2) / 2));
			int Y_p_2D = (int) (p.z - (p.y * Math.sqrt(2) / 2)); 
			Point p2d = new Point(X_p_2D, Y_p_2D);
			drawer.draw(new Circle3D(p2d, Integer.valueOf(ipR.getText()), colorPicker.getValue()));
    		drawer.draw(new Ellipse3D(p2d, Integer.valueOf(ipR.getText()), Integer.valueOf(ipR.getText()) / 4, colorPicker.getValue()));
		});
	}
}
