/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *Cette class permet de creer des objets de type Cayégories
 * @author Francis
 * @version 1.0
 */
public class Categorie {
    /**
     * idCat attribut de classse de type int
     */
    private int idCat;
    /**
     * libelle
     */
    private String libelle;
/**
 * 
 * @param idCat c'est un identifiant unique pour une catégorie
 * @param libelle 
 */
    public Categorie(int idCat, String libelle) {
        this.idCat = idCat;
        this.libelle = libelle;
    }

    public Categorie(int idCat) {
        this.idCat = idCat;
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }
    /**
     * Constructeur par défaut
     */

    public Categorie() {
    }

    public int getIdCat() {
        return idCat;
    }
/**
 * 
 * @param idCat 
 */
    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getLibelle() {
        return libelle;
    }
/**
 * @since 1.0
 * @param libelle 
 */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idCat=" + idCat + ", libelle=" + libelle + '}';
    }
    
}
