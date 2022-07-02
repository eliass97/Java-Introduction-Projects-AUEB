/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

public class BlueRayDVDPlayer extends Device {
	
	private String Type;
	private String Format;
	private String Resolution;
	
	public BlueRayDVDPlayer() {
		
	}
	
	public BlueRayDVDPlayer(String Code,String Name,String Year,String Producer,double Price,int Number,String t,String r,String f){
		super(Code,Name,Year,Producer,Price,Number);
		Type = t;
		Format = f;
		Resolution = r;
	}
	
	public String getType(){
		return Type;
	}
	
	public void setType(String t){
		Type = t;
	}
	
	public String getResolution(){
		return Resolution;
	}
	
	public void setResolution(String r){
		Resolution = r;
	}
	
	public String getFormat(){
		return Format;
	}
	
	public void setFormat(String f){
		Format = f;
	}
	
	public String toString(){
        return super.toString()+"| Type: "+getType()+"| Resolution: "+getResolution()+"| Format: "+getFormat();
    }
	
	public String getContents(){
		String s = super.getContents();
	    s = s + "\nType: " + Type;
	    s = s + "\nResolution: " + Resolution;
	    s = s + "\nFormat: " + Format;
	    return s;
	}
	
}