//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

import java.io.*;
import java.util.*;

public class AlgorithmB {
	
	static long TotAverage;
	static int TotMaximum;
	
	//All the objects are read from the file and saved in the list
	//The object at the back of the list will be removed first
	//High priority means higher possibility to be first in the PQ
	//Priority is given according to the objects' size
	//PQ was set to put the objects with higher priority on the top
	//T starts from the arrival time of the first object and adds up to the size of the completed object each cycle
	//Done is responsible for the main loop - It becomes true when all objects have been completed
	//Pass stops the other loop if the list is empty
	//That way when all the objects have been completed pass will block PQ from inserting other objects
	//When an object is completed it is writen in the output file
	//Maximum size of an object is 128
	//Arrival times are checked also
	//Waiting times are computed during the main loop
	//Average and maximum are computed during the main loop
	//Besides the example we are given - we have tested AlgorithmB with 2 more examples containing 9 objects instead of 3
	//First object gets max priority by default
	//Default example: (0-15/5-100/10-3)
	//Our example: (0-15/5-100/10-3/18-5/25-20/35-10/50-8/80-30/100-25)
	
    public static void runB(String in,String out) {
		System.out.println("Testing algorithmB for file: "+in);
	    List list = new List();
	    list = ReadFile(in);
		File f = null;
	    BufferedWriter writer = null;
		long average = 0;
		int maximum = 0;
		int idMax = 1;
		int size = 0;
		try	{
	        f = new File(out);
			try	{
		    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
	        }
	        catch (FileNotFoundException e) {
		        System.err.println("Failed to open file for writing!");
	        }
	    }
	    catch (NullPointerException e) {
	        System.err.println ("Failed to open file for writing!");
	    }
	    if(!list.isEmpty()) {
			MaxPQ PQ = new MaxPQ(list.getSize()*2);
			boolean done = false;
			boolean pass = true;;
			boolean completed = false;
			PrintJob temp;
			PrintJob object = list.removeFromBack();
		    int T = object.getArrivalTime();
			while(!done) {
				while(object.getArrivalTime() <= T && pass == true){
					PQ.insert(object);
					if (!list.isEmpty()) {
					    object = list.removeFromBack();
					}
					else {
						completed = true;
						pass = false;
					}
				}
				if(completed == true && PQ.isEmpty()) {
					done = true;
				}
				else {
				    temp = PQ.getMax();
				    temp.setWaitingTime((T-temp.getArrivalTime()));
					T = T + temp.getSize();
					average = average + temp.getWaitingTime();
					size++;
		            try	{
			            writer.write("t= "+(temp.getArrivalTime()+temp.getWaitingTime()+temp.getSize())+", completed file "+temp.getID());
				        writer.newLine();
		            }
		            catch (IOException e) {
			            System.err.println("Failed to write!");
		            }
			        if(temp.getWaitingTime() > maximum) {
				        maximum = temp.getWaitingTime();
				        idMax = temp.getID();
			        }
				}
			}
			if (size != 0) {
			average = average / size;
		    }
	        try {
	     	    writer.write("Average waiting time = "+average);
			    writer.newLine();
	    	    writer.write("Maximum waiting time = "+maximum+", achieved by file "+idMax);
	        }
	        catch (IOException e) {
		        System.err.println("Failed to write!");
	        }
	        try {
		        writer.close();
	        }
	        catch (IOException e) {
		        System.err.println("Failed to close the file!");
            }
			System.out.println("Procedure has finished!");
			System.out.println("Check the file "+out+" for more information.");
			System.out.println();
			TotAverage = average;
			TotMaximum = maximum;
	    }
    }
	
    public static List ReadFile(String filename){
	    String previousTime = "0";
		boolean alert = false;
		List list = new List();
		Scanner scan = null;
		int id = 0;
	    try	{
		    File f = new File(filename);
			try {
			    scan = new Scanner(f);
			} catch (FileNotFoundException e) {
				System.err.println ("Failed to open file for reading!");
			    alert = true;
			}
	    }
	    catch (NullPointerException e) {
		    System.err.println ("Failed to open file for reading!");
			alert = true;
	    }
	    while (scan.hasNextLine() && alert!=true) {
		    id = id + 1;
            String currentLine = scan.nextLine();
            String words[] = currentLine.split(" ");
	        if(words.length != 2){
			    alert = true;
			    System.out.println("Each line must have a word for the arrival time and a word for the size! Please restart the program!");
		    }
		    if(Integer.parseInt(words[0]) < Integer.parseInt(previousTime)) {
			    alert = true;
			    System.out.println("The time arrival of a package is wrong! Please restart the program!");
		    }
		    if(Integer.parseInt(words[1]) > 128) {
			    alert = true;
			    System.out.println("The size of a package is bigger than 128! Please restart the program!");
		    }
			if(Integer.parseInt(words[1]) <= 0) {
				alert = true;
			    System.out.println("The size of a package must be a positive integer! Please restart the program!");
			}
		    if(alert != true){
			    PrintJob PJ = new PrintJob(id,Integer.parseInt(words[1]),0,Integer.parseInt(words[0]),128-Integer.parseInt(words[1]));
			    list.insertAtFront(PJ);
				previousTime = words[0];
		    }
        }
		return list;
    }
}