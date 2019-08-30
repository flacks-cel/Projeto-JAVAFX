package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Cliente;
import model.services.ClienteService;

public class ClienteFormController implements Initializable {
	
	private Cliente entity;
	
	private ClienteService service;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtEmpresa;

	@FXML
	private TextField txtProjeto;

	@FXML
	private Label labelErroE;
	
	@FXML
	private Label labelErroP;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btCancelar;
	
	public void setCliente(Cliente entity) {
		this.entity = entity;
	}
	public void setClienteService(ClienteService service) {
		this.service = service;
	}

	@FXML
	public void onBtSalvarAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("A entity estava nula!");
		}
		if(service == null) {
			throw new IllegalStateException("O Service estava nulo!");
		}
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			Utils.atualStage(event).close();
		}
		catch(DbException e) {
			Alerts.showAlert("Erro ao salvar o cliente", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private Cliente getFormData() {
		Cliente obj = new Cliente();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setEmpresa(txtEmpresa.getText());
		obj.setProjeto(txtProjeto.getText());
		
		return obj;
	}
	
	@FXML
	public void onBtCancelarAction(ActionEvent event) {
		Utils.atualStage(event).close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();

	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtEmpresa, 40);
		Constraints.setTextFieldMaxLength(txtProjeto, 40);
	}
	
	public void updateFormData() {
		if(entity == null) {
			throw new IllegalStateException("A entity está vazia");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtEmpresa.setText(entity.getEmpresa());
		txtProjeto.setText(entity.getProjeto());
	}

}
