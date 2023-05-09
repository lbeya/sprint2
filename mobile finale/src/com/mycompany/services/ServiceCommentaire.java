/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Commentaire;
import com.mycompany.utils.Statics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 21693
 */
public class ServiceCommentaire {
     public static ServiceCommentaire instance = null;

    private ConnectionRequest req;
    public static boolean resultOk = true;
    public ServiceCommentaire() {
        req = new ConnectionRequest();

    }
      public static ServiceCommentaire getInstance() {
        if (instance == null) {
            instance = new ServiceCommentaire();
        }
        return instance;
    }
      public void addCommentaire(Commentaire com) {
          //sendMail();
          //sendSMS();
        String url = Statics.BASE_URL + "commentaire/addjson"
                + "?commentaire=" + com.getCommentaire();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data ==" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
}
      
          
      public void sendMail() {
        String url = Statics.BASE_URL + "commentaire/SendMail";
                
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data ==" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
}
      
                
      public void sendSMS() {
        String url = Statics.BASE_URL + "commentaire/SendSMS";
                
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data ==" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
}


    /**
     *
     * @return
     */
    public ArrayList <Commentaire> afficherAllCommentaire() {
        ArrayList <Commentaire> result = new ArrayList<>();
        req.setUrl(Statics.BASE_URL + "commentaire/liste");
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();

                try {
                    Map<String, Object> mapCommentaire = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));

                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapCommentaire.get("root");
                    System.out.println(listOfMaps);
                    for (Map<String, Object> obj : listOfMaps) {
                        if (obj != null) {
                            Commentaire commL = new Commentaire();
                            System.out.println("++++++++++"+commL);
                            float id = Float.parseFloat(obj.get("id").toString());
                            
                            commL.setCommentaire(obj.get("commentaire").toString());
                            // commL.setDateComm(obj.get("dateComm").toString());
                    
                            commL.setId((int) id);
                            System.out.println(commL);
                            result.add(commL);
                        }
                      

                    }

                } catch (Exception ex) {

                    ex.printStackTrace();
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    }

    public Commentaire affichageCommentaireBYID(int id) {
        Commentaire result = new Commentaire();
        req.setUrl(Statics.BASE_URL + "commentaire/details" + "?id=" + id);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();

                try {

                    Map<String, Object> mapCommentaire = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    System.out.println("mapCommentaire :" + mapCommentaire);
                    result.setCommentaire(mapCommentaire.get("commentaire").toString());
                    result.setDateComm(mapCommentaire.get("dateComm").toString());

                    result.setId((int) id);

                } catch (Exception ex) {

                    ex.printStackTrace();
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
        //NetworkManager.getInstance().addToQueueAndWait(req);

    }
    public static void EditCommentaire(int id,String commentaire) {
        String url = Statics.BASE_URL+"commentaire/editCommentaire?id="+id+"&commentaire="+commentaire;
        MultipartRequest req = new MultipartRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("commentaire",commentaire);
        System.out.println("zaza"+commentaire);
              System.out.println(url);
        req.addResponseListener((response)-> {
            
            byte[] data = (byte[]) response.getMetaData();
            String s = new String(data);
            System.out.println(s);
             System.out.println("editeditedit");
            //if(s.equals("success")){}
            //else {
                //Dialog.show("Erreur","Echec de modification", "Ok", null);
            //}
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    public void deleteCommentaire(int id ){
        String url = Statics.BASE_URL +"commentaire/deleteCommentaire?id="+id;
       
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data ==" + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
         
    }
    
}
