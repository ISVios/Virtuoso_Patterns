/**
 * 
 * @author vios 
 * @versio 0.0.1
 * 
 */
package i.svoboda.programm.virtuosopatterns;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import i.svoboda.programm.virtuosopatterns.gui.MainWindow;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class VPMain extends Application {
	
	public final static String version = "0.0.1"; // i not sure need final

	public static int exitOut = 0;

	public static String[] args; // change to HashMap and parse function

	public static void main(String[] args) { // will never use throw
		
		Locale.setDefault(Locale.ENGLISH);

		// don't use System.gc();

		VPMain.args = args; // change to HashMap and parse function

		launch(args);

	}

	@Override
	public void start(Stage notuse) { // will never use throw
		notuse = null;
		// don't use notuse

		try {

			// parse args !!!!!!!!!!!!!!!!!!!!!!

			// load config (def lang, prop)

			// init main frame

			FXMLLoader fxmlLoader = new FXMLLoader();

			fxmlLoader.setLocation(MainWindow.class.getResource("main_frame.fxml"));
			fxmlLoader.setResources(ResourceBundle.getBundle("i.svoboda.programm.virtuosopatterns.lang.lang", new Locale("eng"))); // get from config 

			fxmlLoader.load();
			
			fxmlLoader = null; // to gc

			// load plugins

			// add plugin to project

		} catch (Exception e) {

			// add crash frame without fx , maybe swing('JAlert')

//			Platform.runLater(() -> {
//
//				// init and show crash window
//				JFrame frame = new JFrame();
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				frame.setSize(600, 400);
//				frame.setVisible(true);
//
//			});

			e.printStackTrace(); // don't foget del or put in debug func

			quitProgramm(); // del need restart
		}

	}

	public static void quitProgramm() {

		Platform.exit();
		System.exit(exitOut);

	}

}
