package client;

import javax.swing.*;
import CGUI.*;
import CGUI.Menu;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.io.OutputStream;

public class ClientGUI extends Thread {
    //public static PansCollection pl;
    public static Cartoon car;
    private OutputStream os;
    private InputStream ins;
    public ClientGUI(OutputStream os, InputStream ins){
        this.ins=ins;
        this.os=os;
    }
    @Override
    public void run() {
        JFrame frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(e.getComponent(), "Do u want to go finish?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
                    System.exit(0);
                }
            }
        });
        //Create main panel
        JSplitPane mainPan=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        Filter f=new Filter();
        mainPan.setRightComponent(f);

        JPanel jp = new JPanel();
        car=new Cartoon();
        car.setPreferredSize(new Dimension(800,650));
        car.setMinimumSize(new Dimension(800,650));

        //Create and set up the menu pane.
        Menu demo = new Menu(f,os,ins);
        frame.setJMenuBar(demo.createMenuBar());
        //mainPan.setLeftComponent(f);
        jp.add(car);
        jp.setPreferredSize(new Dimension(800,650));
        jp.setMinimumSize(new Dimension(800,650));
        mainPan.setLeftComponent(jp);
        frame.add(mainPan);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }
}
