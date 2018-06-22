package model;

public class Pancakes implements Comparable<Pancakes> {
	public PansNames name;
	public Size size;
	public Integer id;
	public String location;
	public String color;

	public Pancakes(Size size, PansNames name, Integer id, String location) {
		this.name=name;
		this.size=size;
		this.id=id;
		this.location=location;
		if(this.name.equals(PansNames.BANANA)){
			this.color="YELLOW";
		}else if(this.name.equals(PansNames.CHOC)){
			this.color="BROWN";
		}else if(this.name.equals(PansNames.PAN)){
			this.color="RED";
		}else if(this.name.equals(PansNames.VANILLA)){
			this.color="BLUE";
		}
	}

	@Override
	public int compareTo(Pancakes p) {
		if(this.size.sizeNum-p.size.sizeNum>0){return +1;}
		else
		if(this.size.sizeNum-p.size.sizeNum<0){return -1;}
		else
		if(this.size.sizeNum-p.size.sizeNum==0){return 0;}
		else return 0;
	}
	public int compareTo1(Pancakes p){
		return name.compareTo(p.name);
	}
	public boolean equals(Object s) {
		if (s == null) {
			return false;
		}
		if (this == s) {
			return true;
		}
		if (!(getClass() == s.getClass())){
			return false;
		}

		else {
			Pancakes tmp = (Pancakes) s;
			return (tmp.name.equals(name) && tmp.size.equals(size) && tmp.id.equals(id) && tmp.location.equals(location));
		}
	}
	public String getType(){
		if(this.name.equals(PansNames.CHOC)){
			return "CHOC";
		}else if(this.name.equals(PansNames.BANANA)){
			return "BANANA";
		}else if(this.name.equals(PansNames.PAN)){
			return "PAN";
		}else if(this.name.equals(PansNames.VANILLA)){
			return "VANILLA";
		}else{
			return null;
		}
	}
	public String toString() {
		return id+ " "+size+" "+name;
	}
}