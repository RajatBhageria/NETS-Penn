/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetdata;

import java.io.IOException;

/**
 *
 * @author RajatBhageria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Questions q = new Questions();

        //Question 1
        String producer = "Disney"; //This is the producer being used
        System.out.println("Question 1: " + "List all movies nominated "
                + "for the Best Picture award for which one of the "
                + "Production Companies was :" + producer);
        
        for (String e: q.question1(producer)){
            System.out.println(e);
        }
        System.out.println("\n");
        
      
        //Question 2
        String movie = "Divorce, Italian Style"; //This is the movie used
        System.out.println("Question 2: For the Best Original Screenplay "
                + "award, list the writers for the movie that was nominated/won"
                + " titled " + movie);
        for (String e: q.question2(movie)){
            System.out.println(e);
        }
        System.out.println("\n");
        
       
        //Question 3
        String role = "King"; //This is the role used
        System.out.println("Question 3: List all actors nominated for a Best "
                + "Leading Actor award whose role was playing a " + role + ":");
        for (String e: q.question3(role)){
            System.out.println(e);
        }
        System.out.println("\n");
        
        
        //Question 4
        int year = 2006; //This is the year used 
        System.out.println("Question 4: For the year " + year + ", list all actresses "
               + "nominated for a Best Leading Actress award along with the\n"
               + "movie and their age that year.");
        for (String e: q.question4(year)){
            System.out.println(e);
        }
        System.out.println("\n");
        
        
        //Question 5
        int numberOfAwards = 4; 
        System.out.println("Question 5: List all directors"
                + " (with the corresponding movies) that have been nominated "
                + "for at least 4 Best Director awards.");
        for (String e: q.question5(numberOfAwards)){
            System.out.println(e);
        }
        System.out.println("\n");

        
        //Question 6
        System.out.println("Question 6: List the country "
                + "(with the corresponding movies) that has been nominated "
                + "the most number of times for "
                + "Best Foreign Language Film award.");
        q.question6();
        for (String e: q.question6()){
            System.out.println(e);
        }
        System.out.println("\n");
    
        //Question 7
        String actor = "Tom Hanks"; //This is the Actor used
        String typeOfAward = "Best Animated Feature";
        System.out.println("Question 7: List all movies nominated for "
                + typeOfAward + " award that starred " + actor);
        for (String e: q.question7(actor, typeOfAward)){
            System.out.println(e);
        }
        System.out.println("\n");
        
        
        //Question 8
        System.out.println("Question 8: List the budgets of"
                + " each of the best director nominatd films"
                + " (in chronological order) ");
        for (String e: q.question8()){
            System.out.println(e);
        }
        System.out.println("\n");
        
        
        
        //EC: Wildcard
        int yearEC = 1936; //This is the year being used
        System.out.println("EC: Wildcard:"
                + "The average age of all the actors nominated for the "
                + "Best Leading Actor in "+ year + " is: " 
                + q.wildcard(yearEC) + " Years");
        System.out.println("\n");


        
    }
}