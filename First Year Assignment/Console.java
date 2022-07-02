/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

public class Console extends Device {
	
	private String Type;
	private String Sound;
	private String Processor;
	private String Graphics;
	private String HardDrive;
	
	public Console() {
		
	}
	
	public Console(String Code,String Name,String Year,String Producer,double Price,int Number,String t,String p,String g,String s,String hd){
		super(Code,Name,Year,Producer,Price,Number);
		Type = t;
		Sound = s;
		Processor = p;
		Graphics = g;
		HardDrive = hd;
	}
	
	public String getType(){
		return Type;
	}
	
	public void setType(String t){
		Type = t;
	}
	
	public String getSound(){
		return Sound;
	}
	
	public void setSound(String s){
		Sound = s;
	}
	
	public String getProcessor(){
		return Processor;
	}
	
	public void setProcessor(String p){
		Processor = p;
	}
	
	public String getGraphics(){
		return Graphics;
	}
	
	public void setGraphics(String g){
		Graphics = g;
	}
	
	public String getHardDrive(){
		return HardDrive;
	}
	
	public void setHardDrive(String hd){
		HardDrive = hd;
	}
	
	public String toString(){
        return super.toString()+"| Type: "+getType()+"| Processor: "+getProcessor()+"| Graphics: "+getGraphics()+"| Sound: "+getSound()+"| Hard Drive: "+getHardDrive();
    }
	
	public String getContents(){
		String s = super.getContents();
	    s = s + "\nType: " + Type;
	    s = s + "\nSound: " + Sound;
	    s = s + "\nProcessor: " + Processor;
		s = s + "\nGraphics: " + Graphics;
		s = s + "\nHard Drive: " + HardDrive;
	    return s;
	}
	
}