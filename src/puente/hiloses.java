package puente;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class hiloses extends  Thread{
    public ImageView[] imgazul;
    public ImageView[] imgrojo;
    int opc;
    int i=0;
    int j=0;
    int cont=0;
    int monazul=0;
    int monrojo=0;
    public Image azul = new Image("Image/mono_azul.png");
    public Image rojo = new Image("Image/mono_rojo.png");
    public hiloses(ImageView[] imgazul,ImageView[] imgrojo,int opc){
        this.imgazul=imgazul; this.imgrojo=imgrojo; this.opc = opc;
    }

    @Override
    public void run() {
        super.run();
        try {
            switch (opc){
                case 0:
                    LibereAzul();
                    monazul++;
                    while(monazul<4||monrojo<4){
                        int x =(int)(Math.random()*7000+1000);
                        int opc= (int)(Math.random()*2);
                        System.out.println("MonA: "+monazul+"MonR: "+monrojo+" Tiempo: "+x+"  opc: "+opc+"  i: "+i+"  j: "+j);
                        sleep(x);
                        switch (opc){
                            case 0:
                                if(i<4){
                                    LibereAzul();
                                    monazul++;
                                }else{
                                    LibereRojo();
                                    monrojo++;
                                }
                                break;
                            case 1:
                                if(j<4){
                                    LibereRojo();
                                    monrojo++;
                                }else{
                                    LibereAzul();
                                    monazul++;
                                }
                                break;
                        }
                    }
                    break;
                case 1:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void LibereRojo() {
        imgrojo[j].setImage(rojo);
        j++;
    }

    private void Reserve() {
        cont--;
    }

    public void LibereAzul() {
        imgazul[i].setImage(azul);
        i++;
    }
}
