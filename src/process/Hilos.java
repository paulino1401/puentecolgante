package process;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hilos extends Thread{
    public Image Azul,Rojo;
    public Image espacio = new Image("Image/espacio.png");
    public ImageView[] imgazul;
    public ImageView[] imgrojo;
    public ImageView imgpuente;
    int i,j,opc;
    String valor;
    boolean vacioA,vacioR;
    public Hilos(ImageView[] imgazul, ImageView[] imgrojo,ImageView imgpuente,int i,int j,int opc,String valor){
        this.imgazul = imgazul; this.imgrojo = imgrojo; this.imgpuente = imgpuente; this.i=i; this.j=j; this.opc=opc;
        this.valor=valor;
    }
    public Hilos(ImageView[] imgazul, ImageView[] imgrojo,ImageView imgpuente,Image azul,Image rojo,int opc,String valor){
        this.imgazul = imgazul; this.imgrojo = imgrojo; this.imgpuente = imgpuente; this.opc=opc; this.Azul=azul;
        this.Rojo = rojo; this.valor=valor;
    }

    @Override
    public void run(){
        super.run();
        try{
            switch (valor){
                case "a":
                    sleep(2000);
                    switch (opc){
                        case 0:
                            System.out.println("comenzo con azul "+i);
                            int x = (int)(Math.random()*4000+3000);
                            sleep(x);
                            if(i==j){
                                for (int k = 0; k <1200 ; k+=10) {
                                    imgazul[i].setTranslateX(k);
                                    sleep(30);
                                }
                                imgazul[i].setImage(espacio);
                                imgazul[i].setTranslateX(0);
                                sleep(400);
                            }else{
                                if(i>j){
                                    for (int k = 0; k <1200 ; k+=10) {
                                        imgazul[i].setTranslateX(k);
                                        sleep(30);
                                    }
                                    imgazul[i].setImage(espacio);
                                    imgazul[i].setTranslateX(0);
                                    sleep(400);
                                }else{
                                    if(i<j){
                                        for (int k = 0; k >-1200 ; k-=10) {
                                            imgrojo[j].setTranslateX(k);
                                            sleep(30);
                                        }
                                        imgrojo[j].setImage(espacio);
                                        imgrojo[j].setTranslateX(0);
                                        sleep(400);
                                    }
                                }
                            }

                            break;
                        case 1:
                            int y = (int)(Math.random()*4000+3000);
                            System.out.println("comenzo con rojo "+j);
                            sleep(y);
                            if(i==j){
                                for (int k = 0; k >-1200 ; k-=10) {
                                    imgrojo[j].setTranslateX(k);
                                    sleep(30);
                                }
                                imgrojo[j].setImage(espacio);
                                imgrojo[j].setTranslateX(0);
                                sleep(400);

                            }else{
                                if(i<j){
                                    for (int k = 0; k >-1200 ; k-=10) {
                                        imgrojo[j].setTranslateX(k);
                                        sleep(30);
                                    }
                                    imgrojo[j].setImage(espacio);
                                    imgrojo[j].setTranslateX(0);
                                    sleep(400);

                                }else{
                                    if(i>j){
                                        for (int k = 0; k <1200 ; k+=10) {
                                            imgazul[i].setTranslateX(k);
                                            sleep(30);
                                        }
                                        imgazul[i].setImage(espacio);
                                        imgazul[i].setTranslateX(0);
                                        sleep(400);
                                    }
                                }
                            }
                            break;
                    }
                    break;
                case "b":
                    switch (opc){
                        case 0:
                            System.out.println("Prioridad azul "+i);
                            sleep(2000);
                            for (int k = 0; k <4 ; k++) {
                                if(imgazul[k].getImage()==Azul){
                                    for (int t = 0; t <1200 ; t+=10) {
                                        imgazul[k].setTranslateX(t);
                                        sleep(30);
                                    }
                                    imgazul[k].setImage(espacio);
                                    imgazul[k].setTranslateX(0);
                                    sleep(400);
                                }else{
                                    System.out.println("la posicion "+k+" no contiene imagen azul");
                                }
                            }
                            sleep(4000);
                            break;
                        case 1:
                            System.out.println("Prioridad Rojo "+j);
                            sleep(2000);
                            for (int k = 0; k <4 ; k++) {
                                if(imgrojo[k].getImage()==Rojo){
                                    for (int t = 0; t >-1200 ; t-=10) {
                                        imgrojo[k].setTranslateX(t);
                                        sleep(30);
                                    }
                                    imgrojo[k].setImage(espacio);
                                    imgrojo[k].setTranslateX(0);
                                    sleep(400);
                                }else{
                                    System.out.println("la posicion "+k+" no contiene imagen roja");
                                }

                            }
                            sleep(4000);
                            break;
                    }
                    break;
            }



        }catch (Exception e){}
    }



}
