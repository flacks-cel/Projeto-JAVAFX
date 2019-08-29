package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Cliente;

public class ClienteListController implements Initializable{
	
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
	
	@FXML
	public void onBtNovoAction() {
		System.out.println("Teste do click");
	}

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

}
