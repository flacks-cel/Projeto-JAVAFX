package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Cliente;
import model.services.ClienteService;

public class ClienteListController implements Initializable{
	
	private ClienteService service;
	
	@FXML
	private TableView<Cliente> tableViewCliente;
	
	@FXML
	private TableColumn<Cliente, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnEmpresa;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnProjeto;
	
	@FXML
	private Button btNovo;
	
	public void setClienteService(ClienteService service) {
		this.service = service;
	}
	
	@FXML
	public void onBtNovoAction(ActionEvent evento) {
		Stage parentStage = Utils.atualStage(evento);
		criaDialogoFormu("/gui/ClienteForm.fxml", parentStage);
	}
	
	private ObservableList<Cliente> obsList;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		inicializaNode();
		
	}

	private void inicializaNode() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
		tableColumnProjeto.setCellValueFactory(new PropertyValueFactory<>("projeto"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewCliente.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Service estava nulo!");
		}
		
		List<Cliente> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewCliente.setItems(obsList);
	}
	
	private void criaDialogoFormu(String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			Stage dialogoStage = new Stage();
			dialogoStage.setTitle("Insira os dados do cliente");
			dialogoStage.setScene(new Scene(pane));
			dialogoStage.setResizable(false);
			dialogoStage.initOwner(parentStage);
			dialogoStage.initModality(Modality.WINDOW_MODAL);
			dialogoStage.showAndWait();
			
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Erro ao carregar a visualização", e.getMessage(), AlertType.ERROR);
		}
	}

}
