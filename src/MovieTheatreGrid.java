

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MovieTheatreGrid { 
	int [][] theatre=null;
	Map<Integer, List<Integer>> availability;
	final int buffer=3;
	
	public MovieTheatreGrid() { 
		theatre=new int[10][20]; //Initializing empty movie theatre
		availability=new HashMap<>(); //Initializing a map with row and its corresponding availability
		Integer[] columns= {0,20};
		for(int i=0;i<10;i++) {
			availability.put(i, new ArrayList<Integer>(Arrays.asList(columns))); 
		}
	}

	public String allocate(String reqId, int numberOfSeats) {  // Allocates the movie seats to the end-user 
		
		String outputText=reqId + " "; // Initializing an output String
		
		if(numberOfSeats>20) { 
			outputText+= "COVID Restrictions! Due to the Guidelines from the Government, "
					+ "we cannot book more than 20 seats\n";
			return outputText;
		}
		
		System.out.println("Before Allocation:");
		for(Map.Entry<Integer, List<Integer>> entry: availability.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		boolean flag=false;
		
		for(int i=0;i<10;i++) { // Find a row where the user can be allocated desired number of seats
			List<Integer> row_details=availability.get(i); 
			int startPos=row_details.get(0);
			int emptySeats=row_details.get(1);
			if(emptySeats>=numberOfSeats) {
				int j;
				for(j=0;startPos+j>=0 && startPos+j<20 && j<numberOfSeats-1;j++) {
					theatre[i][startPos+j]=1;
					outputText+=Character.toString((char)i+65) + (startPos+j+1) +",";
				}
				outputText+=Character.toString((char)i+65) + (startPos+j+1);
				
				List<Integer> new_row_details=new ArrayList<Integer>();
				new_row_details.add(startPos+numberOfSeats+buffer);
				new_row_details.add(emptySeats-numberOfSeats-buffer);
				availability.put(i, new_row_details);
				
				System.out.println("After Allocation:");
				for(Map.Entry<Integer, List<Integer>> entry: availability.entrySet()) {
					System.out.println(entry.getKey() + " : " + entry.getValue());
				}
				System.out.println("-----------------------");
				
				flag=true;
				break;
			}
		}
		
		if(!flag) {
			outputText+="Due to the COVID Restrictions and to do our part for public health and safety, "
					+ "we are prohibited from operating at full capacity. Hence, We cannot process your request.";
		}
		return outputText;
	}	
}
