package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClienteFormController implements Initializable {

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

	@FXML
	public void onBtSalvarAction() {
		System.out.println("Botão Salvar");
	}

	@FXML
	public void onBtCancelarAction() {
		System.out.println("Botão Cancelar");
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

}
