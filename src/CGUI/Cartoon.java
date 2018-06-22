package CGUI;

import client.ClientGUI;
import client.SampleClient;
import model.Pancakes;
import model.PansNames;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public class Cartoon extends JPanel {
    private static final int PREF_W = 900;
    private static final int PREF_H = 700;
    private static final int ROOM_WIDTH = 100;
    private static final int ROOM_HEIGHT= 100;


    HashMap<String, Rectangle> Rooms;

    public  static LinkedList<Oval> ovals=new LinkedList<>();
    public static TimerAnima ta;
    //int animation=0;
    public Cartoon(){
        Rooms = new HashMap<>();
        Rooms.put("bucket 1", new Rectangle(100,200, ROOM_WIDTH, ROOM_HEIGHT));
        Rooms.put("bucket 2", new Rectangle(300,400, ROOM_WIDTH, ROOM_HEIGHT));
        Rooms.put("other bucket", new Rectangle(650,75, ROOM_WIDTH, ROOM_HEIGHT));
        Rooms.put("bucket 3", new Rectangle(400,95, ROOM_WIDTH, ROOM_HEIGHT));
        Rooms.put("bucket 4", new Rectangle(100,400, ROOM_WIDTH, ROOM_HEIGHT));

        makeOvals();

    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        for(Map.Entry<String, Rectangle> room : Rooms.entrySet()){
            Rectangle coord = room.getValue();
            g.drawRect(coord.x, coord.y, coord.width, coord.height);

            g.drawString(room.getKey(), coord.x - 30 + coord.width/2, coord.y - 30+ coord.height/2);
        }

        drawPans(g);
    }

    public void drawPans(Graphics g){
        //g.setColor(null);
        if(SampleClient.pl!=null){
            for(Oval o:ovals){
                g.setColor(o.col);

                add(o);

                o.paintComponent(g);

            }
        }
    }
    public static void makeOvals(){
        ovals=new LinkedList<>();
        if(SampleClient.pl!=null){
            for(Integer i:new TreeSet<Integer>(SampleClient.pl.Mo.keySet())) {
                Pancakes pan = SampleClient.pl.Mo.get(i);
                Color col;
                if(pan.color.equals("YELLOW")&&pan.name.equals(PansNames.BANANA)){
                    col= Color.YELLOW;
                }else if(pan.color.equals("BROWN")&&pan.name.equals(PansNames.CHOC)){
                    col= Color.GRAY;
                }else if(pan.color.equals("BLUE")&&pan.name.equals(PansNames.VANILLA)){
                    col= Color.BLUE;
                }else if(pan.color.equals("RED")&&pan.name.equals(PansNames.PAN)){
                    col= Color.RED;
                }else{
                    col=Color.GREEN;
                }
                Oval o=new Oval(pan,col);
                o.setToolTipText(pan.toString());
                ovals.add(o);
            }
        }
    }
    public static void startAnimation(Integer size,String type,Integer id){
        ta=new TimerAnima(30,size,type,id);
        ta.start();

    }
    public static void stopAnimation() {
        ta.stop();
        for(Oval o:ovals){
            o.animation=0;
        }
        ClientGUI.car.repaint();

    }
}