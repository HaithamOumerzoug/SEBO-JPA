package sebo.haitham.metier;

public class Article {
	private Long id;
	private String designation;
	private double prix;
	private int stock;
	private Long id_cat;
	private String photo;
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(String designation, double prix, int stock, Long id_cat, String photo) {
		this.designation = designation;
		this.prix = prix;
		this.stock = stock;
		this.id_cat = id_cat;
		this.photo = photo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Long getId_cat() {
		return id_cat;
	}
	public void setId_cat(Long id_cat) {
		this.id_cat = id_cat;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
