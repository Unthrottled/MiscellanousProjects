// NimModel.java
// Initial source code from Jeff Friesen's 6/21/2004 article
// Java Tech: An Intelligent Nim Computer Game, Part 2
// http://today.java.net/pub/a/today/2004/06/21/nim2.html
// Modified to separate model code to better support the MVC ideal
// Also to use resource subdirectories, nim package, ant build file
// M. Wainer, Jan 2007, Aug 2010
package nim;

public class NimModel {

    public static final char PLAYER_A = 'A';
    public static final char PLAYER_B = 'B';
    public static final int MAXNODES = 6;
    public static final int MAXDIFFICULTY = 3;
    private final static int MAXNIMJAS = 30;
    // Game tree root node reference. Modified during game play; reset if user
    // chooses to play again.
    private Node tempRoot;
    private Node gameTreeRoot;
    private int numNimjas;
    private int numNodes = 3;
    private int aiDifficulty = 3;    

    public NimModel(int nnimjas) {
        gameTreeRoot = buildGameTree(nnimjas, PLAYER_A);
        numNimjas = nnimjas;
        newGame();
    }

    public boolean gameOver() {
        return (tempRoot.nNimjas == 0);
    }
    

    public int getNumNimjas() {
        return numNimjas;
    }
    
    public int getNumNodes(){
    	return numNodes;
    }
    
	public int getMaxNimjas(){
		return MAXNIMJAS;
	}	

	
	public int getDifficulty(){
		return aiDifficulty;
	}
    
    public boolean setAiDiff(int diff){
    	if(diff > MAXDIFFICULTY)
    		return false;
    	aiDifficulty = diff;
    	return true;
    }
    
    public boolean setNumNimjas(int num){
    	if(num > MAXNIMJAS)
    		return false;
    	numNimjas = num;
        gameTreeRoot = buildGameTree(numNimjas, PLAYER_A);
        newGame();
    	return true;
    }
    
    public boolean setNumNodes(int nnodes){
    	if(nnodes > MAXNODES)
    		return false;
    	numNodes = nnodes;
        gameTreeRoot = buildGameTree(numNimjas, PLAYER_A);
        newGame();
    	return true;
    }

    public void playTurn(int nimjasToTake) {
    	if(nimjasToTake > MAXNODES)
    		return;
    	tempRoot = tempRoot.nodeList.get(nimjasToTake - 1);
    	return;
    }

    final public void newGame() {
        tempRoot = gameTreeRoot;
    }

    final public Node buildGameTree(int nnimjas, char player) {
        Node n = new Node();
        n.nNimjas = nnimjas;
        n.player = player;
        for(int i = 0; i < numNodes; i++){
        	if(nnimjas >= i + 1){
        		n.nodeList.add(buildGameTree(nnimjas - (i + 1),
        				(player == PLAYER_A) ? PLAYER_B : PLAYER_A));
        		n.nodeAdded();
        	}
        }
        return n;
    }

    public int computeMinimax(Node n) {
    	int ans = 0;
		if(n.nNimjas == 0)
			return (n.player == PLAYER_A) ? 1 : -1;
		for(int i = 0; i < n.nodeList.size(); i++){
			if (n.player == PLAYER_A){
				if(i == 0)
					ans = Math.max(-1, computeMinimax(n.nodeList.get(i)));
	    		for(int j = i + 1; j < n.nodeList.size(); j++){
	    			if(n.nodeList.get(j) != null){
	    				ans = Math.max(ans, computeMinimax(n.nodeList.get(j)));
	    			}
	    			else
	    				break;
	    		}
	    	}
	    	else{
	    		if(i == 0)
	    			ans = Math.min(1, computeMinimax(n.nodeList.get(i)));
	    		for(int j = i + 1; j < n.nodeList.size(); j++){
	    			if(n.nodeList.get(j) != null){
	    				ans = Math.min(ans, computeMinimax(
	    						n.nodeList.get(j)));
	    			}
	    			else
	    				break;
	    		}
	    	}
		}    	
        return ans;
    }

    public int takeBestMove() {
        // Use the minimax algorithm to determine if the
        // computer player's optimal move is the child node left
        // of the current root node, the child node below the
        // current root node, or the child node right of the
        // current root node.
    	int[] versions = new int[tempRoot.nodeList.size()];
    	int takenNimjas = -1;
    	boolean isOptimal = true;
    	for(int i = 0; i< tempRoot.nodeList.size(); i++){
    		if(i == 0)
    			versions[i] = computeMinimax(tempRoot.nodeList.get(i));
    		else
    			versions[i] = (i < versions.length) ?
    					computeMinimax(tempRoot.nodeList.get(i)) : 2;
    	}
    	
    	//Nerfed the AI when it is a Grasshopper, It just randomly takes nimjas
    	//but randomly choose when it isn't in end game.
    	for(int i = 0; i < tempRoot.nodeList.size() && aiDifficulty > 1; i++){
    		for(int j = 0; j < tempRoot.nodeList.size(); j++){
    			if(i != j){
	    			if(!(versions[i] < versions[j])){
	    				isOptimal = false;
	    				break;
	    			}
    			}
    		}
    		if(isOptimal){  
    			takenNimjas = i + 1;
    			tempRoot = tempRoot.nodeList.get(i);
    			break;
    		}
    		isOptimal = true;
    	}
    	if(takenNimjas == -1){
    		takenNimjas = (int) (Math.random() * versions.length) + 1;
    		tempRoot = tempRoot.nodeList.get(takenNimjas - 1);
    	}    	
        return takenNimjas;
    }    
  
}
