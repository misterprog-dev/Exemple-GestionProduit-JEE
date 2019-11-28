package com.ocGestionProduit.metiers;

public class Produit {
	private Long id;
	private String nom;
	private String description;
    private int prix, etat;
    
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String nom, String description, int prix, int etat) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.etat = etat;
	}
	public Produit(Long id, String nom, String description, int prix, int etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.etat = etat;
    }
    
    public String toString() {
        return nom + " - " + description + " - " + prix + " - " + etat;
    }

    public void Show() {
        System.out.println(toString());
    }
	
	
}