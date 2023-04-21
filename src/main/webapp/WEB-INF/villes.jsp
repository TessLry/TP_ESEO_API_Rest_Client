<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>Villes </title>
</head>

<body>
<%@ include file="menu.jsp" %>
    
    <h1> Toutes les villes </h1>
   
    <a href="/TP_ESEO_API_Rest_Client/villes?page=infoVille&code_commune=${listeVille[0].getCode_commune_INSEE()}">
    	 <c:out value="${ listeVille[0].getNom_commune() }" />
    </a>
    
    <!-- <c:forEach items="${listeVille}" var="ville">
		<c:out value="${ ville.getNom_commune() }" />
		<br> 
	</c:forEach> -->
	
	<!--  <div class="pagination_section">
       <ul id="pagination-clean">
		    <li class="previous-off">« Précédent</li>
		    <li class="active">1</li>
		    <li><a href="/?page=2">2</a></li>
		    <li><a href="/?page=3">3</a></li>
		    <li><a href="/?page=4">4</a></li>
		    <li><a href="/?page=5">5</a></li>
		    <li><a href="/?page=6">6</a></li>
		    <li><a href="/?page=7">7</a></li>
		    <li class="next"><a href="/?page=2">Suivant »</a></li>
		</ul>
    </div> -->
    
    
	
			
  

</body>
</html>