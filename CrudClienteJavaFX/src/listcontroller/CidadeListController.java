package listcontroller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import factory.JPAFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Cidade;
import model.Cliente;
import repository.CidadeRepository;
import repository.ClienteRepository;

public class CidadeListController implements Initializable{

	private Cidade cidade;
	private Stage stage;
	private Parent parent;

	@FXML
    private TextField tfPesquisar;

	@FXML
    private TableView<Cidade> tvCidades;

    @FXML
    private TableColumn<Cidade, Integer> tcIdCidade;

    @FXML
    private TableColumn<Cidade, String> tcNomeCidade;

    @FXML
    private TableColumn<Cidade, String> tcNomeEstado;

    @FXML
    private TableColumn<Cidade, String> tcNomePais;
    
    @FXML
    private Button btPesquisar;
    
    public void abrir() {
    	stage = new Stage();
		Scene scene = new Scene(parent, 500, 400);
		stage.setTitle("Consulta de Cidades");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// CONFIGURANDO AS COLUNAS DAS TABELAS CONFORME OS ATRIBUTOS DA CLASSE CLIENTE
		tcIdCidade.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcNomeCidade.setCellValueFactory(new PropertyValueFactory<>("nomeCidade"));
		tcNomeEstado.setCellValueFactory(new PropertyValueFactory<>("nomeEstado"));
		tcNomePais.setCellValueFactory(new PropertyValueFactory<>("nomePais"));	
	}

    @FXML
    void handleOnMouseClicked(MouseEvent event) {
		// VERIFICANDO SE Ã‰ O BOTÃƒO PRINCIPAL QUE FOI CLIADO
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			// VERIFICANDO SE A QUANTIDADE DE CLIQUES NO BOTÃƒO PRIMÃ�RIO Ã‰ IGUAL A 2
			if (event.getClickCount() == 2) {

				//PREENCHE CIDADE
				cidade = tvCidades.getSelectionModel().getSelectedItem();
				
				//FECHA TELA DE LISTAGEM APÓS CLICK NA LINHA
				getStage().close();

			}
		}
    }
    
    public Cidade getCidadeSelecionada() {
    	return cidade;
    }

    @FXML
    void handlePesquisar(ActionEvent event) {
		CidadeRepository repository = new CidadeRepository(JPAFactory.getEntityManager());
		List<Cidade> lista = repository.getCidades(tfPesquisar.getText());

		if (lista.isEmpty()) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Informação:");
			alerta.setHeaderText(null);
			alerta.setContentText("A consulta não retornou dados!");
			alerta.show();
		}

		tvCidades.setItems(FXCollections.observableList(lista));
    }
    
    public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
}
