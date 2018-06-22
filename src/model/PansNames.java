package model;
public enum PansNames {
	PAN("Simple pancakes",1),
	CHOC("Chocolate pancakes",2),
	VANILLA("Pancakes with vanilla",3),
	BANANA("Pancakes with banana",4);

	int panNum;
	private final String descr;
	PansNames(String s,int e) {
		descr=s;
		panNum=e;
	}

	@Override
	public String toString() {
		return descr;
	}

}