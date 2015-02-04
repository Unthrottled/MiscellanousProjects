package nim;
// GuiNim.java
// Initial source code from Jeff Friesen's 6/21/2004 article
// Java Tech: An Intelligent Nim Computer Game, Part 2
// http://today.java.net/pub/a/today/2004/06/21/nim2.html
// Modified to bring model code out to better support MVC concepts.
// Also to use resource subdirectories, nim package, ant build file
// M. Wainer, Jan 2007, Aug 2009, Aug 2010

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;

public class GuiNim extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NimPanel center;
	private JButton btnPupil;
	private JButton btnPupils;
	private JButton btnPupils_1;
	private JButton btnPupils_2;
	private JButton btnPupils_3;
	private JButton btnPupils_4;
	private JLabel lblDifficulty;
	private JLabel lblActiveSensei;
	private JLabel lblSelectYourPupils;


public GuiNim (String title) {
      // Display title in frame window's title bar.
	   super (title);
	   getContentPane().setBackground(Color.DARK_GRAY);
	   setDefaultCloseOperation (EXIT_ON_CLOSE);
	   setBounds(100, 100, 1015, 695);
	   //pack (); // Pack all components to their preferred sizes.
	   setResizable (false);
	   
	   JMenuBar menuBar = new JMenuBar();
	   menuBar.setBackground(Color.DARK_GRAY);
	   setJMenuBar(menuBar);
	   
	   JMenu mnOptions = new JMenu("Options");
	   mnOptions.setForeground(Color.decode("#ded1da"));
	   menuBar.add(mnOptions);
	   
	   JMenuItem mntmNewGame = new JMenuItem("New Game");
	   mntmNewGame.addActionListener(new ActionHandler());
	   mnOptions.add(mntmNewGame);
	   
	   JMenu mnGameOptions = new JMenu("Game Options");
	   mnOptions.add(mnGameOptions);
	   
	   JMenu mnOfNimjas = new JMenu("# of Nimjas");
	   mnOfNimjas.addActionListener(new ActionHandler());
	   mnGameOptions.add(mnOfNimjas);
	   
	   JMenuItem mntmNimjas = new JMenuItem("10 Nimjas");
	   mntmNimjas.addActionListener(new ActionHandler());
	   mnOfNimjas.add(mntmNimjas);
	   
	   JMenuItem mntmNimjas1 = new JMenuItem("15 Nimjas");
	   mntmNimjas1.addActionListener(new ActionHandler());
	   mnOfNimjas.add(mntmNimjas1);
	   
	   JMenuItem mntmNimjas2 = new JMenuItem("20 Nimjas");
	   mntmNimjas2.addActionListener(new ActionHandler());
	   mnOfNimjas.add(mntmNimjas2);
	   
	   //JMenuItem mntmNimjas3 = new JMenuItem("25 Nimjas");
	  // mntmNimjas3.addActionListener(new ActionHandler());
	  // mnOfNimjas.add(mntmNimjas3);
	   
	  // JMenuItem mntmNimjas4 = new JMenuItem("30 Nimjas");
	  // mntmNimjas4.addActionListener(new ActionHandler());
	  // mnOfNimjas.add(mntmNimjas4);
	   
	   JMenu mnPupilSelection = new JMenu("Pupil Selection");	   
	   mnGameOptions.add(mnPupilSelection);
	   
	   JMenuItem mntmPupils = new JMenuItem("2 Pupils");
	   mntmPupils.addActionListener(new ActionHandler());
	   mnPupilSelection.add(mntmPupils);
	   
	   JMenuItem mntmPupils_1 = new JMenuItem("3 Pupils");
	   mntmPupils_1.addActionListener(new ActionHandler());
	   mnPupilSelection.add(mntmPupils_1);
	   
	   JMenuItem mntmPupils_2 = new JMenuItem("4 Pupils");
	   mntmPupils_2.addActionListener(new ActionHandler());
	   mnPupilSelection.add(mntmPupils_2);
	   
	   JMenuItem mntmPupils_3 = new JMenuItem("5 Pupils");
	   mntmPupils_3.addActionListener(new ActionHandler());
	   mnPupilSelection.add(mntmPupils_3);
	   
	   JMenuItem mntmPupils_4 = new JMenuItem("6 Pupils");
	   mntmPupils_4.addActionListener(new ActionHandler());
	   mnPupilSelection.add(mntmPupils_4);
	   
	   JMenu mnDifficulty = new JMenu("Difficulty");
	   mnGameOptions.add(mnDifficulty);
	   
	   JMenuItem mntmGrasshoppereasy = new JMenuItem("Grasshopper (Easy)");
	   mntmGrasshoppereasy.addActionListener(new ActionHandler());
	   mnDifficulty.add(mntmGrasshoppereasy);
	   
	   //JMenuItem mntmGrandMastermedium = new JMenuItem("Grand Master (Medium)");
	   //mntmGrandMastermedium.addActionListener(new ActionHandler());
	   //mnDifficulty.add(mntmGrandMastermedium);
	   
	   JMenuItem mntmConfuscius = new JMenuItem("Confuscius (Hard)");
	   mnDifficulty.add(mntmConfuscius);
	   
	   JMenu mnPlayers = new JMenu("Players");
	   mnGameOptions.add(mnPlayers);
	   
	   JMenuItem mntmPlayer = new JMenuItem("1 Player");
	   mntmPlayer.addActionListener(new ActionHandler());
	   mnPlayers.add(mntmPlayer);
	   
	   JMenuItem mntmPlayers = new JMenuItem("2 Players");
	   mnPlayers.add(mntmPlayers);
	   mntmPlayers.addActionListener(new ActionHandler());
	   getContentPane().setLayout(null);
	   
	   JPanel panel = new JPanel();
	   panel.setBackground(Color.RED);
	   panel.setBounds(12, 0, 985, 651);
	   getContentPane().add(panel);
	   panel.setLayout(null);
	   
	   JPanel right = new JPanel();
	   right.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	   right.setBounds(0, 50, 89, 586);
	   right.setBackground(Color.BLACK);
	   panel.add(right);
	   
	   btnPupil = new JButton("1 Pupil");
	   btnPupil.setBounds(0, 2, 89, 83);
	   btnPupil.setEnabled(false);
	   btnPupil.addActionListener(new ActionHandler());
	   right.setLayout(null);
	   right.add(btnPupil);
	   
	   btnPupils = new JButton("2 Pupils");
	   btnPupils.setBounds(0, 85, 89, 83);
	   btnPupils.setEnabled(false);
	   btnPupils.addActionListener(new ActionHandler());
	   right.add(btnPupils);
	   
	   btnPupils_1 = new JButton("3 Pupils");
	   btnPupils_1.setBounds(0, 168, 89, 83);
	   btnPupils_1.setEnabled(false);
	   btnPupils_1.addActionListener(new ActionHandler());
	   right.add(btnPupils_1);
	   
	   btnPupils_2 = new JButton("4 Pupils");
	   btnPupils_2.setBounds(0, 251, 89, 83);
	   btnPupils_2.setEnabled(false);
	   btnPupils_2.addActionListener(new ActionHandler());
	   right.add(btnPupils_2);
	   
	   btnPupils_3 = new JButton("5 Pupils");
	   btnPupils_3.setBounds(0, 334, 89, 83);
	   btnPupils_3.setEnabled(false);
	   btnPupils_3.addActionListener(new ActionHandler());
	   right.add(btnPupils_3);
	   
	   btnPupils_4 = new JButton("6 Pupils");
	   btnPupils_4.setBounds(0, 417, 89, 83);
	   btnPupils_4.setEnabled(false);
	   btnPupils_4.addActionListener(new ActionHandler());
	   right.add(btnPupils_4);
	   
	   JLabel label = new JLabel(new ImageIcon("images/buttonback.png"));
	   label.setBounds(0, 2, 99, 586);
	   right.add(label);
	   
	   JPanel head = new JPanel();
	   head.setBounds(0, 0, 985, 50);
	   head.setBackground(new Color(173, 255, 47));
	   panel.add(head);
	   head.setLayout(null);
	   
	   JPanel panel_1 = new JPanel();
	   panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	   panel_1.setBounds(0, 0, 985, 25);
	   panel_1.setBackground(new Color(0, 0, 255));
	   head.add(panel_1);
	   panel_1.setLayout(null);
	   	   
	   JLabel lblLogo = new JLabel(new ImageIcon("images/logo_background.png"));
	   lblLogo.setText("");
	   lblLogo.setBounds(0, 0, 985, 25);
	   panel_1.add(lblLogo);	   
	   
	   JPanel panel_2 = new JPanel();
	   panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	   panel_2.setBounds(0, 25, 985, 25);
	   panel_2.setBackground(Color.decode("#ded1da"));
	   head.add(panel_2);
	   panel_2.setLayout(null);
	   
	   lblSelectYourPupils = new JLabel("Select Your Pupils |");
	   lblSelectYourPupils.setBackground(new Color(0, 255, 0));
	   lblSelectYourPupils.setBounds(0, 4, 135, 15);
	   panel_2.add(lblSelectYourPupils);
	   
	   JLabel lblPlayerstate = new JLabel("Active Sensei: ");
	   lblPlayerstate.setBounds(374, 4, 103, 15);
	   panel_2.add(lblPlayerstate);
	   
	   lblActiveSensei = new JLabel("");
	   lblActiveSensei.setBounds(489, 4, 138, 15);
	   panel_2.add(lblActiveSensei);
	   
	   JPanel bottom = new JPanel();
	   bottom.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	   bottom.setBounds(0, 636, 985, 15);
	   bottom.setBackground(Color.decode("#ded1da"));
	   panel.add(bottom);
	   bottom.setLayout(null);
	   
	   JLabel lblFooter = new JLabel("Honor Level: ");
	   lblFooter.setBounds(0, 0, 93, 15);
	   bottom.add(lblFooter);
	   
	   lblDifficulty = new JLabel("");
	   lblDifficulty.setBounds(93, 0, 150, 15);
	   bottom.add(lblDifficulty);
	   
	   JLabel lblLoading = new JLabel("LOADING");
	   lblLoading.setVisible(false);
	   lblLoading.setBounds(354, 0, 70, 15);
	   bottom.add(lblLoading);
	   
	   center = new NimPanel(this);
	   center.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	   center.setBounds(89, 50, 896, 586);
	   center.setBackground(Color.decode("#00010b"));
	   panel.add(center);
	   setDifficultyLabel();
	   setActivePlayer();
	   
	  // JLabel lblNinjas = new JLabel(new ImageIcon("images/background.png"));
	   //center.add(lblNinjas);
	   // Display frame window and all contained components.
	   setVisible (true);
	   setButtons();
   }

   
   public static void main(String[] args) {
		// Schedule App's GUI create & show for event-dispatching thread
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GuiNim ("Nimjas!");
			}
		});
	}
   private final class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
	   		if(arg0.getSource().getClass().equals(btnPupil.getClass())){
	 	   			moveNimja((Integer.valueOf(((AbstractButton)
	 	   					arg0.getSource()).getText().substring(0, 1))));
	 	   			setButtons();
	 	   			setActivePlayer();
	   		}
	   		else if(arg0.getSource().getClass().equals(new JMenuItem().getClass())){
	   			String temp = ((AbstractButton) arg0.getSource()).getText();
	   			if(temp.contains("(")){
	   				setDifficulty(temp);
	   			}
	   			else if(temp.contains("Pupil")){
	   				setPupilSelection((Integer.valueOf(((AbstractButton) 
	   						arg0.getSource()).getText().substring(0, 1))));
	   			}
	   			else if(temp.contains("New Game")){
	   				setNewGame();
	   			}
	   			else if(temp.contains("Player")){
	   				setPlayerCount((Integer.valueOf(((AbstractButton) 
	   						arg0.getSource()).getText().substring(0, 1))));
	   				setDifficultyLabel();
	   			}
	   			else if(temp.contains("Nimjas")){
	   				setNimjaCount((Integer.valueOf(((AbstractButton) 
	   						arg0.getSource()).getText().substring(0, 2))));	   		
	   			}
	   		}
	   	}
	}
   
   private void moveNimja(int nimjaCount){
	   center.moveNimja(nimjaCount);
   }
   
   private void setDifficulty(String diffString){
	   center.setDifficulty(diffString);
	   setDifficultyLabel();   
   }
   
   private void setPupilSelection(int pCount){
	   center.setPupilSelection(pCount);
	   setButtons();
   }
   private void setPlayerCount(int playerCount){
	   center.setPlayerCount(playerCount);
   }
   private void setNewGame(){
	   center.setNewGame();
	   setButtons();
   }
   private void setNimjaCount(int nimjaCount){
	   center.setNimjaCount(nimjaCount);
   }
   
   public void setButtons(){	   
	    if(center.getMoveCount() > 0 && center.getVisibleNimjaCount() >= 1){
	    	btnPupil.setEnabled(true);
	    	btnPupil.setVisible(true);
	    }
	    else{
	    	btnPupil.setEnabled(false);
	    	btnPupil.setVisible(false);
	    }
	    if(center.getMoveCount() > 1 && center.getVisibleNimjaCount() >= 2){
	    	btnPupils.setEnabled(true);
	    	btnPupils.setVisible(true);
	    }
	    else{
	    	btnPupils.setEnabled(false);
	    	btnPupils.setVisible(false);
	    }
	    if(center.getMoveCount() > 2 && center.getVisibleNimjaCount() >= 3){
	    	btnPupils_1.setEnabled(true);
	    	btnPupils_1.setVisible(true);
	    }
	    else{
	    	btnPupils_1.setEnabled(false);
	    	btnPupils_1.setVisible(false);
	    }
	    if(center.getMoveCount() > 3 && center.getVisibleNimjaCount() >= 4){
	    	btnPupils_2.setEnabled(true);
	    	btnPupils_2.setVisible(true);
	    }
	    else{
	    	btnPupils_2.setEnabled(false);
	    	btnPupils_2.setVisible(false);
	    }
	    if(center.getMoveCount() > 4 && center.getVisibleNimjaCount() >= 5){
	    	btnPupils_3.setEnabled(true);
	    	btnPupils_3.setVisible(true);
	    }
	    else{
	    	btnPupils_3.setEnabled(false);
	    	btnPupils_3.setVisible(false);
	    }
	    if(center.getMoveCount() > 5 && center.getVisibleNimjaCount() >= 6){
	    	btnPupils_4.setEnabled(true);
	    	btnPupils_4.setVisible(true);
	    }
	    else{
	    	btnPupils_4.setEnabled(false);
	    	btnPupils_4.setVisible(false);
	    }
	    setDifficultyLabel();
   }
   private void setDifficultyLabel(){
	   String temp =center.getDifficulty();
	   lblDifficulty.setText(temp);
	   switch(temp){
		   case "Confusious":
			   lblDifficulty.setForeground(Color.decode("#e22c1c"));
			   break;
		   case "Grasshopper":
			   lblDifficulty.setForeground(Color.GREEN);
		   default:
			   lblDifficulty.setForeground(Color.BLUE);
			   break;
	   }
	   return;	   
   }
   /**
    * Figure out how to execute this on the mouse
    * drag event.
    */
   private void setActivePlayer(){
	   String temp = center.getActiveSensei();
	   lblActiveSensei.setText(temp);
	   switch(temp){
	   case "Honorable Sensei 1":
		   lblActiveSensei.setForeground(Color.decode("#c40707"));
		   lblSelectYourPupils.setBackground(Color.decode("#c40707")); 
		   break;
	   case "Honorable Sensei 2":
		   lblActiveSensei.setForeground(Color.decode("#006ea1"));
		   lblSelectYourPupils.setBackground(Color.decode("#006ea1"));
		   break;
	   case "Robot Sensei":
		   lblActiveSensei.setForeground(Color.decode("#1ac318"));
		   lblSelectYourPupils.setBackground(Color.decode("#1ac318"));
		   break;
	   default: break;		   
	   }	
   }
   }
 

