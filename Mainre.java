/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation;

import ENTITIES.Reclamation;
import Service.Service_feedback;
import Service.Service_reservation;
import entities.Feedback;
import entities.Reservation;
import java.sql.SQLException;
import service.Service_reclamation;

/**
 *
 * @author ASUS
 */
public class Mainre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
       Service_reclamation r = new Service_reclamation();
       Reclamation reclamation = new Reclamation("typr","bbal","ggg","dddd","bon","ddddd");
      /*Reclamation reclamation = new Reclamation(231,"produit","ff","aaaaaaa","ffffffff","bon etat","ff","fffff");*/
      // r.ajouter(reclamation);
      //r.supprimer(337);
    //  System.out.println(r.afficher());
      reclamation.setType("dddd");
      reclamation.setDescription("sss");
      reclamation.setDate("2020-02-02");
      reclamation.setSujet("ddd");
      reclamation.setEtat("owah");
      reclamation.setId(339);
        // r.modifier(reclamation);
        //r.recherche();*
        Feedback v= new Feedback("ffff", 0, "dd");
        Service_feedback sf = new Service_feedback();
       // sf.ajouter(v);
        //sf.deletefeedback(2);
        // sf.supprimerr(3);
        v.setDate("2022-02-16");
        v.setDescription("ssss");
        v.setRate(7);
        v.setUser("sss");
        v.setId(7);
        //  sf.modifier(v);
        //  System.err.println(sf.afficher()); 
        Service_reservation srr = new Service_reservation();
        Reservation rv =new Reservation(1,1,"mmmm","2020-02-02") ;
        srr.Ajouter(rv);
        //srr.deleteReservation(1);
       rv.sethebergement(0);
       rv.setHeure(0);
       rv.setNom("ff");
       rv.setDate("2020-01-01");
       rv.setId_reservation(3);
        srr.Modifier(rv);
         System.err.println(srr.Afficher()); 
        
    }

    
    
}
