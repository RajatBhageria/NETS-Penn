/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetdata;

import java.io.IOException;
import java.util.ArrayList;
import javax.lang.model.util.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author RajatBhageria
 */
public class Questions {
    
    /**
     * Question 1
     * @param The producer that the user wants to use
     * @return An arrayList of all the movies that were nominated by the
     * particular producer. 
     */
    public ArrayList<String> question1(String producer){
                Document question1 = null;
        try {
             question1 = Jsoup.connect("http://en.wikipedia.org/wiki/"
                     + "Academy_Award_for_Best_Picture").get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ArrayList<String> q1 = new ArrayList<String>();
            for (Element td: question1.getElementsByTag("td")){
                if (td.text().equals(producer)){
                    q1.add(td.previousElementSibling().text());
                }
            }
        return q1;
    }
    
    
    /**
     * Question 2
     * @param The movie that the user wants to use
     * @return An arrayList of all the writers of that movie
     */
    public ArrayList<String> question2(String movie){
        Document question2 = null;
        try {
             question2 = Jsoup.connect("http://en.wikipedia.org/wiki/"
                     + "Academy_Award_for_Best_Original_Screenplay").get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ArrayList<String> q2 = new ArrayList<String>();
        for (Element td: question2.getElementsByTag("td")){
            if(td.text().equals(movie)){
                Element allWriters = td.nextElementSibling();
                for (Element e: allWriters.getElementsByTag("a")){
                    q2.add(e.text());
                }
            }
        }
        return q2;
    }
    
     /**
     * Question 3
     * @param The movie that the user wants to use
     * @return An arrayList of all the writers of that movie
     */
    public ArrayList<String> question3(){
        Document question3 = null;
        try {
             question3 = Jsoup.connect("http://en.wikipedia.org/wiki/"
                     + "Academy_Award_for_Best_Actor").get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ArrayList<String> q2 = new ArrayList<String>();
        for (Element tr: question3.getElementsByTag("tr")){
            if (tr.lastElementSibling().previousElementSibling().text().contains("King")){
                q2.add(tr.firstElementSibling().nextElementSibling().text());
            }
        }
        return q2;
    }
}
