import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */

/**
 * @author RajatBhageria
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String file= "src/facebook_combined.txt";
		try 
		{
		    BufferedReader in = new BufferedReader(new FileReader(file));
		    String str;
		    while ((str = in.readLine()) != null)
		    	System.out.println(str);
		    in.close();
		} 
		
		catch (IOException e) {
			System.out.println("ERROR: unable to read file " + file);
		    e.printStackTrace(); 
		}


	}

}