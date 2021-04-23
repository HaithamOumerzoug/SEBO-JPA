package sebo.haitham_said.metier;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Categorie {
private static final long serialVersionUID = 1L;
	@Column(name = "RefCat")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long refcat;
	@Column(name = "Cat")
	private String cat;
	@OneToMany(targetEntity = Article.class, mappedBy = "category")
	private List<Article> articles = new ArrayList<>();
	
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
	@Override
	public String toString() {
		return "Categorie [refcat=" + refcat + ", cat=" + cat + "]";
	}
	
	
}
