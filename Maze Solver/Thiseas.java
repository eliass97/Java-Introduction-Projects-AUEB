import java.io.*;
import java.util.*;

public class Thiseas {
	
	public static void main(String[] args){
		
		Scanner scan = null; //Creates scanner to read from the file
		boolean alert = false; //Will be used to make sure program will run fine
        boolean finished = false; //Will be used to stop the while loop when the exit is found
		boolean up,down,right,left; //Dirrections to move
		boolean Epos = false; //Will be used to confirm the position of E
	    boolean Efound = false; //Will be used to confirm the excistance of E
		int k; //Counts all the possible ways to move
		int l; //Counts all the non-visited possible ways to move
		int dir = 0; //Saves the direction of the previous move
		int poped; //Saves the poped int
		try {
			scan = new Scanner(new File(args[0])); //Reading file from cmd
		} catch (Exception e) {
            System.err.println("File not found.");
			alert = true;
        }
		if(alert == false){
		    int i = 0;
		    int j = 0;
		    int x = scan.nextInt(); //Reading x
		    int y = scan.nextInt(); //Reading y
		    int Ex = scan.nextInt(); //Reading x for E
		    int Ey = scan.nextInt(); //Reading y for E
			int ix = Ex; //Current position of x
			int iy = Ey; //Current position of y
            int[][] board = new int[x][y]; //Creating int array for the maze
		    board[Ex][Ey] = 2; //Putting 2 in the position of E at the array
		    String currentLine = scan.nextLine();
		    while (scan.hasNextLine() && alert==false) {
			    if(i==x){ //If the scanner started reading a line beyond the given X then stop the program
				    alert = true;
				    System.out.println("Error - Wrong parameter for X given.");
			    }
		        j = 0;
                currentLine = scan.nextLine();
                String words[] = currentLine.split(" "); //Creates a string with all the ints in the line
			    if(words.length>y){ //If the scanner started reading an int in column beyond the given Y then stop the program
				    alert = true;
				    System.out.println("Error - Wrong parameter for Y given.");
			    }
			    if(alert == false){ 
                    for(String str : words) { //For every int in the line
				        if(!str.equals("E")){
                            try {
                                board[i][j]= Integer.parseInt(str); //Saves the ints in the array
                            }catch(NumberFormatException nfe) {};
				        } else {
	                        Efound = true;
						    if(Ex != i || Ey!=j){ //Confirms the position of E
							    Epos = true;
						    }
					    }
				        System.out.print(board[i][j]+" "); //Prints the array
                        j++;
			        }
			    }
			    System.out.println();
			    i++;
            }
            if(Efound == false){ //Error for case: E was not found
			    System.out.println("Error - E was not found.");
		    } else if(Epos == true) { //Error for case: E was found in wrong position
			    System.out.println("Error - E was found in wrong position.");
		    } else if(Efound == true && Epos == false && alert == false) { //If everything is fine then the search for the exit begins
			    System.out.println("Maze is loaded and E was found. The E has been replaced with the number 2. Starting the search for exit:");
				StringStackImpl<Integer> stackx = new StringStackImpl<Integer>(); //Creates the stack for x
				StringStackImpl<Integer> stacky = new StringStackImpl<Integer>(); //Creates the stack for y
				stackx.push(ix);
				stacky.push(iy);
				k = 0;
				l = 0;
				while(finished != true){ //Searching the paths
				    k = 0;
					l = 0;
					down = false;
					up = false;
					left = false;
					right = false;
	                if((ix==x-1 || iy==y-1 || iy==0 || ix==0) && board[ix][iy]==0){ //If the exit is found
		                stackx.push(ix);
					    stacky.push(iy);
						board[ix][iy] = 3;
		                finished = true;
						k = 100;
	                }
	                if (ix >= 0 && iy >= 0 && ix < x  && iy < y && board[ix][iy] != 1 && finished == false) { //If it's still in the maze
                        if(ix!=x-1){ //Check down						
                            if(board[ix+1][iy]!=1){
							    k++;
								if(board[ix+1][iy]==0 || board[ix+1][iy]==2){
									l++;
									down = true;
								}
						    }
						}
						if(ix!=0){ //Check up
						    if(board[ix-1][iy]!=1){
							    k++;
								if(board[ix-1][iy]==0 || board[ix-1][iy]==2){
									l++;
									up = true;
								}
							}
						}
						if(iy!=y-1){ //Check right
						    if(board[ix][iy+1]!=1){
							    k++;
								if(board[ix][iy+1]==0 || board[ix][iy+1]==2){
									l++;
									right = true;
								}
						    }
						}
						if(iy!=0){ //Check left
						    if(board[ix][iy-1]!=1){
							    k++;
								if(board[ix][iy-1]==0 || board[ix][iy-1]==2){
									l++;
									left = true;
								}
						    }
						}
						if(l==0){ //If it's a deadend
							poped = stackx.pop();
							poped = stacky.pop();
							board[ix][iy] = 1;
							if(!stackx.isEmpty() && !stacky.isEmpty()){
							    ix = stackx.peek();
							    iy = stacky.peek();
							}
						} else if(l==1){ //If there's only 1 way to move
							board[ix][iy] = 3;
							if(up == true){ //Move up
								ix = ix - 1;
								dir = 1;
							} else if(down == true){ //Move down
								ix = ix + 1;
								dir = 2;
							} else if(left == true){ //Move left
								iy = iy - 1;
								dir = 3;
							} else { //Move right
								iy = iy + 1;
								dir = 4;
							}
							stackx.push(ix);
							stacky.push(iy);
						}
						if(l>1){ //If there are multiple ways to move
                            if(dir == 1){ //If previous direction was up
								board[ix][iy]=3;
							    if(up == true){ //Move up
								    ix = ix - 1;
									dir = 1;
							    } else if(left == true){ //Move left
								    iy = iy - 1;
									dir = 3;
							    } else if(right == true){ //Move right
								    iy = iy + 1;
									dir = 4;
							    } else { //Move down
								    ix = ix + 1;
									dir = 2;
							    }
								stackx.push(ix);
							    stacky.push(iy);
							} else if(dir == 2){ //If previous direction was down
								board[ix][iy]=3;
								if(down == true){ //Move down
								    ix = ix + 1;
									dir = 2;
							    } else if(left == true){ //Move left
								    iy = iy - 1;
									dir = 3;
							    } else if(right == true){ //Move right
								    iy = iy + 1;
									dir = 4;
							    } else { //Move up
								    ix = ix - 1;
									dir = 1;
							    }
								stackx.push(ix);
							    stacky.push(iy);
							} else if(dir == 3){ //If previous direction was left
								board[ix][iy]=3;
								if(left == true){ //Move left
								    iy = iy - 1;
									dir = 3;
							    } else if(up == true){ //Move up
								    ix = ix - 1;
									dir = 1;
							    } else if(down == true){ //Move down
								    ix = ix + 1;
									dir = 2;
							    } else { //Move right
								    iy = iy + 1;
									dir = 4;
							    }
								stackx.push(ix);
							    stacky.push(iy);
							} else { //If previous direction was right
								board[ix][iy]=3;
								if(right == true){ //Move right
								    iy = iy + 1;
									dir = 4;
							    } else if(up == true){ //Move up
								    ix = ix - 1;
									dir = 1;
							    } else if(down == true){ //Move down
								    ix = ix + 1;
									dir = 2;
							    } else { //Move left
								    iy = iy - 1;
									dir = 3;
							    }
								stackx.push(ix);
							    stacky.push(iy);
							}
						}
						if(k==0){ //If there's nothing possible to do
							finished = true;
						}
	                }
                }
				if (k != 0){ 
                    System.out.println("Exit found: ("+stackx.peek()+","+stacky.peek()+")"); //Exit was found
		        } else {
	                System.out.println("No exit was found."); //Exit wasn't found
		        }
	        }
        }
	}
}