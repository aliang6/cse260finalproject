package Piece;
import javafx.scene.layout.Pane;
public class General extends Piece{
	public General(double x, double y, double alpha, char side, Pane pane){
		super(x, y, alpha, side, pane);
		if(side == 'R'){
			image_view = createImageView("/Images/Pieces/red_general.png");
		}
		else{
			image_view = createImageView("/Images/Pieces/black_general.png");
		}
		image_view.setOpacity(alpha);
		pane.getChildren().add(this.image_view);
		image_view.relocate(x * RATIO, y * RATIO);
	}
}