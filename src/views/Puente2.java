package views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import process.Efectos;
import process.Hilos;

import java.lang.Thread;

public class Puente2 extends Stage {

    private Scene escena;
    private Label texto;
    private Button btnazul,btnrojo;
    private VBox vBox;
    private HBox hBox,hBox1,hBox2,hBox3;
    public ImageView[] imgazul = new ImageView[4];
    public ImageView[] imgrojo = new ImageView[4];
    public ImageView imgpuente = new ImageView("Image/puente_col.png");
    public ImageView imgestre = new ImageView("Image/estrella.png");
    public Image espacio = new Image("Image/espacio.png");
    public Image azul = new Image("Image/mono_azul.png");
    public Image rojo = new Image("Image/mono_rojo.png");
    public Thread pue,efe;
    int i=-1,j=-1;

    public Puente2(){
        CrearGUI();
        this.setTitle("Puente Colgante Prioridad a un color");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {
        texto = new Label("Presione los monos de su preferencia: ");
        btnazul = new Button(" AZUL ");
        btnrojo = new Button(" ROJO ");
        vBox = new VBox(41);
        hBox = new HBox(4);
        hBox1 = new HBox(2);
        hBox2 = new HBox(2);
        hBox3 = new HBox(40);
        imgpuente.setTranslateY(140);
//---------------------------------------------------------------------------------------------------------------
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
//---------------------------------------------------------------------------------------------------------------
        btnazul.setOnMouseClicked(event -> {
            if(event.getButton()== MouseButton.PRIMARY){
                if(event.getClickCount()==1){
                    if(i<4){
                        i++;
                        System.out.println("i "+i+"  j "+j);
                        imgazul[i].setImage(azul);
                    }
                    if(i==3){
                        i=-1;
                        pue = new Hilos(imgazul,imgrojo,imgpuente,azul,rojo,0,"b");
                        try{
                            for (int k = 0; k <1 ; k++) {
                                pue.start();
                            }
                        }catch (Exception e){}
                    }
                }
            }

        });

        btnrojo.setOnMouseClicked(event -> {
            if(event.getButton()== MouseButton.PRIMARY){
                if(event.getClickCount()==1){
                    if(j<4){
                        j++;
                        System.out.println("i "+i+"  j "+j);
                        imgrojo[j].setImage(rojo);
                    }
                    if(j==3){
                        j=-1;
                        pue = new Hilos(imgazul,imgrojo,imgpuente,azul,rojo,1,"b");
                        try{
                            pue.start();
                        }catch (Exception e){}
                    }
                }
            }
        });
//---------------------------------------------------------------------------------------------------------------
        hBox.getChildren().addAll(texto,btnazul,btnrojo);
        hBox3.getChildren().addAll(hBox1,imgpuente,hBox2);
        vBox.getChildren().addAll(imgestre,hBox,hBox3);
//----------------------------------------------------------------------------------------------------------------

        escena = new Scene(vBox,1200,400);
        escena.getStylesheets().add(getClass().getResource("/CSS/estilos.css").toExternalForm());

    }



}
