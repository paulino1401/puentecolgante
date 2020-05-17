package puente;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class hiloses extends  Thread{
    GridPane gridPane;
    ImageView imgazul;
    public Image azul = new Image("Image/mono_azul.png");
    public hiloses(GridPane gridPane, ImageView imgazul){}

    @Override
    public void run() {
        super.run();
        imgazul = new ImageView(azul);
        gridPane.add(imgazul,0,1);
    }
}
