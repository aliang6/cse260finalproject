import Piece.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseDragEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;

public class StartScreen extends Application{
	final double RATIO = 0.6;
	Scene game_screen = null, start_screen = null;
	ImageView red_turn, black_turn, player_turn;
	Cannon cannon;

	public void start(Stage primaryStage){
		// Stage Setup
		primaryStage.setTitle("Chinese Chess");
		primaryStage.setWidth(1920 * RATIO);
		primaryStage.setHeight(1115 * RATIO);
		primaryStage.setResizable(false);
		setupStartMenu(primaryStage);

		primaryStage.show();
	}

	public void setupStartMenu(Stage primaryStage){
		ImageView background = createImageView("/Images/main_menu.png", true);
		
		Button start_button = createButton("/Images/start.png");
		start_button.setOnMouseClicked(e -> {
			setupGameScreen(primaryStage);
			primaryStage.setScene(game_screen);
		});
		Button load_button = createButton("/Images/load.png");
		load_button.setOnMouseClicked(e -> {
			if(game_screen != null)
				primaryStage.setScene(game_screen);
		});
		Button about_button = createButton("/Images/about.png");
		about_button.setOnMouseClicked(e -> {

		});
		Button quit_button = createButton("/Images/quit.png");
		quit_button.setOnMouseClicked(e -> {
			System.exit(0);
		});

		Pane pane = new Pane();
		pane.getChildren().addAll(background, start_button, load_button, about_button, quit_button);
		start_button.relocate(600 * RATIO, 530 * RATIO);
		load_button.relocate(1000 * RATIO, 530 * RATIO);
		about_button.relocate(560 * RATIO, 730 * RATIO);
		quit_button.relocate(1000 * RATIO, 720 * RATIO);
		start_screen = new Scene(pane);
		start_screen.getStylesheets().add("/css/start_menu.css");
		primaryStage.setScene(start_screen);
	}

	public void setupGameScreen(Stage primaryStage){
		ImageView background = createImageView("/Images/board.png", true);
		red_turn = createImageView("/Images/red_turn.png", false);
		black_turn = createImageView("/Images/black_turn.png", false);
		player_turn = red_turn;
		ImageView captured_pieces = createImageView("/Images/captured_pieces.png", false);

		Button save_button = createButton("/Images/save.png");
		save_button.setOnMouseClicked(e ->{
			primaryStage.setScene(start_screen);
		});
		Button quit_button = createButton("/Images/quit.png");
		quit_button.setOnMouseClicked(e -> {
			System.exit(0);
		});
		
		Pane pane = new Pane();
		pane.getChildren().addAll(background, save_button, quit_button, player_turn, captured_pieces);
		save_button.relocate(1030 * RATIO, 850 * RATIO);
		quit_button.relocate(1410 * RATIO, 850 * RATIO);
		player_turn.relocate(990 * RATIO, 30 * RATIO);
		captured_pieces.relocate(990 * RATIO, 240 * RATIO);
		Board board = new Board(pane);
		setupPieces(pane);
		game_screen = new Scene(pane);
		game_screen.getStylesheets().add("/css/start_menu.css");
	}

	public void setupPieces(Pane pane){
		Side black_side = new Side('B', pane, false); // Setup black board pieces
		Side red_side = new Side('R', pane, false); // Setup red board pieces
		Side captured_red_side = new Side('R', pane, true); // Setup captured red pieces
		Side captured_black_side = new Side('B', pane, true); // Setup captured black pieces
	}

	//===============================Helper Functions=======================================
	public Button createButton(String image_location){
		return new Button("", createImageView(image_location, false)); 
	}

	public ImageView createImageView(String image_location){
		Image image = new Image(image_location);
		ImageView image_view = new ImageView(image);
		image_view.setFitWidth(image.getWidth() * RATIO);
		image_view.setPreserveRatio(true);
		image_view.setSmooth(true);
		image_view.setCache(true);
		return image_view;
	}

	public ImageView createImageView(String image_location, boolean background){
		Image image = new Image(image_location);
		ImageView image_view = new ImageView(image);
		if(background){
			image_view.setFitWidth(1920 * RATIO);
		}
		else{
			image_view.setFitWidth(image.getWidth() * RATIO);
		}
		image_view.setPreserveRatio(true);
		image_view.setSmooth(true);
		image_view.setCache(true);
		return image_view;
	}
	//======================================================================================

	public static void main(String[] args){
		launch("StartScreen");
	}
}