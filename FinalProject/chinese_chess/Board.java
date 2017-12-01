import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseDragEvent;

public class Board{
	Rectangle[][] board;
	final double RATIO = 0.6;
	int x = 24, y = 36, spacing = 100;

	public Board(Pane pane){
		board = new Rectangle[10][9];
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 9; j++){
				board[i][j] = new Rectangle((x + j * spacing) * RATIO, (y + i * spacing) * RATIO, spacing * RATIO, spacing * RATIO);
				board[i][j].setFill(Color.rgb(183, 17, 17, 0.4));
				board[i][j].setStroke(Color.BLACK);
				pane.getChildren().add(board[i][j]);
			}
		}
		y = 544;
		for(int i = 5; i < 10; i++){
			for(int j = 0; j < 9; j++){
				board[i][j] = new Rectangle((x + j * spacing) * RATIO, (y + (i - 5) * spacing) * RATIO, spacing * RATIO, spacing * RATIO);
				board[i][j].setFill(Color.rgb(183, 17, 17, 0.4));
				board[i][j].setStroke(Color.BLACK);
				final int i2 = i, j2 = j;
				board[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
				  public void handle(MouseEvent e) {
				      board[i2][j2].setFill(Color.rgb(12, 128, 34, 0.4));
				  }
				});
				board[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
				  public void handle(MouseEvent e) {
				      board[i2][j2].setFill(Color.rgb(183, 17, 17, 0.4));
				  }
				});

				pane.getChildren().add(board[i][j]);

			}
		}
	}
}