/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

import java.io.*;
import java.util.*;

public class StoreFileOrder {

	private ArrayList <Orders> StoreProducts = new ArrayList<Orders>();

	 public void loadFile(String data) {
         int counter = 0;

        File f = null;
        BufferedReader reader = null;
        Orders product = null;
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
				if(line.trim().equals("ORDER_LIST")){
					line = reader.readLine();
					if (line != null) {
						if(line.trim().equals("{")) {
							line = reader.readLine();
							while(line != null) {
								if (line !=null) {
								    if(line.trim().equals("ORDER")){
									    line = reader.readLine();
									    if( line !=null) {
											if(line.trim().equals("{")){
										        line = reader.readLine();
												product = new Orders();
												if(line!=null){
												    if(line.trim().startsWith("ITEM_TYPE")) {
										                product.setDevice(line.substring(10).trim());
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
													if (line.trim().startsWith("ORDER_DATE")){
														product.setOrderDate(line.substring(11).trim());
													}
                                                }
												line = reader.readLine();
												if(line!=null) {
													if (line.trim().startsWith("ARRIVE_DATE")){
														product.setArriveDate(line.substring(12).trim());
													}
                                                }
												line = reader.readLine();
												if(line!=null) {
													if (line.trim().startsWith("FINAL_COST")){
														product.setFinalCost(Double.parseDouble(line.substring(11).trim()));
													}
                                                }
												line = reader.readLine();
												if(line!=null) {
													if (line.trim().startsWith("DONE")){
														product.setDone(Boolean.parseBoolean(line.substring(5).trim()));
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
	public Orders get(int i){
		return StoreProducts.get(i);
	}


	public int size()	{
		return StoreProducts.size();
	}

}