package beans;

public class Album {
	
int id_album, idUtilisateur;
String nom, visibilite;
public Album() {}
public Album(int idUtilisateur,  String nom, String visibilite) {
	this.idUtilisateur=idUtilisateur;
	this.visibilite=visibilite;
	this.nom=nom;
	
}
public Album(String nom, String visibilite) {
	
	this.visibilite=visibilite;
	this.nom=nom;
	
}
public int getId_album() {
	return id_album;
}
public void setId_album(int id_album) {
	this.id_album = id_album;
}
public int getIdUtilisateur() {
	return idUtilisateur;
}
public void setIdUtilisateur(int idUtilisateur) {
	this.idUtilisateur = idUtilisateur;
}
public String getVisibilite() {
	return visibilite;
}
public void setVisibilite(String visibilite) {
	this.visibilite = visibilite;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
}
