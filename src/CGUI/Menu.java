package CGUI;


import client.ClientGUI;
import client.SampleClient;
import client.Windows1251Control;
import com.sun.security.ntlm.Client;
import manage.Commands;
import model.PansNames;
import model.Size;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;


public class Menu implements ActionListener{
    private static String START_COMMAND = "start";
    private static String STOP_COMMAND = "stop";
    private static String UPDATE_COMMAND = "update";
    private static String RUS = "rus";
    private static String ROU = "rou";
    private static String ENG = "eng";
    private static String SWE = "swe";
    private Integer size;
    private String type;
    private Integer id;
    private Filter f;
    private OutputStream os;
    private InputStream ins;
    public Menu(Filter f, OutputStream os, InputStream ins){
        this.f=f;
        this.ins=ins;
        this.os=os;

    }
    private Toolkit toolkit = Toolkit.getDefaultToolkit();

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", SampleClient.locale, new Windows1251Control());
        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu(rb.getString("Menu"));
        menu.setMnemonic(KeyEvent.VK_M);
        menuBar.add(menu);

        //a group of JMenuItems
        JMenuItem menuItem1 = new JMenuItem(rb.getString("START"),
                KeyEvent.VK_S);

        menuItem1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem1.setActionCommand(START_COMMAND);
        menuItem1.addActionListener(this);
        menu.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem(rb.getString("STOP"),
                KeyEvent.VK_T);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem2.setActionCommand(STOP_COMMAND);
        menuItem2.addActionListener(this);
        menu.add(menuItem2);

        JMenuItem menuItem3 = new JMenuItem(rb.getString("Update"),
                KeyEvent.VK_U);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem3.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuItem3.setActionCommand(UPDATE_COMMAND);
        menuItem3.addActionListener(this);
        menu.add(menuItem3);

        JMenu menu1 = new JMenu(rb.getString("Language"));
        menu1.setMnemonic(KeyEvent.VK_L);
        menuBar.add(menu1);

        JMenuItem menuItem4 = new JMenuItem(rb.getString("eng"),
                KeyEvent.VK_E);

        menuItem4.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem4.setActionCommand(ENG);
        menuItem4.addActionListener(this);
        menu1.add(menuItem4);

        JMenuItem menuItem5 = new JMenuItem(rb.getString("rus"),
                KeyEvent.VK_R);

        menuItem5.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem5.setActionCommand(RUS);
        menuItem5.addActionListener(this);
        menu1.add(menuItem5);

        JMenuItem menuItem6 = new JMenuItem(rb.getString("rou"),
                KeyEvent.VK_O);

        menuItem6.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuItem6.setActionCommand(ROU);
        menuItem6.addActionListener(this);
        menu1.add(menuItem6);

        JMenuItem menuItem7 = new JMenuItem(rb.getString("swe"),
                KeyEvent.VK_S);

        menuItem7.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_4, ActionEvent.ALT_MASK));
        menuItem7.setActionCommand(SWE);
        menuItem7.addActionListener(this);
        menu1.add(menuItem7);

        return menuBar;
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (START_COMMAND.equals(command)) {
            //Start button clicked
            size=f.size;
            type=f.type;
            id=f.id;
            Cartoon.startAnimation(size,type,id);
        } else if (STOP_COMMAND.equals(command)) {
            //Stop button clicked
            size=f.size;
            type=f.type;
            id=f.id;
            Cartoon.stopAnimation();
            ClientGUI.car.repaint();
        } else if (UPDATE_COMMAND.equals(command)) {
            //Update button clicked.
            SampleClient.pl=Commands.getCollection(os,ins);
            Cartoon.makeOvals();
            ClientGUI.car.repaint();
        }else if(ROU.equals(command)){
            SampleClient.locale=new Locale("ro","RO");
            SampleClient.cgui.close();
            SampleClient.pl=Commands.getCollection(os,ins);
            Size.BIG.remakeDescr();
            Size.MEDIUM.remakeDescr();
            Size.SMALL.remakeDescr();
            PansNames.BANANA.remakeDescr();
            PansNames.VANILLA.remakeDescr();
            PansNames.PAN.remakeDescr();
            PansNames.CHOC.remakeDescr();
            SampleClient.cgui = new ClientGUI(os,ins);
            SampleClient.cgui.start();
        }else if(RUS.equals(command)){
            SampleClient.locale=new Locale("ru","RU");
            SampleClient.cgui.close();
            SampleClient.pl=Commands.getCollection(os,ins);
            Size.BIG.remakeDescr();
            Size.MEDIUM.remakeDescr();
            Size.SMALL.remakeDescr();
            PansNames.BANANA.remakeDescr();
            PansNames.VANILLA.remakeDescr();
            PansNames.PAN.remakeDescr();
            PansNames.CHOC.remakeDescr();
            SampleClient.cgui = new ClientGUI(os,ins);
            SampleClient.cgui.start();
        }else if(SWE.equals(command)){
            SampleClient.locale=new Locale("sv","SE");
            SampleClient.cgui.close();
            SampleClient.pl=Commands.getCollection(os,ins);
            Size.BIG.remakeDescr();
            Size.MEDIUM.remakeDescr();
            Size.SMALL.remakeDescr();
            PansNames.BANANA.remakeDescr();
            PansNames.VANILLA.remakeDescr();
            PansNames.PAN.remakeDescr();
            PansNames.CHOC.remakeDescr();
            SampleClient.cgui = new ClientGUI(os,ins);
            SampleClient.cgui.start();
        }else if(ENG.equals(command)){
            SampleClient.locale=new Locale("en","GB");
            SampleClient.cgui.close();
            SampleClient.pl=Commands.getCollection(os,ins);
            Size.BIG.remakeDescr();
            Size.MEDIUM.remakeDescr();
            Size.SMALL.remakeDescr();
            PansNames.BANANA.remakeDescr();
            PansNames.VANILLA.remakeDescr();
            PansNames.PAN.remakeDescr();
            PansNames.CHOC.remakeDescr();
            SampleClient.cgui = new ClientGUI(os,ins);
            SampleClient.cgui.start();
        }
    }
}