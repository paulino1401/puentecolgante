package process;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hilos extends Thread{
    public Image imgA1 = new Image("Image/puenteA1.png");
    public Image imgA2 = new Image("Image/puenteA2.png");
    public Image imgA3 = new Image("Image/puenteA3.png");
    public Image imgR1 = new Image("Image/puenteR1.png");
    public Image imgR2 = new Image("Image/puenteR2.png");
    public Image imgR3 = new Image("Image/puenteR3.png");
    public Image azul = new Image("Image/mono_azul.png");
    public Image rojo = new Image("Image/mono_rojo.png");
    public Image ppuente = new Image("Image/puente_col.png");
    public Image espacio = new Image("Image/espacio.png");
    public ImageView[] imgazul;
    public ImageView[] imgrojo;
    public ImageView imgpuente;
    int i,j,opc;
    String valor;
    public Hilos(ImageView[] imgazul, ImageView[] imgrojo,ImageView imgpuente,int i,int j,int opc,String valor){
        this.imgazul = imgazul; this.imgrojo = imgrojo; this.imgpuente = imgpuente; this.i=i; this.j=j; this.opc=opc;
        this.valor=valor;
    }

    @Override
    public void run(){
        super.run();
        try{
            switch (valor){
                case "a":
                    switch (opc){
                        case 0:
                            System.out.println("comenzo con azul "+i);
                            int x = (int)(Math.random()*4000+3000);
                            sleep(x);
                            if(i==j){
                                imgazul[i].setImage(espacio);
                                sleep(400);
                                imgpuente.setImage(imgA1);
                                sleep(600);
                                imgpuente.setImage(imgA2);
                                sleep(600);
                                imgpuente.setImage(imgA3);
                                sleep(600);
                                imgpuente.setImage(ppuente);
                            }else{
                                if(i>j){
                                    imgazul[i].setImage(espacio);
                                    sleep(400);
                                    imgpuente.setImage(imgA1);
                                    sleep(600);
                                    imgpuente.setImage(imgA2);
                                    sleep(600);
                                    imgpuente.setImage(imgA3);
                                    sleep(600);
                                    imgpuente.setImage(ppuente);
                                }else{
                                    if(i<j){
                                        imgrojo[j].setImage(espacio);
                                        sleep(400);
                                        imgpuente.setImage(imgR1);
                                        sleep(600);
                                        imgpuente.setImage(imgR2);
                                        sleep(600);
                                        imgpuente.setImage(imgR3);
                                        sleep(600);
                                        imgpuente.setImage(ppuente);
                                    }
                                }
                            }

                            break;
                        case 1:
                            int y = (int)(Math.random()*4000+3000);
                            System.out.println("comenzo con rojo "+j);
                            sleep(y);
                            if(i==j){
                                imgrojo[j].setImage(espacio);
                                sleep(400);
                                imgpuente.setImage(imgR1);
                                sleep(600);
                                imgpuente.setImage(imgR2);
                                sleep(600);
                                imgpuente.setImage(imgR3);
                                sleep(600);
                                imgpuente.setImage(ppuente);
                            }else{
                                if(i<j){
                                    imgrojo[j].setImage(espacio);
                                    sleep(400);
                                    imgpuente.setImage(imgR1);
                                    sleep(600);
                                    imgpuente.setImage(imgR2);
                                    sleep(600);
                                    imgpuente.setImage(imgR3);
                                    sleep(600);
                                    imgpuente.setImage(ppuente);
                                }else{
                                    if(i>j){
                                        imgazul[i].setImage(espacio);
                                        sleep(400);
                                        imgpuente.setImage(imgA1);
                                        sleep(600);
                                        imgpuente.setImage(imgA2);
                                        sleep(600);
                                        imgpuente.setImage(imgA3);
                                        sleep(600);
                                        imgpuente.setImage(ppuente);
                                    }
                                }
                            }

                            break;
                    }
                    break;
            }



        }catch (Exception e){}
    }



}
