/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Administrateur
 */
public class Produit {
    private int idProd;
    private String nomProd;
    private String descriptionProd;
    private double prix;
    private int qteProd;
    private Categorie catProd;

    public Produit() {
    }

    public Produit(int idProd, String nomProd, String descriptionProd, double prix, int qteProd, Categorie catProd) {
        this.idProd = idProd;
        this.nomProd = nomProd;
        this.descriptionProd = descriptionProd;
        this.prix = prix;
        this.qteProd = qteProd;
        this.catProd = catProd;
    }


    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public String getDescriptionProd() {
        return descriptionProd;
    }

    public void setDescriptionProd(String descriptionProd) {
        this.descriptionProd = descriptionProd;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQteProd() {
        return qteProd;
    }

    public void setQteProd(int qteProd) {
        this.qteProd = qteProd;
    }

    public Categorie getCatProd() {
        return catProd;
    }

    public void setCatProd(Categorie catProd) {
        this.catProd = catProd;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProd=" + idProd + ", nomProd=" + nomProd + ", descriptionProd=" + descriptionProd + ", prix=" + prix + ", qteProd=" + qteProd + ", catProd=" + catProd + '}';
    }

  

    
}
