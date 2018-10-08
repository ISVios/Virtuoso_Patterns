package a.a.zhemanov.programm.virtuosopatterns;

import a.a.zhemanov.programm.virtuosopatterns.bnf.BNF;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		try {

			BNF bnf = new BNF();

			bnf.setText("a = 5  /n b = a + 6");
			bnf.parse();
			bnf.solution();

			System.out.println(bnf.isChar("a"));

			System.exit(0);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
