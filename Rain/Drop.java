import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Drop {
	private Rectangle rect;
	private boolean removed=false;
	public Drop(Pane rootNode, Stage stage) {
		rect = new Rectangle(Math.random()*2+1,Math.random()*20+8);
		rect.setFill(Color.BLUE);
		rootNode.getChildren().add(rect);
		animate(stage);
	}
	private void animate(Stage stage) {
		rect.setX(Math.random()*stage.getWidth());
		TranslateTransition transition = new TranslateTransition(Duration.seconds(Math.random()*1.25+0.15),rect);
		transition.setToY(stage.getHeight());
		transition.setFromY(-Math.random()*200);
		transition.play();
		transition.setOnFinished(e->{
			Rain.water.riseLevel();
			if(!removed)this.animate(stage);
		});
	}
	public void remove(Pane rootNode) {
		removed=true;
		rootNode.getChildren().remove(rect);
	}

}
