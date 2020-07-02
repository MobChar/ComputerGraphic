package menuLoader;

import drawer.Drawer;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;

public class Loader3D  extends MenuLoaderInterface{
	public Loader3D(VBox content_box,Drawer drawer, ColorPicker color_picker) {
		super(content_box,drawer, color_picker);
		// TODO Auto-generated constructor stub
		//Contructor phai ke thua tu MenuLoaderInterface
	}

	@Override
	public void init() {
		
		Button rectangular_btn=new Button("Rectangular");
		rectangular_btn.setPrefWidth(100);
		rectangular_btn.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		Button sphere_btn=new Button("Sphere");
		sphere_btn.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		sphere_btn.setPrefWidth(100);
		Button refesh_btn=new Button("Refesh");
		refesh_btn.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		refesh_btn.setPrefWidth(100);
		
		rectangular_btn.setOnAction((e)->{
			new RectangularLoader(this.contentBox,drawer,colorPicker);
		});
		
		sphere_btn.setOnAction((e)->{
			new SphereLoader(this.contentBox,drawer,colorPicker);
		});
		
		refesh_btn.setOnAction((e)->{
			this.drawer.clear();
		});
		
		contentBox.setSpacing(20);
		this.contentBox.getChildren().addAll(rectangular_btn,sphere_btn,refesh_btn);
	}

}
