package nim;

import java.util.ArrayList;

public class Node
{
	   int nNimjas; // Number of matches remaining after a move to this Node
	                 // from the parent Node.
	   int nNodes = 0;
	   char player;  // Game configuration from which player (A - player A, B -
	                 // player B) makes a move.

	   ArrayList<Node> nodeList = new ArrayList<Node>();
	   
	   public void nodeAdded(){
		   nNodes++;
		   return;
	   }

}