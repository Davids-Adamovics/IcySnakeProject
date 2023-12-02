package lv.venta;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lv.venta.Game;
import lv.venta.backgroundMusic;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;

import lv.venta.enumGender;
import lv.venta.player;

public class PrimaryController {

	@FXML
	private TextField usernameInput;
	@FXML
	private TextField ageInput;
	@FXML
	private RadioButton malePick;
	@FXML
	private RadioButton femalePick;
	@FXML
	private Button buttonSave;
	private backgroundMusic musicPlayer;
	
	@FXML
	private Slider volumeSlider;
	   
	public static player currentPlayer;
	
	
	public void SwitchTogame(ActionEvent event) throws IOException {
		try {

			String username = usernameInput.getText();
			byte age = Byte.parseByte(ageInput.getText());
			enumGender gender = malePick.isSelected() ? enumGender.male : enumGender.female;

			currentPlayer = new player(username, age, gender);

			System.out.println("Player Information:");
			System.out.println(currentPlayer);

			musicPlayer = new backgroundMusic(new String[]{"game1.wav", "game2.wav", "game3.wav"});

			
			Game game = new Game();
			Stage gameStage = new Stage();
			game.start(gameStage);
			

			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			currentStage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   // Getter method for currentPlayer
    public player getCurrentPlayer() {
        return currentPlayer;
    }

	
}