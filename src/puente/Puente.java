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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.Thread;

public class Puente extends Application implements EventHandler {
    public ImageView[] imgazul = new ImageView[4];
    public ImageView[] imgrojo = new ImageView[4];
    public ImageView imgpuente = new ImageView("Image/puente_col.png");
    private Scene escena;
    private Button btnazul,btnrojo;
    private Label lpersona;
    public GridPane gridPane,gridPane2;
    public Thread pue;
    private VBox vBox;

    @Override
    public void start(Stage primaryStage) {
        btnazul = new Button(" AZUL ");
        btnrojo = new Button(" ROJO ");
        lpersona = new Label("Con que persona quiere empezar:    ");
        vBox = new VBox(4);
        gridPane = new GridPane();
        gridPane2 = new GridPane();

        gridPane.add(lpersona,0,0);
        gridPane.add(btnazul,1,0);
        gridPane.add(btnrojo,2,0);
        gridPane2.add(imgpuente,4,0);
        for (int i = 0; i <4 ; i++) {
            imgazul[i] = new ImageView();
            gridPane2.add(imgazul[i],i,0);
        }
        for (int i = 0; i <4 ; i++) {
            imgrojo[i] = new ImageView();
            gridPane2.add(imgrojo[i],i+5,0);
        }
        btnazul.setOnAction(event -> {
            pue = new hiloses(imgazul,imgrojo,imgpuente,0);
            try{
                for (int i = 0; i <1 ; i++) {
                    pue.start();
                }
            }catch(Exception e){}

        });
        btnrojo.setOnAction(event -> {
            pue = new hiloses(imgazul,imgrojo,imgpuente,1);
            try{
                for (int i = 0; i <1 ; i++) {
                    pue.start();
                }
            }catch(Exception e){}

        });
        vBox.getChildren().addAll(gridPane,gridPane2);
        escena = new Scene(vBox,1200,400);
        primaryStage.setTitle("Puente");
        primaryStage.setScene(escena);
        primaryStage.show();

    }

    @Override
    public void handle(Event event) {

    }
}
