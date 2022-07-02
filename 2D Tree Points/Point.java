//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

public class Point {
	
	private int x;
	private int y;
	
    public Point(int x, int y) {
		if(x < 0 || x > 100 || y < 0 || y > 100) {
			System.out.println("Failed to create the point!");
			System.out.println("Incorrect values have been given to x and y!");
			this.x = -1;
			this.y = -1;
		} else {
			this.x = x;
		    this.y = y;
		}
    }
	
    public int x() {
		return x;
    }
	
    public int y() {
		return y;
	}
	
    public double distanceTo(Point z) {
		return Math.sqrt((x-z.x())*(x-z.x()) + (y-z.y())*(y-z.y()));
	}
	
    public int squareDistanceTo(Point z) {
		return ((x-z.x())*(x-z.x()) + (y-z.y())*(y-z.y()));
	}
	
    public String toString() {
		return "("+x+","+y+")";
	}
}