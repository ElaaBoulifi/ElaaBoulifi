/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import static com.oracle.nio.BufferSecrets.instance;
import ENTITIES.Reclamation; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.Debug.id;
import util.DataSource;
/**
 *
 * @author USER
 */
public class Service_reclamation {
Connection cnx = DataSource.getInstance().getCnx();
 


    private Statement ste;
    private PreparedStatement pst;
 
    public void ajouter(Reclamation r) {
          try {
                       
            String req = "INSERT INTO reclamation (type, ido, sujet,"
                    + "description, date, etat, idU) values (?,?,?,?,?,?,?)";
            PreparedStatement pre = cnx.prepareStatement(req);
             
            pre.setString(1, r.getType());
            pre.setString(2, r.getIdo());
            pre.setString(3, r.getSujet());
            pre.setString(4, r.getDescription());
            pre.setString(5, r.getDate());
            pre.setString(6, r.getEtat());
            pre.setString(7, r.getUser());
            pre.executeUpdate();
            System.out.println("Reclamation Ajoutée !");
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }  
    
    }

     public void supprimerr(int id) {
 try {
            String req = "DELETE FROM reclamation WHERE id="+id+"";
            PreparedStatement pst = cnx.prepareStatement(req);
           
            pst.executeUpdate();
            System.out.println("reclamation Supprimée !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }   
    }
      
 
    public int getNbrReclamation() {
        String sql="SELECT COUNT(*) FROM reclamation";
        ResultSet rs;
        int countIdRec=0;
        try {
            PreparedStatement st= cnx.prepareStatement(sql);
			ResultSet res= st.executeQuery(); 
                        while(res.next()) {
                           countIdRec= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdRec;
    }
    
     
   
    public void supprimer(Reclamation r) {
 try {
            String req = "DELETE FROM reclamation WHERE id="+r.getId();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, r.getId());
            pst.executeUpdate();
            System.out.println("reclamation Supprimée !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }   
    }

    public void supprimer(int id) {
 try {
            String req = "DELETE FROM reclamation WHERE id="+id+"";
            PreparedStatement pst = cnx.prepareStatement(req);
           
            pst.executeUpdate();
            System.out.println("reclamation Supprimée !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }  
    }
    public void modifier(Reclamation r) {
      try {
            String req = "UPDATE reclamation SET type=?, sujet=?, description=? , date=? , etat=?  WHERE `id`=?";
            PreparedStatement pre = cnx.prepareStatement(req);
            pre.setString(1, r.getType());
            pre.setString(2, r.getSujet());
            pre.setString(3, r.getDescription());
            pre.setString(4, r.getDate());
            pre.setString(5, r.getEtat());
            pre.setInt(6, r.getId());
             
            pre.executeUpdate();
            System.out.println("reclamation Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }   
    }
    public int updateEtat(Reclamation r) throws SQLException {

        String requestUpdate = "UPDATE reclamation SET etat`=?  WHERE id`=?";
        PreparedStatement pre = cnx.prepareStatement(requestUpdate);
        pre.setString(1, r.getEtat());
        pre.setInt(2, r.getId());
        System.out.println(r);
        return pre.executeUpdate();
    }
        public int updateDescription(Reclamation r) throws SQLException {

        String requestUpdate = "UPDATE reclamation SET description`=?  WHERE id`=?";
        PreparedStatement pre = cnx.prepareStatement(requestUpdate);
        pre.setString(1, r.getDescription());
        pre.setInt(2, r.getId());
        System.out.println(r);
        return pre.executeUpdate();
    }

    public List<Reclamation> afficher() {
        List<Reclamation> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM reclamation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Reclamation(rs.getInt("id"), rs.getString("type"), rs.getString("ido"), rs.getString("sujet"),rs.getString("description"), rs.getString("date"), rs.getString("etat"), rs.getString("idU")));
                
            }
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return list;
   
    }
      public List<Reclamation> afficherdes() {
        List<Reclamation> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM reclamation order by id  desc";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Reclamation(rs.getInt("id"), rs.getString("type"), rs.getString("ido"), rs.getString("sujet"),rs.getString("description"), rs.getString("date"), rs.getString("etat"), rs.getString("idU")));
                
            }
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return list;
      } 
   
    public List<Reclamation> recherche(int id ) {
        List<Reclamation> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM reclamation where id="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Reclamation(rs.getInt("id"), rs.getString("type"), rs.getString("ido"), rs.getString("sujet"),rs.getString("description"), rs.getString("date"), rs.getString("etat"), rs.getString("idU")));
                
            }
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return list;
   
    }
    public int recherche(String id ) {
        List<Reclamation> listf = new ArrayList<>();
        try {
            String requete = "SELECT * FROM reclamation where id="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                listf.add(new Reclamation(rs.getString("idU")));
                
            }
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return 1;
    } 
   
    
}