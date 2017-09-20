import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Rain extends Application{
	Stage rootStage;
	public static Water water;
	static Sound sound;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		sound = new Sound();
		water= new Water(primaryStage);
		ArrayList<Drop> drops = new ArrayList<>();
		rootStage=primaryStage;
		rootStage.setWidth(800);
		rootStage.setHeight(600);
		rootStage.setTitle("Rain");
		BorderPane rootNode = new BorderPane();
		Pane animationPane = new Pane();
		rootStage.setScene(new Scene(rootNode, rootStage.getWidth(), rootStage.getHeight()));
		Slider slider = new Slider(0,5000,0);
		slider.valueProperty().addListener(e->{
			int newVal = (int) slider.getValue();
			while(newVal>drops.size())drops.add(new Drop(animationPane,primaryStage));
			while(newVal<drops.size()) {
				drops.get(drops.size()-1).remove(animationPane);
				drops.remove(drops.size()-1);
			}
			if(newVal>0) {
				if(!sound.isRunning())sound.start();
				sound.setVolume(newVal/100);
			}
			else sound.stop();
		});
		rootNode.setTop(slider);
		rootNode.setCenter(animationPane);
		rootNode.getChildren().add(water.getNode());
		animationPane.toBack();
		rootStage.show();
	}
}
