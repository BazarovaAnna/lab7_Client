package CGUI;

import client.Windows1251Control;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Inserter extends JPanel
        implements PropertyChangeListener {
    static Locale locale = Locale.getDefault();
    static ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", locale, new Windows1251Control());
    //Values for the fields
    public Integer amount = 0;

    //Labels to identify the fields
    private JLabel amountLabel;

    //Strings for the labels
    private static String amountString = rb.getString("Idtoch");

    //Fields for data entry
    private JFormattedTextField amountField;

    //Formats to format and parse numbers
    private NumberFormat amountFormat;

    public Inserter() {
        super(new BorderLayout());
        setUpFormats();
        //Create the labels.
        amountLabel = new JLabel(amountString);

        //Create the text fields and set them up.
        amountField = new JFormattedTextField(amountFormat);
        amountField.setValue(new Double(amount));
        amountField.setColumns(10);
        amountField.addPropertyChangeListener("value", this);

        //Tell accessibility tools about label/textfield pairs.
        amountLabel.setLabelFor(amountField);

        //Lay out the labels in a panel.
        JPanel labelPane = new JPanel(new GridLayout(0, 1));
        labelPane.add(amountLabel);

        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new GridLayout(0, 1));
        fieldPane.add(amountField);

        //Put the panels in this panel, labels on left,
        //text fields on right.
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, BorderLayout.CENTER);
        add(fieldPane, BorderLayout.LINE_END);
    }

    /**
     * Called when a field's "value" property changes.
     */
    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == amountField) {
            amount = ((Number) amountField.getValue()).intValue();
        }
    }
    private void setUpFormats() {
        amountFormat = NumberFormat.getNumberInstance();
    }
}