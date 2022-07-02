/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

public class Camera extends Device {
	
	private String Type;
	private String Megapixel;
	private String OpticalZoom;
	private String DigitalZoom;
	private String Size;
	
	public Camera() {
		
	}
	
	public Camera(String Code,String Name,String Year,String Producer,double Price,int Number,String t,String m,String o,String d,String s){
		super(Code,Name,Year,Producer,Price,Number);
		Type = t;
		Megapixel = m;
		OpticalZoom = o;
		DigitalZoom = d;
		Size = s;
	}
	
	public String getType(){
		return Type;
	}
	
	public void setType(String t){
		Type = t;
	}
	
	public String getMegapixel(){
		return Megapixel;
	}
	
	public void setMegapixel(String m){
		Megapixel = m;
	}
	
	public String getOpticalZoom(){
		return OpticalZoom;
	}
	
	public void setOpticalZoom(String o){
		OpticalZoom = o;
	}
	
	public String getDigitalZoom(){
		return DigitalZoom;
	}
	
	public void setDigitalZoom(String d){
		DigitalZoom = d;
	}
	
	public String getSize(){
		return Size;
	}
	
	public void setSize(String s){
		Size = s;
	}
	
	public String toString(){
        return super.toString()+"| Type: "+getType()+"| Megapixel: "+getMegapixel()+"| Optical Zoom: "+getOpticalZoom()+"| Digital Zoom: "+getDigitalZoom()+"| Screen Size: "+getSize();
    }
	
	public String getContents(){
		String s = super.getContents();
	    s = s + "\nType: " + Type;
	    s = s + "\nMegapixel: " + Megapixel;
	    s = s + "\nOptical Zoom: " + OpticalZoom;
		s = s + "\nDigital Zoom: " + DigitalZoom;
		s = s + "\nSize: " + Size;
	    return s;
	}
	
}