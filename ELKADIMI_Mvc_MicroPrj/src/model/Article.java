package model;

import java.util.ArrayList;

public class Article {
	
	private int CodeArticle;
	private String Designation;
	private double Prix;
	private int Stock;
	private String Categorie;
	private String Photo;
	
	
	
	public Article(int CodeArticle, String Designation, double 	Prix, int Stock, String Categorie,
			String Photo) {
		super();
		this.CodeArticle = CodeArticle;
		this.Designation = Designation;
		this.Prix = Prix;
		this.Stock = Stock;
		this.Categorie = Categorie;
		this.Photo = Photo;
		
	}
	public Article() {
		// TODO Auto-generated constructor stub
	}
	public int getCodeArticle() {
		return CodeArticle;
	}
	public void setCodeArticle(int codeArticle) {
		this.CodeArticle = codeArticle;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		this.Designation = designation;
	}
	public double getPrix() {
		return Prix;
	}
	public void setPrix(double prix) {
		this.Prix = prix;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		this.Stock = stock;
	}
	public String getCategorie() {
		return Categorie;
	}
	public void setCategorie(String categorie) {
		this.Categorie = categorie;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String Photo) {
		this.Photo = Photo;
	}
	@Override
	public String toString() {
		return "Article [CodeArticle=" + CodeArticle + ", Designation=" + Designation + ", Prix=" + Prix + ", Categorie=" + Categorie + ",+"
				+"Photo=" + Photo + "]";
	}
	public boolean check(ArrayList<String> panier, String CodeArticle) {
		for(String CodeArticle1 : panier) {
			if(CodeArticle.equals(CodeArticle1))
				return true;
		}
		return false;
	}
	public ArrayList<String> remove(ArrayList<String> panier, String CodeArticle) {
		for(String CodeArticl : panier) {
			if(CodeArticl.equals(CodeArticle)) {
				panier.remove(CodeArticl);
				break;
			}
				
		}
		
		return panier;
	}
	
	

}