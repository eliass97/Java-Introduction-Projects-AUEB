/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

public class Device {
	
	private String Code;
	private String Name;
	private String Year;
	private String Producer;
	private double Price;
	private int Number;
	private String imagePath;
    
	public Device() {
		
	}
	
	public Device (String c,String n,String y,String pro,double pri,int num) {
		Code = c;
		Name = n;
		Year = y;
		Producer = pro;
		Price = pri;
		Number = num;
	}
	
	public String getCode(){
		return Code;
	}
	
	public void setCode(String c){
		Code = c;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setName(String n){
		Name = n;
	}
	
	public String getYear(){
		return Year;
	}
	
	public void setYear(String y){
		Year = y;
	}
	
	public String getProducer(){
		return Producer;
	}
	
	public void setProducer(String pro){
	    Producer = pro;
	}
	
	public double getPrice(){
		return Price;
	}
	
	public void setPrice(double pri){
		Price = pri;
	}
	
	public int getNumber(){
		return Number;
	}
	
	public void setNumber(int num){
		Number = num;
	}
	
	public void setImagePath(String path){
		imagePath = path;
	}
	
	public String getImagePath(){
		return imagePath;
	}
	
	public String toString(){
		return "Code: "+getCode()+"| Name: "+getName()+"| Year: "+getYear()+"| Producer: "+getProducer()+"| Price:"+getPrice()+"| Number: "+getNumber();
	}
	
	public String getContents(){
		String s = new String("Code: " + Code);
	    s = s + "\nName: " + Name;
	    s = s + "\nYear: " + Year;
		s = s + "\nProducer: " + Producer;
		s = s + "\nPrice: " + Price;
		s = s + "\nNumber: " + Number;
	    return s;
	}
}