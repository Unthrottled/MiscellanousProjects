// Ninja.java
// Initial source code from Jeff Friesen's 6/21/2004 article
// Java Tech: An Intelligent Nim Computer Game, Part 2
// http://today.java.net/pub/a/today/2004/06/21/nim2.html
// Modified to separate model code to better support MVC ideal
// also to use resource subdirectories, nim package, ant build file
// M. Wainer, Jan 2007, Aug 2010
package nim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

//import javax.swing.ImageIcon;

public class Nimja
{
	final static int NIMJAWIDTH = 40;
	final static int NIMJAHEIGTH = 60;
	final static String PLAYER1 = "images/nimja_player1.png";
	final static String PLAYER2 = "images/nimja_player2.png";
	final static String PLAYERCPU = "images/nimja_playercpu.png";
	final static String DEFAULTNIMJA = "images/nimja_default.png";
	static private int nSelected, nDropped;
	private int player;

	private boolean dropped, selected;
	private int originX, originY;
	//private ImageIcon nimja;
	private Shape nimjaHead;
	private Shape nimjaHeadBand;
	private Shape nimjaTassels;

	Nimja (int ox, int oy) {
		setOrigin (ox, oy);
		nimjaHead = defineNimja(20);
		nimjaHeadBand = defineNimjaHeadBand(20);
		nimjaTassels = defineNimjaTassels(20);
	}

	boolean contains (int x, int y) {		
		return (x >= originX && x <= originX+NIMJAWIDTH &&
				y >= originY && y <= originY+NIMJAHEIGTH);
		
	}

	void draw (Graphics g, NimPanel np) {		
		/*nimja = new ImageIcon (getNimjaModel());
		g.drawImage (nimja.getImage (), originX, originY, np);*/
		/**
		 * Some effort was given to replacing the
		 * ImageIcon with java2D nimja head, given
		 * the time constraints... 
		 */
		Graphics2D g2 = (Graphics2D) g; 
		Color savedColor = g2.getColor();
		AffineTransform savedTransform = g2.getTransform();
		g2.setColor(Color.LIGHT_GRAY);
		g2.translate(originX , originY + 15);
		g2.rotate(Math.toRadians(-45));
		g2.fill(nimjaTassels);
		g2.setColor(getNimjaColor());		
		g2.draw(nimjaTassels);
		g2.rotate(Math.toRadians(-30));
		g2.fill(nimjaTassels);
		g2.draw(nimjaTassels);
		g2.setTransform(savedTransform);
		g2.translate(originX +20, originY+20);
		g2.setColor(Color.BLACK);
		g2.fill(nimjaHead);
		g2.setColor(Color.black);
		g2.draw(nimjaHead);
		g2.setTransform(savedTransform);
		g2.translate(originX -8, originY +23);
		g2.setColor(getNimjaColor());
		g2.fill(nimjaHeadBand);
		g2.setColor(Color.LIGHT_GRAY);
		g2.draw(nimjaHeadBand);
		
		g2.setTransform(savedTransform);
		g2.setColor(savedColor);
	}
	
	private Shape defineNimja(double t){
		Shape bigCircle = new Ellipse2D.Double(-t, -t, 2*t,2*t);
		Area symbol = new Area(bigCircle);		
		return symbol;
	}
	
	private Shape defineNimjaHeadBand(double t){
		Shape bigCircle = new Ellipse2D.Double(-t, -t, 5*t,t/2);
		Shape bigCircle1 = new Ellipse2D.Double(-t  - (t * 0.30), -t - (t * 0.30), 5*t,t/2);		
		Shape bigCircle2 = new Ellipse2D.Double(-t-20, -t -50, 7*t,7*t);
		Shape bigCircle3 = new Ellipse2D.Double(-t +28, -t-5, 2*t,2*t);
		Area temp = new Area(bigCircle2);
		temp.subtract(new Area(bigCircle3));
		
		Area headBand = new Area(bigCircle);
		headBand.subtract(new Area(bigCircle1));
		headBand.subtract(temp);
		
		
		return headBand;
	}
	
	private Shape defineNimjaTassels(double t){
		GeneralPath tassel = new GeneralPath();
		tassel.moveTo(0, 0);
		tassel.quadTo(-t, -t, -t, -t/2);
		tassel.lineTo(t,t);
		
		return tassel;
	}

	int getOriginX () {
		return originX;
	}

	int getOriginY () {
		return originY;
	}
	
	int getNimjaWidth(){
		return NIMJAWIDTH;
	}
	int getNimjaHeight(){
		return NIMJAHEIGTH;
	}

	boolean isDropped () {
		return dropped;
	}

	boolean isSelected () {
		return selected;
	}
	
	int getPlayer(){
		return player;
	}

	void setDropped (boolean dropped) {
		this.dropped = dropped;
		nDropped++;
	}

	void setOrigin (int x, int y) {
		originX = x;
		originY = y;
	}

	void setSelected (boolean selected, int plyr) {
		if (!this.selected && selected == true)
			nSelected++;

		if (this.selected && selected == false)
			nSelected--;

		this.selected = selected;
		this.player = plyr;
	}
	
	static int getNumSelected() {
		return nSelected;
	}
	
	static int getNumDropped(){
		return nDropped;
	}
	
	static void resetNimjas(){
		nDropped = 0;
	}
	/*private String getNimjaModel(){
		if(!selected)
			return DEFAULTNIMJA;
		switch(player){
		  case 0: return PLAYERCPU;
		  case 1: return PLAYER1;
		  case 2: return PLAYER2;
		  default: return null;
		}
	}*/
	private Color getNimjaColor(){
	if(!selected)
		return Color.DARK_GRAY;
	switch(player){
	  case 0: return Color.decode("#1ac318");
	  case 1: return Color.decode("#c40707");
	  case 2: return Color.decode("#006ea1");
	  default: return null;
	}
}
}
