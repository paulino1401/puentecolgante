package puente;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class hiloses extends  Thread{
    GridPane gridPane;
    ImageView[] imgazul = new ImageView[4];
    public Image azul = new Image("Image/mono_azul.png");
    public hiloses(GridPane gridPane){
        this.gridPane = gridPane;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i <4 ; i++) {
            imgazul[i] = new ImageView(azul);
            gridPane.add(imgazul[i],i,1);
        }

    }
}
