package puente;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.Thread;

public class Puente extends Application implements EventHandler {
    private Scene escena;
    private Label texto;
    private Button btnazul,btnrojo,btnequi,btnprio;
    private VBox vBox;
    private HBox hBox,hBox1,hBox2,hBox3;
    public ImageView[] imgazul = new ImageView[4];
    public ImageView[] imgrojo = new ImageView[4];
    public ImageView imgpuente = new ImageView("Image/puente_col.png");
    public ImageView imgestre = new ImageView("Image/estrella.png");
    public Image espacio = new Image("Image/espacio.png");
    public Thread pue,efe;


    @Override
    public void start(Stage primaryStage) {
        btnequi = new Button(" Equitativa ");
        btnprio = new Button(" Prioridad ");
        btnazul = new Button(" AZUL ");
        btnrojo = new Button(" ROJO ");
        vBox = new VBox(41);
        hBox = new HBox(4);
        hBox1 = new HBox(2);
        hBox2 = new HBox(2);
        hBox3 = new HBox(40);
//------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i <4 ; i++) {
            imgazul[i] = new ImageView();
            imgazul[i].setImage(espacio);
            hBox1.getChildren().add(imgazul[i]);
        }
        for (int i = 0; i <4 ; i++) {
            imgrojo[i] = new ImageView();
            imgrojo[i].setImage(espacio);
            hBox2.getChildren().add(imgrojo[i]);

        }
        efe= new Efectos(imgestre);
        try{
            efe.start();
        }catch (Exception e){}
//------------------------------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------------------------
        hBox.getChildren().addAll(btnazul,btnrojo);
        hBox3.getChildren().addAll(hBox1,imgpuente,hBox2);
        vBox.getChildren().addAll(imgestre,hBox,hBox3);
//------------------------------------------------------------------------------------------------------------------
        escena = new Scene(vBox,1200,400);
        escena.getStylesheets().add(getClass().getResource("/CSS/estilos.css").toExternalForm());

    }


    @Override
    public void handle(Event event) {

    }
}
