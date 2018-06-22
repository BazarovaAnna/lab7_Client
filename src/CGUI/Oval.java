package CGUI;

import javafx.util.Pair;
import model.Pancakes;

import javax.swing.*;
import java.awt.*;


public class Oval extends JLabel {
    Rectangle rectangle;
    int radius;
    int XX;
    int YY;
    int right;
    Color dd;
    private static final int NORMAL_PAS= 40;
    private static final int BIG_PAS = 60;
    private static final int LITTLE_PAS = 20;

    private static final int ROOM_WIDTH = 100;
    private static final int ROOM_HEIGHT= 100;
    Color col;
    public int animation=0;
    public Pancakes pan;

    public Oval(Pancakes pan,Color col){

        this.pan=pan;
        this.col=col;
        setToolTipText(pan.toString());

    }
    public void paintComponent(Graphics g){
        //System.out.println("*");
        int X;
        int Y;
        int SIZE=0;
        if(pan.location.equals("1")){
            X=110;
            Y =210;
        }else if(pan.location.equals("2")){
            X=310;
            Y=410;
        }else if(pan.location.equals("3")){
            X=410;
            Y=105;
        }else if(pan.location.equals("4")){
            X=110;
            Y=410;
        }else{
            X=660;
            Y=85;
        }
        X=X-20+(ROOM_WIDTH)/2;
        Y=Y-10+(ROOM_HEIGHT)/2;

        if(pan.size.sizeNum==1){
            SIZE=LITTLE_PAS;
        }else if(pan.size.sizeNum==2){
            SIZE=NORMAL_PAS;
        }else if(pan.size.sizeNum==3){
            SIZE=BIG_PAS;
        }

        rectangle = new Rectangle(X, Y, SIZE, SIZE);
        Pair<Color, Rectangle> pair = new Pair<Color, Rectangle>(col, rectangle);

        dd=pair.getKey();
        radius = pair.getValue().width/2 + animation;
        XX = pair.getValue().x - 10 + pair.getValue().width/2;
        YY = pair.getValue().y;
        right = radius < (ROOM_WIDTH/2) ? radius : ROOM_WIDTH/2;
        setBounds(XX,YY,radius,radius);
        g.fillOval(XX, YY, right, right);
        g.setColor(dd);
    }

}
