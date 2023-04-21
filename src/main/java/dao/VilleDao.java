package dao;

import java.util.List;

import beans.Ville;

public interface VilleDao {
	List<Ville> getListeVilles();
	Ville getVilleByCodeCommune(String code_commune);
	void modifierVille(Ville ville);

}
