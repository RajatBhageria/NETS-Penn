/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author RajatBhageria
 */

public class Questions {
    
    private Document doc;
    private Element link;

    public Questions() throws IOException {
        doc = Jsoup.connect("http://en.wikipedia.org/wiki/"
                + "Portal:Academy_Award").get();
        link = doc.select("a").first();
    }


    /**
     * Question 1
     * @param producer The producer that the user wants to use
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
     * @param movie: The movie that the user wants to use
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
     * @param role: The role that you want to check. Initially "King"
     * @return An HashSet of all the movies in which someone plays king
     */
    public HashSet<String> question3(String role){
        Document question3 = null;
        try {
             question3 = Jsoup.connect("http://en.wikipedia.org/wiki/"
                     + "Academy_Award_for_Best_Actor").get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HashSet<String> q3 = new HashSet<String>();
        for (Element td: question3.getElementsByTag("td")){
            if (td.text().startsWith(role)){
                q3.add(td.previousElementSibling().
                        previousElementSibling().text());
            }
        } 
        
        return q3;
    }
    
    /**
     * Question 4
     * @param year that the user wants the answer to be about
     * @return ArrayList of the actress's name, 
     * her age at the time, and the movie she acted in
     */
    public ArrayList<String> question4(int year){
        Document question4 = null;
        try {
             question4 = Jsoup.connect("http://en.wikipedia.org/wiki/"
                     + "Academy_Award_for_Best_Actress").get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ArrayList<String> q4 = new ArrayList<String>();
        for (Element tr: question4.getElementsByTag("tr")){
            if (tr.child(0).text().startsWith(year + "")){
                Element actress = tr; 
                String nextYear = 1 + year + "";
                while (!actress.nextElementSibling().text().
                        startsWith(nextYear) ){
                    actress = actress.nextElementSibling();
                    String name = actress.child(0).text();
                    String film = actress.child(1).text();
                    
                    
                    //Finding the age
                    String href = actress.child(0).child(0).attr("href");
                    Document ageDoc = null;
                    try {
                        ageDoc = Jsoup.connect(
                                "https://en.wikipedia.org"+href).get();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    String bday = "";
                    for (Element l: ageDoc.getElementsByClass("bday")){
                        bday = l.text();
                    }
                    Integer birthYearInt = 
                            Integer.parseInt(bday.substring(0,4));
                    int ageAtCeremony = year - birthYearInt;
                    
                    //Adding everything to the ArrayList to be returned
                    q4.add("Actress: " + name );
                    q4.add("Film: " + film);
                    q4.add("Age: " + ageAtCeremony);
                }
            }   
        } 
        return q4;
    }
    
    /**
     * Question 5
     * @return An arrayList of all the directors 
     */
    public ArrayList<String> question5(int numberOfAwards){
        Document question5 = null;
        try {
             question5 = Jsoup.connect("http://en.wikipedia.org/wiki/"
                     + "Academy_Award_for_Best_Directing").get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ArrayList<String> q5 = new ArrayList<String>();
        for (Element li: question5.getElementsByTag("li")){
            String person = li.text();
            if (person.endsWith(")") && person.contains("–")){
                int openParen = person.indexOf("(");
                int closeParen = person.indexOf(")");
                int number = Integer.parseInt(person.substring(openParen+1, closeParen));
                
                String href = li.child(0).attr("href");
                String actorName = li.child(0).attr("title");
                Document actorPage = null;

                if (number >= numberOfAwards){
                    q5.add("Actor Name: " + actorName);
                    q5.add("Number of Awards: " + number);
                    q5.add("Movies: ");
                    try {
                    actorPage = Jsoup.connect(
                            "https://en.wikipedia.org"+href).get();
                    }   catch (IOException ex) {
                        ex.printStackTrace();
                    } 
                    for (Element e: actorPage.getElementsByTag("td")){
                        if (e.text().equals("Best Director")){
                            Elements all = e.siblingElements();
                            if (all.get(0).text().startsWith("1")||all.get(0).text().startsWith("2")){
                                String movie = all.get(1).text();
                                q5.add(movie);
                            }
                        }
                    }
                }     
                    
            }
        }
        return q5;
    }
}

