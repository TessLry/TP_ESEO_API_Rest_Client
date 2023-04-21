<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>Villes </title>
</head>

<body>
<%@ include file="menu.jsp" %>
    
    <h1> Calculer la distance entre 2 villes :  </h1>
    
    <br> 
    
    <form method="post" action="villes">
	    <select name="ville_1" id="ville_1">
			<option value="null">--Selectionner une ville --</option>
			<c:forEach items="${listeVille}" var="ville">
				<option value="${ ville.getCode_commune_INSEE() }"> 
					<c:out value="${ ville.getNom_commune() }" /> 
				</option>
			</c:forEach>
		</select>
		
		 <select name="ville_2" id="ville_2">
			<option value="null">--Selectionner une ville --</option>
			<c:forEach items="${listeVille}" var="ville">
				<option value="${ ville.getCode_commune_INSEE() }"> 
					<c:out value="${ ville.getNom_commune() }" /> 
				</option>
			</c:forEach>
		</select>
		
		<br>
		<br>
		<input type="submit" name="calculerDistance" value="Calculer la distance"/>	
	</form>
	
	<br>
	
	<p> Distance entre les 2 villes : </p>
	<c:out value="${ distanceEntre2Villes }" /> 
    
	
			
  

</body>
</html>