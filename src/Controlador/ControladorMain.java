package Controlador;

import Modelo.Persona;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControladorMain {

	private final static ObservableList<Persona> data = FXCollections.observableArrayList(
			new Persona("Pablo", "Hernández", 616432432), new Persona("Miguel", "Martínez", 678543545), new Persona("Javier", "Borreguero", 645237824));

	public static ObservableList<Persona> getData() {
		return data;
	}

	public static void setdata(Persona persona) {
		data.add(persona);
	}
	
	public static void setdata(Persona persona, int index) {
		data.set(index, persona);
	}
	
	public static Alert errorAlert(String error) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("alerta!");
		alert.setHeaderText("");
		alert.setContentText(error);

		alert.showAndWait();
		return alert;
	}
}