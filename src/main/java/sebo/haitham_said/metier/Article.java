package sebo.haitham_said.metier;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodeArticle")
	private Long id;
	@Column(name = "Designation")
	private String designation;
	@Column(name = "Prix")
	private double prix;
	@Column(name = "Stock")
	private int stock;
	@ManyToOne
	private Categorie category;
	@Column(name = "Photo")
	private String photo;
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(String designation, double prix, int stock, Long id_cat, String photo, Categorie cat) {
		this.designation = designation;
		this.prix = prix;
		this.category = cat;
		this.stock = stock;
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
	
	public Categorie getCategory() {
		return category;
	}
	public void setCategory(Categorie category) {
		this.category = category;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", designation=" + designation + ", prix=" + prix + ", stock=" + stock
				+ ", category=" + category + ", photo=" + photo + "]";
	}
	
	
	
}
