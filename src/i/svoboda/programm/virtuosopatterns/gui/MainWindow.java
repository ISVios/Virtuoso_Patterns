package i.svoboda.programm.virtuosopatterns.gui;

import java.net.URL;
import java.util.ResourceBundle;

import i.svoboda.programm.virtuosopatterns.VPMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainWindow implements Initializable{
	private Stage stage;
	private Scene scene;
	@FXML
	private Parent root;
	
	
	public MainWindow() {
		
		// need?
		
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
		
		try {
			
			// init main frame
			
			stage = new Stage();
			scene = new Scene(root, 1024, 768);
			
			stage.setMinWidth(((AnchorPane)root).getMinWidth());
			stage.setMinHeight(((AnchorPane)root).getMinHeight());
			
			stage.setScene(scene);
			
			stage.setOnCloseRequest(we->{ VPMain.quitProgramm(); }); // normal exit
			stage.setTitle("Vrtuoso Patterns " + VPMain.version);
					
			stage.show();
			
			
			
		} catch (Exception e) {
			
			// gui error
			e.printStackTrace();
			VPMain.quitProgramm(); // !!!!!!!!!!!!!!!!
		}
		
		
	}

}
