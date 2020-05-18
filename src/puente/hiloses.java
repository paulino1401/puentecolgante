package puente;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class hiloses extends  Thread{
    public ImageView[] imgazul;
    public ImageView[] imgrojo;
    int opc;
    int i=0;
    int j=0;
    int cont=0;
    int monazul=0;
    int monrojo=0;
    String num = i+"";
    String num1 = j+"";
    public ImageView imgpuente;
    public Image imgpuenteA = new Image("Image/puente_colA.png");
    public Image imgpuenteR = new Image("Image/puente_colR.png");
    public Image azul = new Image("Image/mono_azul.png");
    public Image rojo = new Image("Image/mono_rojo.png");
    public Image ppuente = new Image("Image/puente_col.png");
    public hiloses(ImageView[] imgazul,ImageView[] imgrojo,ImageView imgpuente,int opc){
        this.imgazul=imgazul; this.imgrojo=imgrojo; this.imgpuente=imgpuente; this.opc = opc;
    }

    @Override
    public void run() {
        super.run();
        try {
            switch (opc){
                case 0:
                    LibereAzul();
                    monazul++;
                    sleep(3000);
                    imgazul[0].setImage(null);
                    imgpuente.setImage(imgpuenteA);

                    while(monazul<4||monrojo<=3){
                        //System.out.println("i: "+i+" j: "+j);
                        int x =(int)(Math.random()*8000+3000);
                        int opc= (int)(Math.random()*2);
                       // System.out.println("MonA: "+monazul+"MonR: "+monrojo+" Tiempo: "+x+"  opc: "+opc+"  i: "+i+"  j: "+j);
                        switch (opc){
                            case 0:
                                if(i<4){
                                    LibereAzul();
                                    imgpuente.setImage(ppuente);
                                    sleep(1500);
                                    if(i>j){
                                        imgazul[i-1].setImage(null);
                                        imgpuente.setImage(imgpuenteA);
                                    }else{
                                        if(j>i){
                                            imgrojo[j].setImage(null);
                                            imgpuente.setImage(imgpuenteR);
                                        }else{
                                            if(i==j){
                                                imgrojo[j].setImage(null);
                                                imgpuente.setImage(imgpuenteR);
                                            }
                                        }

                                    }
                                    monazul++;

                                }else{
                                    if(j<4) {
                                        LibereRojo();
                                        imgpuente.setImage(ppuente);
                                        sleep(1500);
                                        if(i>j){
                                            imgazul[i-1].setImage(null);
                                            imgpuente.setImage(imgpuenteA);
                                        }else{
                                            if(j>i){
                                                imgrojo[j].setImage(null);
                                                imgpuente.setImage(imgpuenteR);
                                            }else{
                                                if(i==j){
                                                    imgrojo[j].setImage(null);
                                                    imgpuente.setImage(imgpuenteR);
                                                }
                                            }

                                        }
                                        monrojo++;
                                    }
                                }
                                break;
                            case 1:
                                if(j<4){
                                    LibereRojo();
                                    imgpuente.setImage(ppuente);
                                    sleep(1500);
                                    if(j>i){
                                        imgrojo[j].setImage(null);
                                        imgpuente.setImage(imgpuenteR);
                                    }else{
                                        if(i>j){
                                            imgazul[i].setImage(null);
                                            imgpuente.setImage(imgpuenteA);
                                        }else{
                                            if(i==j){
                                                imgazul[i].setImage(null);
                                                imgpuente.setImage(imgpuenteA);
                                            }
                                        }
                                    }
                                    monrojo++;
                                }else{
                                    LibereAzul();
                                    imgpuente.setImage(ppuente);
                                    sleep(1500);
                                    if(j>i){
                                        imgrojo[j].setImage(null);
                                        imgpuente.setImage(imgpuenteR);
                                    }else{
                                        if(i>j){
                                            imgazul[i].setImage(null);
                                            imgpuente.setImage(imgpuenteA);
                                        }else{
                                            if(i==j){
                                                imgazul[i].setImage(null);
                                                imgpuente.setImage(imgpuenteA);
                                            }
                                        }
                                    }
                                    monazul++;
                                }
                                break;
                        }
                        sleep(x);

                    }
                    System.out.println("a terminado");

                    break;
                case 1:
                    LibereRojo();
                    monrojo++;
                    while(monazul<=3||monrojo<4){
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void LibereRojo() {
        System.out.println("Img Rojo: "+j+"  Img Azul: "+i);
        imgrojo[j].setImage(rojo);
        imgrojo[j].setId(num1);
        j++;
    }

    private void Reserve() {
        cont--;
    }

    public void LibereAzul() {
        System.out.println("Img Azul: "+i+"  Img Rojo: "+j);
        imgazul[i].setImage(azul);
        imgazul[i].setId(num);
        i++;

    }
}
