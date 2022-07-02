/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/
import java.io.*;
import java.util.*;

public class WriteFileSale {

	private ArrayList<Sales> StoreProductsS = new ArrayList<Sales>();

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
        writer.write("SALES_LIST"+"\r\n"+"{"+"\r\n");
		} catch (IOException e) {
			System.err.println("Write error!");
		}
		for (Sales ProductS:StoreProductsS) {
			String itemInfo = new String();
			try	{
				writer.write("SALE\r\n{\r\nITEM_TYPE\t"+ProductS.getDevice()+"\r\nNAME\t"+ProductS.getName()
				+"\r\nPHONE\t"+ProductS.getPhone()+"\r\nCODE\t"+ProductS.getCode()+"\r\nDATE\t"+ProductS.getSaleDate()
				+"\r\nCOST\t"+ProductS.getFinalCost()+"\r\n}\r\n");
			}
			catch (IOException e) {
				System.err.println("Write error!");
			}
		}
		try {
		writer.write("}\r\n");
		} catch(IOException e) {
			System.err.println("Write error!");
		}
		try {
			writer.close();
		}
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}
	
 	public void add(Sales b) {
			 StoreProductsS.add(b);
	}
}