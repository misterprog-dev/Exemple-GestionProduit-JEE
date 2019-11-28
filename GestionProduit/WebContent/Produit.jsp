<%@page import="com.ocGestionProduit.web.ProduitBeans"%>
<%@page import="com.ocGestionProduit.metiers.Produit"%>
<%@page import="com.ocGestionProduit.metiers.Operation"%>
<%@page import="java.util.Iterator"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" name='viewport' content='width=device-width, initial-scale=1.0'>
	<title>Esatic.Net || Gestion Produit</title>
	<link href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css' rel='stylesheet' media='screen' />
</head>
<body>

	<%
	
		ProduitBeans produits;
		if(request.getAttribute("modele") != null){
			produits = (ProduitBeans) request.getAttribute("modele");
		}else{
			Operation o = new Operation();
			produits = new ProduitBeans();
			produits.setListe(o.getAll());
		}

	%>

	<div class="container">
		<div class="text-center">
			<h2>Java Entreprise Edition JEE</h2>
			<h3>
				Mise en place des technologies JSP, Servlet, MVC, JDBC
			</h3>
			<br>
			<h2> Ajouter nouveau produit</h2>
		</div>
	
		<div class="container">
		
			<form action="prodServlet" method="post">
		
				<table class="table table-dark" border="1" width="30%">
				  <tbody>
				    <tr>
				      	<td>Nom</td>
				     	<td><input type="text" name="nom" class="form-control"></td>
				    </tr>
				    <tr>
				      <td>Description</td>
				      <td><input type="text" name="description" class="form-control"></td>
				    </tr>
				    <tr>
				      <td>Prix</td>
				      <td><input type="number" name="prix" class="form-control"></td>
				    </tr>
				    <tr>
				      <td>Etat</td>
				      <td><input type="number" name="etat" class="form-control"></td>
				    </tr>
				    <tr>
				      <td colspan="2"><input type="submit" value="Valider" class="btn btn-primary btn-block"></td>
				    </tr>
				  </tbody>
				</table>
			
			</form>
			
		</div>
	

		<div class="container">
			<h2>LISTE DES PRODUITS</h2>
			<table border="1" width="60%" class="table table-dark">
				<thead>
					<tr>
						<th> ID</th>
						<th> NOM</th>
						<th> DESCRIPTION</th>
						<th> PRIX</th>
						<th> ETAT</th>
						<th> OPTION</th>
					</tr>
				</thead>
				<tbody>
						
					<%
						Iterator<Produit> list = produits.getListe().iterator();
		
						while(list.hasNext()){
							Produit p = list.next();
					%>
	
					<tr>
						<td><%= p.getId() %></td>
						<td><%= p.getNom() %></td>
						<td><%= p.getDescription() %></td>
						<td><%= p.getPrix() %></td>
						<td><%= p.getEtat() %></td>
						<td>
							<form action="prodServlet" method="post">
								<input type="hidden"  name="id" value="<%= p.getId() %>">
								<input type="hidden" name="action" value="supprimer">
								<input type="submit" class="form-control btn btn-danger" value="Supprimer"> 
							</form>
						</td>
					</tr>
	
					<%
	
						}
					%>
					
				</tbody>
			</table>
		</div>
		
	</div>
	
	
	<script type="text/javascript" src="src='http://code.jquery.com/jquery.js"></script>
	<script type="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>