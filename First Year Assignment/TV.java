/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

public class TV extends Device {
	
	private String Type;
	private String Dimension;
	private String Resolution;
	private String Ports;
	
	public TV() {
		
	}
	
	public TV(String Code,String Name,String Year,String Producer,double Price,int Number,String t,String d,String r,String p){
		super(Code,Name,Year,Producer,Price,Number);
		Type = t;
		Dimension = d;
		Resolution = r;
		Ports = p;
	}
	
	public String getType(){
		return Type;
	}
	
	public void setType(String t){
		Type = t;
	}
	
	public String getDimension(){
		return Dimension;
	}
	
	public void setDimension(String d){
		Dimension = d;
	}
	
	public String getResolution(){
		return Resolution;
	}
	
	public void setResolution(String r){
		Resolution = r;
	}
	
	public String getPorts(){
		return Ports;
	}
	
	public void setPorts(String p){
		Ports = p;
	}
	
	public String toString(){
        return super.toString()+"| Type: "+getType()+"| Dimension: "+getDimension()+"| Resolution: "+getResolution()+"| Ports: "+getPorts();
    }
	
	public String getContents(){
		String s = super.getContents();
	    s = s + "\nType: " + Type;
	    s = s + "\nDimension: " + Dimension;
	    s = s + "\nResolution: " + Resolution;
		s = s + "\nPorts: " + Ports;
	    return s;
	}
	
}