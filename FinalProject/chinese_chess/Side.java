import Piece.*;
import javafx.scene.layout.Pane;

public class Side{
	General general;
	Advisor left_advisor, right_advisor;
	Elephant left_elephant, right_elephant;
	Horse left_horse, right_horse;
	Chariot left_chariot, right_chariot;
	Cannon left_cannon, right_cannon;
	Soldier soldier_one, soldier_two, soldier_three, soldier_four, soldier_five;
	public Side(char side, Pane pane, boolean captured){ // 'R' or 'B'
		int row, col, spacing = 100;
		if(!captured){ // On board
			int c_row, c_col, s_row;
			if(side == 'R'){ // Red side
				col = 22;
				row = 952;
				c_row = 750;
				c_col = 124;
				s_row = 646;
			}
			else{ // Black side
				col = 22;
				row = 34;
				c_row = 238;
				c_col = 124;
				s_row = 338;
			}
			left_chariot = new Chariot(col, row, 1, side, pane);
			left_horse = new Horse((col + spacing), row, 1, side, pane);
			left_elephant = new Elephant((col + 2 * spacing), row, 1, side, pane);
			left_advisor = new Advisor((col + 3 * spacing), row, 1, side, pane);
			general = new General((col + 4 * spacing), row, 1, side, pane);
			right_advisor = new Advisor((col + 5 * spacing), row, 1, side, pane);
			right_elephant = new Elephant((col + 6 * spacing), row, 1, side, pane);
			right_horse = new Horse((col + 7 * spacing), row, 1, side, pane);
			right_chariot = new Chariot((col + 8 * spacing), row, 1, side, pane);
			left_cannon = new Cannon(c_col, c_row, 1, side, pane);
			right_cannon = new Cannon((c_col + 6 * spacing), c_row, 1, side, pane);
			soldier_one = new Soldier(col, s_row, 1, side, pane);
			soldier_two = new Soldier((col + 2 * spacing), s_row, 1, side, pane);
			soldier_three = new Soldier((col + 4 * spacing), s_row, 1, side, pane);
			soldier_four = new Soldier((col + 6 * spacing), s_row, 1, side, pane);
			soldier_five = new Soldier((col + 8 * spacing), s_row, 1, side, pane);
			left_chariot.addDragAndDrop();
			left_horse.addDragAndDrop();
			left_elephant.addDragAndDrop();
			left_advisor.addDragAndDrop();
			general.addDragAndDrop();
			right_advisor.addDragAndDrop();
			right_elephant.addDragAndDrop();
			right_horse.addDragAndDrop();
			right_chariot.addDragAndDrop();
			left_cannon.addDragAndDrop();
			right_cannon.addDragAndDrop();
			soldier_one.addDragAndDrop();
			soldier_two.addDragAndDrop();
			soldier_three.addDragAndDrop();
			soldier_four.addDragAndDrop();
			soldier_five.addDragAndDrop();
		}
		else{ // Captured
			if(side == 'R'){ // Red side
				row = 598;
				col = 996;
			}
			else{ // Black side
				row = 368;
				col = 996;
			}
			soldier_one = new Soldier(col, row, 0.5, side, pane);
			soldier_two = new Soldier((col + spacing), row, 0.5, side, pane);
			soldier_three = new Soldier((col + 2 * spacing), row, 0.5, side, pane);
			soldier_four = new Soldier((col + 3 * spacing), row, 0.5, side, pane);
			soldier_five = new Soldier((col + 4 * spacing), row, 0.5, side, pane);
			left_cannon = new Cannon((col + 5 * spacing), row, 0.5, side, pane);
			right_cannon = new Cannon((col + 6 * spacing), row, 0.5, side, pane);
			left_chariot = new Chariot((col + 7 * spacing), row, 0.5, side, pane);
			right_chariot = new Chariot(col, row + spacing, 0.5, side, pane);
			left_horse = new Horse((col +  spacing), row + spacing, 0.5, side, pane);
			right_horse = new Horse((col + 2 * spacing), row + spacing, 0.5, side, pane);
			left_elephant = new Elephant((col + 3 * spacing), row + spacing, 0.5, side, pane);
			right_elephant = new Elephant((col + 4 * spacing), row + spacing, 0.5, side, pane);
			left_advisor = new Advisor((col + 5 * spacing), row + spacing, 0.5, side, pane);
			right_advisor = new Advisor((col + 6 * spacing), row + spacing, 0.5, side, pane);
			general = new General((col + 7 * spacing), row + spacing, 0.5, side, pane);
		}
	}
}