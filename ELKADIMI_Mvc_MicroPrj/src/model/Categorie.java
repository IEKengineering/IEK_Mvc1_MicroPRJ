package model;

public class Categorie {
	
	private int RefCat;
	private String Cat;
	
	
	public Categorie(int RefCat, String Cat) {
		super();
		this.RefCat = RefCat;
		this.Cat = Cat;
	}
	public int getRefCat() {
		return RefCat;
	}
	public void setRefCat(int refCat) {
		this.RefCat = refCat;
	}
	public String getCat() {
		return Cat;
	}
	public void setCat(String cat) {
		this.Cat = cat;
	}
	
	
}