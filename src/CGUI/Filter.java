package CGUI;

import client.Windows1251Control;

import javax.swing.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Filter extends JPanel implements ActionListener,ItemListener {
    private Slider sl;
    private TypesGroup bg;
    private Inserter in;
    public static Integer size=0;
    public static String type="ALL";
    public static Integer id=0;
    public boolean allSizes=true;
    Locale locale = Locale.getDefault();
    ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", locale, new Windows1251Control());
    public Filter(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        sl = new Slider();
        add(sl);
        JCheckBox all=new JCheckBox(rb.getString("Tick"));
        all.setMnemonic(KeyEvent.VK_A);
        all.setSelected(true);
        all.addItemListener(this);
        add(all);
        bg=new TypesGroup();
        add(bg);
        in=new Inserter();
        add(in);

        JButton ok=new JButton("OK");
        ok.addActionListener(this);
        add(ok);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(allSizes==true){
            size=0;
        }else{
            size=sl.result;
        }
        type=bg.type;
        id=in.amount;
        //System.out.println(size);
        //System.out.println(type);
        //System.out.println(id);
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            allSizes=true;
        }else{
            allSizes=false;
        }
    }
}
