package model;

import client.SampleClient;
import client.Windows1251Control;
import java.util.ResourceBundle;

public enum Size {

    BIG("BIG", 3),
    MEDIUM("MEDIUM", 2),
    SMALL("SMALL", 1);

    public int sizeNum;
    String descr;
    String s;

    Size(String s, int e) {
        this.s=s;
        ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", SampleClient.locale, new Windows1251Control());
        descr = rb.getString(s);
        sizeNum = e;
    }
    public void remakeDescr(){
        ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", SampleClient.locale, new Windows1251Control());
        descr=rb.getString(s);
    }

    @Override
    public String toString() {
        return descr;
    }
}
