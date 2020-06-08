package puente;

import javafx.scene.image.ImageView;

public class Efectos extends Thread{
    public ImageView imgestre;
    public Efectos(ImageView imgestre){
        this.imgestre=imgestre;
    }

    @Override
    public void run(){
        super.run();
        for (int k = 0; k <1200 ; k+=10) {
            imgestre.setTranslateX(k);
            try{
                sleep(800);
            }catch (Exception e){}
            if(k==1190){k=-1190;}
        }
    }
}
