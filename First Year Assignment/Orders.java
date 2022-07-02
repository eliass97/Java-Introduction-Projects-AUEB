/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

public class Orders {
	
	private int Code;
	private String Device;
	private String Name;
	private String Phone;
	private String OrderDate;
	private String ArriveDate;
	private double FinalCost;
	private boolean Done;
	
	public Orders() {
		
	}
	
	public Orders(int c,String d,String n,String p,String od,String ad,double fc,boolean done){
		Code = c;
		Device = d;
		Name = n;
		Phone = p;
		OrderDate = od;
		ArriveDate = ad;
		FinalCost = fc;
		this.Done = done;
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
	
	public String getOrderDate(){
		return OrderDate;
	}
	
	public void setOrderDate(String od){
		OrderDate = od;
	}
	
	public String getArriveDate(){
		return ArriveDate;
	}
	
	public void setArriveDate(String ad){
		ArriveDate = ad;
	}
	
	public double getFinalCost(){
		return FinalCost;
	}
	
	public void setFinalCost(double fc){
		FinalCost = fc;
	}
	
	public boolean getDone(){
		return this.Done;
	}
	
	public void setDone(boolean done){
		this.Done = done;
	}
	
	public String toString(){
        return "\nCode: "+getCode()+"| Device: "+getDevice()+"| Name: "+getName()+"| Phone: "+getPhone()+"| Order Date: "+getOrderDate()+"| Arrive Date: "+getArriveDate()+"| Final Cost: "+getFinalCost()+"| Completed: "+getDone();
    }
	
}