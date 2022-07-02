/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

public class Sales {
	
	private int Code;
	private String Device;
	private String Name;
	private String Phone;
	private String SaleDate;
	private double FinalCost;
	
	public Sales() {
		
	}
	
	public Sales(int c,String d,String n,String p,String sd,double fc){
		Code = c;
		Device = d;
		Name = n;
		Phone = p;
		SaleDate = sd;
		FinalCost = fc;
	}
	
	public int getCode(){
		return Code;
	}
	
	public void setCode(int c){
		Code = c;
	}
	
	public String getDevice(){
		return Device;
	}
	
	public void setDevice(String d){
		Device = d;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setName(String n){
		Name = n;
	}
	
	public String getPhone(){
		return Phone;
	}
	
	public void setPhone(String p){
		Phone = p;
	}
	
	public String getSaleDate(){
		return SaleDate;
	}
	
	public void setSaleDate(String sd){
		SaleDate = sd;
	}
	
	public double getFinalCost(){
		return FinalCost;
	}
	
	public void setFinalCost(double fc){
		FinalCost = fc;
	}
	
	public String toString(){
        return "\nCode: "+getCode()+"| Device: "+getDevice()+"| Name: "+getName()+"| Phone: "+getPhone()+"| Sale Date: "+getSaleDate()+"| Final Cost: "+getFinalCost();
    }
	
}