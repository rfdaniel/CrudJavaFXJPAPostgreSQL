package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane root = FXMLLoader.load(getClass().getResource("/view/CadastroCliente.fxml"));
		
		Scene scene = new Scene(root, 600, 550);
		
		primaryStage.setTitle("CRUD de Clientes");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
