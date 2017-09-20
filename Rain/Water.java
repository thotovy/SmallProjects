import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Water {
	private double level=0;
	private Rectangle rect;
	private Stage rootStage;
	public Water(Stage stage) {
		rootStage=stage;
		rect = new Rectangle(0,rootStage.getHeight(),rootStage.getWidth(),level);
		rect.setFill(Color.BLUE);
	}
	public void riseLevel() {
		level+=0.001;
		rect.setHeight(level);
		rect.setY(rootStage.getHeight()-level);
		rect.setWidth(rootStage.getWidth());	
	}
	public Node getNode() {
		return rect;
	}
}
