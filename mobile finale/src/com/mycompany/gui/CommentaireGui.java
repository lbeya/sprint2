/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Commentaire;
import com.mycompany.services.ServiceCommentaire;

/**
 * GUI builder created Form
 *
 * @author 21693
 */
public class CommentaireGui extends com.codename1.ui.Form {

    public CommentaireGui() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
  
    public CommentaireGui(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.TextField gui_Text_Field = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button.addActionListener(callback);
        gui_Button_1.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button) {
                onButtonActionEvent(ev);
            }
            if(sourceComponent == gui_Button_1) {
                onButton_1ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollVisible(true);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:6ee1f6; bgType:image_aligned_top_left; bgImage:commentaire-1.png; alignment:left;");
        setTitle("");
        setName("CommentaireGui");
        gui_Text_Field.setPreferredSizeStr("inherit 28.571428mm");
                gui_Text_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field.setName("Text_Field");
        gui_Button.setPreferredSizeStr("29.89418mm inherit");
        gui_Button.setText("Add");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setInlineAllStyles("bgColor:2930f0; fgColor:fffffe; transparency:255;");
        gui_Button.setName("Button");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button,"\ue0c9".charAt(0));
        gui_Button_1.setPreferredSizeStr("21.16402mm inherit");
        gui_Button_1.setText("Back");
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setInlineAllStyles("bgColor:dd1201; fgColor:fffffe; transparency:255;");
        gui_Button_1.setName("Button_1");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_1,"\ue5c4".charAt(0));
        addComponent(gui_Text_Field);
        addComponent(gui_Button);
        addComponent(gui_Button_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Text_Field.getParent().getLayout()).setInsets(gui_Text_Field, "23.343372% 29.72259% 59.18675% auto").setReferenceComponents(gui_Text_Field, "-1 -1 -1 -1").setReferencePositions(gui_Text_Field, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "0.0mm 1.5873022mm auto auto").setReferenceComponents(gui_Button, "0 0 -1 -1").setReferencePositions(gui_Button, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_1.getParent().getLayout()).setInsets(gui_Button_1, "0.0mm auto auto 2.645502mm").setReferenceComponents(gui_Button_1, "0 -1 1 0 ").setReferencePositions(gui_Button_1, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
            try {
                if (gui_Text_Field.getText() == "") {
                    Dialog.show("plz add ", "", "annuler", "ok");
                } else {
                    ;
                    InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iD = ip.showInfiniteBlocking();
                    Commentaire comm = new Commentaire(String.valueOf(gui_Text_Field.getText()));
                    System.out.println(gui_Text_Field.getText());
                    System.out.println("data is " + comm);
                    ServiceCommentaire.getInstance().addCommentaire(comm);
                    iD.dispose();
                    refreshTheme();
                    new ListCommentaire().show();
                  
                    
              
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

       
    }

    public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new ListCommentaire().show();
    }

}
