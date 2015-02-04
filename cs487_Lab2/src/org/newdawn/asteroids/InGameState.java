package org.newdawn.asteroids;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.newdawn.asteroids.entity.Entity;
import org.newdawn.asteroids.entity.EntityManager;
import org.newdawn.asteroids.entity.OverShield;
import org.newdawn.asteroids.entity.Player;
import org.newdawn.asteroids.entity.PowerUp;
import org.newdawn.asteroids.entity.Rock;
import org.newdawn.asteroids.gui.BitmapFont;
import org.newdawn.asteroids.model.ObjLoader;
import org.newdawn.asteroids.model.ObjModel;
import org.newdawn.asteroids.sound.Sound;
import org.newdawn.asteroids.sound.SoundLoader;
import org.newdawn.spaceinvaders.lwjgl.Texture;
import org.newdawn.spaceinvaders.lwjgl.TextureLoader;

/**
 * This state is responsible for rendering the game world and handling
 * the mechanics of game play.
 * 
 * @author Kevin Glass
 */
public class InGameState implements GameState, EntityManager {
	/** The unique name of this state */
	public static final String NAME = "ingame";
	public static final int MAXHEALTH = 7;
	
	/** The texture for the back drop */
	private Texture background;
	/** The texture for the particles in the shot */
	private Texture shotTexture;
	/** The texture for the ship */
	private Texture shipTexture;
	/** The model of the player's ship */
	private ObjModel shipModel;
	/** The texture applied to the asteroids */
	private Texture rockTexture;
	/** The model rendered for the asteroids */
	private ObjModel rockModel;
	private ObjModel powerUpModel;
	private Texture powerUpTexture;
	private Texture barrierTexture;
	private ObjModel barrierModel;
	private Texture armourRoundTexture;
	
	/** The font used to draw the text to the screen */
	private BitmapFont font;
	
	/** The entity representing the player */
	private Player player;
	/** The entities in the game */
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	/** The list of entities to be added at the next opportunity */
	private ArrayList<Entity> addList = new ArrayList<Entity>();
	/** The list of entities to be removed at the next opportunity */
	private ArrayList<Entity> removeList = new ArrayList<Entity>();

	/** The OpenGL material properties applied to everything in the game */
	private FloatBuffer material;
	
	/** The current score */
	private int score;
	/** The number of lifes left */
	private int life = 4;
	/** True if the game is over */
	private boolean gameOver;
	
	/** The sound effect to play when shooting */
	private Sound shoot;
	/** The sound effect to play when rocks split apart */
	private Sound split;
	private Sound collection;
	
	/** The current level of play */
	private int level;
	/** The timeout for the game over message before resetting to the menu */
	private int gameOverTimeout;
	private PowerUp activePowerUP;
	private OverShield barrier;
	
	/**
	 * Create a new game state
	 */
	public InGameState() {
	}

	/**
	 * @see org.newdawn.asteroids.GameState#getName()
	 */
	public String getName() {
		return NAME;
	}
	
	/**
	 * Defint the light setup to view the scene
	 */
	private void defineLight() {
		FloatBuffer buffer;
		
		buffer = BufferUtils.createFloatBuffer(4);
		buffer.put(1).put(1).put(1).put(1); 
		buffer.flip();
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, buffer);
		
		buffer = BufferUtils.createFloatBuffer(4);
		buffer.put(1).put(1).put(1).put(1);
		buffer.flip();
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, buffer);
		
		// setup the ambient light 
		buffer = BufferUtils.createFloatBuffer(4);
		buffer.put(0.8f).put(0.8f).put(0.8f).put(0.8f);
		buffer.flip();
		GL11.glLightModel(GL11.GL_LIGHT_MODEL_AMBIENT, buffer);
		GL11.glLightModeli(GL11.GL_LIGHT_MODEL_TWO_SIDE, GL11.GL_TRUE);
		
		// set up the position of the light
		buffer = BufferUtils.createFloatBuffer(4);
		buffer.put(10).put(10).put(5).put(0);
		buffer.flip();
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, buffer);
		
		GL11.glEnable(GL11.GL_LIGHT0);
		
		material = BufferUtils.createFloatBuffer(4);
	}

	/**
	 * @see org.newdawn.asteroids.GameState#init(org.newdawn.asteroids.GameWindow)
	 */
	
	/**
	 * This is where the game pictures and Models are set
	 */
	public void init(GameWindow window) throws IOException {
		defineLight();
		
		TextureLoader loader = new TextureLoader();
		background = loader.getTexture("res/bg.jpg");
		shotTexture = loader.getTexture("res/shot.png");
		
		shipTexture = loader.getTexture("res/ship.jpg");
		shipModel = ObjLoader.loadObj("res/ship.obj");
		rockTexture = loader.getTexture("res/rock.jpg");
		rockModel = ObjLoader.loadObj("res/rock.obj");
		
		powerUpModel = ObjLoader.loadObj("res/powerup.obj");
		powerUpTexture = loader.getTexture("res/powerup.jpg");
		barrierModel = ObjLoader.loadObj("res/kinetic_barrier2.obj");
		barrierTexture = loader.getTexture("res/kinetic_barrier.png");
		armourRoundTexture = loader.getTexture("res/shot_armor.png");
		
		
		Texture fontTexture = loader.getTexture("res/font.png");
		font = new BitmapFont(fontTexture, 32, 32);
		
		shoot = SoundLoader.get().getOgg("res/shots.ogg");
		split = SoundLoader.get().getOgg("res/bush.ogg");
		collection = SoundLoader.get().getOgg("res/collected.ogg");
	}

	/**
	 * @see org.newdawn.asteroids.GameState#render(org.newdawn.asteroids.GameWindow, int)
	 */
	public void render(GameWindow window, int delta) {
		// reset the view transformation matrix back to the empty
		// state. 
		GL11.glLoadIdentity();

		material.put(1).put(1).put(1).put(1); 
		material.flip();
		GL11.glMaterial(GL11.GL_FRONT, GL11.GL_DIFFUSE, material);
		GL11.glMaterial(GL11.GL_BACK, GL11.GL_DIFFUSE, material);
		
		// draw our background image
		GL11.glDisable(GL11.GL_LIGHTING);
		drawBackground(window);
		
		// position the view a way back from the models so we
		// can see them
		GL11.glTranslatef(0,0,-50);

		// loop through all entities in the game rendering them
		for (int i=0;i<entities.size();i++) {
			Entity entity = (Entity) entities.get(i);
			
			entity.render();
		}
		
		drawGUI(window);
	}

	/**
	 * Draw the overlay for score and lifes
	 * 
	 * @param window The window in which the GUI is displayed 
	 */
	private void drawGUI(GameWindow window) {
		window.enterOrtho();
		
		GL11.glColor3f(1,1,0);
		font.drawString(1, "SCORE:" + score, 260, 5);
		
		GL11.glColor3f(1,0,0);
		String lifeString = "";
		for (int i=0;i<life;i++) {
			lifeString += "O";
		}
		GL11.glColor3f(0.2f,0.8f,0);
		font.drawString(1, "HEALTH", 5, 525);
		GL11.glColor3f(1,0,0);
		font.drawString(0, lifeString, 5, 565);

				
		if(activePowerUP != null){
			String powerUpString = activePowerUP.getPowerUpBonus();
			float ratio = 0.0f;
			if(activePowerUP.getActiveStatus()){					
					ratio = activePowerUP.getLifeSpanRatio();
			}
			else if(barrier != null && barrier.getLife() >=0){
				ratio = barrier.getBarrierRatio();
			}
			String powerUpStringDecay = powerUpString.substring(0, 
					(int)Math.floor(( 1 - ratio) * powerUpString.length()));
			String powerUpStringRemain = powerUpString.substring( 
					powerUpStringDecay.length());
			int decayPos = 725 - (powerUpString.length()*25);
			int remainPos = decayPos + (powerUpStringDecay.length()*25) + 20;
			GL11.glColor3f(0.6f, 0.2f, 0.0f);
			font.drawString(1,powerUpStringRemain, remainPos, 565);
			if(powerUpStringRemain.length() <=0)
				GL11.glColor3f(0.3f,0.3f,0.3f);
			else
				GL11.glColor3f(1,1,1);
			font.drawString(1, powerUpStringDecay,
					decayPos, 565);			
		}
		
		GL11.glColor3f(1,1,1);
		if (gameOver) {			
			font.drawString(1, "GAME OVER", 280, 286);
		}
		
		if(life < 1)
			GL11.glColor3f(1, 0, 0);
		else
			GL11.glColor3f(1,1,1);
		window.leaveOrtho();
	}
	
	/**
	 * Draw the background image
	 * 
	 * @param window The window to display the background in 
	 */
	private void drawBackground(GameWindow window) {
		window.enterOrtho();
		
		background.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2i(0,0);
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2i(0,600);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2i(800,600);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2i(800,0);
		GL11.glEnd();
		
		window.leaveOrtho();
	}
	
	/**
	 * @see org.newdawn.asteroids.GameState#update(org.newdawn.asteroids.GameWindow, int)
	 */
	public void update(GameWindow window, int delta) {
		if (gameOver) {
			gameOverTimeout -= delta;
			if (gameOverTimeout < 0) {
				setNewGame();
				window.changeToState(MenuState.NAME);
			}
		}
		
		for (int i=0;i<entities.size();i++) {
			Entity entity = (Entity) entities.get(i);
			@SuppressWarnings("unused")
			float firstSize = entity.getSize();
			
			for (int j=i+1;j<entities.size();j++) {
				Entity other = (Entity) entities.get(j);
				
				if (entity.collides(other)) {
					entity.collide(this, other);
					other.collide(this, entity);
				}
			}
		}
		
		if(isPowerUpActive("HEALTH")){
			if(life + 1 <= MAXHEALTH)
				life++;
		}
		
		entities.removeAll(removeList);
		entities.addAll(addList);
		
		removeList.clear();
		addList.clear();
		
		// loop through all the entities in the game causing them
		// to update (i.e. move, shoot, etc)		
		int rockCount = 0;
		
		for (int i=0;i<entities.size();i++) {
			Entity entity = (Entity) entities.get(i);
			
			entity.update(this, delta);
			
			if (entity instanceof Rock) {
				rockCount++;
			}
		}
		
		if (rockCount == 0) {
			level++;
			spawnRocks(level);
		}
		
	}

	/**
	 * @see org.newdawn.asteroids.GameState#enter(org.newdawn.asteroids.GameWindow)
	 */
	public void enter(GameWindow window) {
		entities.clear();
		
		player = new Player(shipTexture, shipModel, shotTexture);
		entities.add(player);
		
		life = 4;
		score = 0;
		level = 10;
		gameOver = false;
		
		spawnRocks(level);
		spawnPowerUp(level);
		player.setPowerUpTextures(armourRoundTexture);
	}

	/**
	 * Spawn some asteroids into the game world
	 * 
	 * @param count The number of rocks to be spawned
	 */
	private void spawnRocks(int count) {
		// spawn some rocks
		int fails = 0;
		for (int i=0;i<count;i++) {
			float xp = (float) (-20 + (Math.random() * 40));
			float yp = (float) (-20 + (Math.random() * 40));
			
			Rock rock = new Rock(rockTexture, rockModel, xp, yp, 3);
			if (!rock.collides(player)) {
				entities.add(rock);
			} else {
				i--;
				fails++;
			}
			
			if (fails > 5) {
				return;
			}
		}
	}
	
	private void setNewGame(){
		activePowerUP = null;
		barrier = null;
	}
	
	private void spawnPowerUp(int count){
		float xp = (float) (-20 + (Math.random() * 40));
		float yp = (float) (-20 + (Math.random() * 40));
		PowerUp pwr = new PowerUp(powerUpTexture, powerUpModel, xp, yp, 3, 0,0);		
		entities.add(pwr);
	}
	
	
	/**
	 * @see org.newdawn.asteroids.GameState#leave(org.newdawn.asteroids.GameWindow)
	 */
	public void leave(GameWindow window) {
	}

	/**
	 * @see org.newdawn.asteroids.entity.EntityManager#removeEntity(org.newdawn.asteroids.entity.Entity)
	 */
	public void removeEntity(Entity entity) {
		removeList.add(entity);
	}

	/**
	 * @see org.newdawn.asteroids.entity.EntityManager#addEntity(org.newdawn.asteroids.entity.Entity)
	 */
	public void addEntity(Entity entity) {	
		addList.add(entity);
	}

	/**
	 * @see org.newdawn.asteroids.entity.EntityManager#rockDestroyed(int)
	 */
	public void rockDestroyed(int size) {
		split.play(1.0f,1.0f);
		score += (4 - size) * 100;
	}

	/**
	 * @see org.newdawn.asteroids.entity.EntityManager#playerHit()
	 */
	public void playerHit() {
		life--;
		if (life < 0) {
			gameOver = true;
			gameOverTimeout = 6000;
			removeEntity(player);
		}
	}

	/**
	 * @see org.newdawn.asteroids.entity.EntityManager#shotFired()
	 */
	public void shotFired() {
		shoot.play(1.0f,0.5f);
	}
	
	public void powerUpCollected(Entity entity){
		activePowerUP = (PowerUp) entity;
		//misc powerup actions
		if(activePowerUP.getPowerUpBonus().contains("OVER-SHEILD")){
			barrier = new OverShield(barrierModel, barrierTexture,player.getX(),player.getY(),player.getSize() * 1.5f
					,powerUpModel, powerUpTexture);
			player.setKineticBarrier(barrier);
			entities.add(barrier);
		}
		collection.play(1.0f, 0.5f);
		
	}
	
	public boolean isPowerUpActive(String powerUP){
		if(activePowerUP != null)
			return activePowerUP.getPowerUpBonus().contains(powerUP) 
					&& activePowerUP.getActiveStatus();
		else
			return false;
	}

}
