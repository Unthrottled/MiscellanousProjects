package org.newdawn.asteroids.entity;

import org.lwjgl.opengl.GL11;
import org.newdawn.asteroids.model.ObjModel;
import org.newdawn.spaceinvaders.lwjgl.Texture;

public class PowerUp extends AbstractEntity{
	/** The texture to be applied to this entity */
	private Texture texture;
	/** The model to be rendered for this entity */
	private ObjModel model;
	@SuppressWarnings("unused")
	private int size;
	private float rotateSpeed = (float) (Math.random() * 0.5f) + 1;
	private String powerUpBonus;
	private int lifeSpan = -1;
	private int initialLifeSpan;
	private boolean isCollected = false;
	private boolean isStatic = false;
	
	public PowerUp(Texture texture, ObjModel model, float x, float y, int size, float vx, float vy) {
		this.texture = texture;
		this.model = model;		
		velocityX = vx;
		velocityY = vy;
		positionX = x;
		positionY = y;
		this.size = size;
		rotationZ = rotateSpeed;
		powerUpBonus = setBonus();

	}
	
	void collected(EntityManager manager, Entity reason){		
		manager.powerUpCollected(this);
		isCollected = true;	
	}
	
	public String getPowerUpBonus(){
		return powerUpBonus;
	}
	
	public boolean getActiveStatus(){
		return (lifeSpan > 0 && isCollected) || isStatic;
	}
	
	public float getLifeSpanRatio(){
		
		return (float) lifeSpan/initialLifeSpan;
	}
	
	
	public boolean isCollected(){
		return isCollected;
	}

	@Override
	public void render() {
		if(isCollected)
			return;
		// TODO Auto-generated method stub
		// enable lighting over the rock model
		GL11.glEnable(GL11.GL_LIGHTING);
		
		// store the original matrix setup so we can modify it
		// without worrying about effecting things outside of this 
		// class
		GL11.glPushMatrix();

		// position the model based on the players currently game
		// location
		GL11.glTranslatef(positionX,positionY,-1);

		// rotate the PowerUP round to its current Y axis rotate
		GL11.glRotatef(rotationZ,0,1,0);
		
		// scale the model based on the size of rock we're representing
		//GL11.glScalef(size, size, size);
		GL11.glScalef(1.0f,1.0f,1.0f);
		
		// bind the texture we want to apply to our rock and then
		// draw the model 
		texture.bind();
		model.render();
		
		// restore the model matrix so we leave this method
		// in the same state we entered
		GL11.glPopMatrix();
	}

	@Override
	public float getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void update(EntityManager manager, int delta) {
		// call the abstract entitie's update method to cause the
		// rock to move based on its current settings
		super.update(manager, delta);
		if(isCollected && lifeSpan > 0){
			//if(lifeSpan % 100 == 0)
				//System.out.println("PowerUp Drain");
			lifeSpan -= delta;
			if(!getActiveStatus()){
				manager.removeEntity(this);
				float xp = (float) (-20 + (Math.random() * 40));
				float yp = (float) (-20 + (Math.random() * 40));
				PowerUp pwr = new PowerUp(texture, model, xp, yp, 3, 0,0);
				manager.addEntity(pwr);
			}
		}
		else if(isCollected && lifeSpan <=0 && !isStatic){
			manager.removeEntity(this);
			float xp = (float) (-20 + (Math.random() * 40));
			float yp = (float) (-20 + (Math.random() * 40));
			PowerUp pwr = new PowerUp(texture, model, xp, yp, 3, 0,0);
			if(!powerUpBonus.contains("OVER-SHEILD"))
				manager.addEntity(pwr);
		}
		else if(isCollected && isStatic){
			isStatic = false;
		}
		rotationZ += (delta / 10.0f) * rotateSpeed;
	}

	@Override
	public void collide(EntityManager manager, Entity other) {
		if(!(other instanceof Player))
			return;
	}
	
	private String setBonus(){
		switch ((int)(Math.floor((Math.random() * 4) + 1))){
			case 1:
				lifeSpan = 10000;
				initialLifeSpan = lifeSpan;
				return "INVINCIBLITY";
			case 2:
				isStatic = true;
				return "OVER-SHEILD";
			case 3:
				isStatic = true;
				return "HEALTH";
			case 4:
				break;
			default:
				return "DEFAULT";
		}
		lifeSpan = 8000;
		initialLifeSpan = lifeSpan;
		switch ((int)(Math.floor((Math.random() * 3) + 1))){
			case 1:				
				return "ARMOR-PEIRCING";
			case 2:
				return "RAPID-FIRE";
			case 3:
				return "BIG-SHOT";
			default:
				return "DEFAULT";		
		}		
	}
}
