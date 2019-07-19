/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.java1;

/**
 *
 * @author Administrateur
 */
public class CoursJava1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  
        System.out.println("Bonjour et bienvenu");
        
      /*  // déclaration
        int note;
        
        // initialisation assignation  
        note = 10;
        
        // déclaration + assignation de la variable
        int qte = 12;
        
        // déclaration de plusieurs variables
        
        int var1,var2,var3;
        
        // affichage des valeurs des variables
        
        System.out.println(note);
        
        
        // var boolean
        boolean trouve;
        trouve = false;
        
        // var caractere
        char tarif;
        tarif = 'k';
        
        String caractere;
        caractere = "etat";
        
        // var double
        double prix;
        
        prix = 52;
        System.out.println(prix);
        
        
        // lire les donnees du clavier
        
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrer un entier");
        int valeurClavier;
        
        //int
        valeurClavier = clavier.nextInt();
        System.out.println("la valeur est de :" + valeurClavier);
        
       //ligne
        System.out.println("Entrer une ligne");
        clavier.nextLine();
        String ligne = clavier.nextLine();
        System.out.println("la valeur est de :" + ligne);
        
        //char
        System.out.println("Entrer un caractere");
        char carac = clavier.next().charAt(0);
        System.out.println("la valeur est de :" + carac);
        
        final int PRIX_U = 10;
        
       /* System.out.println("entrez une valeur :");
        int tempsHeures = valeurClavier / 3600;
        
              
        int tempsMinutes = tempsHeures  %60;
        
        int tempsSecondes = tempsMinutes  %60;
        
        System.out.println("la valeur est de :" + tempsHeures+"h" + tempsMinutes + "m" + tempsSecondes + "s");
         
         
        final int TVA = 1.1;
        final int PRODUIT = 20;
        
        System.out.println("entrez le nombre de produit :");
        float prixPayer = TVA * PRODUIT * valeurClavier;
        System.out.println("le prix à payer est " + valeurClavier);*/
        
        // tp1
        
       /* int heure,minute,seconde,tempsEcoule;
        
        tempsEcoule = 3600;
        seconde = tempsEcoule%60;
        minute = (tempsEcoule/60)%60;
        heure = (tempsEcoule/3600);
        
        System.out.println("le temps écoulé est de" + tempsEcoule + "==>" + heure + "h:"+minute+"m:"+seconde+"s");
        
        //tp3
        
        int a,b,c;
        
        a=5;
        b=10;
        System.out.println("avant le swap,a :"+a+ "et b: "+b);
        c = a;
        a = b;
        b = c;
        System.out.println("apres le swap a:"+a+"et b :"+b);
        */
        //tp2
        /***déclaration des variables****/
        /*final int TVA = 20;
        double pu,pttc,pthtva;
        int qté;
        
        /*** initialisation des variables****/
        
       /* qte = 10;
        pu = 125;
        pthtva = (pu*qte);
        pttc = (pthtva+(pthtva* TVA/100));
        
        
        System.out.println("pu :"+pu+"qté : "+qte+" ==>"+pttc);
        
        //exercice1
        int entier=45;
        
        if (entier==0) {
            System.out.println("l'entier est strictement nul");
        }
        else if(entier>0) {
        System.out.println("l'entier est strictement positif");
        }
        else if(entier<0) {
        System.out.println("l'entier est strictement négatif");
        }
        
        //exercice2
        
        int a1,b1,c1;
        
        a1=4;
        b1=65;
        c1=12;
        
        if (a1 > b1 && a1>c1) {
            System.out.println(a1);
        }
        else if (b1>a1 && b1>c1) {
         System.out.println(b1); 
        }
        else if (c1>a1 && c1>b1) {
            System.out.println(c1);
    }  
        //exercice3
        int borneInf,borneSup;
        
        if(b<c) {
            borneInf = b;
            borneSup = c;
        }
        else {
            borneInf = c;
            borneSup =b;
        }
          if(a1 > borneInf && a1 < borneSup ){
            System.out.println("La valeur " + a1 + "" + "appartient à l'intervalle ]" + borneInf +  "," + borneSup + "[");
            
        }
        else{
            System.out.println("La valeur " + a1 + "" + "appartient à l'intervalle ]" + borneInf +  "," + borneSup + "[");
            
            
        }
          
          
          
          
          
          
          
    
    
    
    //tp boucles
    //exercice 1
    
        int nombre = 5,i;
        
        for(i=0;i<=10;i++) {
   
            System.out.println(nombre + "'" + i + "=" + (nombre*i));

        }
        
         i =0;
      
         while (i<=10) {
        
             System.out.println(nombre + "'" + i + "=" + (nombre*i));
             i++;
        }
    
    
    //exercice2
     
   int somme = 0, chiffre = 123;
   
    
    while(chiffre!=0) {
        System.out.println("le modulo :" + chiffre%10+"iteration"+chiffre);
        somme = somme + chiffre%10;
        chiffre = chiffre/10;
    }
   
        System.out.println("la somme est de :");
        

       // exercice3
       
       int nbre= 4,reste;
       String configBin="";
       while(nbre>=1) {
           reste = nbre%2;
           nbre = nbre/2;
           System.out.println("reste");
           configBin = reste + configBin;
       }
        System.out.println("la config binaire est : " + configBin);
        
        */
        
        
        /*******les tableaux********/
        // 1 Déclaration
        /*int [] tabEnt;
        // 2 création du tableau
        tabEnt = new int[10];
        // 3 initialisation du tableau
        for(int i=0;i<tabEnt.length;i++) {
            tabEnt[i] = i;
        }
        // 4 parcours et affichage des éléments du tableau avec une boucle foreach
        for(int francis : tabEnt) {
            System.out.println(francis);
        }
        // 5- faire la somme des éléments d'un tableau
        
        int soe = sommeElt (tabEnt);
        System.out.println("la somme des éléments du tableau :" + soe);
        System.out.println (sommeImpairs (simpson));
        
        // faire la somme des éléments d'un tableau passé en paramètre
     
    }   
/**
        
     /** 
     public static int sommeElt(int[] tab) {
        int somme = 0;
        for(int  i=0;i<tab.length;i++) {
            somme = somme + tab [i];
    }
        //System.out.println(somme);
                
        return somme;
}
     public static int sommeImpairs(int [] simpson) {
         int somme1 = 0;
         for(int i=0;i<simpson.length;i++) {
             if(simpson[i]%2 !=0){
         somme1 = somme1 + simpson[i];
         }  
         }
         return somme1;
     }
     
     //ex2
     
     public static int valeurMax(int[] tab) {
         int max = tab[0];
         for(int i = 1; i<tab.length;i++) {
             if(tab[i]>max){
                 max = tab[i];
             }
         }
         return max;
     } 
         //ex3
         public static boolean tableauOrdonne(int[] tab) {
             boolean ordonne = true;
             int i=0;
             while (i<tab.length && ordonne) {
                 if(tab[i+1] <tab[i]) {
                     ordonne = false;
                 }
                 i++;
             }
             return ordonne;
         
         }
            //avec for
           public static boolean tableauOrdonne2(int[] tab) {
             boolean ordonne = true;
            
            for (int i=0;i<tab.length;i++) {
                 if(tab[i+1] <tab[i]) {
                     ordonne = false;
                     break;
                 }
                 i++;
                 System.out.println("itération :"+i);
             }
             return ordonne;
     }
            public static int[] tritableau(int[]tab){
                int[]tabEnt = tab;
                
                 //new int[tab.length];
                //int [] tabEnt1 = tab;
                for(int i=tab.length-1,j=0 ; i>=0 ; i--,j++) {
                //for (int i=0; i<tab.length-1;i++){
                   tabEnt [j] = tab[i];
                 
                }
                
                return tabEnt;
            }
            
            public static int[] triTableau(int[] tab){
                int [] tabEnt = tab;
                int j, valInserer;
                for (int i=0; i<tab.length-1;i++){
                    valInserer = tabEnt[i];
                    j=i-1;
                    
                    while(j>=0 &&valInserer <tabEnt [j]){
                        tabEnt [j+i]=tab[j];
                        j=j-1;
                    }
                    tabEnt[j+1] = valInserer;
                }
                
                
                return tabEnt;
            }
            */
            // tableau à deux dim
            // 1 declaration à deux dim
            int [][] tabEnt;
            // 2 création du tableau
            tabEnt = new int [4] [4];
            // 3 initialisation à déclaration
            int [][] tab = { { 0,1,2},
                {4,5,6,7},
                {8,9,10,11}
            };
            System.out.println ("la taille du tabEnt est"+ tabEnt[0].length);
            System.out.println ("la taille du tab est"+ tab[0].length);
            
            
            // parcours d'un tableau à deux dimensions avec le for
            int k=0;
            for(int i=0; i<tabEnt.length; i++){
                for(int j=0;j<tabEnt[i].length;j++,k++){
                    tabEnt [i] [j] = k;
                }
            }
            // parcours d'un tableau avec une boucle forEach
            for(int[] sousTab : tabEnt) {
                for(int val : sousTab) {
                    System.out.println(" | "+val);
                }
                System.out.println("");
            }
    }
}
