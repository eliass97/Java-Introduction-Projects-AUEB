//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

import java.io.*;
import java.util.*;

public class TwoDTree {
	
	protected int size;
	protected Node root;
	
	static class Node {
        public Node leftChild, rightChild, parent;
        public Point key;
        
        protected Node(Point key) {
            if (key == null) throw new IllegalArgumentException();
            this.key = key;
        }
    }
	
    public TwoDTree() {
		size = 0;
	}
	
    public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
    public int size() {
		return size;
	}
	
    public void insert(Point p) { //Use search to check if the point already exists in the tree before using this method
		Node newNode = new Node(p); //Create a node with the point
		if(root == null) { //If there's no root then the newNode will be the root
			root = newNode; //Insert the point to the root
			size++; //Increase the size of the tree
		}
		else { //If there's already a root
			int i = 1; //Counter - If iMOD2=1 then we rely on x else on y to compare
			Node current = root; //Start from the root
			Node parent;
			while(true) {
				parent = current;
				if(i%2 == 1) { //Rely on x to compare
					if(p.x() < current.key.x()) { //If its smaller then go left
						current = current.leftChild; //Use the left child as currentNode
						if(current == null) { //If its null then return to previous situation and break
							parent.leftChild = newNode; //Set the point to node
							size++; //Increase the size of the tree
							return;
						}
					}
					else { //else go right
						current = current.rightChild; //Use the right child as currentNode
						if(current == null) { //If its null then return to previous situation and break
							parent.rightChild = newNode; //Set the point to node
							size++; //Increase the size of the tree
							return;
						}
					}
				}
				else { //Rely on y to compare
					if(p.y() < current.key.y()) { //If its smaller then go left
						current = current.leftChild; //Use the left child as currentNode
						if(current == null) { //If its null then return to previous situation and break
							parent.leftChild = newNode; //Set the point to node
							size++; //Increase the size of the tree
							return;
						}
					}
					else { //else go right
						current = current.rightChild; //Use the right child as currentNode
						if(current == null) { //If its null then return to previous situation and break
							parent.rightChild = newNode; //Set the point to node
							size++; //Increase the size of the tree
							return;
						}
					}
				}
				i++; //Increase the counter - If we relied on x now we will have to rely on y and if we relied on y now we have to rely on x to compare
			}
		}
	}
	
    public boolean search(Point p) {
		boolean contain = false; //boolean for return
		if(root != null) {
			if(p.x() == root.key.x() && p.y() == root.key.y()) {
			    contain = true;
		    }
		}
		Node current = root; //Start from the root of the tree
		int i = 1; //Counter - Used at the same way we used the counter at insert method
        while (current != null && contain != true) { //While we havent reached the end of the tree
			if(i%2 == 1) { //Rely on x to compare
			    if(p.x() < current.key.x()) { //Smaller = go left
				    current = current.leftChild;
			    }
			    else if(p.x() > current.key.x()) { //Bigger = go right
				    current = current.rightChild;
			    }
			    else {
				    if(p.y() == current.key.y()) { //Equal = check if they have equal y
					    contain = true; //found
				    }
					else {
						current = current.rightChild; //else go right
					}
			    }
			}
			else { //Rely on y to compare
				if(p.y() < current.key.y()) { //Smaller = go left
				    current = current.leftChild;
			    }
			    else if(p.y() > current.key.y()) { //Bigger = go right
				    current = current.rightChild;
			    }
			    else {
				    if(p.x() == current.key.x()) { //Equal = check if they have equal x
					    contain = true; //found
				    }
					else {
						current = current.rightChild; //else go right
					}
			    }
			}
			i++; //Increase the counter
        }
        return contain; //Return the boolean
	}
	
	private Point nearestNeighbor(Point p, Point pNear, Node current, Rectangle rectLeft, Rectangle rectRight, int i) { //Private recursive method for nearestNeighbor
		boolean left = true; //Left route
		boolean right = true; //Right route
		Point p1 = null; //Temporary point 1
		Point p2 = null; //Temporary point 2
		if(i%2 == 1) { //Rely on x
			rectLeft = new Rectangle(rectLeft.xmin(),rectLeft.ymin(),current.key.x(),rectLeft.ymax()); //Change xmax
			rectRight = new Rectangle(current.key.x(),rectRight.ymin(),rectRight.xmax(),rectRight.ymax()); //Change xmin
			if(p.squareDistanceTo(pNear) < rectLeft.squareDistanceTo(p)) { //Check if we can go to the left
			    left = false;
		    }
		    if(p.squareDistanceTo(pNear) < rectRight.squareDistanceTo(p)) { //Check if we can go to the right
			    right = false;
		    }
			if(left == false && right == false) { //If both routes are not available return the pNear
				return pNear;
			} else { //Else increase the counter and try both routes
				i++;
				if(left == true) { //Try to go left
					if(current.leftChild != null) {
					    if(p.squareDistanceTo(pNear) > p.squareDistanceTo(current.leftChild.key)) {
							pNear = current.leftChild.key; //Renew pNear if possible
						}
						p1 = nearestNeighbor(p, pNear, current.leftChild, rectLeft, rectLeft, i); //pNear found on left route
					}
				}
				if(right == true) { //Try to go right
					if(current.rightChild != null) {
						if(p.squareDistanceTo(pNear) > p.squareDistanceTo(current.rightChild.key)) {
							pNear = current.rightChild.key; //Renew pNear if possible
						}
						p2 = nearestNeighbor(p, pNear, current.rightChild, rectRight, rectRight, i); //pNear found on right route
					}
				}
				//Find which one to use as final pNear for the return
				if(p1 == null && p2 != null) {
					if(p2.squareDistanceTo(p) <= pNear.squareDistanceTo(p)) {
						return p2;
					} else {
						return pNear;
					}
				} else if(p1 != null && p2 == null) {
					if(p1.squareDistanceTo(p) <= pNear.squareDistanceTo(p)) {
						return p1;
					} else {
						return pNear;
					}
				} else if(p1 == null && p2 == null) {
					return pNear;
				} else {
					if(p2.squareDistanceTo(p) >= p1.squareDistanceTo(p)) {
						if(p1.squareDistanceTo(p) <= pNear.squareDistanceTo(p)) {
							return p1;
						} else {
							return pNear;
						}
					} else {
						if(p2.squareDistanceTo(p) <= pNear.squareDistanceTo(p)) {
							return p2;
						} else {
							return pNear;
						}
					}
				}
			}
		} else { //Rely on y
			rectLeft = new Rectangle(rectLeft.xmin(),rectLeft.ymin(),rectLeft.xmax(),current.key.y()); //Change ymax
			rectRight = new Rectangle(rectRight.xmin(),current.key.y(),rectRight.xmax(),rectRight.ymax()); //Change ymin
			if(p.squareDistanceTo(pNear) < rectLeft.squareDistanceTo(p)) { //Check if left route is available
			    left = false;
		    }
		    if(p.squareDistanceTo(pNear) < rectRight.squareDistanceTo(p)) { //Check if right route is available
			    right = false;
		    }
			if(left == false && right == false) { //If both are blocked then return the pNear
				return pNear;
			} else { //Else increase the counter and try both routes
				i++;
				if(left == true) { //Try to go left
					if(current.leftChild != null) {
					    if(p.squareDistanceTo(pNear) > p.squareDistanceTo(current.leftChild.key)) {
							pNear = current.leftChild.key; //Renew pNear if possible
						}
						p1 = nearestNeighbor(p, pNear, current.leftChild, rectLeft, rectLeft, i); //pNear found on left route
					}
				}
				if(right == true) { //Try to go right
					if(current.rightChild != null) {
						if(p.squareDistanceTo(pNear) > p.squareDistanceTo(current.rightChild.key)) {
							pNear = current.rightChild.key; //Renew pNear if possible
						}
						p2 = nearestNeighbor(p, pNear, current.rightChild, rectRight, rectRight, i); //pNear found on right route
					}
				}
				//Find which one to use as final pNear for the return
				if(p1 == null && p2 != null) {
					if(p2.squareDistanceTo(p) <= pNear.squareDistanceTo(p)) {
						return p2;
					} else {
						return pNear;
					}
				} else if(p1 != null && p2 == null) {
					if(p1.squareDistanceTo(p) <= pNear.squareDistanceTo(p)) {
						return p1;
					} else {
						return pNear;
					}
				} else if(p1 == null && p2 == null) {
					return pNear;
				} else {
					if(p2.squareDistanceTo(p) >= p1.squareDistanceTo(p)) {
						if(p1.squareDistanceTo(p) <= pNear.squareDistanceTo(p)) {
							return p1;
						} else {
							return pNear;
						}
					} else {
						if(p2.squareDistanceTo(p) <= pNear.squareDistanceTo(p)) {
							return p2;
						} else {
							return pNear;
						}
					}
				}
			}
		}
	}
	
    public Point nearestNeighbor(Point p) {
		Rectangle rectL = new Rectangle(0,0,100,100); //Rectangle that corrensponds to the root
		Rectangle rectR = new Rectangle(0,0,100,100); //Rectangle that corrensponds to the root
        return nearestNeighbor(p, root.key, root, rectL, rectR, 1); //Call the recursive method
	}
	
	private List rangeSearch(Rectangle rect, Node current, Rectangle rectLeft, Rectangle rectRight, List list, int i) { //Private recursive method for rangeSearch
		if(current != null) { //If its null then simply return the list
			boolean left = false; //Left route
			boolean right = false; //Right route
			if(rect.contains(current.key)) { //Check if the current key belongs in the rectangle 
				list.insertAtFront(current.key);
			}
			if(i%2 == 1) { //Rely on x
				rectLeft = new Rectangle(rectLeft.xmin(),rectLeft.ymin(),current.key.x(),rectLeft.xmax()); //Change xmax
			    rectRight = new Rectangle(current.key.x(),rectRight.ymin(),rectRight.xmax(),rectRight.ymax()); //Change xmin
				if(rect.intersects(rectLeft)) { //Check if left route is available
				    left = true;
			    }
			    if(rect.intersects(rectRight)) { //Chack if right route is available
				    right = true;
			    }
				if(left == false && right == false) { //If we can't go neither left nor right then return the list
					return list;
				} else { //Else increase the counter and try both routes
					i++;
					if(current.leftChild != null && left == true) { //Try to go left
						list = rangeSearch(rect,current.leftChild,rectLeft,rectLeft,list,i);
					}
					if(current.rightChild != null && right == true) { //Try to go right
					    list = rangeSearch(rect,current.rightChild,rectRight,rectRight,list,i);
					}
					return list; //Return the result
				}
			} else { //Rely on y
				rectLeft = new Rectangle(rectLeft.xmin(),rectLeft.ymin(),rectLeft.xmax(),current.key.y()); //Change ymin
				rectRight = new Rectangle(rectRight.xmin(),current.key.y(),rectRight.xmax(),rectRight.ymax()); //Change ymax
				if(rect.intersects(rectLeft)) { //Check if left route is available
				    left = true;
			    }
			    if(rect.intersects(rectRight)) { //Check if right route is available
				    right = true;
			    }
				if(left == false && right == false) { //If we can't go neither left nor right then return the list
					return list;
				} else { //Else increase the counter and try both routes
					i++;
					if(current.leftChild != null && left == true) { //Try to go left
						list = rangeSearch(rect,current.leftChild,rectLeft,rectLeft,list,i);
				    }
					if(current.rightChild != null && right == true) { //Try to go right
					    list = rangeSearch(rect,current.rightChild,rectRight,rectRight,list,i);
				    }
					return list; //Return the result
				}
			}
		} else {
			return list; //Return the list
		}
	}
	
    public List rangeSearch(Rectangle rect) {
		List list = new List(); //The list for the points
		if(root != null) {
			Rectangle rectl = new Rectangle(0,0,100,100); //Rectangle that corrensponds to the root
		    Rectangle rectr = new Rectangle(0,0,100,100); //Rectangle that corrensponds to the root
			return rangeSearch(rect,root,rectl,rectr,list,1); //Call the recursive method
		}
		return list; //If the root is null then return an empty list
	}
	
	public static void main(String args[]) {
		Scanner str = new Scanner(System.in); //Scanner to read the keyboard inputs
		System.out.print("Enter filename: ");
		String filename = str.nextLine(); //Read filename
		System.out.println();
		boolean alert = false;
		Point p; //Temporary point
		Rectangle rect; //Temporary rectangle (in case ans == 1)
		List list = new List(); //Temporary list (in case ans == 1)
		String currentLine;
		Scanner scan = null;
		int size = 0; //Tree size
	    try	{
		    File f = new File(filename);
			try {
			    scan = new Scanner(f);
			}
			catch (FileNotFoundException e) {
				System.err.println ("Failed to open file for reading!");
			    alert = true;
			}
	    }
	    catch (NullPointerException e) {
		    System.err.println ("Failed to open file for reading!");
			alert = true;
	    }
		size = scan.nextInt(); //Read the size of the tree
		TwoDTree tree = new TwoDTree(); //Initiate the tree
		int i = 0; //Counter
		currentLine = scan.nextLine(); //Change line
	    while (scan.hasNextLine() && alert != true) { //For the amount of lines equal to the size given and as long we have no problem
			currentLine = scan.nextLine();
            String words[] = currentLine.split(" ");
	        if(words.length != 2){ //If the line contains more than 2 words
			    alert = true;
			    System.err.println("Each line must have a word for X and a word for Y! Please restart the program!");
		    }
			System.out.println("("+words[0]+","+words[1]+")");
		    if(Integer.parseInt(words[0]) > 100 || Integer.parseInt(words[0]) < 0 || Integer.parseInt(words[1]) > 100 || Integer.parseInt(words[1]) < 0) { //Check for limits
			    alert = true;
			    System.err.println("Lower limit is 0 and upper limit is 100! Please restart the program!");
		    }
			p = new Point(Integer.parseInt(words[0]),Integer.parseInt(words[1])); //Create the point
			if(tree.search(p)) { //If the point already exists in the tree
				alert = true;
				System.err.println("A point is being repeated in the line "+(i+2));
			}
		    if(alert != true){ //If everything is fine then insert the point in the tree
			    tree.insert(p); //Insert it in the tree
		    }
			i++; //Increase counter
        }
		System.out.println();
		if(size != i && alert != true) { //If we have more lines in the file then the size is wrong
			alert = true;
			System.out.println("There has been a problem with the size of the tree!\nPlease check the input file one more time and restart the program!");
		}
		if(alert != true && !tree.isEmpty()) { //If everything is ok so far
			int ans = 0; //User's answer
			while(ans != 1 && ans != 2 && ans != 3) { //Prints options
				System.out.println("Enter '1' to insert a query rectangle.");
				System.out.println("Enter '2' to insert a query point.");
				System.out.println("Enter '3' to shut down the program.");
				System.out.print("Answer: ");
				ans = str.nextInt(); //Read the answer
				System.out.println();
			}
			if(ans == 1) { //For inserting a query rectangle
				System.out.print("Enter xmin: ");
				int xmin = str.nextInt(); //Read xmin
				System.out.println();
				System.out.print("Enter xmax: ");
				int xmax = str.nextInt(); //Read xmax
				System.out.println();
				System.out.print("Enter ymin: ");
				int ymin = str.nextInt(); //Read ymin
				System.out.println();
				System.out.print("Enter ymax: ");
				int ymax = str.nextInt(); //Read ymax
				System.out.println();
				rect = new Rectangle(xmin,ymin,xmax,ymax); //Create rectangle with the given inputs
				if(rect.xmin() != -1 && rect.xmax() != -1 && rect.ymin() != -1 && rect.ymax() != -1) {
					list = tree.rangeSearch(rect); //Use rangeSearch
				    list.print(); //Print the list
				}
			}
			else if(ans == 2) { //For inserting a query point
				System.out.print("Enter X: ");
				int x = str.nextInt(); //Read x
				System.out.println();
				System.out.print("Enter Y: ");
				int y = str.nextInt(); //Read y
				System.out.println();
				p = new Point(x,y); //Create a point with the given inputs
				if(p.x() != -1 && p.y() != -1) {
					boolean dontGo = tree.search(p); //If there's such point in the tree
				    if(dontGo == true) {
					    System.out.println("The specific point exists in the tree!");
				    }
				    else {
					    Point result = tree.nearestNeighbor(p); //Use nearestNeighbor
				        double dista = result.distanceTo(p); //The distance to the point
					    System.out.println("Found: "+result.toString()+"  Distance: "+dista); //Print the point and it's distance
				    }
				}
			}
			else { //Exit
				System.out.println("Bye.");
			}
		}
	}
}