package beans;


import java.sql.Date;

public class Photo {
private int id,hauteur, largeur, idUtilisateur, id_albumfk;
private String titre, mots_cles, description;
private Date date_creation, date_maj;
private  String image;

public Photo() {}
public Photo(String titre, int hauteur, int largeur, String image, String mots_cles, String description, int id_albumfk ) {
	this.titre=titre;
	this.hauteur=hauteur;
	this.largeur= largeur;
	this.image= image;
	this.mots_cles=mots_cles;
	this.description= description;
	this.id_albumfk= id_albumfk;
}
public Photo(String titre, int hauteur, int largeur, String image, String mots_cles, Date date_creation, String description) {
	this.titre=titre;
	this.hauteur=hauteur;
	this.largeur= largeur;
	this.image= image;
	this.date_creation=date_creation;
	this.mots_cles=mots_cles;
	this.description= description;
	
}

public Photo(String titre, int hauteur, int largeur, String image, String mots_cles, String description) {
	this.titre=titre;
	this.hauteur=hauteur;
	this.largeur= largeur;
	this.image= image;
	this.mots_cles=mots_cles;
	this.description= description;
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getHauteur() {
	return hauteur;
}
public void setHauteur(int hauteur) {
	this.hauteur = hauteur;
}
public int getLargeur() {
	return largeur;
}
public void setLargeur(int largeur) {
	this.largeur = largeur;
}
public int getIdUtilisateur() {
	return idUtilisateur;
}
public void setIdUtilisateur(int idUtilisateur) {
	this.idUtilisateur = idUtilisateur;
}
public int getIdAlbum() {
	return id_albumfk;
}
public void setIdAlbum(int idAlbum) {
	this.id_albumfk = idAlbum;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getMots_cles() {
	return mots_cles;
}
public void setMots_cles(String mots_cles) {
	this.mots_cles = mots_cles;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDate_creation() {
	return date_creation;
}
public void setDate_creation(Date date_creation) {
	this.date_creation = date_creation;
}
public Date getDate_maj() {
	return date_maj;
}
public void setDate_maj(Date date_maj) {
	this.date_maj = date_maj;
}
public  String  getImage() {
	return image;
}

public void setImage( String image) {
	this.image = image;
}


}
