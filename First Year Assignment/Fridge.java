/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

public class Fridge extends Device {
	
	private String Type;
	private String EnergyClass;
	private String Preservation;
	private String Refrigeration;
	
	public Fridge() {
		
	}
	
	public Fridge(String Code,String Name,String Year,String Producer,double Price,int Number,String t,String ec,String p,String r){
		super(Code,Name,Year,Producer,Price,Number);
		Type = t;
		EnergyClass = ec;
		Preservation = p;
		Refrigeration = r;
	}
	
	public String getType(){
		return Type;
	}
	
	public void setType(String t){
		Type = t;
	}
	
	public String getEnergyClass(){
		return EnergyClass;
	}
	
	public void setEnergyClass(String ec){
		EnergyClass = ec;
	}
	
	public String getPreservation(){
		return Preservation;
	}
	
	public void setPreservation(String p){
		Preservation = p;
	}
	
	public String getRefrigeration(){
		return Refrigeration;
	}
	
	public void setRefrigeration(String r){
		Refrigeration = r;
	}
	
	public String toString(){
        return super.toString()+"| Type: "+getType()+"| Energy Class: "+getEnergyClass()+"| Preservation Capacity: "+getPreservation()+"| Refrigeration Capacity: "+getRefrigeration();
    }
	
	public String getContents(){
		String s = super.getContents();
	    s = s + "\nType: " + Type;
	    s = s + "\nEnergy Class: " + EnergyClass;
	    s = s + "\nPreservation: " + Preservation;
		s = s + "\nRefrigeration: " + Refrigeration;
	    return s;
	}
	
}