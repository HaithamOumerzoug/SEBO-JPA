package sebo.haitham_said.metier;

public class Categorie {
	private Long refcat;
	private String cat;
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String Cat) {
		this.cat = Cat;
	}
	public Long getRefCat() {
		return refcat;
	}
	public void setRefCat(Long refCat) {
		this.refcat = refCat;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String Cat) {
		this.cat = Cat;
	}
	
	
}
