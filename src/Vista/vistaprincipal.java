package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Modelo.Persona;
import application.Main;
import Controlador.ControladorMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class vistaprincipal implements Initializable {

	private ControladorMain CmiMain;

	private Main miMain;

	@FXML
	private Button btnAceptar;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnBorrar;

	@FXML
	private TableView<Persona> miTabla;

	@FXML
	private TableColumn<Persona, String> colName;

	@FXML
	private TableColumn<Persona, String> colApe;

	@FXML
	private TableColumn<Persona, Integer> colTf;

	// Relaciona el main con el controlador
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.miMain = ProgramaPrincipal;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		miTabla.setItems(ControladorMain.getData());
		colName.setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
		colApe.setCellValueFactory(new PropertyValueFactory<Persona, String>("Apellido"));
		colTf.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("telefono"));
	}

	@FXML
	private void ventanaIniciar() {
		this.miMain.mostrarAgenda();
	}

	public void borrar() {
		if (miTabla.getSelectionModel().getSelectedItem() != null) {
			miTabla.getItems().remove(miTabla.getSelectionModel().getSelectedItem());
			miTabla.getSelectionModel().clearSelection();
		} else {
			System.out.println("no hay selección");
			ControladorMain.errorAlert("intentando borrar un objeto no seleccionado, por favor seleccione una fila");
		}
	}

	public void modificar() {
		if (miTabla.getSelectionModel().getSelectedItem() != null) {
		// ControladorMain.setdata(new Persona("pepe", "albondiga", 293648632)); //añade datos no se actualiza
		miMain.mostrarEditorModifica(miTabla.getSelectionModel().getSelectedItem(), miTabla.getSelectionModel().getSelectedIndex());
		} else {
			System.out.println("no hay selección");
			ControladorMain.errorAlert("intentando editar un objeto no seleccionado, por favor seleccione una fila");
		}
	}

	public void insertar() {
		miMain.mostrarEditorInsertar();
	}
}