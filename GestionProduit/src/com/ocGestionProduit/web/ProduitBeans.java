package com.ocGestionProduit.web;

import java.util.ArrayList;
import com.ocGestionProduit.metiers.Produit;

public class ProduitBeans {

    private Produit produit = new Produit();

    private ArrayList<Produit> liste = new ArrayList<Produit>();

    /**
     * @return Produit return the produit
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * @param produit the produit to set
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public ArrayList<Produit> getListe() {
		return liste;
	}

	/**
     * @param arrayList the liste to set
     */
    public void setListe(ArrayList arrayList) {
        this.liste = arrayList;
    }

}
