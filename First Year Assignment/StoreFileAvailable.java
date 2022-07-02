/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

import java.io.*;
import java.util.*;

public class StoreFileAvailable {

	private ArrayList <Device> StoreProducts = new ArrayList<Device>();

	 public void loadFile(String data) {
         int counter = 0;

        File f = null;
        BufferedReader reader = null;
        Device product = null;
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
					if(line.trim().equals("ITEM_LIST")){
						line = reader.readLine();
						if (line != null) {
							if(line.trim().equals("{")) {
								line = reader.readLine();
								while(line != null) {
								    if (line !=null) {
								        if(line.trim().equals("ITEM")){
									    line = reader.readLine();
									        if( line !=null) {
											    if(line.trim().equals("{")){
												line = reader.readLine();
												if(line.trim().startsWith("ITEM_TYPE")) {
										            if(line.trim().substring(10).trim().equals("WashingMachine")){ 
													    product = new WashingMachine();
													    line = reader.readLine();
													    if(line != null){
														    if(line.trim().startsWith("CODE")){
															    product.setCode(line.substring(5).trim());
														    }    
													    }
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL")){
																product.setName(line.substring(6).trim());
															}
														}
														line = reader.readLine();
															if(line!=null) {
																if (line.trim().startsWith("MODEL_YEAR")){
																	product.setYear(line.substring(11).trim());
																}
															}
															line = reader.readLine();
															if(line!=null) {
																if (line.trim().startsWith("MANUFACTURER")){
																	product.setProducer(line.substring(13).trim());
																}
															}
															line = reader.readLine();
															if(line!=null) {
																if (line.trim().startsWith("PRICE")){
																	product.setPrice(Double.parseDouble(line.substring(6).trim()));
																}
															}
															line = reader.readLine();
															if(line!=null) {
																if (line.trim().startsWith("PIECES")){
																	product.setNumber(Integer.parseInt(line.substring(7).trim()));
																}
															}
															line = reader.readLine();
															if(line!=null) {
																if (line.trim().startsWith("ENERGYCLASS")){
																	((WashingMachine)product).setEnergyClass(line.substring(12).trim());
																}
															}
															line = reader.readLine();
															if(line!=null) {
																if (line.trim().startsWith("CAPACITY")){
																	((WashingMachine)product).setCapacity(line.substring(9).trim());
																}
															}
															line = reader.readLine();
															if(line!=null) {
																if (line.trim().startsWith("ROUNDS")){
																	((WashingMachine)product).setRounds(line.substring(7).trim());
																}
															}
															line = reader.readLine();
															if (line != null) {
															    if (line.trim().equals("}")) {
																StoreProducts.add(product);
															    }
														    }
												        
												    } else if (line.trim().substring(10).trim().equals("TV")) { 
														product = new TV();
														line = reader.readLine();
													    if(line != null){
														    if(line.trim().startsWith("CODE")){
											    			    product.setCode(line.substring(5).trim());
														    }    
											    		    }
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL")){
																product.setName(line.substring(6).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL_YEAR")){
																product.setYear(line.substring(11).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MANUFACTURER")){
												    			product.setProducer(line.substring(13).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
												    		if (line.trim().startsWith("PRICE")){
																product.setPrice(Double.parseDouble(line.substring(6).trim()));
															}
														}
													    line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PIECES")){
																product.setNumber(Integer.parseInt(line.substring(7).trim()));
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("TYPE")){
																((TV)product).setType(line.substring(5).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("DIMENSION")){
																((TV)product).setDimension(line.substring(10).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("RESOLUTION")){
																((TV)product).setResolution(line.substring(11).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PORTS")){
																((TV)product).setPorts(line.substring(6).trim());
															}
														}
														line = reader.readLine();
														if (line != null) {
														    if (line.trim().equals("}")) {
													    	StoreProducts.add(product);
												        	}
													    }
													} else if (line.trim().substring(10).trim().equals("Fridge")) { 
														product = new Fridge();
														line = reader.readLine();
													    if(line != null){
														    if(line.trim().startsWith("CODE")){
															    product.setCode(line.substring(5).trim());
														    }    
													    }
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL")){
																product.setName(line.substring(6).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL_YEAR")){
																product.setYear(line.substring(11).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MANUFACTURER")){
																product.setProducer(line.substring(13).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PRICE")){
																product.setPrice(Double.parseDouble(line.substring(6).trim()));
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PIECES")){
																product.setNumber(Integer.parseInt(line.substring(7).trim()));
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("TYPE")){
																((Fridge)product).setType(line.substring(5).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("ENERGYCLASS")){
																((Fridge)product).setEnergyClass(line.substring(12).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PRESERVATION")){
																((Fridge)product).setPreservation(line.substring(13).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("REFRIGERATION")){
												    			((Fridge)product).setRefrigeration(line.substring(14).trim());
															}
														}
														line = reader.readLine();
														if (line != null) {
														    if (line.trim().equals("}")) {
														    	StoreProducts.add(product);
														    }
													    }
													} else if (line.trim().substring(10).trim().equals("Console")) { 
														product = new Console();
														line = reader.readLine();
													    if(line != null){
														    if(line.trim().startsWith("CODE")){
															    product.setCode(line.substring(5).trim());
														    }    
													    }
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL")){
																product.setName(line.substring(6).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL_YEAR")){
																product.setYear(line.substring(11).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MANUFACTURER")){
																product.setProducer(line.substring(13).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PRICE")){
																product.setPrice(Double.parseDouble(line.substring(6).trim()));
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PIECES")){
																product.setNumber(Integer.parseInt(line.substring(7).trim()));
															}
														}
														line = reader.readLine();
														if(line!=null) {
												    		if (line.trim().startsWith("TYPE")){
																((Console)product).setType(line.substring(5).trim());
												    		}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("SOUND")){
																((Console)product).setSound(line.substring(6).trim());
															}
														}
												    	line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PROCESSOR")){
																((Console)product).setProcessor(line.substring(10).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("GRAPHICS")){
																((Console)product).setGraphics(line.substring(9).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("HARDDRIVE")){
																((Console)product).setHardDrive(line.substring(10).trim());
															}
														}
														line = reader.readLine();
														if (line != null) {
														    if (line.trim().equals("}")) {
															StoreProducts.add(product);
														    }
													    }
													} else if (line.trim().substring(10).trim().equals("Camera")) {
													    product = new Camera();
														line = reader.readLine();
														if(line != null){
															if(line.trim().startsWith("CODE")){
																product.setCode(line.substring(5).trim());
															}    
														}
													    line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL")){
																product.setName(line.substring(6).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL_YEAR")){
																product.setYear(line.substring(11).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MANUFACTURER")){
																product.setProducer(line.substring(13).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PRICE")){
																	product.setPrice(Double.parseDouble(line.substring(6).trim()));
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PIECES")){
																product.setNumber(Integer.parseInt(line.substring(7).trim()));
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("TYPE")){
																((Camera)product).setType(line.substring(5).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MEGAPIXEL")){
																((Camera)product).setMegapixel(line.substring(10).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("OPTICALZOOM")){
																((Camera)product).setOpticalZoom(line.substring(12).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("DIGITALZOOM")){
															    ((Camera)product).setDigitalZoom(line.substring(12).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("SIZE")){
																((Camera)product).setSize(line.substring(5).trim());
															}
														}
														line = reader.readLine();
														if (line != null) {
														    if (line.trim().equals("}")) {
															StoreProducts.add(product);
														    }
														   }
													} else if (line.trim().substring(10).trim().equals("BlueRayDVDPlayer")) { 
													    product = new BlueRayDVDPlayer();
														line = reader.readLine();
														if(line != null){
														    if(line.trim().startsWith("CODE")){
															    product.setCode(line.substring(5).trim());
														    }    
													    }
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL")){
																product.setName(line.substring(6).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MODEL_YEAR")){
																product.setYear(line.substring(11).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("MANUFACTURER")){
																product.setProducer(line.substring(13).trim());
											     			}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PRICE")){
																product.setPrice(Double.parseDouble(line.substring(6).trim()));
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("PIECES")){
																product.setNumber(Integer.parseInt(line.substring(7).trim()));
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("TYPE")){
																((BlueRayDVDPlayer)product).setType(line.substring(5).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("FORMAT")){
																((BlueRayDVDPlayer)product).setFormat(line.substring(7).trim());
															}
														}
														line = reader.readLine();
														if(line!=null) {
															if (line.trim().startsWith("RESOLUTION")){
																((BlueRayDVDPlayer)product).setResolution(line.substring(11).trim());
															}
														}
														line = reader.readLine();
														if (line != null) {
														    if (line.trim().equals("}")) {
															    StoreProducts.add(product);
														    }
								                        } 
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
	public Device get(int i){
		return StoreProducts.get(i);
	}


	public int size()	{
		return StoreProducts.size();
	}

}