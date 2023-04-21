package beans;


public class Ville {
	
	private String Code_commune_INSEE;
	private String nom_commune;
	private String code_postal;
	private String libelle_acheminement;
	private String ligne_5;
	private String latitude;
	private String longitude; 
	
	public Ville(String code_commune_INSEE, String nom_commune, String code_postal, String libelle_acheminement,
			String ligne_5, String latitude, String longitude) 
	{
		this.Code_commune_INSEE = code_commune_INSEE;
		this.nom_commune = nom_commune;
		this.code_postal = code_postal;
		this.libelle_acheminement = libelle_acheminement;
		this.ligne_5 = ligne_5;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Ville() 
	{
		
	}
	
	public String getCode_commune_INSEE() {
		return Code_commune_INSEE;
	}
	public void setCode_commune_INSEE(String code_commune_INSEE) {
		Code_commune_INSEE = code_commune_INSEE;
	}
	public String getNom_commune() {
		return nom_commune;
	}
	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getLibelle_acheminement() {
		return libelle_acheminement;
	}
	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelle_acheminement = libelle_acheminement;
	}
	public String getLigne_5() {
		return ligne_5;
	}
	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public double distanceEntreDeuxVilles(Ville ville) {
		double latitude1 = Double.parseDouble(this.getLatitude());
		double longitude1 = Double.parseDouble(this.getLongitude());
		double latitude2 = Double.parseDouble(ville.getLatitude());
		double longitude2 = Double.parseDouble(ville.getLongitude());

		double theta = longitude1 - longitude2;
		double distance = Math.sin(deg2rad(latitude1)) * Math.sin(deg2rad(latitude2)) + Math.cos(deg2rad(latitude1)) * Math.cos(deg2rad(latitude2)) * Math.cos(deg2rad(theta));
		distance = Math.acos(distance);
		distance = rad2deg(distance);
		distance = distance * 60 * 1.1515;

		distance = distance * 1.609344;

		return (distance);
	}
	
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}	

}
