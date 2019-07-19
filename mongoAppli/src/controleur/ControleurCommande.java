/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import com.mongodb.BasicDBObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modele.Commande;
import modele.CommandeDao;
import modele.Produit;
import vue.CommandeVue;
import vue.LigneCommande;

/**
 *
 * @author Formation
 */
public class ControleurCommande implements ActionListener,MouseListener{

    private CommandeVue cmdVue;
    private CommandeDao cmdDao;
    private LigneCommande ligneCmd;
    private DefaultTableModel modelCmd,modelLigneCmd;
    
    public ControleurCommande() {
        this.cmdVue = new CommandeVue();
        this.cmdDao = new CommandeDao();
        this.ligneCmd = new LigneCommande();

        this.cmdVue.getTxtDateCmd().setText(getDateJour());

        nextId();
        initModelCmd();
        //addListerner();
        initBtnD();
        this.cmdVue.setVisible(true);
        this.ligneCmd.setVisible(true);
    }

    /**
     * cette méthode retour la date du jour formatée
     *
     * @return
     */
    public String getDateJour() {
        Date aujourdhui = new Date();

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/Y");

        return formater.format(aujourdhui);
    }

    /**
     * cette méthode retourne l'id max de la collection Catégorie
     *
     * @return
     */
    public int maxId() {
        List<Commande> listeCmd = this.cmdDao.getAllCommande();
        List<Integer> listeId = new ArrayList<>();

        for (Commande cmd : listeCmd) {
            listeId.add(cmd.getIdCmd());
        }
        if (listeId.isEmpty()) {
            listeId.add(0);
        }
        return Collections.max(listeId);
    }
    /**
     * cette méthode met à jour le champs idCat avec l'id max +1 de la base
     */
    public void nextId() {
        this.cmdVue.getTxtIdCmd().setText(Integer.toString(maxId() + 1));
    }
      /**
     * 
     */
    public void initModelCmd(){
       modelCmd = new DefaultTableModel();   
          //création du modele catégorie
        //Ajout des Colonnes du dodele Catégorie
        modelCmd.addColumn("ID Commande");
        modelCmd.addColumn("Nom Client");
        modelCmd.addColumn("Date Commande");
        modelCmd.addColumn("Nombre de produit");
        //inserer les lignes dans le modele cat
        List<Commande> allCmd = new ArrayList<>();
        allCmd = this.cmdDao.getAllCommande();
        
        for (Commande cmd : allCmd) {
            modelCmd.addRow(new Object[]{cmd.getIdCmd(),
                cmd.getNomClient(),
                cmd.getDate(),
                cmd.getListeProd().size()});
        }
        this.cmdVue.getjTable1().setModel(modelCmd);     
    }
     public void initModelLigneCmd(){
       modelLigneCmd = new DefaultTableModel();   
          //création du modele catégorie
        //Ajout des Colonnes du dodele Catégorie
        modelLigneCmd.addColumn("ID Commande");
        modelLigneCmd.addColumn("Nom Client");
        modelLigneCmd.addColumn("Date Commande");
        modelLigneCmd.addColumn("Nombre de produit");
        //inserer les lignes dans le modele cat
        List<Produit> allCmd = new ArrayList<>();
        allCmd = this.cmdDao.getAllProduit();
        
        for (Produit cmd : allCmd) {
            modelLigneCmd.addRow(new Object[]{cmd.getIdCmd(),
                cmd.getNomClient(),
                cmd.getDate(),
                cmd.getListeProd().size()});
        }
        this.cmdVue.getjTable1Ligne().setModel(modelCmd);     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //gestion de la suppression d'une commande
        if(e.getSource().equals(this.cmdVue.getBtnSupprimerCmd())){
            this.cmdDao.supprimerCommande(new Commande(Integer.parseInt(
                    this.cmdVue.getTxtIdCmd().getText()),null));
            
            initModelCmd();
        }
        //création de la commande
        if(e.getSource().equals(this.cmdVue.getBtnAjouterCmd())){
            Commande cmd = new Commande();
            cmd.setIdCmd(Integer.parseInt(this.cmdVue.getTxtIdCmd().getText()));
            cmd.setNomClient(this.cmdVue.getTxtNomClient().getText());
            cmd.setDate(this.cmdVue.getTxtDateCmd().getText());
            
            this.cmdDao.ajouterCommande(cmd);
            
            nextId();
            initModelCmd();
        }
        if(e.getSource().equals(this.cmdVue.getBtnResetCmd())){
            initBtnD();
            this.cmdVue.getTxtDateCmd().setText(getDateJour());
            this.cmdVue.getTxtNomClient().setText("");
            nextId();
        }
        if(e.getSource().equals(this.cmdVue.getBtnAjouterProdCmd())){
            this.ligneCmd.setVisible(true);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //gestion de la suppression d'une commande
        if (e.getSource().equals(this.cmdVue.getBtnSupprimerCmd())) {
            this.cmdDao.supprimerCommande(new Commande(Integer.parseInt(
                    this.cmdVue.getTxtIdCmd().getText()), null));

            initModelCmd();
        }
        //création de la commande
        if (e.getSource().equals(this.cmdVue.getBtnAjouterCmd())) {
            Commande cmd = new Commande();
            cmd.setIdCmd(Integer.parseInt(this.cmdVue.getTxtIdCmd().getText()));
            cmd.setNomClient(this.cmdVue.getTxtNomClient().getText());
            cmd.setDate(this.cmdVue.getTxtDateCmd().getText());

            this.cmdDao.ajouterCommande(cmd);

            nextId();
            initModelCmd();
        }
        if (e.getSource().equals(this.cmdVue.getBtnResetCmd())) {
            initBtnD();
            this.cmdVue.getTxtDateCmd().setText(getDateJour());
            this.cmdVue.getTxtNomClient().setText("");
            nextId();
        }
        if (e.getSource().equals(this.cmdVue.getBtnAjouterProdCmd())) {
            this.ligneCmd.setVisible(true);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
         int ligne = this.cmdVue.getjTable1().getSelectedRow(); 
         //id de la commande
         int idCmd =Integer.parseInt(modelCmd.getValueAt(ligne,0).toString());
         
         this.cmdVue.getTxtIdCmd().setText(modelCmd.getValueAt(ligne,0).toString());
         this.cmdVue.getTxtNomClient().setText(modelCmd.getValueAt(ligne,1).toString());
         this.cmdVue.getTxtDateCmd().setText(modelCmd.getValueAt(ligne,2).toString());
         
         initBtnM();
         
         this.ligneCmd.getTxtIdCmd().setText(modelCmd.getValueAt(ligne,0).toString());
         this.ligneCmd.getTxtNomClient().setText(modelCmd.getValueAt(ligne,1).toString());
         this.ligneCmd.getTxtDateCmd().setText(modelCmd.getValueAt(ligne,2).toString());
    
         /*****************modele ligne Commande************/
        modelLigneCmd = new DefaultTableModel();   
          //création du modele catégorie
        //Ajout des Colonnes du modele Catégorie
        modelLigneCmd.addColumn("ID Prod");
        modelLigneCmd.addColumn("Nom Prod");
        modelLigneCmd.addColumn("QTE Commandée");
        modelLigneCmd.addColumn("Catégorie");
        //inserer les lignes dans le modele cat
        List<Commande> allCmd = new ArrayList<>();
        Commande cmd = this.cmdDao.getOneCommande(idCmd);
        
        for (BasicDBObject obj : cmd.getListeProd()) {          
            modelLigneCmd.addRow(new Object[]{obj.get("_id"),
                obj.get("nomProd"),obj.get("qteCmd")});
        }
        this.ligneCmd.getjTable1().setModel(modelLigneCmd);      
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   public void addListerner(){
       this.cmdVue.getjTable1().addMouseListener(this);
       this.cmdVue.getBtnSupprimerCmd().addActionListener(this);
       this.cmdVue.getBtnAjouterCmd().addActionListener(this);
       this.cmdVue.getBtnResetCmd().addActionListener(this);
       this.cmdVue.getBtnAjouterProdCmd().addActionListener(this);
    }
   public void initBtnD(){
       this.cmdVue.getBtnAjouterCmd().setEnabled(true);
       this.cmdVue.getBtnAjouterProdCmd().setEnabled(false);
       this.cmdVue.getBtnSupprimerCmd().setEnabled(false);
   }
  public void initBtnM(){
       this.cmdVue.getBtnAjouterCmd().setEnabled(false);
       this.cmdVue.getBtnAjouterProdCmd().setEnabled(true);
       this.cmdVue.getBtnSupprimerCmd().setEnabled(true);
   }
   
}