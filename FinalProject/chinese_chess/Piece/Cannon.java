package Piece;
import javafx.scene.layout.Pane;
public class Cannon extends Piece{
	public Cannon(double x, double y, double alpha, char side, Pane pane){
		super(x, y, alpha, side, pane);
		if(side == 'R'){
			image_view = createImageView("/Images/Pieces/red_cannon.png");
		}
		else{
			image_view = createImageView("/Images/Pieces/black_cannon.png");
		}
		image_view.setOpacity(alpha);
		pane.getChildren().add(this.image_view);
		image_view.relocate(x * RATIO, y * RATIO);
	}
}