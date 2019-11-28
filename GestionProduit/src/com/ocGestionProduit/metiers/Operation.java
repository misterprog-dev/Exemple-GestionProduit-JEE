package com.ocGestionProduit.metiers;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Operation {

	private ArrayList<Produit> produits = new ArrayList<Produit>();

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
    
    public void add (Produit p) {
    	
    	try {
    		//1
			Class.forName("com.mysql.jdbc.Driver");
			//Connexion
			java.sql.Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_gestionproduittest", "root","");
			//Préparer requête
			PreparedStatement pr = (PreparedStatement) cn.prepareStatement("INSERT INTO produit VALUES (NULL, ?, ?, ?, ?, NOW())");
			pr.setString(1, p.getNom());
			pr.setString(2, p.getDescription());
			pr.setInt(3, p.getPrix());
			pr.setInt(4, p.getEtat());
			
			pr.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        produits.add(p);
    }

    public void remove (Long id) {
        for(Produit p:produits) {
            if(p.getId() == id){
                produits.remove(p);
                break;
            }
        }
        
        try {
    		//1
			Class.forName("com.mysql.jdbc.Driver");
			//Connexion
			java.sql.Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_gestionproduittest", "root","");
			//Préparer requête
			PreparedStatement pr = (PreparedStatement) cn.prepareStatement("DELETE FROM produit WHERE id = ?");
			pr.setLong(1, id);
			
			pr.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public ArrayList getAll() {

    	ArrayList<Produit> listProduits = new ArrayList<Produit>();
    	
    	try {
    		//1
			Class.forName("com.mysql.jdbc.Driver");
			//Connexion
			java.sql.Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_gestionproduittest", "root","");
			//Préparer requête
			PreparedStatement pr = (PreparedStatement) cn.prepareStatement("SELECT * FROM produit");
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getLong("id"));
				p.setNom(rs.getString("nom"));
				p.setDescription(rs.getString("description"));
				p.setPrix(rs.getInt("prix"));
				p.setEtat(rs.getInt("etat"));
				
				listProduits.add(p);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return listProduits;
    }
	
	
	
}
