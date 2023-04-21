<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>Villes </title>
	<link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css">
    
    <style>
		ul.pagination {
		    display: inline-block;
		    padding: 0;
		    margin: 0;
		}
		
		ul.pagination li {display: inline;}
		
		ul.pagination li a {
		    float: left;
		    padding: 8px 16px;
		    border-radius: 5px;
		    color: black;
			text-decoration: none;
		}
		
		ul.pagination li a.active {
		    background-color: #111;
		    color: white;
		    border-radius: 5px;
		}
		
		 li a:hover:not(.active) {background-color: #ddd;}
		
		.listeVille a {
			color: black;
			text-decoration: none;
			padding: 8px;
		}
		.listeVille {
			display: grid;
			grid-template-columns: repeat(4, 1fr);
		}
	</style>

</head>

<body>
<%@ include file="menu.jsp" %>
     <main>
     
	    <h2> Toutes les villes </h2>
		
		<div class="listeVille">
			<c:forEach var="i" begin="${ (numPage-1)*nbResultatsParPage }" end="${ numPage*nbResultatsParPage }">
			    <a href="/TP_ESEO_API_Rest_Client/villes?page=infoVille&code_commune=${listeVille[i].getCode_commune_INSEE()}">
			    	<c:out value="${ listeVille[i].getNom_commune() }" />
			    </a>
			</c:forEach>
	    </div>
	    
	    <br>
	    <br>
	    
	    <div class="pagination">
			 <ul class="pagination">
			 	<li><a href="villes?page=villes&numPage=1">««</a></li>
				<li><a href="villes?page=villes&numPage=${ numPage-1 }">«</a></li>
				<li><a class="active" href="villes?page=villes&numPage=${ numPage }">${ numPage }</a></li>
				<li><a href="villes?page=villes&numPage=${ numPage+1 }">${ numPage+1 }</a></li>
				<li><a href="villes?page=villes&numPage=${ numPage+2 }">${ numPage+2 }</a></li>
				<li><a href="villes?page=villes&numPage=${ numPage+3 }">${ numPage+3 }</a></li>
				<li><a href="villes?page=villes&numPage=${ numPage+4 }">${ numPage+4 }</a></li>
				<li><a href="villes?page=villes&numPage=${ numPage+1 }">»</a></li>
				<li><a href="villes?page=villes&numPage=${ nbPageTotal+1 }">»»</a></li>
			</ul>
	    </div>
    
    </main>
	
</body>
</html>