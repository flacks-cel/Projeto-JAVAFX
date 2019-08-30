package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Cliente;

public class ClienteFormController implements Initializable {
	
	private Cliente entity;

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

	@FXML
	public void onBtSalvarAction() {
		System.out.println("Bot�o Salvar");
	}

	@FXML
	public void onBtCancelarAction() {
		System.out.println("Bot�o Cancelar");
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
			throw new IllegalStateException("Entity est� vazia");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtEmpresa.setText(entity.getEmpresa());
		txtProjeto.setText(entity.getProjeto());
	}

}
