/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/
import java.io.*;
import java.util.*;

public class WriteFileOrder {

	private ArrayList<Orders> StoreProductsO = new ArrayList<Orders>();

 public void createFile  (String path) {

		File f = null;
		BufferedWriter writer = null;

		try	{
			f = new File(path);
		}
		catch (NullPointerException e) {
			System.err.println ("File not found.");
		}

		try	{
			writer = new BufferedWriter(new OutputStreamWriter
				(new FileOutputStream(f)));
		}
		catch (FileNotFoundException e) {
			System.err.println("Error opening file for writing!");
		}
		try{
        writer.write("ORDER_LIST"+"\r\n"+"{"+"\r\n");
		} catch (IOException e) {
			System.err.println("Write error!");
		}
		for (Orders ProductO:StoreProductsO) {
			String itemInfo = new String();
			try	{
				writer.write("ORDER\r\n{\r\nITEM_TYPE\t"+ProductO.getDevice()+"\r\nCODE\t"+ProductO.getCode()
				+"\r\nNAME\t"+ProductO.getName()+"\r\nPHONE\t"+ProductO.getPhone()+"\r\nORDER_DATE\t"+ProductO.getOrderDate()
				+"\r\nARRIVE_DATE\t"+ProductO.getArriveDate()+"\r\nFINAL_COST\t"+ProductO.getFinalCost()+"\r\nDONE\t"+ProductO.getDone()+"\r\n}\r\n");
			}
			catch (IOException e) {
				System.err.println("Write error!");
			}
		}
		try {
		writer.write("}\r\n");
		} catch (IOException e) {
			System.err.println("Write error!");
		}
		try {
			writer.close();
		}
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}
	
 	public void add(Orders b) {
			 StoreProductsO.add(b);
	}
}

