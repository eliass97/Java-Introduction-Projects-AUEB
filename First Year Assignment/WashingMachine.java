/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

public class WashingMachine extends Device {
	
	private String Type;
	private String EnergyClass;
	private String Capacity;
	private String Rounds;
	
	public WashingMachine() {
		
	}
	
	public WashingMachine(String Code,String Name,String Year,String Producer,double Price,int Number,String ec,String c,String r){
		super(Code,Name,Year,Producer,Price,Number);
		EnergyClass = ec;
		Capacity = c;
		Rounds = r;
	}
	
	public String getEnergyClass(){
		return EnergyClass;
	}
	
	public void setEnergyClass(String ec){
		EnergyClass = ec;
	}
	
	public String getCapacity(){
		return Capacity;
	}
	
	public void setCapacity(String c){
		Capacity = c;
	}
	
	public String getRounds(){
		return Rounds;
	}
	
	public void setRounds(String r){
		Rounds = r;
	}
	
	public String toString(){
        return super.toString()+"| Energy CLass: "+getEnergyClass()+"| Capacity: "+getCapacity()+"| Rounds: "+getRounds();
    }
	
	public String getContents(){
		String s = super.getContents();
	    s = s + "\nEnergy Class: " + EnergyClass;
	    s = s + "\nCapacity: " + Capacity;
	    s = s + "\nRounds: " + Rounds;
	    return s;
	}
	
}