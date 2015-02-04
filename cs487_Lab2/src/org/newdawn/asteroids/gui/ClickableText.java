package org.newdawn.asteroids.gui;

public class ClickableText {
	private int xCoord;
	private int yCoord;
	private float width;
	private float height;
	private String textString;
	
	public ClickableText(String t, int x, int y, float w, float h){
		textString = t;
		xCoord = x;
		yCoord = y;
		width = w + (t.length() * w);
		height = h;
	}
	
	public String getText(){
		return textString;
	}
	
	public boolean isInFocus(int x, int y){		
		return (x >= xCoord || x <= width) && 
				(y >= yCoord || y <= height);
	}

}
