package factory;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import listcontroller.CidadeListController;

public class CidadeListControllerFactory {
	
	public static CidadeListController getInstance() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(CidadeListControllerFactory.class.getResource("/view/ListagemCidade.fxml"));
    	Parent root = loader.load();
    	
    	//OBTENDO O CONTROLADOR
    	CidadeListController listagem = loader.getController();
    	listagem.setParent(root);
    	
    	return listagem;
	}
}
