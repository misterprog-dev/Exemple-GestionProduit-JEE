package com.ocGestionProduit.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocGestionProduit.metiers.Operation;
import com.ocGestionProduit.metiers.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/url_ProduitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Operation op;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		op = new Operation();
		
		if(request.getParameter("action") != null) {
			op.remove(Long.valueOf(request.getParameter("id")));
		
		}else {
			
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			int prix = Integer.valueOf(request.getParameter("prix"));
			String etat = request.getParameter("etat");

			//Traitement
			op.add(new Produit(1L, nom, description, prix, Integer.parseInt(etat)));
			
		}
		

		ProduitBeans pb = new ProduitBeans();
		pb.setListe(op.getAll());
		
		request.setAttribute("modele", pb);
		request.getRequestDispatcher("Produit.jsp").forward(request, response);
		


		
		//Afficher les infos
		//PrintWriter pr = response.getWriter();
		
		//pr.println(nom + "  ---   " + description + "  ---  " + prix + "  ---  " + etat + "  .");
	}

}
