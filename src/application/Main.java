package application;

import java.io.IOException;

import Controlador.ControladorMain;
import Modelo.Persona;
import Vista.vistaedicion;
import Vista.vistaprincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage stagePrincipal;
	private AnchorPane rootPane;
	private ControladorMain CMiMain;

	@Override
	public void start(Stage stagePrincipal) throws Exception {
		Main.stagePrincipal = stagePrincipal;
		mostrarAgenda();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void mostrarAgenda() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/Agenda.fxml"));
			rootPane = (AnchorPane) loader.load();
			Scene scene = new Scene(rootPane);
			stagePrincipal.setTitle("Agenda");
			stagePrincipal.setScene(scene);

			vistaprincipal controller = loader.getController();
			controller.setProgramaPrincipal(this);
			// controller.setCM(CMiMain);

			stagePrincipal.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mostrarEditorModifica(Persona pers, int index) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/PersonaDatos.fxml"));
			AnchorPane ventanaDos;

			ventanaDos = (AnchorPane) loader.load();

			/* Creamos la segunda ventana como otro stage */
			Stage ventana = new Stage();
			ventana.setTitle("Editar");

			/* Le decimos a la ventana quién es la ventana original */
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaDos);
			ventana.setScene(scene);

			vistaedicion controller2 = loader.getController();
			controller2.setStagePrincipal(ventana);
			controller2.setTfApellido(pers.getApellido());
			controller2.setTfNombre(pers.getNombre());
			controller2.setTfTelefono(pers.getTelefono());
			controller2.setIndex(index);

			ventana.show();

			mostrarAgenda();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void mostrarEditorInsertar() {

		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/PersonaDatos.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
			
			/* Creamos la segunda ventana como otro stage */
			Stage ventana = new Stage();
			ventana.setTitle("Editar");
			
			/* Le decimos a la ventana quién es la ventana original */
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaDos);
			ventana.setScene(scene);

			vistaedicion controller2 = loader.getController();
			controller2.setStagePrincipal(ventana);

			ventana.show();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}