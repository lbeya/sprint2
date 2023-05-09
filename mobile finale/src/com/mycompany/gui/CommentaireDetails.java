/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Commentaire;
import com.mycompany.services.ServiceCommentaire;
import java.util.ArrayList;

/**
 *
 * @author 21693
 */
public class CommentaireDetails extends Form {
  Form current;
    Form listeForm;
    private MultiButton gui_Multi_Button_1;
    private com.codename1.components.MultiButton gui_LA;

    public CommentaireDetails(Resources res, int id) {
        listeForm = new Form("commentaireListe", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setScrollableY(true);
    
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Commentaire Details", "Title")
                )
        );

       setInlineStylesTheme(res);
       setInlineAllStyles("font:50px; bgColor:6ee1f6;");
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("container");
        getContentPane().setScrollVisible(false);
        Commentaire CommentaireDetail = ServiceCommentaire.getInstance().affichageCommentaireBYID(id);

       
        Label L1 = new Label(CommentaireDetail.getCommentaire());
        Container box = new Container(BoxLayout.y());
        Container c = new Container(BoxLayout.x());
        Container ComContainer = new Container(BoxLayout.x());
        Container ca1 = new Container(BoxLayout.y());
        Button c1 = new Button(res.getImage("com.jpg"));
        Label l = new Label(CommentaireDetail.getCommentaire());
     System.out.println("commentaire detailer " + id );

        c.add(c1);
        ca1.add(l);
    

        box.add(c);
        box.add(ca1);

        Label lRecentSub = new Label("Recent Commentaire");

        box.add(lRecentSub);

      
        current.add(box);
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_DELETE_OUTLINE);
        RoundBorder rb = (RoundBorder) fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            ServiceCommentaire.getInstance().deleteCommentaire(id);
            new ListCommentaire(res).show();
               
        });


    }

}