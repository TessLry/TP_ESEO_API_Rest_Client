package dao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import beans.Ville;

public class VilleDaoImpl implements VilleDao {
	
	@Override
	public List<Ville> getListeVilles() {
		List<Ville> listeVilles = new ArrayList<>();
		
		HttpRequest requestAllVille = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8181/villes"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		HttpResponse<String> responseAllVille = null;
		try {
			responseAllVille = HttpClient.newHttpClient().send(requestAllVille, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} 
		JSONArray ja = new JSONArray(responseAllVille.body());
		
		for(int i=0; i<ja.length(); i++) {
			JSONObject jo = ja.getJSONObject(i);
			Ville ville = new Ville();
			ville.setCode_commune_INSEE(jo.getString("code_commune_INSEE"));
			ville.setNom_commune(jo.getString("nom_commune"));
			listeVilles.add(ville);
			
		}
		
		return listeVilles;
	}
	
	@Override
	public Ville getVilleByCodeCommune(String code_commune) {		
		HttpRequest requestVille = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8181/villes/"+ code_commune))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		HttpResponse<String> responseVille = null;
		try {
			responseVille = HttpClient.newHttpClient().send(requestVille, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} 
		JSONObject jo = new JSONObject(responseVille.body());
		
		Ville ville = new Ville();
		ville.setCode_commune_INSEE(jo.getString("code_commune_INSEE"));
		ville.setNom_commune(jo.getString("nom_commune"));
		ville.setCode_postal(jo.getString("code_postal"));
		ville.setLibelle_acheminement(jo.getString("libelle_acheminement"));
		ville.setLigne_5(jo.getString("ligne_5"));
		ville.setLatitude(jo.getString("latitude"));
		ville.setLongitude(jo.getString("longitude"));
		
		
		return ville;
	}
	
	@Override
	public void modifierVille(Ville ville) {
		JSONObject jo = new JSONObject(ville);
        String json = jo.toString();
        
		HttpRequest requestVille = HttpRequest.newBuilder()
		        .uri(URI.create("http://localhost:8181/villes"))
		        .header("Content-Type", "application/json")
		        .PUT(BodyPublishers.ofString(json))
		        .build();
		
		try {
			HttpClient.newHttpClient().send(requestVille, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} 
	}

}
