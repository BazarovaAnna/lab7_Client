package model;
public enum Size {
	BIG("Huge",3),
	MEDIUM("Medium",2),
	SMALL("Small",1);

	public int sizeNum;
	private final String descr;
	Size(String s,int e) {
		descr=s;
		sizeNum=e;
	}
	@Override
	public String toString() {
		return descr;
	}
}
