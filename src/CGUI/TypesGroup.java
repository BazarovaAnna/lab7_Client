package CGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TypesGroup extends JPanel implements ActionListener {
    private String BAN="Pancakes with banana (Yellow)";
    private String VAN="Pancakes with vanilla (Blue)";
    private String CHO="Pancakes with chocolate (Grey)";
    private String SIM="Simple pancakes (Red)";
    private String ALL="All pancakes";
    public String type="ALL";
    public TypesGroup(){
        JLabel radioLabel = new JLabel("Type of your Pancake", JLabel.CENTER);
        radioLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Create the radio buttons.
        JRadioButton banana = new JRadioButton(BAN);
        banana.setMnemonic(KeyEvent.VK_B);
        banana.setActionCommand(BAN);


        JRadioButton vanilla = new JRadioButton(VAN);
        vanilla.setMnemonic(KeyEvent.VK_V);
        vanilla.setActionCommand(VAN);

        JRadioButton chocolate = new JRadioButton(CHO);
        chocolate.setMnemonic(KeyEvent.VK_C);
        chocolate.setActionCommand(CHO);

        JRadioButton simple = new JRadioButton(SIM);
        simple.setMnemonic(KeyEvent.VK_S);
        simple.setActionCommand(SIM);

        JRadioButton all = new JRadioButton(ALL);
        all.setMnemonic(KeyEvent.VK_A);
        all.setActionCommand(ALL);
        all.setSelected(true);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(banana);
        group.add(vanilla);
        group.add(chocolate);
        group.add(simple);
        group.add(all);

        //Register a listener for the radio buttons.
        banana.addActionListener(this);
        vanilla.addActionListener(this);
        chocolate.addActionListener(this);
        simple.addActionListener(this);
        all.addActionListener(this);
        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(banana);
        radioPanel.add(vanilla);
        radioPanel.add(chocolate);
        radioPanel.add(simple);
        radioPanel.add(all);

        add(radioLabel);
        add(radioPanel, BorderLayout.LINE_START);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (BAN.equals(command)) {
            //banana button clicked
            type="BANANA";
        } else if (VAN.equals(command)) {
            //vanilla button clicked
            type="VANILLA";
        } else if (CHO.equals(command)) {
            //chocolate button clicked.
            type="CHOC";
        }else if (SIM.equals(command)) {
            //simple button clicked.
            type="PAN";
        }else if (ALL.equals(command)) {
            //all button clicked.
            type="ALL";
        }
    }
}
