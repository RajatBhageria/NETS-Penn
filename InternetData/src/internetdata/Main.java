/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetdata;

/**
 *
 * @author RajatBhageria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
        System.out.println("Question 2: List all actors nominated for a Best "
                + "Leading Actor award whose role was playing a King:");
        for (String e: q.question3()){
            System.out.println(e);
        }
        System.out.println("\n");
        
    }
}