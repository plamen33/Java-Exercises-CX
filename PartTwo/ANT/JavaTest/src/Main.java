import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 500;
	private static final int DEFAULT_VALUE_INSETS = 35;
	private static final int NUMBER_OF_QUESTIONS = 27;
	private static int score = 0;
	static Stage stage;
	private static int counter = 0;

	static ArrayList<String> questions = new ArrayList<String>();
	static ArrayList<String> answersA = new ArrayList<String>();
	static ArrayList<String> answersB = new ArrayList<String>();
	static ArrayList<String> answersC = new ArrayList<String>();
	static ArrayList<String> answersD = new ArrayList<String>();
	static ArrayList<String> answers = new ArrayList<String>();

	public static void main(String[] args) {

		data();
		launch(args);

	}

	public static void setScene(Scene scene) {
		stage.setScene(scene);
	}

	public static void check(String answer) {

		if (answer.equals(answers.get(counter))) {
			score++;
		}

		counter++;
		if (counter == NUMBER_OF_QUESTIONS) {
			ScoreScreen.display(score);
			return;
		}

		QuestionScreen.display(questions.get(counter), answersA.get(counter), answersB.get(counter), answersC.get(counter),
				answersD.get(counter));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		final double MAX_FONT_SIZE = 18.0; // define max font size you need
		final double FONT_SIZE = 15.0; // define max font size you need
		stage = primaryStage;
		stage.setTitle("Java OOP Test");

		Label label = new Label("Welcome! Press the button to start the test.\n          This is the Java OOP test.");
		label.setTextFill(Paint.valueOf("green"));

		label.setFont(new Font(MAX_FONT_SIZE));
		label.setAlignment(Pos.CENTER);
		Button startButton = new Button("Start the test");
		startButton.setFont(new Font(FONT_SIZE));
		questions.get(0);
		startButton.setOnAction(e -> {
			QuestionScreen.display(questions.get(0), answersA.get(0), answersB.get(0), answersC.get(0), answersD.get(0));
		});

		StackPane top = new StackPane();
		top.getChildren().add(label);

		StackPane middle = new StackPane();
		middle.getChildren().add(startButton);

		BorderPane borderLayout = new BorderPane();
		borderLayout.setTop(top);
		borderLayout.setCenter(middle);
		borderLayout.setPadding(new Insets(DEFAULT_VALUE_INSETS,DEFAULT_VALUE_INSETS,DEFAULT_VALUE_INSETS,DEFAULT_VALUE_INSETS));
		Scene scene = new Scene(borderLayout, WINDOW_HEIGHT, WINDOW_WIDTH);

		stage.getIcons().add(new Image(getClass().getResource("cup.png").toExternalForm())); // setting the new icon and favicon
		stage.setScene(scene);
		stage.show();
	}

	public static void newTest() {
		score = 0;
		counter = 0;
		QuestionScreen.display(questions.get(0), answersA.get(0), answersB.get(0), answersC.get(0), answersD.get(0));

	}

	private static void data() {
		questions.add("When one object acquires all the properties and behaviours of parent object is known, as :");
		answersA.add("Polymorphism");
		answersB.add("Inheritance");
		answersC.add("Abstraction");
		answersD.add("Composition");
		answers.add("Inheritance");

		questions.add("Binding (or wrapping) code and data together into a single unit is known, as:");
		answersA.add("Polymorphism");
		answersB.add("Inheritance");
		answersC.add("Abstraction");
		answersD.add("Encapsulation");
		answers.add("Encapsulation");

		questions.add("Constructor can be ");
		answersA.add("final");
		answersB.add("static");
		answersC.add("private");
		answersD.add("abstract");
		answers.add("private");

		questions.add("An interface cannot be: ");
		answersA.add("used to define abstract data types");
		answersB.add("instantiated");
		answersC.add("extended by other interfaces");
		answersD.add("implemented by a class or structure");
		answers.add("instantiated");

		questions.add("An interface method is ");
		answersA.add("default");
		answersB.add("abstract");
		answersC.add("extended");
		answersD.add("protected");
		answers.add("abstract");
		
		questions.add("Interface methods cannot be ");
		answersA.add("static (assume the use of Java 8)");
		answersB.add("abstract");
		answersC.add("private");
		answersD.add("public");
		answers.add("private");

		questions.add("Abstract classes cannot be :");
		answersA.add("extended");
		answersB.add("declared public");
		answersC.add("instantiated");
		answersD.add("protected");
		answers.add("instantiated");

		questions.add("Inner class can be made private :");
		answersA.add("true");
		answersB.add("false");
		answersC.add("no idea");
		answersD.add("next question please");
		answers.add("true");

		questions.add("Existing package in java is :");
		answersA.add("java.lung");
		answersB.add("java.language");
		answersC.add("java.lang");
		answersD.add("java.tran");
		answers.add("java.lang");

		questions.add("Which is a non-static method having the same name as its class?");
		answersA.add("Field");
		answersB.add("Method");
		answersC.add("Constructor");
		answersD.add("Abstract method");
		answers.add("Constructor");

		questions.add("Final variables cannot be");
		answersA.add("declared");
		answersB.add("initialized");
		answersC.add("changed after initilization");
		answersD.add("accessed outside object ");
		answers.add("changed after initilization");


		questions.add("Final Methods cannot be");
		answersA.add("overridden and overloaded");
		answersB.add("overloaded");
		answersC.add("Used with non final variables");
		answersD.add("overridden");
		answers.add("overridden");

		questions.add("Static variables can");
		answersA.add("only be accessed by static methods");
		answersB.add("can be accessed even without creating an object of a class");
		answersC.add("not be inherited");
		answersD.add("not be accessed using class prefix");
		answers.add("can be accessed even without creating an object of a class");

		questions.add("Singleton class");
		answersA.add("cannot have any object");
		answersB.add("cannot be sub classed");
		answersC.add("Can have only 1 object");
		answersD.add("cannot have static elements");
		answers.add("Can have only 1 object");

		questions.add("Protected data members");
		answersA.add("are accessible in subclass");
		answersB.add("are not accessible in subclass");
		answersC.add("are not accessible within package");
		answersD.add("are accessible from anywhere");
		answers.add("are accessible in subclass");

		questions.add("What kind of variables a class can consist of ?");
		answersA.add("class variables, instance variables");
		answersB.add("class variables, local variables, instance variables");
		answersC.add("class variables");
		answersD.add("class variables, local variables");
		answers.add("class variables, local variables, instance variables");

		questions.add("Objects are stored on");
		answersA.add("Stack");
		answersB.add("Heap");
		answersC.add("Stack and Heap");
		answersD.add("RAM");
		answers.add("Heap");

		questions.add("Reflection is:");
		answersA.add("a framework for object modification");
		answersB.add("process of modifying objects before compile");
		answersC.add("interface which extends Polymorphism");
		answersD.add("process of exam./modif. runtime behaviour of object at runtime");
		answers.add("process of exam./modif. runtime behaviour of object at runtime");

		questions.add("Reflection makes your application:");
		answersA.add("simpler");
		answersB.add("faster");
		answersC.add("slower");
		answersD.add("smaller");
		answers.add("slower");

		questions.add("In Reflection you need to precompile modified class:");
		answersA.add("true");
		answersB.add("false");
		answersC.add("depends on the situation of use");
		answersD.add("JVM decides that");
		answers.add("false");

		questions.add("Why do we use transient keyword:");
		answersA.add("to transfer data");
		answersB.add("to push Reflection in a class");
		answersC.add("to restrict access to certain fields");
		answersD.add("to tell which fields not to serialize");
		answers.add("to tell which fields not to serialize");

		questions.add("Which is correct about Singleton design pattern");
		answersA.add("It is a creational pattern");
		answersB.add("This pattern involves a single class");
		answersC.add("Its only object can be accessed directly without instantiation");
		answersD.add("All is correct");
		answers.add("All is correct");

		questions.add("This class is example of Singleton");
		answersA.add("ClassLoader");
		answersB.add("ComponentOrientation");
		answersC.add("Runtime");
		answersD.add("Date");
		answers.add("Runtime");

		questions.add("X implements Y and Y extends Z, which is correct ?");
		answersA.add("X x = new Y();");
		answersB.add("X x = new Z();");
		answersC.add("Z z = new Y();");
		answersD.add("Z z = new X();");
		answers.add("Z z = new X();");

		questions.add(" Object o1 = new Object();  System.out.println(o1.getClass() == Object.class); ");
		answersA.add("false");
		answersB.add("true");
		answersC.add("Compile error");
		answersD.add("Runtime error");
		answers.add("true");

		questions.add("Object a1 = new Object();  Object a2 = a1; System.out.print(a1 == a2); System.out.print(a2.equals(a1));");
		answersA.add("falsefalse");
		answersB.add("falsetrue");
		answersC.add("truetrue");
		answersD.add("truefalse");
		answers.add("truetrue");
		//27
		questions.add("Can abstract class have a constructor ?");
		answersA.add("No");
		answersB.add("Yes");
		answersC.add("Depends");
		answersD.add("Sometimes yes, sometimes no");
		answers.add("Yes");
	}

	public static void  onClose(){
		System.exit(0);
	}

	public static void Answers(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("OOP Java Test");
		alert.setTitle("Java Test Answers");
		alert.setContentText("Question1: Inheritance" +
				"\nQuestion2: Encapsulation" +
				"\nQuestion3: private" +
				"\nQuestion4: instantiated" +
				"\nQuestion5: abstract\n" +
				"Question6: private\n" +
				"Question7: instantiated\n" +
				"Question8: true\n" +
				"Question9: java.lang\n" +
				"Question10: Constructor\n"+
				"Question11: changed after initilization\n" +
				"Question12: overridden\n"+
				"Question13: can be accessed even without creating an object of class\n"+
				"Question14: Can have only 1 object\n"+
				"Question15: are accessible in subclass\n"+
				"Question16: class variables, local variables, instance variables\n" +
				"Question17: Heap\n"+
				"Question18: process of examining/modifying runtime behaviour of object at runtime\n" +
				"Question19: slower\n" +
				"Question20: false\n" +
				"Question21: to tell which fields not to serialize\n"+
				"Question22: All is correct\n"+
				"Question23: Runtime\n"+
				"Question24: Z z = new X();\n" +
				"Question25: true\n"+
				"Question26: truetrue\n"+
				"Question27: Yes\n"

		);


		alert.show();

	}
}
