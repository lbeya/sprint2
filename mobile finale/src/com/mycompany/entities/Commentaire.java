/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author 21693
 */
public class Commentaire {
    private int id;
    private String dateComm ; 
    private String commentaire ;

    public Commentaire(int id, String dateComm, String commentaire) {
        this.id = id;
        this.dateComm = dateComm;
        this.commentaire = commentaire;
    }

    public Commentaire(String dateComm, String commentaire) {
        this.dateComm = dateComm;
        this.commentaire = commentaire;
    }

    public Commentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Commentaire() {
       
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateComm() {
        return dateComm;
    }

    public void setDateComm(String dateComm) {
        this.dateComm = dateComm;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
    
}
