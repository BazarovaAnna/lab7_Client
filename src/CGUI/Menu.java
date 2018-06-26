package CGUI;


import client.ClientGUI;
import client.SampleClient;
import client.Windows1251Control;
import manage.Commands;

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
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", locale, new Windows1251Control());
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
        }
    }
}