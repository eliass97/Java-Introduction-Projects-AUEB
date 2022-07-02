//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

import java.io.*;
import java.util.*;

public class Comparisons {
	
	//At first we create the values for each of the 5 N using the random generator.
	//Objects b and c are also created to execute AlgorithmB and AlgorithmC for every file.
	//Using 2 loops we create 50 files with their data.
	//We make size is smaller than 128 and there are no time gabs.
	//When a file is created, the proper message is printed.
	//Then AlgorithmB is executed for the specific file followed by AlgorithmC.
	//Every time a file is completed, a proper message in printed and an output text is created for it.
	//All the files are saved at 3150156_3150171/randoms/.
	//WARNING: AlgorithmB is way too faster than AlgorithmC at the execution.
	//WARNING: A file execution with AlgorithmB might take 1-5 seconds but with AlgorithmC will take way too longer.
	
	public static void main(String[] args) { 
		AlgorithmB b = new AlgorithmB();
		AlgorithmC c = new AlgorithmC();
		Random rndm = new Random();
		int N[] = new int[5];
		int num,cap,time,previousTime,size=0;
		int maxC=0;
		int maxB=0;
		long aveB=0;
		long aveC=0;
		N[0] = rndm.nextInt(9900) + 100;
		N[1] = rndm.nextInt(10000) + 10000;
		N[2] = rndm.nextInt(10000) + 20000;
		N[3] = rndm.nextInt(10000) + 30000;
		N[4] = rndm.nextInt(10000) + 40000;
		for(int i=0;i<5;i++) {
			for(int j=0;j<10;j++) {
				time = 0;
				previousTime = 0;
				num = i * 10 + j + 1;
				File f = null;
	            BufferedWriter writer = null;
                try	{
	                f = new File("random"+"\\"+"input"+num+".txt");
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
				for(cap=0;cap<N[i];cap++) {
					if(cap != 0) {
						time = rndm.nextInt(size+1) + previousTime;
						previousTime = time;
					}
					size = rndm.nextInt(128) + 1;
					try	{
			            writer.write(time+" "+size);
				        writer.newLine();
		            }
		            catch (IOException e) {
			            System.err.println("Failed to write!");
		            }
				}
	            try {
		            writer.close();
	            }
	            catch (IOException e) {
		            System.err.println("Failed to close the file!");
                }
				System.out.println("Created file: "+"input"+num+".txt");
				b.runB("random"+"\\"+"input"+num+".txt","random"+"\\"+"outputB"+num+".txt");
				c.runC("random"+"\\"+"input"+num+".txt","random"+"\\"+"outputC"+num+".txt");
				aveB = aveB + b.TotAverage;
				aveC = aveC + c.TotAverage;
				maxB = maxB + b.TotMaximum;
				maxC = maxC + c.TotMaximum;
			}
			File f = null;
	        BufferedWriter writer = null;
            try	{
	            f = new File("results"+"\\"+"Result"+(((i+1)*10)-9)+"-"+((i+1)*10)+".txt");
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
			aveB = aveB/10;
			aveC = aveC/10;
			maxB = maxB/10;
			maxC = maxC/10;
			try	{
			    writer.write("B -> Average AWT: "+aveB+" | "+"Average MWT: "+maxB);
				writer.newLine();
				writer.write("C -> Average AWT: "+aveC+" | "+"Average MWT: "+maxC);
				writer.newLine();
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
			aveB = 0;
			aveC = 0;
			maxB = 0;
			maxC = 0;
		}
	}
}