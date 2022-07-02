/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

import java.io.*;
import java.util.*;

public class StoreFileSale {

	private ArrayList <Sales> StoreProducts = new ArrayList<Sales>();

	 public void loadFile(String data) {
         int counter = 0;

        File f = null;
        BufferedReader reader = null;
        Sales product = null;
        String line;

        try {
            f = new File(data);
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }
        try {
            reader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        }
        try {
           	line = reader.readLine();
			if(!line.trim().equals(" ")) {
				if(line.trim().equals("SALES_LIST")){
					line = reader.readLine();
					if (line != null) {
						if(line.trim().equals("{")) {
							line = reader.readLine();
							while(line != null) {
								if (line !=null) {
								    if(line.trim().equals("SALE")){
									    line = reader.readLine();
									    if( line !=null) {
											if(line.trim().equals("{")){
										        line = reader.readLine();
												product = new Sales();
												if(line!=null){
												    if(line.trim().startsWith("ITEM_TYPE")) {
										                product.setDevice(line.substring(10).trim());
												    } 
                                                }
												line = reader.readLine();
												if(line!=null) {
													if (line.trim().startsWith("NAME")){
														product.setName(line.substring(5).trim());
													}
												}
												line = reader.readLine();
												if(line!=null) {
													if (line.trim().startsWith("PHONE")){
														product.setPhone(line.substring(6).trim());
													}
                                                }
												line = reader.readLine();
												if(line!=null) {
											    	if (line.trim().startsWith("CODE")){
														product.setCode(Integer.parseInt(line.substring(5).trim()));
													}
												}
												line = reader.readLine();
												if(line!=null) {
													if (line.trim().startsWith("DATE")){
														product.setSaleDate(line.substring(5).trim());
													}
                                                }
												line = reader.readLine();
												if(line!=null) {
													if (line.trim().startsWith("COST")){
														product.setFinalCost(Double.parseDouble(line.substring(5).trim()));
													}
                                                }
												line = reader.readLine();
												if(line!=null) {
												    if(line.trim().startsWith("}")){
													    StoreProducts.add(product);
												    }
												}
											}
										}
									}
								}
								line = reader.readLine();
								if(line!=null){
								    if(line.trim().startsWith("}")){
									    line = reader.readLine();
								    }
								}
							}
						}
					}
				}
			}			
        } catch (IOException e) {
            System.out.println("Error reading line " + counter + ".");
        }
        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
    }
	public Sales get(int i){
		return StoreProducts.get(i);
	}


	public int size()	{
		return StoreProducts.size();
	}

}