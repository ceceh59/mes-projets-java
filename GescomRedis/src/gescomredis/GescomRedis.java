/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gescomredis;

import static java.lang.reflect.Array.set;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.Spliterators.iterator;
import static jdk.nashorn.internal.objects.NativeArray.map;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Administrateur
 */
public class GescomRedis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Jedis jedis = new Jedis("localhost");
        System.out.println("connexion ok"
                + " ");
    
  
        /****Manipulation des chaines************/
        jedis.set("prenom","Lisa");       
        String value  = jedis.get("prenom");       
        System.out.println("prenom = " + value);
        
        /***Manipulation des liste ************/
         //création et initialisation de la liste
        jedis.rpush("listeP","premier", "deuxième","troisième");
          //parcours de la liste
         
          List<String> valeurList = 
                  jedis.lrange("listeP", 0, -1);
          
          for(String val : valeurList){
              System.out.println(" val : " + val);
          }
    
          for(int i = 0;i<valeurList.size();i++){
              System.out.println( i + " : " + valeurList.get(i));
          }
        System.out.println(jedis.lrange("listeP", 0, -1));
        
        /*** Manipulation de hash set ****************/
        jedis.hset("categorie","idCat","1");
        jedis.hset("categorie", "libelle","DVD");         
        //parcours du hash set
        Map<String,String> map = jedis.hgetAll("categorie");
        
        Set listeKeys = map.keySet();
        Iterator iterator = listeKeys.iterator();
        while(iterator.hasNext()){
            Object key = iterator.next();
            System.out.println(key + " => " + map.get(key));
        }
        
        
        System.out.println("set " + jedis.hgetAll("categorie")); 
        
        
        /****Manipulation du type set*******************/
        //création des sets
        jedis.sadd("livre","Tintin","Durant","Milou");
        jedis.sadd("BD", "delise","mening","bart");
        //parcours des sets
        Set<String> valueLivre = jedis.smembers("livre");
        Iterator<String> itLivre = valueLivre.iterator();
        
        while(itLivre.hasNext()){
            String nom = itLivre.next();
            //affichage des valeurs
            System.out.println("value : " + nom);
        }
            //affichage de toutes les valeurs du set
        System.out.println("toutes les valeurs : " + jedis.smembers("livre"));
    }
    
}