package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	public void onBtNovoAction() {
		System.out.println("Teste do click");
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

}
