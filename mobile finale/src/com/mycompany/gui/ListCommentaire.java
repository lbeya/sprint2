package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
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

public class ListCommentaire extends Form {

    Form current;
    Form listeForm;
    
    public ListCommentaire(Resources res) {
       
         listeForm = new Form("ListCommentaire", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setScrollableY(true);
         getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("ListCommentaire", "Title")
                )
        );
       setInlineStylesTheme(res);
       setInlineAllStyles("font:50px; bgColor:6ee1f6;");
       
      
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("container");
        getContentPane().setScrollVisible(false);
   
        ArrayList<Commentaire> list = ServiceCommentaire.getInstance().afficherAllCommentaire();
        System.out.println("++++++++++"+list);
    // Create a new container to hold the commentaires

for (Commentaire commentaire : list) {
    if (commentaire != null) {
        Container box = new Container(BoxLayout.x());
        Container c = new Container(BoxLayout.x());
        Container ca1 = new Container(BoxLayout.y());
        Container ca2 = new Container(BoxLayout.y());
        Button c1 = new Button(res.getImage("com.jpg"));
        Button c2 = new Button();
        c2.setText("Update");
        Label l = new Label("Commentaire : " + commentaire.getCommentaire());
        c.add(c1);
        ca1.add(l);
        ca2.add(c2);
        box.add(c);
        box.add(ca1);
        box.add(ca2);
        c2.addPointerPressedListener((ActionListener) (ActionEvent evt) -> {
             
                   new CommentaireEdit(res, commentaire.getId()).show();
            
            });
         l.addPointerPressedListener((ActionListener) (ActionEvent evt) -> {
             
                   new CommentaireDetails(res, commentaire.getId()).show();
            
            });
        current.add(box);
    }
}


        
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        FloatingActionButton fa = FloatingActionButton.createFAB(FontImage.MATERIAL_NEAR_ME);
        RoundBorder rb0 = (RoundBorder) fa.getUnselectedStyle().getBorder();
        RoundBorder rb = (RoundBorder) fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        rb0.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fa.bindFabToContainer(getContentPane());
         fa.addActionListener(e -> {
            new MapForm();
        });
        fab.addActionListener(e -> {
            new CommentaireGui().show();
        });
    }

    ListCommentaire() {
          this(com.codename1.ui.util.Resources.getGlobalResources());
    }
}
