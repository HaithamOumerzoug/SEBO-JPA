package sebo.haitham_said.metier;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private int codepostal;
	private String ville;
	private String tel=null;
	private String motdepasse;
	public Client() {
		super();
	}
	public Client(String nom, String prenom, String email, String adresse, int codepostal, String ville,
			String motdepasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.codepostal = codepostal;
		this.ville = ville;
		this.motdepasse = motdepasse;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse
				+ ", codepostal=" + codepostal + ", ville=" + ville + ", tel=" + tel + ", motdepasse=" + motdepasse
				+ "]";
	}
	
	
}
