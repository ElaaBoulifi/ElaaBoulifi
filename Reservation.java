/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Reservation {
    private int id_reservation ;
    private int hebergement;
    private int heure;
    private String nom;
    private String date;


    public Reservation(int id_reservation, int hebergement, int heure) {
        this.id_reservation = id_reservation;
        this.hebergement = hebergement;
        this.heure = heure;
    }

    public Reservation(int id_reservation, int hebergement, int heure, String nom) {
        this.id_reservation = id_reservation;
        this.hebergement = hebergement;
        this.heure = heure;
        this.nom = nom;
    }

    public Reservation(int hebergement, int heure, String nom) {
        this.hebergement = hebergement;
        this.heure = heure;
        this.nom = nom;
    }

    public Reservation(int id_reservation, int hebergement, int heure, String nom, String date) {
        this.id_reservation = id_reservation;
        this.hebergement = hebergement;
        this.heure = heure;
        this.nom = nom;
        this.date = date;
    }

    public Reservation(int hebergement, int heure, String nom, String date) {
        this.hebergement = hebergement;
        this.heure = heure;
        this.nom = nom;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    

    public Reservation(int hebergement, int heure) {
        this.hebergement = hebergement;
        this.heure = heure;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int gethebergement() {
        return hebergement;
    }

    public void sethebergement(int hebergement) {
        this.hebergement = hebergement;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", hebergement=" + hebergement + ", heure=" + heure + '}';
    }
    
}
