/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrateur
 */
public class ProduitDao implements produitInterface{
    private DB db;
    private DBCollection collectionProd;

    public ProduitDao() {
        this.db = Connexion.getConnexion();
        collectionProd = this.db.getCollection("produit");
    }
    @Override
    public List<Produit> getAllProduit() {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     List<Produit>listeProd = new ArrayList<>();
    //stockage de toutes les categories dans un objet DBCursor
    DBCursor cursor = this.collectionProd.find();
    
    //parcours du cursor
    while(cursor.hasNext()){//hasNext permet de tester la fin du curseur
        DBObject obj = cursor.next();
        //next permet de recuperer le doc dans le curseur apres chaque iteration
    Produit prod = new Produit();
    prod.setIdProd((int)obj.get("_id"));
   
    prod.setDescriptionProd(obj.get("description").toString());
    prod.setNomProd(obj.get("nom").toString());
    prod.setPrix((double)obj.get("prix"));
   prod.setQteProd((int)obj.get("quantite"));
   
    //création du document pour récupérer la cat dans le document Prod
    DBObject objCat = (DBObject)obj.get("idCat");
    
    //mise à jour de la cat ds l'objet produit
    prod.setCatProd(new Categorie((int)objCat.get("_id"),
    objCat.get("libelle").toString()));
    
            
    
    listeProd.add(prod);
    
    }
    
    return listeProd;
    
    
    
    }

    @Override
    public void addProduit(Produit prod) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //création d'un document 
        BasicDBObject docProd = new BasicDBObject();
        docProd.append("_id",prod.getIdProd());
        docProd.append("nom", prod.getNomProd());
        docProd.append("description", prod.getDescriptionProd());
        docProd.append("prix", prod.getPrix());
        docProd.append("quantite", prod.getQteProd());
        docProd.append("idCat", new BasicDBObject("_id", prod.getCatProd().getIdCat())
        .append("libelle",prod.getCatProd().getLibelle()));
        
        //ajout du document dans la collection catégorie
        this.collectionProd.insert(docProd);
        
        JOptionPane.showMessageDialog(null,"Opération effectuée avec succes");
    }
    
    
    
    

    @Override
    public void deleteproduit(Produit prod) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     BasicDBObject docProd = new BasicDBObject();
        docProd.append("_id", prod.getIdProd());
               
        this.collectionProd.remove(docProd);            
        JOptionPane.showMessageDialog(null,"Opération effectuée avec succes");
    

}

    @Override
    public void updateProduit(Produit prod) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       BasicDBObject docProdNew = new BasicDBObject();
        docProdNew.append("_id",prod.getIdProd());
        //création du document avec les valeur à mettre à jour
       
        docProdNew.append("_id",prod.getIdProd());
        docProdNew.append("nom", prod.getNomProd());
        docProdNew.append("description", prod.getDescriptionProd());
        docProdNew.append("prix", prod.getPrix());
        docProdNew.append("quantite", prod.getQteProd());
        docProdNew.append("idCat", new BasicDBObject("_id", prod.getCatProd().getIdCat())
        .append("libelle",prod.getCatProd().getLibelle()));
        
        BasicDBObject docProdOld = new BasicDBObject();
        docProdOld.append("_id",prod.getIdProd());
        
        this.collectionProd.update(docProdOld, docProdNew);
     
        JOptionPane.showMessageDialog(null,"Opération effectuée avec succes");
    
    
    }

    @Override
    public Produit getOneProduit(int idProd) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Produit prod = new Produit();
        //creation d'un document avec l'id passé en paramètre
        BasicDBObject docProd = new BasicDBObject("_id",idProd);
        //find avec id comme filtre
        //DBCursor cursor = this.collectionCat.find(docCat);
        //DBObject objcat = cursor.next();//this.collectionCat.findOne(docCat);
        DBObject objcat =this.collectionProd.findOne(docProd);
        prod.setIdProd((int)objcat.get("_id"));
        prod.setNomProd(objcat.get("nom").toString());
        
        return prod;
    }
    
    
    
    }
    

