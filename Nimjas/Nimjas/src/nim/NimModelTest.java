package nim;

import javax.swing.JFrame;

import junit.framework.TestCase;
/**
 * @author wainer
 * A small example to show what kind of test might be applied
 * to the model. There should be many tests to verify/design
 * the model's functionality.
 * 
 * This test is using JUnit 3.8.2.
 * In Eclipse you can run it, by highlighting this file in the
 * Package Explorer, (or use the Run menu when viewing in the editor)
 * and selecting, "Run as JUnit Test" If it gives a choice of run
 * configurations, pick Eclipse JUnit.
 *
 */
public class NimModelTest extends TestCase {

	public void testGameOverAtStart() {
		int initNumOfMatchsticks = 3;
		NimModel model = new NimModel(initNumOfMatchsticks);
        assertFalse("Game should not be over, just started", model.gameOver());
	}
	
	public void testGameOverIfAllRemoved() {
		int initNumOfMatchsticks = 3;
		NimModel model = new NimModel(initNumOfMatchsticks);
		model.playTurn(2);
        assertFalse("Game should not be over, items remain", model.gameOver());
		model.playTurn(1);
        assertTrue("Game should be over, last item removed", model.gameOver());
	}
	
	public void testSecondPlayer(){
		NimPanel controller = new NimPanel(new JFrame());
		controller.setPlayerCount(2);
		controller.moveNimja(1);
		assertTrue("Game should be waiting for the second player", controller.getCurrentPlayerInt() ==2);
		
	}
	
	public void testAiSmarts(){
		int takenNimjas, initialNimjas = 4;
		NimModel model = new NimModel(initialNimjas);		
		takenNimjas = model.takeBestMove();//should be three
		assertTrue("Game Should Have Chosen winning moves", takenNimjas == 3);		
		
	}
	

}
