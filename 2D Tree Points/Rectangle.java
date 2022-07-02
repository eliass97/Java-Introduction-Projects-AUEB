//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

public class Rectangle {
	
	private int xmax,xmin,ymax,ymin;
	
    public Rectangle(int xmin, int ymin, int xmax, int ymax) {
        if(xmin<0 || xmax >100 || ymin<0 || ymax>100 || ymax<ymin || xmax<xmin) {
			System.out.println("Failed to create the rectangle!");
			System.out.println("Rectangle valuables are incorrect!");
			this.xmin = -1;
			this.xmax = -1;
			this.ymin = -1;
			this.ymax = -1;
		}
		else {
			this.xmin = xmin;
		    this.xmax = xmax;
		    this.ymin = ymin;
		    this.ymax = ymax;
		}
	}
	
    public int xmin() {
		return xmin;
	}
	
    public int ymin() {
		return ymin;
	}
	
    public int xmax() {
		return xmax;
	}
	
    public int ymax() {
		return ymax;
	}
	
    public boolean contains(Point p) {
		if(p.x() <= xmax && p.x() >= xmin && p.y() <= ymax && p.y() >= ymin) { //If it's inside the rectangle
			return true;
		}
		else { //If it's outside the rectangle
			return false;
		}
	}
	
    public boolean intersects(Rectangle that) {
		if(that.xmax() <= xmax && that.xmax() >= xmin && that.ymin() <= ymax && that.ymin() >= ymin) { // if (xmin <= that.xmax <= xmax) && (ymin <= that.ymin <= ymax)
			return true;
		}
		if(that.xmax() <= xmax && that.xmax() >= xmin && that.ymax() <= ymax && that.ymax() >= ymin) { // if (xmin <= that.xmax <= xmax) && (ymin <= that.ymax <= ymax)
			return true;
		}
		if(that.xmin() <= xmax && that.xmin() >= xmin && that.ymax() <= ymax && that.ymax() >= ymin) { // if (xmin <= that.xmin <= xmax) && (ymin <= that.ymax <= ymax)
			return true;
		}
		if(that.xmin() <= xmax && that.xmin() >= xmin && that.ymin() <= ymax && that.ymin() >= ymin) { // if (xmin <= that.xmin <= xmax) && (ymin <= that.ymin <= ymax)
			return true;
		}
	    if(xmax() <= that.xmax && xmax() >= that.xmin && ymin() <= that.ymax && ymin() >= that.ymin) { // if (that.xmin <= xmax <= that.xmax) && (that.ymin <= ymin <= that.ymax)
			return true;
		}
		if(xmax() <= that.xmax && xmax() >= that.xmin && ymax() <= that.ymax && ymax() >= that.ymin) { // if (that.xmin <= xmax <= that.xmax) && (that.ymin <= ymax <= that.ymax)
			return true;
		}
		if(xmin() <= that.xmax && xmin() >= that.xmin && ymax() <= that.ymax && ymax() >= that.ymin) { // if (that.xmin <= xmin <= that.xmax) && (that.ymin <= ymax <= that.ymax)
			return true;
		}
		if(xmin() <= that.xmax && xmin() >= that.xmin && ymin() <= that.ymax && ymin() >= that.ymin) { // if (that.xmin <= xmin <= that.xmax) && (that.ymin <= ymin <= that.ymax)
			return true;
		}
		return false; //If the others aren't true then the 2 rectangles dont intersect
	}
	
    public double distanceTo(Point p) {
		//Splitting the point's posible positions in 9 cases
		//_______________________________________
		//             |           |
		// Up-Left     | Up-Middle | Up-Right
		//             |           |
		//---------------------------------------
		//             |   Inside  |
		// Left-Middle |    the    | Right-Middle
		//             | Rectangle |
		//---------------------------------------
		//             |           |
		// Down-Left   |Down-Middle| Down-Right
		//             |           |
		//________________________________________
		if(p.y()>=ymax) {
			if(p.x()>=xmin && p.x()<=xmax) { //Up-Middle
				return (p.y()-ymax);
			}
			else if(p.x()<xmin) { //Up-Left
				return Math.sqrt((p.y()-ymax)*(p.y()-ymax)+(xmin-p.x())*(xmin-p.x()));
			}
			else if(p.x()>xmax) { //Up-Right
				return Math.sqrt((p.y()-ymax)*(p.y()-ymax)+(p.x()-xmax)*(p.x()-xmax));
			}
			else {
				System.out.println("Failed to find distance between point and rectangle!");
				return 0;
			}
		}
		else if(p.y()<=ymin) {
			if(p.x()>=xmin && p.x()<=xmax) { //Down-Middle
				return (ymin-p.y());
			}
			else if(p.x()<xmin) { //Down-Left
				return Math.sqrt((ymin-p.y())*(ymin-p.y())+(xmin-p.x())*(xmin-p.x()));
			}
			else if(p.x()>xmax) { //Down-Right
				return Math.sqrt((ymin-p.y())*(ymin-p.y())+(p.x()-xmax)*(p.x()-xmax));
			}
			else {
				System.out.println("Failed to find distance between point and rectangle!");
				return 0;
			}
		}
		else {
			if(p.x()<=xmin) { //Left-Middle
				return (xmin-p.x());
			}
			else if(p.x()>=xmax) { //Right-Middle
				return (p.x()-xmax);
			}
			else { //Inside the rectangle
				//distance from bottom = p.x() - xmin
				//distance from top = xmax - p.x()
				//distance from left = p.y() - ymin
				//distance from right = ymax - p.y()
				if((p.x()-xmin)<=(xmax - p.x()) && (p.x()-xmin)<=(p.y() - ymin)  && (p.x() - xmin)<=(ymax - p.y())) {
					return (p.x() - xmin);
				}
				else if((xmax - p.x())<=(p.x() - xmin) && (xmax - p.x())<=(p.y() - ymin) && (xmax - p.x())<=(ymax - p.y())) {
					return (xmax - p.x());
				}
				else if((p.y() - ymin)<=(p.x() - xmin) && (p.y() - ymin)<=(xmax - p.x()) && (p.y() - ymin)<=(ymax - p.y())) {
					return (p.y() - ymin);
				}
				else {
				    return (ymax - p.y());
				}
			}
		}
	}
	
    public double squareDistanceTo(Point p) {
		//Splitting the point's posible positions in 9 cases
		//_______________________________________
		//             |           |
		// Up-Left     | Up-Middle | Up-Right
		//             |           |
		//---------------------------------------
		//             |   Inside  |
		// Left-Middle |    the    | Right-Middle
		//             | Rectangle |
		//---------------------------------------
		//             |           |
		// Down-Left   |Down-Middle| Down-Right
		//             |           |
		//________________________________________
		if(p.y()>=ymax) {
			if(p.x()>=xmin && p.x()<=xmax) { //Up-Middle
				return ((p.y()-ymax)*(p.y()-ymax));
			}
			else if(p.x()<xmin) { //Up-Left
				return ((p.y()-ymax)*(p.y()-ymax)+(xmin-p.x())*(xmin-p.x()));
			}
			else if(p.x()>xmax) { //Up-Right
				return ((p.y()-ymax)*(p.y()-ymax)+(p.x()-xmax)*(p.x()-xmax));
			}
			else {
				System.out.println("Failed to find distance between point and rectangle!");
				return 0;
			}
		}
		else if(p.y()<=ymin) {
			if(p.x()>=xmin && p.x()<=xmax) { //Down-Middle
				return ((ymin-p.y())*(ymin-p.y()));
			}
			else if(p.x()<xmin) { //Down-Left
				return (ymin-p.y())*(ymin-p.y())+(xmin-p.x())*(xmin-p.x());
			}
			else if(p.x()>xmax) { //Down-Right
				return ((ymin-p.y())*(ymin-p.y())+(p.x()-xmax)*(p.x()-xmax));
			}
			else {
				System.out.println("Failed to find distance between point and rectangle!");
				return 0;
			}
		}
		else {
			if(p.x()<=xmin) { //Left-Middle
				return ((xmin-p.x())*(xmin-p.x()));
			}
			else if(p.x()>=xmax) { //Right-Middle
				return ((p.x()-xmax)*(p.x()-xmax));
			}
			else { //Inside the rectangle
				//distance from bottom = p.x() - xmin
				//distance from top = xmax - p.x()
				//distance from left = p.y() - ymin
				//distance from right = ymax - p.y()
				if((p.x()-xmin)<=(xmax - p.x()) && (p.x()-xmin)<=(p.y() - ymin)  && (p.x() - xmin)<=(ymax - p.y())) {
					return (p.x() - xmin)*(p.x() - xmin);
				}
				else if((xmax - p.x())<=(p.x() - xmin) && (xmax - p.x())<=(p.y() - ymin) && (xmax - p.x())<=(ymax - p.y())) {
					return (xmax - p.x())*(xmax - p.x());
				}
				else if((p.y() - ymin)<=(p.x() - xmin) && (p.y() - ymin)<=(xmax - p.x()) && (p.y() - ymin)<=(ymax - p.y())) {
					return (p.y() - ymin)*(p.y() - ymin);
				}
				else {
				    return (ymax - p.y())*(ymax - p.y());
				}
			}
		}
	}
	
    public String toString() {
		return "["+xmin+","+xmax+"] x ["+ymin+","+ymax+"]";
	}
}