//*******************************************************************************************
// 
// $Workfile: FugateCS201.java $
// $Revision: 1 $
// $Author: Brian Fugate $ 
// $Modtime: 03/02/23 09:21 $
// 
// Study.com Computer Science 201
// State and Capital Final Assignment Program
//
//*******************************************************************************************

import java.util.Scanner;  // Import the Scanner class
import java.util.HashMap;  // Import the HashMap class
import java.util.Map;      // Import the Map class
import java.util.TreeMap;  // Import the TreeMap class

public class FugateCS201 {
	
	//method to print 2D array
	public static void print2D(String[][] stringArray) {
		// loop to iterate through the array and print each row
		for (int i = 0; i < stringArray.length; i++) {
			System.out.print("{" + stringArray[i][0] + ", " + stringArray[i][1] + "} ");
		}
	}
	
	//method to clone 2D array
	public static String[][] clone2D(String[][] stringArray) {
		String[][] stringArrayClone = new String[50][2]; //create array for cloning
		
		//iterate through arrays and clone each element
		for (int i = 0; i < stringArray.length; i++) {
			stringArrayClone[i][0] = stringArray[i][0];
			stringArrayClone[i][1] = stringArray[i][1];
		}
		return stringArrayClone; //return cloned array
	}
	
	//method to bubble sort 2D array
	public static void bubbleSort(String[][] stringArray) {
		//first loop traverses to the end of the list
		for (int i = 0; i < stringArray.length - 1; i++) {
    
			//next, go to the next-to-last element
			for (int j = 0; j < stringArray.length - i - 1; j++) {
     
				//compare to see if the current value is greater than the next value
				if (stringArray[j][1].compareTo(stringArray[j+1][1]) > 0) {
					//swap stringArray[j+1] and stringArray[j]
					//these steps create a temporary holding variable,
					//then flip one to the other including both state and capital
					String temp0 = stringArray[j][0];
					String temp1 = stringArray[j][1];
					stringArray[j][0] = stringArray[j+1][0];
					stringArray[j][1] = stringArray[j+1][1];
					stringArray[j+1][0] = temp0;
					stringArray[j+1][1] = temp1;
				}
      		}
		}
   	}
    
   	//method to quiz user on 2D array (only works for 2 column array)
   	public static void capitalQuiz(String[][] stringArray) {
   		//declare variables and objects
   		int correctCount = 0;
   		String userInput = new String();
   		Scanner scanner = new Scanner(System.in); //Scanner object for user input
    	
   		//loop through array to get all elements
   		for (int i = 0; i < stringArray.length; i++) {
    		
   			//prompt user for input, then store input in userInput String
   			System.out.print("Enter the capital of " + stringArray[i][0] + " or 'exit' to give up and go to part 2: ");
   			userInput = scanner.nextLine();
    		
   			//check user's answer or exit loop
   			if (userInput.equalsIgnoreCase("exit")) {
   				return;
   			} else if (userInput.equalsIgnoreCase(stringArray[i][1])) {
   				correctCount++;
   				System.out.println("Correct! Your have gotten " + correctCount + " out of " + (i + 1) + " correct.\n");
   			} else {
   				System.out.println("Incorrect! Your have gotten " + correctCount + " out of " + (i + 1) + " correct.\n");
   			}
   		}
   	}
    
   	//method to populate HashMap with states and capitals
   	public static HashMap<String, String> putArrayInHashMap(String[][] stringArray) {
   		//create local HashMap instance for method
   		HashMap<String, String> stringHashMap = new HashMap<>();
    	
   		//loop through array to populate HashMap
   		for (int i = 0; i < stringArray.length; i++) {
   			stringHashMap.put(stringArray[i][0], stringArray[i][1]);
   		}
    	
   		return stringHashMap; //send HashMap back to main method
   	}
    
   	//method to print HashMap
   	public static void printHashMap(HashMap<String, String> stringHashMap) {
   		//loop through HashMap entries and print each key-value pair
   		for (Map.Entry<String, String> e : stringHashMap.entrySet()) {
   			System.out.print("{" + e.getKey() + ", " + e.getValue() + "} ");
   		}
   	}
    
   	//method to populate TreeMap with states and capitals from HashMap
   	public static TreeMap<String, String> putHashMapInTreeMap(HashMap<String, String> stringHashMap) {
   		//create local TreeMap instance for method
   		TreeMap<String, String> stringTreeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    	
   		//loop through HashMap to populate TreeMap
   		for (Map.Entry<String, String> e : stringHashMap.entrySet()) {
   			stringTreeMap.put(e.getKey(), e.getValue());
   		}
    	    	
   		return stringTreeMap; //send TreeMap back to main method
   	}
    	
   	// method to print TreeMap
   	public static void printTreeMap(TreeMap<String, String> stringTreeMap) {
   		//loop through TreeMap keys and print key-value pairs
   		for (String key : stringTreeMap.keySet()) {
   			System.out.print("{" + key + ", " + stringTreeMap.get(key) + "} ");
   		}
   	}
    
   	// method to display capital of inputted state
   	public static void findCapital(TreeMap<String, String> stringTreeMap) {
   		//declare variables and objects
   		String userInput = new String();
   		Scanner scanner = new Scanner(System.in); //Scanner object for user input
    	
   		//loop to allow multiple user inquiries
   		do {
   			System.out.print("Enter a state name to see its capital, or 'exit' to end program: ");
   			userInput = scanner.nextLine();
    		
   			//evaluate user input
   			if (stringTreeMap.containsKey(userInput)) {
   				System.out.println("\n The capital of " + userInput + " is " + stringTreeMap.get(userInput) + "\n\n");
   			} else if (!userInput.equalsIgnoreCase("exit")) {
   				System.out.println("\nPlease enter a valid state name...\n");
   			}
   		} while (!userInput.equalsIgnoreCase("exit"));
   	}
    
   	//main method to run program
   	public static void main(String[] args) {
	
   		//Create and populate two dimensional string array with states and their capitals in alphabetical order by state
   		String[][] stateCapitals = {{"Alabama","Montgomery"},{"Alaska","Juneau"},{"Arizona","Phoenix"},{"Arkansas","Little Rock"},
   									{"California","Sacramento"},{"Colorado","Denver"},{"Connecticut","Hartford"},{"Delaware","Dover"},
   									{"Florida","Tallahassee"},{"Georgia","Atlanta"},{"Hawaii","Honolulu"},{"Idaho","Boise"},
   									{"Illinois","Springfield"},{"Indiana","Indianapolis"},{"Iowa","Des Moines"},{"Kansas","Topeka"},
   									{"Kentucky","Frankfort"},{"Louisiana","Baton Rouge"},{"Maine","Augusta"},{"Maryland","Annapolis"},
   									{"Massachusetts","Boston"},{"Michigan","Lansing"},{"Minnesota","St. Paul"},{"Mississippi","Jackson"},
   									{"Missouri","Jefferson City"},{"Montana","Helena"},{"Nebraska","Lincoln"},{"Nevada","Carson City"},
   									{"New Hampshire","Concord"},{"New Jersey","Trenton"},{"New Mexico","Santa Fe"},{"New York","Albany"},
   									{"North Carolina","Raleigh"},{"North Dakota","Bismarck"},{"Ohio","Columbus"},{"Oklahoma","Oklahoma City"},
   									{"Oregon","Salem"},{"Pennsylvania","Harrisburg"},{"Rhode Island","Providence"},{"South Carolina","Columbia"},
   									{"South Dakota","Pierre"},{"Tennessee","Nashville"},{"Texas","Austin"},{"Utah","Salt Lake City"},
   									{"Vermont","Montpelier"},{"Virginia","Richmond"},{"Washington","Olympia"},{"West Virginia","Charleston"},
   									{"Wisconsin","Madison"},{"Wyoming","Cheyenne"}};
		
		//Create objects for copying and sorting initial array into array, HashMap, and TreeMap
		String[][] sortedStateCapitals = new String[50][2]; //create array for sorting
		HashMap<String, String> stateCapitalHashMap = new HashMap<>(); //create HashMap
		TreeMap<String, String> stateCapitalTreeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);  //create TreeMap
		
		//clone initial array and sort
		sortedStateCapitals = clone2D(stateCapitals);
		bubbleSort(sortedStateCapitals);
									
		//Print array before sort
		System.out.println("\nList of state capitals sorted by state:\n");
		print2D(stateCapitals);
		System.out.print("\n\n\n");
		
		//Print array after sort
		System.out.println("List of state capitals sorted by capital:\n");
		print2D(sortedStateCapitals);
		System.out.print("\n\n\n");
		
		//Quiz user on capitals
		capitalQuiz(sortedStateCapitals);
		System.out.print("\n\n\n");
		
		//populate HashMap with unsorted states and capitals array
		stateCapitalHashMap = putArrayInHashMap(stateCapitals);
		
		//print HashMap
		System.out.println("List of state capitals in HashMap:\n");
		printHashMap(stateCapitalHashMap);
		System.out.print("\n\n\n");
		
		//populate TreeMap with states and capitals HashMap
		stateCapitalTreeMap = putHashMapInTreeMap(stateCapitalHashMap);
		
		//print TreeMap which was automatically sorted in natural order on population
		System.out.println("List of state capitals in TreeMap:\n");
		printTreeMap(stateCapitalTreeMap);
		System.out.print("\n\n\n");
		
		//display capital for given state from user input
		findCapital(stateCapitalTreeMap);
	}
}