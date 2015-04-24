/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Handler;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Entity.*;

/**
 *
 * @author FATHALLAH Wael
 */
public class OffreHandler extends DefaultHandler{
    
    private Vector offres;
     String     idTag="close";
     String     id_gerantTag="close";
     String     id_adresseTag="close";
     String  etatTag="close";
     String  typeImmobTag="close";
     String  natureTag="close";
     String  payementTag="close";
     String    surfaceTag="close";
     String     nbrPieceTag="close";
     String  datePublicationTag="close";
     String  dateModificationTag="close";
     String  dispobileAPartirTag="close";
     String  descriptionTag="close";
     String     etageTag="close";
     String ascenceurTag="close";
     String cuisineEquipeTag="close";
     String jardinTag="close";
     String entreeIndepTag="close";
     String gazDeVilleTag="close";
     String chauffageTag="close";
     String meubleTag="close";
     String climatisationTag="close";
     String   noteTag="close";
     String  urlImageTag="close";
     String  positionTag="close";
     
     StringBuffer strB=new StringBuffer(1024);
     
     public OffreHandler(){
         offres=new Vector();
     }
      
     public Offre[] getOffres(){
         Offre[] offress = new Offre[offres.size()];
        offres.copyInto(offress);
        return offress;
     }
      // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Offre currentOffre;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        strB.setLength(0);
        System.out.println("Start Element :" + qName);
        if (qName.equals("entry")) {
            currentOffre = new Offre();
            //2ème methode pour parser les attributs
          
           
            /****/
            
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("id_gerant")) {
            id_gerantTag = "open";
        } 
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("entry")) {
            // we are no longer processing a <reg.../> tag
            offres.addElement(currentOffre);
            currentOffre = null;
        } else if (qName.equals("id")) {
            String id=strB.toString();
            currentOffre.setId(Integer.parseInt(id));
            
        } else if (qName.equals("id_gerant")) {  
            String id_gerant=strB.toString();
            currentOffre.setId_gerant(Integer.parseInt(id_gerant));
        } 
         else if (qName.equals("typeimmob")) {  
            String typeimmob=strB.toString();
            currentOffre.setTypeImmob(typeimmob);
        } 
         else if (qName.equals("nature")) {  
            String nature=strB.toString();
            currentOffre.setNature(nature);
        } 
        else if (qName.equals("etat")) {  
            String etat=strB.toString();
            currentOffre.setEtat(etat);
        } 
         else if (qName.equals("payement")) {  
            String payement=strB.toString();
            currentOffre.setPayement(payement);
        } 
         else if (qName.equals("surface")) {  
            String surface=strB.toString();
            currentOffre.setSurface(Integer.parseInt(surface));
        } 
         else if (qName.equals("nbrpiece")) {  
            String nbrpiece=strB.toString();
            currentOffre.setNbrPiece(Integer.parseInt(nbrpiece));
        } 
         else if (qName.equals("nbrpiece")) {  
            String nbrpiece=strB.toString();
            currentOffre.setNbrPiece(Integer.parseInt(nbrpiece));
         }
         else if (qName.equals("urlimage")) {  
            String urlImage=strB.toString();
            currentOffre.setUrlImage(urlImage);
         }
        else if (qName.equals("description")) {  
            String description=strB.toString();
            currentOffre.setDescription(description);
         }
        
        
        
       
    }
    // "characters" are the text between tags
     public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        
        if (currentOffre != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                strB.append(ch, start, length);
               
            } else
                if (id_gerantTag.equals("open")) {
                     strB.append(ch, start, length);
              
            } 
            else
                if (typeImmobTag.equals("open")) {
                     strB.append(ch, start, length); 
            } 
            else
                if (natureTag.equals("open")) {
                     strB.append(ch, start, length);  
            } 
       
             else
                if (etatTag.equals("open")) {
                     strB.append(ch, start, length);  
            } 
            else
                if (payementTag.equals("open")) {
                     strB.append(ch, start, length);  
            } 
            else
                if (surfaceTag.equals("open")) {
                     strB.append(ch, start, length);  
            } 
                else 
                    if(urlImageTag.equals("open")){
                        strB.append(ch,start,length);
                    }
             else 
                    if(descriptionTag.equals("open")){
                        strB.append(ch,start,length);
                    }
            
            
        }
    }
    
}
