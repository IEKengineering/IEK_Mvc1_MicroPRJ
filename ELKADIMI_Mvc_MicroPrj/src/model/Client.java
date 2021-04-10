package model;

import java.util.ArrayList;



public class Client {
	
	private int id;
	private String email;
	private String nom;
	private String prenom;
	private String adresse;
	private int codepostal;
	private String ville;
	private String tel;
	private String username;
	private String password;
	
	
	
	
	public Client(String email, String nom, String prenom, String adresse, int codepostal, String ville,
			String tel,String username, String password) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codepostal = codepostal;
		this.ville = ville;
		this.tel = tel;
		this.username = username;
		this.password = password;
	}
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getcodepostal() {
		return codepostal;
	}
	public void setcodepostal(int codepostal) {
		this.codepostal = codepostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Object fetchadd(ArrayList<Client> userList, String username) {
		for(Client c : userList) {
			if(c.getUsername().equals(username))
				return c.getAdresse();
		}
		return "";
	}
	public Object fetchemail(ArrayList<Client> userList, String username) {
		for(Client c: userList) {
			if(c.getUsername().equals(username))
				return c.getEmail();
		}
		return "";
	}
	public Object fetchname(ArrayList<Client> userList, String username) {
		for(Client c: userList) {
			if(c.getUsername().equals(username))
				return c.getNom();
		}
		return "";
	}
	
	

}
