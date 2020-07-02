package menuLoader;

import coordinateSystem.Point;
import drawableObject.Circle3D;
import drawableObject.Ellipse3D;
import drawableObject.Line;
import drawer.Drawer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		Label r = new Label("R:");
		TextField ipR = new TextField();
		VBox root = new VBox();
		Button ok = new Button("OK");
		root.getChildren().add(x);
		root.getChildren().add(ipX);
		root.getChildren().add(y);
		root.getChildren().add(ipY);
		root.getChildren().add(r);
		root.getChildren().add(ipR);
		root.getChildren().add(ok);
		Scene scene = new Scene(root, 400, 400);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
		ok.setOnAction((e)->{
			drawer.draw(new Circle3D(new Point(Integer.valueOf(ipX.getText()), Integer.valueOf(ipY.getText())), Integer.valueOf(ipR.getText()), colorPicker.getValue()));
    		drawer.draw(new Ellipse3D(new Point(Integer.valueOf(ipX.getText()), Integer.valueOf(ipY.getText())), Integer.valueOf(ipR.getText()), Integer.valueOf(ipR.getText()) / 4, colorPicker.getValue()));
		});
	}

	

}
