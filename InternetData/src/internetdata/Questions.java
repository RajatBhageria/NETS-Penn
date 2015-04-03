/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
                if (producer.equals("Disney")){
                    if (td.text().equals(producer) || 
                        td.text().equals("Disney, Pixar")){
                    q1.add(td.previousElementSibling().text());
                }
                else{
                    if (td.text().equals(producer)){
                        q1.add(td.previousElementSibling().text());

                    }
                }
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
     * @param numberOfAwards. The minimum number of Best Director Awards
     * that a director needs to win to be returned by this algorithm. 
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
                int number = Integer.parseInt(
                        person.substring(openParen+1, closeParen));
                
                String href = li.child(0).attr("href");
                String actorName = li.child(0).attr("title");
                Document actorPage = null;

                if (number >= numberOfAwards){
                    q5.add("\n");
                    q5.add(actorName);
                    q5.add("Number of Awards: " + number);
                    q5.add("Movies: ");
                }
            }
        }
        ArrayList<String> moviesDirectors = new ArrayList<>();
        for (Element tr: question5.getElementsByTag("tr")){            
            if (tr.text().contains(" – ") && !tr.text().startsWith("4")){
               for (Element a: tr.getElementsByTag("a")){
                   if (!a.text().startsWith("19") && !a.text().startsWith("20"))
                    moviesDirectors.add(a.text());
               }
            }
        }

        for (int i = 1; i < moviesDirectors.size()-1;i++){
                if (q5.contains(moviesDirectors.get(i))){
                    int index = q5.indexOf(moviesDirectors.get(i));
                    q5.add(index+3,moviesDirectors.get(i+1));
                    i++;
                }
                
        }
        return q5;
    }
    
    /**
     * Question 6
     * @return An arrayList of all the movies with the country with most movies
     */
    public ArrayList<String> question6(){
        Document question6 = null;
        try {
             question6 = Jsoup.connect("http://en.wikipedia.org/wiki/"
                     + "List_of_Academy_Award_winners_and_nominees_for_"
                     + "Best_Foreign_Language_Film").get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HashMap<String,HashSet<String>> q6 = new HashMap<>();
        for (Element tr: question6.getElementsByTag("tr")){
            
            if ((tr.child(0).text().startsWith("19") 
                    || tr.child(0).text().startsWith("20")) ){
                String name = "";
                String country = "";
                try{
                    name = tr.child(1).text();
                    country = tr.child(3).text();
                } catch(Exception e){
                    
                }
                if (!q6.containsKey(country)){
                    HashSet<String> movies = new HashSet<>();
                    movies.add(name);
                    q6.put(country,  movies);
                }
                else{
                    HashSet<String> movies = q6.get(country);
                    movies.add(name);
                    q6.put(country, movies);
                }
            }
        }
        int size = 0;
        ArrayList<String> output = new ArrayList<>();
        for (String key:q6.keySet()){
            if (q6.get(key).size()>size){
                size =q6.get(key).size();
                output.clear(); //Empty the ArrayList  
                output.add("Country: " + key + "\n");
                output.add("Movies:");
                for (String element: q6.get(key)){
                    output.add(element);
                }
            }
        }
        return output;  
    }
    
   /**
     * Question 7
     * @param actor: A string of the actor who needs to have starred in a 
     * particular movie to return it.
     * @param typeOfAward: A string of the type of award (e.g., 
     * "Best Animated Feature")
     * @return An HashSet of all the movies that meet the requirements
     */
    public HashSet<String> question7(String actor, String typeOfAward){
        Document question5 = null;
        try {
             question5 = Jsoup.connect("http://en.wikipedia.org/wiki/"
                     + "Academy_Award_for_Best_Animated_Feature").get();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
        HashSet<String> output = new HashSet<>();
        for (Element tr: question5.getElementsByTag("tr")){            
            if (tr.text().contains(" – ")){
               for (Element a: tr.getElementsByTag("a")){
                   if (!a.text().startsWith("20") && !a.text().startsWith("[")){
                       String href = a.getElementsByAttribute("href").text();
                       Document temp= null;
                       try {
                            temp = Jsoup.connect("http://en.wikipedia.org/wiki/"
                                    + href).get();
                       } catch (IOException ex) {
                           ex.printStackTrace();
                       } 

                       for (Element newTr: temp.getElementsByTag("tr")){
                           if (newTr.text().startsWith("Starring")){
                               //System.out.println( newTr.text());
                               if (newTr.text().contains(actor)){
                                   output.add(a.text());
                               }
                           }
                       }
                       
                   }
               }
            }
        }
        return output;
        
    }
    
       
    public ArrayList<String> question8(){
        ArrayList<String> q8 = new ArrayList<>();
        int year = 1981;
            q8.add("Averge Age: "+ helperQuestion8(year));
       
        return q8;
    }
    
   /**
     * Question 8
     * @param year that the user wants the answer to be about
     * @return ArrayList of the actress's name, 
     * her age at the time, and the movie she acted in
     */
    private int helperQuestion8(int year ){
        Document question8 = null;
        ArrayList<Integer> temp = new ArrayList<>();

        try {
             question8 = Jsoup.connect("http://en.wikipedia.org/wiki/"
                     + "Academy_Award_for_Best_Actor").get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            for (Element tr: question8.getElementsByTag("tr")){
            if (tr.child(0).text().startsWith(year + "")){
                Element actor = tr; 
                int  next = 1 + year;
                String nextYear = next+ "";
                System.out.println(nextYear);
                while (!actor.nextElementSibling().text().
                        startsWith(nextYear) ){
                    actor = actor.nextElementSibling();                    
                    
                    //Finding the age'
                    String href="";
                    try{
                         href = actor.child(0).child(0).attr("href");
                    }
                    catch (Exception e){
                    }
                    Document ageDoc = null;
                    try {
                        ageDoc = Jsoup.connect(
                                "https://en.wikipedia.org"+href).get();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    String bday = "";
                    int ageAtCeremony =0;
                    for (Element l: ageDoc.getElementsByClass("bday")){
                        bday = l.text();
                        Integer birthYearInt = 
                            Integer.parseInt(bday.substring(0,4));
                        ageAtCeremony = year - birthYearInt;
                    }
 
                    
                    //Adding everything to the ArrayList to be returned
                    temp.add(ageAtCeremony);
                }   
            }
        }
        int sum = 0;
        int ave =0;
        for (int e: temp){
            sum +=e;
        }
        ave = sum / temp.size();
        return ave;
    }
 
    
}

