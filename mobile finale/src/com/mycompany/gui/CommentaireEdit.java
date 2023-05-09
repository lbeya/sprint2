/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Commentaire;
import com.mycompany.services.ServiceCommentaire;

/**
 *
 * @author 21693
 */
public class CommentaireEdit  extends Form{ 
    Form current;

    public CommentaireEdit(Resources res, int id) {
        Toolbar tb = new Toolbar(true);
        setScrollableY(true);
        getToolbar().setTitleComponent(
                FlowLayout
                        .encloseCenterMiddle(
                                new Label("Edit Commentaire", "Title")
                        )
        );
     
        
        Button modiff = new Button("Modifier");
        modiff.setInlineStylesTheme(res);
      modiff.setInlineAllStyles("bgColor:2930f0; fgColor:fffffe; transparency:255;");
       Commentaire CommentaireDetail = ServiceCommentaire.getInstance().affichageCommentaireBYID(id);

        TextField Com = new TextField(CommentaireDetail.getCommentaire(), "Commentaire", 20, TextField.EMAILADDR);
        Com.setUIID("TextFieldBlack");
       addStringValue("Commentaire", Com);
        
        

        modiff.setUIID("Edit");
        addStringValue("",modiff);
        
        modiff.addActionListener((ActionEvent edit)->{
        InfiniteProgress ip = new InfiniteProgress();
        final Dialog iD = ip.showInfiniteBlocking();
  
         ServiceCommentaire.EditCommentaire(id,Com.getText());
        CommentaireDetail.setCommentaire(Com.getText());
        
        Dialog.show("Succes","Modifications des coordonnees avec succes","OK",null);
        iD.dispose();
        refreshTheme();
        new ListCommentaire().show();
         
    });
        
  
    }
        private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
      
    }
}
