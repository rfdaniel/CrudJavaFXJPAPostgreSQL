package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import factory.CidadeListControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import listcontroller.CidadeListController;
import model.Cidade;

public class CidadeController extends Controller<Cidade> implements Initializable{

	private Cidade cidade;
	
    @FXML
    private TextField tfNomeCidade, tfNomeEstado, tfNomePais;

    @FXML
    private Button btLimpar, btExcluir, btAlterar, btIncluir;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//SETANDO O FOCUS NO TEXT FIELD NOME CIDADE
		tfNomeCidade.requestFocus();
	}
	
	@FXML
    void handleAlterar(ActionEvent event) {
		getCidade().setNomeCidade(tfNomeCidade.getText());
    	getCidade().setNomeEstado(tfNomeEstado.getText());
    	getCidade().setNomePais(tfNomePais.getText());
    	
    	super.save(getCidade());
    	
    	handleLimpar(event);
    	
    	atualizarBotoes();
    }

    @FXML
    void handleExcluir(ActionEvent event) {
		// MENSAGEM DE ALERTA PARA O USUÃ�RIO CONFIRMAR UMA EXCLUSÃƒO
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmação");
		alert.setHeaderText("Está operação excluirá todas as informações selecionadas da base de dados.");
		alert.setContentText("Deseja realmente excluir?");
		// Capturar as resposta do usuÃ¡rio sobre a mensagem de confirmaÃ§Ã£o
		Optional<ButtonType> resposta = alert.showAndWait();
		if (resposta.get().equals(ButtonType.OK)) {
			super.remove(getCidade());
			handleLimpar(event);
		} else if (resposta.get().equals(ButtonType.CANCEL)) {

		}
		
		atualizarBotoes();
    }

    @FXML
    void handleIncluir(ActionEvent event) {
    	getCidade().setNomeCidade(tfNomeCidade.getText());
    	getCidade().setNomeEstado(tfNomeEstado.getText());
    	getCidade().setNomePais(tfNomePais.getText());
    	
    	super.save(getCidade());
    	
    	handleLimpar(event);
    	
    	atualizarBotoes();
    }

    @FXML
	void handleLimpar(ActionEvent event) {
		tfNomeCidade.setText("");
		tfNomeEstado.setText("");
		tfNomePais.setText("");

		// LIMPANDO AS INFORMACOES DO CLIENTE
		cidade = null;

		tfNomeCidade.requestFocus();

		atualizarBotoes();
	}
    
	private void atualizarBotoes() {
		btIncluir.setDisable(getCidade().getId() != null);
		btAlterar.setDisable(getCidade().getId() == null);
		btExcluir.setDisable(getCidade().getId() == null);
	}
    
    @FXML
    void handleMouseClickedNome(MouseEvent event) throws IOException{
    	
    	CidadeListController listagem = CidadeListControllerFactory.getInstance();
    	listagem.abrir();
		
		setCidade(listagem.getCidadeSelecionada());
		
		tfNomeCidade.setText(getCidade().getNomeCidade());
		tfNomeEstado.setText(getCidade().getNomeEstado());
		tfNomePais.setText(getCidade().getNomePais());
		
		atualizarBotoes();
    }
	
	public Cidade getCidade() {
		if(cidade == null)
			cidade = new Cidade();
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
