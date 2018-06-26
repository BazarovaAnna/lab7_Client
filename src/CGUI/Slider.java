package CGUI;

import client.Windows1251Control;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.event.*;

/*
 * SliderDemo.java requires all the files in the images/doggy
 * directory.
 */
public class Slider extends JPanel
        implements ChangeListener {
    //Set up animation parameters.
    static final int FPS_MIN = 1;
    static final int FPS_MAX = 3;
    static final int FPS_INIT = 2;    //initial size
    public static Integer result=2;
    public Slider() {
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", locale, new Windows1251Control());
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //Create the label.
        JLabel sliderLabel = new JLabel(rb.getString("Sizeof"), JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Create the slider.
        JSlider size = new JSlider(JSlider.HORIZONTAL,
                FPS_MIN, FPS_MAX, FPS_INIT);


        size.addChangeListener(this);

        //Turn on labels at major tick marks.

        //size.setMajorTickSpacing(3);
        //size.setMinorTickSpacing(1);
        size.setPaintTicks(true);
        size.setPaintLabels(true);
        size.setBorder(
                BorderFactory.createEmptyBorder(0, 0, 10, 0));
        Font font = new Font("Serif", Font.ITALIC, 15);
        size.setFont(font);

        //Put everything together.
        add(sliderLabel);
        add(size);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    }

    /**
     * Listen to the slider.
     */
    public void stateChanged(ChangeEvent e) {

        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            int val = source.getValue();
            if (val == 1) {
                //System.out.println("small");
                result=1;
            } else if(val==2){
                //System.out.println("medium");
                result=2;
            }else if(val==3){
                //System.out.println("big");
                result=3;
            }
        }
    }

}