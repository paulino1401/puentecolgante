package puente;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.Thread;

public class Puente extends Application implements EventHandler {
    public Image azul = new Image("Image/mono_azul.png");
    public ImageView[] imgazul = new ImageView[4];
    public ImageView imgpuente = new ImageView("Image/puente_col.png");
    private Scene escena;
    private Button btnazul,btnrojo;
    private Label lpersona;
    public GridPane gridPane;
    public Thread pue;

    @Override
    public void start(Stage primaryStage) {
        btnazul = new Button(" AZUL ");
        btnrojo = new Button(" ROJO ");
        lpersona = new Label("Con que persona quiere empezar:  ");

        btnazul.setOnAction(event -> {
            pue = new hiloses(gridPane);
            pue.start();
          /*  for (int i = 0; i <4 ; i++) {
                imgazul[i] = new ImageView(azul);
                gridPane.add(imgazul[i],i,1);
            }*/
        });

        gridPane = new GridPane();
        gridPane.add(lpersona,0,0);
        gridPane.add(btnazul,1,0);
        gridPane.add(btnrojo,2,0);
        gridPane.add(imgpuente,4,1);

        escena = new Scene(gridPane,900,600);
        primaryStage.setTitle("Puente");
        primaryStage.setScene(escena);
        primaryStage.show();

    }

    @Override
    public void handle(Event event) {

    }
}
