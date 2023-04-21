package servlets;

import java.io.IOException;

import beans.Ville;
import dao.VilleDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Villes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VilleDaoImpl villeDaoImpl = new VilleDaoImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listeVille", this.villeDaoImpl.getListeVilles());
		
		String page;
        if (request.getParameterMap().containsKey("page")) {
        	page = request.getParameter("page");
        } else {
        	page = "";
        }
		switch(page) {
		case "distance":
			this.getServletContext().getRequestDispatcher("/WEB-INF/distance.jsp").include(request, response);
			break;
			case "villes":
				this.getServletContext().getRequestDispatcher("/WEB-INF/villes.jsp").forward(request, response);
				break;
			case "infoVille":
				request.setAttribute("ville", this.villeDaoImpl.getVilleByCodeCommune(request.getParameter("code_commune")));
				this.getServletContext().getRequestDispatcher("/WEB-INF/infoVille.jsp").include(request, response);
				break;
			default:
				this.getServletContext().getRequestDispatcher("/WEB-INF/distance.jsp").forward(request, response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listeVille", this.villeDaoImpl.getListeVilles());
		
		if (request.getParameter("calculerDistance") != null) 
		{
			String code_commune_ville_1 = request.getParameter("ville_1");
			String code_commune_ville_2 = request.getParameter("ville_2");
			
			Ville ville_1 = this.villeDaoImpl.getVilleByCodeCommune(code_commune_ville_1);
			Ville ville_2 = this.villeDaoImpl.getVilleByCodeCommune(code_commune_ville_2);
			
			Double distance = ville_1.distanceEntreDeuxVilles(ville_2);
			
			request.setAttribute("distanceEntre2Villes", distance);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/distance.jsp").forward(request, response);
		}
		else if (request.getParameter("modifierVille") != null) 
		{
			Ville ville = new Ville();
			ville.setCode_commune_INSEE(request.getParameter("code_commune"));
			ville.setNom_commune(request.getParameter("nom_commune"));
			ville.setCode_postal(request.getParameter("code_postal"));
			ville.setLibelle_acheminement(request.getParameter("libelle_acheminement"));
			ville.setLigne_5(request.getParameter("ligne_5"));
			ville.setLatitude(request.getParameter("latitude"));
			ville.setLongitude(request.getParameter("longitude"));
			
			this.villeDaoImpl.modifierVille(ville);
			
			request.setAttribute("ville", this.villeDaoImpl.getVilleByCodeCommune(request.getParameter("code_commune")));
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/infoVille.jsp").forward(request, response);
		}
	}

}
