import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import strategies.*;

public class Main {

	private static Vector<Strategy> strategies;
	
	@SuppressWarnings("unchecked")
	public static Class[] get_classes(String pckgname) {
		try {
			ArrayList classes = new ArrayList();
			
		    // Get a File object for the package 
			File directory = null; 
		    try { 
		    	directory = new File(Thread.currentThread().getContextClassLoader().getResource(pckgname.replace('.', '/')).getFile()); 
		    } 
		    catch(NullPointerException x) { 
		    	System.out.println("Nullpointer");
		    	throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
		    }
		    
		    if (directory.exists()) { 
		    	// Get the list of the files contained in the package 
		    	String[] files=directory.list(); 
		    	for (int i=0; i<files.length; i++) { 
		    		// we are only interested in .class files 
		    		if (files[i].endsWith(".class") && !files[i].startsWith("Strategy")) { 
		    			// removes the .class extension 
		    			classes.add(Class.forName(pckgname+'.'+files[i].substring(0, files[i].length()-6))); 
		    		} 
		    	} 
		    } 
		    else { 
		    	System.out.println("Directory does not exist");
		    	throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
		    }
		    
		    Class[] classesA = new Class[classes.size()]; 
		    classes.toArray(classesA); 
		    return classesA;		  
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")	
	public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		//init strategies vector
		strategies = new Vector<Strategy>();
		
		//get all classes from strategies package
		Class[] classes = get_classes("strategies");
		
		//instantiate all classes and add to vector
		for (int i = 0; i < classes.length; i++) {
			Strategy s = (Strategy) classes[i].newInstance();	
			strategies.add(s);
		}
		
		//hold tournament
		//every strategy plays itself and every other strategy
		Tournament tournament = new Tournament();
		for (int i = 0; i < strategies.size(); i++) {
			for (int j = 0; j < strategies.size(); j++) {
				System.out.println(strategies.get(i).get_name()+" plays "+strategies.get(j).get_name());
				tournament.compete(strategies.get(i), strategies.get(j));				
			}
		}
		
		//output scores
		for (int i = 0; i < strategies.size(); i++) {
			System.out.println(strategies.get(i).get_name()+": "+strategies.get(i).get_score());
			System.out.println(strategies.get(i).get_past_scores());
			System.out.println("No. scores: "+strategies.get(i).get_past_scores().size()+"\n");
		}
		
		//output chart
		Chart c = new Chart(strategies);
		c.pack();
        c.setVisible(true);
	}
}