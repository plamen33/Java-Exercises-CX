
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class ScoreScreen {

	public static void display(Integer score) {
		final double FONT_SIZE = 17.0;
		Label label = new Label("Your score is: " + score + "/27");
		label.setFont(new Font(FONT_SIZE));
		String result = "";

		if(score == 27){result = "Well done.";}
		else if(score == 26||score==25){result = "Almost perfect."; }
		else if(score == 24|| score == 23|| score == 22){result = "Good result !"; }
		else if(score == 20|| score == 21){result = "Not bad, but try more !"; }
		else if (score<20){result = "Surely you could do better.";}

		Label labelResult = new Label(result);

		if(score == 27){result = "Well done."; labelResult.setTextFill(Paint.valueOf("green"));}
		else if(score == 26||score==25){result = "Almost perfect."; labelResult.setTextFill(Paint.valueOf("blue"));}
		else if(score == 24 || score == 23 || score == 22){result = "Good result !"; labelResult.setTextFill(Paint.valueOf("orange"));}
		else if(score == 20 || score == 21){result = "Not bad, but try more !"; labelResult.setTextFill(Paint.valueOf("lime"));}
		else if (score<20){result = "Surely you could do better."; labelResult.setTextFill(Paint.valueOf("red"));}

		labelResult.setFont(new Font(FONT_SIZE));


		Button button = new Button("Try again?");
		button.setOnAction(e -> Main.newTest());
		button.setFont(new Font(FONT_SIZE));

		Button button1 = new Button("Get Answers");
		button1.setOnAction(e -> Main.Answers());
		button1.setFont(new Font(FONT_SIZE));

		Button button2 = new Button("Close test");
		button2.setOnAction(e -> Main.onClose());
		button2.setFont(new Font(FONT_SIZE));


		VBox layout = new VBox(21);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label, labelResult, button);

		layout.getChildren().addAll(button1);
		layout.getChildren().addAll(button2);
		Scene scene = new Scene(layout, 500, 500);

		Main.setScene(scene);

	}
}
