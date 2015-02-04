// NimPanel.java
// Initial source code from Jeff Friesen's 6/21/2004 article
// Java Tech: An Intelligent Nim Computer Game, Part 2
// http://today.java.net/pub/a/today/2004/06/21/nim2.html
// Modified to separate model code to better support MVC ideal
// also to use resource subdirectories, nim package, ant build file
// M. Wainer, Jan 2007, Aug 2010

package nim;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;


import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NimPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final static int MAXPLAYERS = 2;
	// Total number of Match objects.	
	// Array of references to NMATCHES Match objects.
	private Nimja[] nimjas;
	private int nNimjas = 10;
	// Height and width of this panel component, extracted from preferred size.
	private int height, width;
	// Preferred size of this panel component, returns from getPreferredSize().
	private Dimension preferredSize = new Dimension(1015, 685);
	// Drag origin. Used to create a relative displacement during dragging, so
	// that each selected onscreen match moves the same relative amount.
	private int dragx, dragy;
	// Index of previously selected onscreen match (when mouse button pressed).
	// Useful for deselecting that onscreen match.
	private int prev = -1;
	// Icon of logo image, and the image's width and height.
	/**
	 * private ImageIcon logo;	
	 * private int logow, logoh;
	*/
	// Icon of match-pile image, and the image's width and height.
	private ImageIcon dojo;
	private int dojoWidth, dojoHeigth;
	
	private ImageIcon backGround;
	// Method continueGame() displays a dialog box, which requires a reference
	// to the enclosing frame window.
	private JFrame enclosingFrame;
	private final static File DROP_SOUND = new File("sounds/drop.wav");
	NimModel model;
	private int playerCount = 1;
	private int player = 1;
	
	private int nimjaRowCount = 6;
	private int nimjaYOffset = 50;
	private int nimjaXOffset = 23;
	private int nimjaRowSpacing = 30;
	private int nimjaRowHeightSpacing = 20;
	private int  dojoX = 580, dojoY = 150;	

	public NimPanel(JFrame enclosingFrame) {
		// Create game tree with an initial pile of NMATCHES matches. Player A
		// (the human player) goes first.
		model = new NimModel(nNimjas);
		model.newGame();
		// Save enclosingFrame for later use in continueGame().
		this.enclosingFrame = enclosingFrame;
		buildGUI(); // buildGUI() - one time GUI initiailizations
	}

	private MouseMotionAdapter makeMouseMotionListener() {
		MouseMotionAdapter mma;
		mma = new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// Return if no onscreen matches selected. (Cannot drag
				// what hasn't been selected.)
				if (Nimja.getNumSelected() == 0)
					return;
				// Get mouse pointer coordinates.
				int x = e.getX();
				int y = e.getY();
				// For each selected onscreen match, calculate its new
				// origin and determine if it lies completely on the
				// screen. If even one selected onscreen match is not
				// entirely onscreen, don't move any of them.
				for (int i = 0; i < nNimjas; i++)
					if (nimjas[i].isSelected()) {
						Nimja m = nimjas[i];
						int ox = m.getOriginX();
						int oy = m.getOriginY();
						if (ox + x - dragx < 0 || oy + y - dragy < 0
								|| ox + x - dragx + Nimja.NIMJAWIDTH >= width
								|| oy + y - dragy + Nimja.NIMJAHEIGTH >= height)
							return;
					}
				// Move each selected onscreen match.
				for (int i = 0; i < nNimjas; i++)
					if (nimjas[i].isSelected()) {
						Nimja m = nimjas[i];
						int ox = m.getOriginX();
						int oy = m.getOriginY();
						nimjas[i].setOrigin(ox + x - dragx, oy + y - dragy);
					}
				// Establish new drag origin.
				dragx = x;
				dragy = y;
				// Reorder Matches so that selected Matches appear first.
				reorder();
				// Redraw this component so that selected onscreen match is
				// highlighted.
				repaint();
			}
		};
		return mma;
	}

	private MouseAdapter makeMouseListener() {
		MouseAdapter ma;
		ma = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// Get mouse pointer coordinates.
				int x = e.getX();
				int y = e.getY();
				// Establish new drag origin.
				dragx = x;
				dragy = y;
				// Search array of Match objects for first object whose
				// nondropped onscreen image lies below the mouse pointer
				// when mouse button pressed. (NOTE: The search begins with
				// Matches that may overlap other Matches.)
				for (int i = 0; i < nNimjas; i++)
					if (nimjas[i].contains(x, y) && !nimjas[i].isDropped()) {
						// If Match was previously selected, return. There
						// is no point in selecting the Match.
						if (nimjas[i].isSelected()){
							//nimjas[i].setSelected(false, player);
							//repaint();							
							return;
						}
						// Find out if Shift key pressed.
						int m = e.getModifiers();
						if ((m & InputEvent.SHIFT_MASK) != 0) {
							// Shift pressed. If three Matches already
							// selected, deselect previous (i.e., most
							// recently selected) Match.
							if (Nimja.getNumSelected() == model.getNumNodes())
								nimjas[prev].setSelected(false, player);
						} else {
							// Shift not pressed. If there was a
							// previously selected Match, deselect it.
							if (prev != -1)
								nimjas[prev].setSelected(false, player);
						}
						// Select found Match and make it most recently
						// selected Match.
						nimjas[i].setSelected(true, player);
						prev = i;
						// Reorder Matches so that selected Matches appear
						// first.
						reorder();
						// Redraw component so that selected onscreen match
						// is highlighted.
						repaint();
						// Terminate loop.
						break;
					}
			}

			public void mouseReleased(MouseEvent e) {
				// Find out if Shift key pressed. If so, don't deselect
				// onscreen matches.
				int m = e.getModifiers();
				if ((m & InputEvent.SHIFT_MASK) != 0)
					return;
				// As long as at least one onscreen match was selected, the
				// potential exists to deselect.
				if (Nimja.getNumSelected() != 0) {
					// Find out if at least one selected onscreen match is
					// over drop target. If so, drop all onscreen matches.
					boolean droppable = false;
					for (int i = 0; i < nNimjas; i++)
						//Where drop zone is determined
						if (nimjas[i].isSelected() && isInDropZone(nimjas[i])) {
							droppable = true;
							break;
						}
					if (!droppable)
						return;					
					// Based on number of selected onscreen matches, move to
					// appropriate game tree node.
					// User has indicated a move - pass on to model
					model.playTurn(Nimja.getNumSelected());
					// Drop all selected onscreen matches.
					for (int i = 0; i < nNimjas; i++)
						if (nimjas[i].isSelected()) {
							nimjas[i].setSelected(false, player);
							nimjas[i].setDropped(true);
						}
					// Redraw component so that dropped onscreen matches do
					// not appear.
					repaint();
					// Play drop sound (if available).
					playSound(DROP_SOUND);
					// If a leaf node is reached, the computer player has
					// won the game. Inform user and ask if user wants a new
					// game. If not, exit. Otherwise, reset game and return,
					// for a new game.
					if(isEndGame())
						return;
					setPlayer();
					if(playerCount > 1)					
						return;	
					runNimAI();
					// Redraw component so that dropped onscreen matches do
					// not appear.
					repaint();					
					// If a leaf node is reached, the human player has won
					// the game. Inform user and ask if user wants a new
					// game. If not, exit. Otherwise, reset game and return,
					// for a new game.
					if(isEndGame())
						return;
					setPlayer();
				}
			}

		};
		return ma;
	}

	public void buildGUI() {
		backGround = new ImageIcon("images/background.png");
		// Obtain the size of this component. The entire component is used as a
		// drawing surface.
		width = preferredSize.width;
		height = preferredSize.height;
		dojo = new ImageIcon("images/dojo.png");
		dojoWidth = dojo.getImage().getWidth(this);
		dojoHeigth = dojo.getImage().getHeight(this);	
		nimjas = new Nimja[nNimjas];
		setNimjas();
		// Attach a mouse listener to the component. That listener listens for
		// mouse button pressed and mouse button released events.
		MouseAdapter ma = makeMouseListener();
		addMouseListener(ma);
		// Attach a mouse motion listener to the component. That listener
		// listens for mouse dragged events.
		MouseMotionAdapter mma = makeMouseMotionListener();
		addMouseMotionListener(mma);
	}
	
	public void setPlayerCount(int count){
		playerCount = count;
	}

	private boolean continueGame(String message) {
		if (JOptionPane.showConfirmDialog(enclosingFrame, message, "Nimjas",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backGround.getImage(),0,0,this);
		g.drawImage(dojo.getImage(), dojoX, dojoY, this);
		for (int i = nNimjas - 1; i >= 0; i--)
			if (!nimjas[i].isDropped())
				nimjas[i].draw(g, this);
	}

	private void playSound(File file) {
		try {
			// Get an AudioInputStream from the specified file (which must be a
			// valid audio file, otherwise an UnsupportedAudioFileException
			// object is thrown).
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			// Get the AudioFormat for the sound data in the AudioInputStream.
			AudioFormat af = ais.getFormat();
			// Create a DataLine.Info object that describes the format for data
			// to be output over a Line.
			DataLine.Info dli = new DataLine.Info(SourceDataLine.class, af);
			// Do any installed Mixers support the Line? If not, we cannot play
			// a sound file.
			if (AudioSystem.isLineSupported(dli)) {
				// Obtain matching Line as a SourceDataLine (a Line to which
				// sound data may be written).
				SourceDataLine sdl = (SourceDataLine) AudioSystem.getLine(dli);
				// Acquire system resources and make the SourceDataLine
				// operational.
				sdl.open(af);
				// Initiate output over the SourceDataLine.
				sdl.start();
				// Size and create buffer for holding bytes read and written.
				int frameSize = af.getFrameSize();
				int bufferLenInFrames = sdl.getBufferSize() / 8;
				int bufferLenInBytes = bufferLenInFrames * frameSize;
				byte[] buffer = new byte[bufferLenInBytes];
				// Read data from the AudioInputStream into the buffer and then
				// copy that buffer's contents to the SourceDataLine.
				int numBytesRead;
				while ((numBytesRead = ais.read(buffer)) != -1)
					sdl.write(buffer, 0, numBytesRead);
			}
		} catch (LineUnavailableException e) {
		} catch (UnsupportedAudioFileException e) {
		} catch (IOException e) {
		}
	}

	private void reorder() {		
		int[] indices = new int[model.getNumNodes()];
		int j = 0;
		Nimja temp;
		for(int i = 0; i < indices.length; i++)
			indices[i] = -1;
		for(int i = 0; i < nNimjas; i++)
				if(nimjas[i].isSelected())
					indices[j++] = i;
		for(int i = 0; i < indices.length; i++){
			if(indices[i] != -1){
				temp = nimjas[i];
				nimjas[i] = nimjas[indices[i]];
				nimjas[indices[i]] = temp;
			}
			else
				break;
		}
		for(int i = 0; i < indices.length; i++){
			if(prev == indices[i]){
				prev = i;
				break;
			}
		}
		
	}

	private void resetGUIforNewGame() {
		for (int i = 0; i < nNimjas; i++) {
			if (nimjas[i].isSelected())
				nimjas[i].setSelected(false, player);
			if (nimjas[i].isDropped())
				nimjas[i].setDropped(false);
			setNimjas();
		}
		repaint();
	}

	// Used to determine if the chosen Nimja is within the drop zone, aka the
	// dojo picture where the user is
	// supposed to drop the nimja.
	private boolean isInDropZone(Nimja nimjaWarrior) {
		if (nimjaWarrior.getOriginX() + nimjaWarrior.getNimjaWidth() < dojoX)
			return false;// too far to the left of the dojo
		if (nimjaWarrior.getOriginX() > dojoX + dojoWidth)
			return false;// too far to the right of the dojo
		if (nimjaWarrior.getOriginY() > dojoY + dojoHeigth)
			return false;// too low from the dojo
		if (nimjaWarrior.getOriginY() + nimjaWarrior.getNimjaHeight() < dojoY)
			return false;// too high from the dojo
		return true;// Somewhere in betwixt
	}
	
	private void setPlayer(){
		if(playerCount > 1){
			if(player == MAXPLAYERS){
				player = (player + 1) % MAXPLAYERS;
				return;
			}
			player++;
		}
		else{
			if(player == 1){
				player = 0;
				return;
			}
			player++;
		}
	}
	
	private void runNimAI(){	
		//Ill get this multi-thread to work without a zombie thread some how
		//maybe...
		
		/*Runnable aiRunner = new Runnable(){			
			public void run(){*/
				// Computer calculates the best move to make
				int takenMatches = model.takeBestMove();
				// Computer player takes the matches.
				for (int i = 0; i < nNimjas && takenMatches > 0; i++)
					if (!nimjas[i].isDropped()) {
						nimjas[i].setSelected(true, player);
						repaint();
						takenMatches--;
						/*try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
					}
				for (int i = 1; i < nNimjas; i++)
					if(nimjas[i].isSelected()){
						nimjas[i].setDropped(true);
						nimjas[i].setSelected(false, player);
					}
		/*	}
		};
		Thread aiThread = new Thread(aiRunner, "AI Runner");
		aiThread.start();
		System.out.println("End function");*/
	}
	
	public void moveNimja(int nimjaCount){
		int count = nimjaCount;
		int j = 0;
		if(nimjaCount < 0)
			return;
		for(int i = 0; i < nNimjas; i++)
			if(nimjas[i].isSelected())
				nimjas[i].setSelected(false, player);
		while(count > 0){
			if(!nimjas[j].isDropped()){
				nimjas[j].setSelected(true, player);
				prev = j;
				reorder();
				count--;
			}
			j++;
		}
		repaint();	
		model.playTurn(Nimja.getNumSelected());
		playSound(DROP_SOUND);
		for(int i = 0; i < nNimjas; i++)
			if(nimjas[i].isSelected()){
				nimjas[i].setSelected(false, player);
				nimjas[i].setDropped(true);
			}
		repaint();
		if(isEndGame())
			return;
		setPlayer();
		if(playerCount > 1)					
			return;	
		runNimAI();
		repaint();
		if(isEndGame())
			return;
		setPlayer();
		return;
	}
	
	private void setNimjas(){
		for (int i = 0; i < nNimjas; i++)
			nimjas[i] = new Nimja((width - (Nimja.NIMJAWIDTH * nimjaXOffset + 15)) / 2 + i
					% nimjaRowCount * (Nimja.NIMJAWIDTH + nimjaRowSpacing), nimjaYOffset + i / nimjaRowCount
					* (Nimja.NIMJAHEIGTH + nimjaRowHeightSpacing));
	}
	
	private boolean isEndGame(){
		if (model.gameOver()) {
			boolean continuePlay;
			setPlayer();
			continuePlay = continueGame(getActiveSensei() + " wins. "
					+ "Play again?");
			repaint();
			if (!continuePlay)
				System.exit(0);
			setNewGame();
			return true;
		}
		return false;
	}
		
	public int getCurrentPlayerInt(){
		return player;	
	}	
	
	public void setNewGame(){
		resetGUIforNewGame();
		model.newGame();
		Nimja.resetNimjas();
		player = 1;
		return;
	}
		
	public int getMoveCount(){
		return model.getNumNodes();
	}
	
	public int getVisibleNimjaCount(){
		return nNimjas - Nimja.getNumDropped();
	}
	public String getDifficulty(){
		if(playerCount > 1)
			return getOpponent();
		switch(model.getDifficulty()){
			case 1: return "Grasshopper";
			case 2: return "Grand Master";
			case 3: return "Confusious";
			default: return "Unknown";
		}
	}
	public void setDifficulty(String diffString){
		if(diffString.contains("Grasshopper"))
			model.setAiDiff(1);
		else if(diffString.contains("Grand"))
			model.setAiDiff(2);
		else if(diffString.contains("Confu"))
			model.setAiDiff(3);	
		setNewGame();
	}
	
	public void setPupilSelection(int pupilCount){
		model.setNumNodes(pupilCount);
		//add a loading notification....
		setNewGame();
	}
	
	public void setNimjaCount(int nimjaCount){
		model.setNumNimjas(nimjaCount);
		nNimjas = model.getNumNimjas();
		nimjas = new Nimja[nNimjas];
		setNimjas();
		setNewGame();
	}
	
	public String getActiveSensei(){
		switch(player){
			case 0: return "Robot Sensei";
			case 1: return "Honorable Sensei 1";
			case 2: return "Honorable Sensei 2";
			default: return "Unknown";
		}
	}
	
	private String getOpponent(){
		int temp = player;
		if(playerCount > 1){
			if(player == MAXPLAYERS){
				temp = (player + 1) % MAXPLAYERS;
			}
			else
				temp = player + 1;
		}
		switch(temp){
			case 0: return "Robot Sensei";
			case 1: return "Honorable Sensei 1";
			case 2: return "Honorable Sensei 2";
			default: return "Unknown";
		}
	}
}
