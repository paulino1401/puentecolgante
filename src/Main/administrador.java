package Main;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.Puente;
import views.Puente2;

public class administrador extends Application implements EventHandler {
    private Scene escena;
    private Button equi, prior;
    private VBox acomodar;
    @Override
    public void start(Stage primaryStage)  {
        acomodar = new VBox(4);
        equi = new Button("Equitativa");
        prior = new Button("Prioridad a un color ");
        equi.setOnMouseClicked(event -> EventosMenu(1));
        prior.setOnMouseClicked(event -> EventosMenu(2));
        acomodar.getChildren().addAll(equi,prior);

        escena = new Scene(acomodar,150,100);
        primaryStage.setMaximized(false);
        primaryStage.setTitle("Sistemas Operativos");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    private void EventosMenu(int opc) {
        switch (opc){
            case 1: new Puente();
            break;
            case 2: new Puente2();
            break;
        }
    }

    @Override
    public void handle(Event event) {

    }
}
