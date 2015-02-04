/**
 * 	Alex Simons Siu 851287084
 * 	CS 220 
 *	Lab 4
 */


public class Maze {

  /* Task 1. create constant integers (private static final int) EMPTY, WALL, VISITED, PLAYER, 
   * and GOAL with values 0, 1, 2, 3 and 4 respectively
   */
   private static final int EMPTY = 0;
   private static final int WALL = 1;
   private static final int VISITED = 2;
   private static final int PLAYER = 3;
   private static final int GOAL = 4;
    
   
  

  //two-dimensional array and constants 
	private int rows;
	private int columns;
	private int squares[][];
	
	/* two integers for the current row and column of the player, 
	 * and two integers for the row and column of the goal
	 */
   private int currentRow, currentCol;
   private int goalRow, goalCol;
  
  //The maze constructor
	public Maze(int [][] maze, int startRow, int startCol, int goalR, int goalC)
	{
		squares = maze;
		rows = squares.length;
		columns = squares[0].length;

		// Convert any non zero values to walls, zeros will be empty
		for(int r = 0; r< rows; r++){
			for(int c = 0; c<columns; c++)
				if(squares[r][c] != 0){
					squares[r][c] = WALL;}
				else
					squares[r][c] = EMPTY;
		}
		//set the player at the start
        squares[startRow][startCol] = PLAYER;        
                
        //set the starting position as the current position 
       currentRow = startRow;
       currentCol = startCol;
                         
       //Task 4. set the goal position           
       goalRow = goalR;
       goalCol = goalC;
       squares[goalRow][goalCol] = GOAL;  
       
                

	}
  public int getCurrentRow(){
	  return currentRow;
  }
  public int getCurrentCol(){
	  return currentCol;
  }
  //Task 5. Create an isSolved method that returns true if the player is at the position of the goal, false if not      
  public boolean isSolved() {
	  boolean isSolved = false;
	  if(isGoal(currentRow,currentCol)){
		  isSolved = true;
	  }
	  return isSolved;            
  }
        
  //Task 6. Create an isLegal method for checking if the given position is legal (not out-of-bounds of the array)      
	private boolean isLegal(int r, int c)
	{
		boolean legal = true;
		if(((r>squares.length)||(r<0))||((c>squares[0].length)||(c<0))){
			legal = false;
		}
		return legal;
	}

  //Task 7. Create an isGoal method for checking if the position is the goal
	private boolean isGoal(int r, int c)
	{
      return (r==goalRow)&&(c==goalCol);		

	}

  //Task 8. Create an isFree method for checking if the position is valid.
	private boolean isFree(int r, int c)
	{
		boolean free = false;
		if(this.isLegal(r,c)){
		int space = squares[r][c];
		if((space != WALL)&&(space != VISITED)){
			free = true;
		}
		}
		return free;
		
	}

  /* Task 9.
	 * Create a display method that prints a representation of the state of the
	 * maze to standard input Print out an ¡°X¡± for a wall square, a blank for
	 * an empty square or the goal square, an ¡°o¡± for the player position, and
	 * a ¡°*¡± for a visited square
	 */

	public void display()
	{
		 for(int i = 0; i<squares.length; i++){
			 for(int j = 0;j<squares[i].length; j++){
				 if(squares[i][j]==WALL)//if the space is a wall it prints a X
				 {
					 System.out.print("X");
				 }
				 else if(squares[i][j]==VISITED)//if the space is a visited space it prints a *
				 {
					 System.out.print("*");
				 }
				 else if(squares[i][j]==PLAYER)//if the space is the player it prints a o
				 {
					 System.out.print("o");
				 }
				 else if(squares[i][j]==GOAL)//if the space is the goal prints a G
				 {
					 System.out.print("G");
				 }
				 
				 else//if it isn't the above it prints a empty space
				 {
					 System.out.print(" ");
				 }
			 }
			 System.out.println();//new line for the new row
		 }
	}
  
  /* Task 10. Create a makeMove method that accepts a string of the player¡¯s 
   * choice of position, The string should either be a ¡°u,¡± ¡°d,¡± ¡°l¡± or ¡°r¡± 
   * for up, down, left and right, respectively. It should move the player 
   * to the specified square if it is a valid move (not going off the edge
   * of the maze) and is not a wall.  It should return true if it was able
   * to move the player, false if not
   */
      
	public boolean makeMove(String selection)
	{
      boolean move = false;
      String up = "u";
      String down = "d";
      String left = "l";
            
      if(selection.equals(up)){
    	  move = isFree(currentRow-1,currentCol);
    	  if(move){
    		  squares[currentRow][currentCol]=VISITED;
    		  currentRow = currentRow -1;
    		  squares[currentRow][currentCol]=PLAYER;
    	  }
      }
      else if(selection.equals(down)){
    	  move = isFree(currentRow+1,currentCol);
    	  if(move){
    		  squares[currentRow][currentCol]=VISITED;
    		  currentRow = currentRow+1;
    		  squares[currentRow][currentCol]=PLAYER;
    	  }
      }
      else if(selection.equals(left)){
    	  move = isFree(currentRow,currentCol-1);
    	  if(move){
    		  squares[currentRow][currentCol]=VISITED;
    		  currentCol = currentCol -1;
    		  squares[currentRow][currentCol]=PLAYER;
    	  }
      }
      else{
    	  move = isFree(currentRow,currentCol+1);
    	  if(move){
    		  squares[currentRow][currentCol]=VISITED;
    		  currentCol = currentCol+1;
    		  squares[currentRow][currentCol]=PLAYER;
    	  }
      }
      return move;
	}

  /* Task 11: A recursive method solveMaze, returns true if the maze can be 
   * solved, false if not. If the player is not at the goal, it should mark 
   * its current position as visited. Recursively call the solveMaze() method 
   * for each direction it can move into an unvisited square. If there is no 
   * unvisited squares it can move into, it should return false. If a square 
   * is along the found path to the goal, it should mark its square as a path 
   * square. (Note: if the recursive call is along the path, its recursive 
   * call will return true).
   */

	public boolean solveMaze(int r, int c)
	{
     boolean solve = false;
     if(isGoal(r,c)){
    	 squares[r][c]=PLAYER;
    	 solve = true;    	 
     }
     else{
    	 if(isFree(r,c)){ 
    		 squares[r][c]=VISITED;
    		 if(solveMaze(r,c+1)){    			 
    			 return true;
    		 }
    		 else if(solveMaze(r,c-1)){
    			  return true;
    		 }
    		 else if(solveMaze(r-1,c)){
    			 return true;
    		 }
    		 else{
    			 if(solveMaze(r+1,c)){
    				 
    				 return true;
    			 }
    		 }
    	 }
    	 
     }
     if(squares[r][c]==VISITED){
     squares[r][c]=EMPTY;}
     return solve;
	}
        
}
