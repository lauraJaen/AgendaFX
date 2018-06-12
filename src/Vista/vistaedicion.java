package Vista;

import Modelo.Persona;
import application.Main;
import Controlador.ControladorMain;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class vistaedicion {

	private Main myMain;

	@FXML
	private TextField TfNombre;

	@FXML
	private TextField TfApellido;

	@FXML
	private TextField TfTelefono;

	@FXML
	private Stage ventana;
	
	private int index = -3;

	// Relaciona el main con el controlador
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.myMain = ProgramaPrincipal;
	}

	// abrir ventana
	public void setStagePrincipal(Stage ventana) {
		this.ventana = ventana;
	}

	// cerrar ventana -- clickar en cancel
	public void closeWindow() {
		this.ventana.close();
	}

	// clickar en OK
	public void OkPressed() {
		if (TfNombre.getText().equals("") || TfApellido.getText().equals("") || TfTelefono.getText().equals("")) {
			ControladorMain.errorAlert("faltan datos");
			
		} else if (getTfTelefono() == -1 || getTfTelefono() == -2) {
			ControladorMain.errorAlert("datos mal introducidos");
			
		} else {
			if (index != -3) {
				ControladorMain.setdata(new Persona(getTfNombre(), getTfApellido(), getTfTelefono()), index);
			} else {
				ControladorMain.setdata(new Persona(getTfNombre(), getTfApellido(), getTfTelefono()));
			}
			
			
			closeWindow();
		}
	}

	// apellido
	public void setTfApellido(String apellido) {
		System.out.println(apellido + " 2");
		TfApellido.setText(apellido);
	}

	public String getTfApellido() {
		return TfApellido.getText();
	}

	// nombre
	public void setTfNombre(String sNombre) {
		TfNombre.setText(sNombre);
	}

	public String getTfNombre() {
		return TfNombre.getText();
	}

	// telefono
	public void setTfTelefono(int i) {
		TfTelefono.setText(Integer.toString(i));
	}

	public int getTfTelefono() {
		
		try {
			if (TfTelefono.getText().length() == 9 ){
				int i = Integer.parseInt(TfTelefono.getText());

				if (i < 0) {
					return -1;
				} else {
					return i;
				}
			}else {
				return -2;
			}
			
		} catch (Exception e) {
			return -1;
		}
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
}