package org.newdawn.asteroids.entity;

import org.lwjgl.opengl.GL11;
import org.newdawn.asteroids.model.ObjModel;
import org.newdawn.spaceinvaders.lwjgl.Texture;

public class OverShield extends AbstractEntity{
	private static final int INTIAL_LIFE = 5;
	/** The texture to applied to the particles building up the shot */
	private Texture texture, pwerUpTexture;
	/** The size of the initial particles building up this shot */
	private float size = 1.0f;
	/** The amount of time the shot exists for before disappearing */
	private int life = INTIAL_LIFE;
	/** The particle engine used to render the shot */
	private ObjModel model, pwrUpModel;

	
	public OverShield(ObjModel model, Texture texture, float x, float y, float s, 
			ObjModel pwrUpModel, Texture pwerUPText) {	
		positionX = x;
		positionY = y;
		this.texture = texture;
		this.size = s;
		this.model = model;
		this.pwrUpModel = pwrUpModel;
		pwerUpTexture = pwerUPText;
	}
	
	/**
	 * @see org.newdawn.asteroids.entity.Entity#update(org.newdawn.asteroids.entity.EntityManager, int)
	 */
	public void update(EntityManager manager, int delta) {
		// cause the particle to move by calling the abstract super 
		// class's implementation of update
		super.update(manager, delta);
		if (life < 0) {
			// if the life time has run out then remove the shot
			// entity from the game
			manager.removeEntity(this);
			float xp = (float) (-20 + (Math.random() * 40));
			float yp = (float) (-20 + (Math.random() * 40));
			PowerUp pwr = new PowerUp(pwerUpTexture, pwrUpModel, xp, yp, 3, 0,0);
			manager.addEntity(pwr);

		}
	}	
	
	/**
	 * @see org.newdawn.asteroids.entity.Entity#render()
	 */
	public void render() {
		// enable lighting for the player's model
		GL11.glEnable(GL11.GL_LIGHTING);
		
		// store the original matrix setup so we can modify it
		// without worrying about effecting things outside of this 
		// class
		GL11.glPushMatrix();

		// position the model based on the players currently game
		// location
		GL11.glTranslatef(positionX,positionY,0);		

		GL11.glRotatef(rotationZ,0,0,1);
	
		// rotate the ship to the right orientation for rendering. Our
		// ship model is modelled on a different axis to the one we're
		// using so we'd like to rotate it round
		GL11.glRotatef(90,1,0,0);
		
		// scale the model down because its way to big by default
		GL11.glScalef(0.01f,0.01f,0.01f);
		
		// bind to the texture for our model then render it. This 
		// actually draws the geometry to the screen
		texture.bind();
		model.render();
		
		// restore the model matrix so we leave this method
		// in the same state we entered
		GL11.glPopMatrix();
				
	}

	/**
	 * @see org.newdawn.asteroids.entity.Entity#getSize()
	 */
	public float getSize() {
		// the size of our OverShield
		return size;
	}
	
	public int getLife(){
		return life;
	}
	
	public float getBarrierRatio(){
		return (float) life/INTIAL_LIFE;
	}
	
	public void setPosition(float x, float y, float z){
		positionX = x;
		positionY = y;
		rotationZ = z;
	}
	

	/**
	 * @see org.newdawn.asteroids.entity.Entity#collide(org.newdawn.asteroids.entity.EntityManager, org.newdawn.asteroids.entity.Entity)
	 */
	public void collide(EntityManager manager, Entity other) {
		if (other instanceof Rock) {
			((Rock) other).split(manager, this);
			life -= 1;
		}
	}
}
