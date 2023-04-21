<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>Villes </title>
    
    <style>
    	form { 
    		width : 30%;
    		display: flex;
			flex-direction: column;
    	}
    	label{
    	margin-top : 20px
    	}
    </style>
	<link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css">
</head>

<body>
<%@ include file="menu.jsp" %>

	<main>
    
	    <h2> Info sur une ville </h2>
	    
	    <form method="post" action="villes?page=infoVille&code_commune=${ville.getCode_commune_INSEE()}">
	    	<label for="code_commune"> Code commune INSEE </label> 
	    	<input type="text" id="code_commune" name="code_commune" value="${ville.getCode_commune_INSEE()}" readonly>
			
			<br>
			
			<label for="nom_commune"> Nom commune </label> 
	    	<input type="text" id="nom_commune" name="nom_commune" value="${ville.getNom_commune()}">
	    	
	    	<br>
	    	
	    	<label for="code_postal"> Code postal </label> 
	    	<input type="text" id="code_postal" name="code_postal" value="${ville.getCode_postal()}">
	    	
	    	<br>
	    	
	    	<label for="libelle_acheminement"> Libéllé acheminement </label> 
	    	<input type="text" id="libelle_acheminement" name="libelle_acheminement" value="${ville.getLibelle_acheminement()}">
	    	
	    	<br>
	    	
	    	<label for="ligne_5"> Ligne 5 </label> 
	    	<input type="text" id="ligne_5" name="ligne_5" value="${ville.getLigne_5()}">
	    	
	    	<br>
	    	
	    	<label for="latitude"> Latitude </label> 
	    	<input type="text" id="latitude" name="latitude" value="${ville.getLatitude()}">
	    	
	    	<br>
	    	
	    	<label for="longitude"> Longitude </label>
	    	<input type="text" id="longitude" name="longitude" value="${ville.getLongitude()}">
			
			<br>
			<br>
			<input type="submit" name="modifierVille" value="Enregistrer les informations"/>	
		</form>
		
		<br>
		<button onclick="window.location.href = 'http://localhost:8080/TP_ESEO_API_Rest_Client/villes?page=villes&numPage=1';">Retour</button>
    
    </main>
</body>
</html>