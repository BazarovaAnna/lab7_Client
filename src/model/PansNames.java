package model;

import client.SampleClient;
import client.Windows1251Control;

import java.util.Locale;
import java.util.ResourceBundle;

public enum PansNames {
	PAN("USUAL",1),
	CHOC("CHOCOLATE",2),
	VANILLA("VANILLA",3),
	BANANA("BANANA",4);

	int panNum;
	String descr;
	String s;
	PansNames(String s,int e) {
		this.s=s;
		ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", SampleClient.locale, new Windows1251Control());
		descr=rb.getString(s);
		panNum=e;
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