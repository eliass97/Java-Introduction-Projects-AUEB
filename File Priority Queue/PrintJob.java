//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

public class PrintJob implements Comparable<PrintJob> {
	
	private int id;
	private int size;
	private int waitingTime;
	private int arrivalTime;
	private int priority;
	
	public PrintJob(int i,int sz, int wt,int at,int pr) {
		id = i;
		size = sz;
		waitingTime = wt;
		arrivalTime = at;
		priority = pr;
	}
	
	public int getID() {
		return id;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getWaitingTime() {
		return waitingTime;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setSize(int sz) {
		size = sz;
	}
	
	public void setWaitingTime(int wt) {
		waitingTime = wt;
	}
	
	public void setArrivalTime(int at) {
		arrivalTime = at;
	}
	
	public void setPriority(int pr) {
		priority = pr;
	}
	
	public void PrintInfo() {
		System.out.println("ID: "+id);
		System.out.println("Size: "+size);
		System.out.println("Waiting Time: "+waitingTime);
		System.out.println("Arrival Time: "+arrivalTime);
		System.out.println("Priority: "+priority);
		System.out.println();
	}
	
	public int compareTo(PrintJob other) {
		if(getPriority() > other.getPriority()) {
			return 1;
		}
		else if(getPriority() < other.getPriority()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}