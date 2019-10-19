
/**
 * FrogHopper.java
 *
 * Consider a frog that comes to the bank of a river.  The frog would like
 * to cross this river, but it is very wide (more than 40 feet).  Fortunately
 * for the frog, stepping stones dot the river, and it might be possible to
 * cross to the other side.  The frog would like to cross the river by
 * hopping on as few stones as possible, but it must follow these
 * simple rules:
 *    (1)  The frog's maximum hop length is 70 inches.
 *    (2)  The frog cannot make consecutive hops of 50 inches or more.
 *         That is to say, if the frog hops 50 or more inches, the
 *         subsequent hop must be less than 50 inches.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 10/15/2019
 */

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

public class FrogHopper
{
	/**  A two-dimensional array that stores some possible stone combinations.       */
	private final int [][] POSSIBLE_STONE_PATHS = new int[][]
			{{0, 40, 65, 120, 140, 155, 180, 195, 210, 240, 260, 300, 320, 370, 400, 420, 480, 500},
			 {0, 15, 30, 50, 70, 85, 145, 165, 200, 270, 300, 350, 390, 405, 420, 440, 455, 470, 500},
			 {0, 55, 70, 120, 140, 160, 200, 250, 290, 340, 355, 410, 445, 460, 475, 500},
			 {0, 70, 110, 130, 150, 170, 190, 210, 240, 270, 300, 330, 350, 370, 390, 410, 430, 450, 480, 500},
			 {0, 35, 70, 105, 140, 165, 190, 215, 240, 265, 290, 315, 340, 370, 400, 450, 500},
			 {0, 30, 65, 100, 125, 150, 165, 180, 210, 225, 240, 265, 300, 315, 330, 345, 360, 380, 400, 415, 430, 445, 460, 475, 500},
			 {0, 25, 45, 65, 85, 100, 120, 150, 180, 200, 230, 250, 280, 300, 320, 345, 370, 400, 430, 450, 500},
			 {0, 40, 80, 120, 160, 210, 270, 310, 330, 355, 400, 420, 445, 470, 500},
			 {0, 20, 60, 75, 100, 115, 130, 190, 220, 240, 255, 310, 355, 400, 420, 460, 475, 500},
			 {0, 15, 30, 45, 60, 75, 90, 105, 120, 135, 150, 170, 190, 210, 230, 250, 290, 330, 370, 410, 455, 475, 500},
			 {0, 25, 55, 80, 110, 135, 165, 190, 220, 250, 275, 305, 330, 360, 385, 415, 440, 470, 500},
			 {0, 30, 60, 90, 120, 150, 180, 220, 260, 300, 350, 390, 420, 500},
			 {0, 40, 55, 70, 100, 150, 190, 250, 280, 330, 390, 415, 430, 445, 480, 500},
			 {0, 20, 70, 90, 140, 160, 210, 230, 250, 270, 320, 350, 365, 380, 395, 410, 425, 440, 500},
			 {0, 65, 80, 100, 115, 130, 180, 200, 250, 265, 290, 305, 320, 340, 355, 370, 400, 415, 430, 445, 460, 485, 500},
			 {0, 25, 65, 85, 105, 155, 170, 185, 200, 260, 290, 315, 365, 405, 450, 470, 485, 500},
			 {0, 40, 75, 90, 110, 150, 165, 200, 220, 270, 330, 350, 370, 385, 400, 415, 430, 450, 465, 500},
			 {0, 15, 30, 50, 70, 90, 105, 120, 135, 160, 175, 200, 215, 230, 255, 270, 290, 305, 320, 335, 350, 400, 430, 450, 500},
			 {0, 15, 30, 50, 70, 90, 105, 120, 135, 160, 175, 200, 215, 230, 255, 270, 290, 305, 320, 335, 350, 400, 420, 500},
			 {0, 15, 30, 45, 70, 85, 115, 130, 160, 185, 215, 230, 245, 275, 300, 320, 345, 365, 390, 400, 415, 430, 460, 475, 500}};

	/**  Used to store a particular array of stones.      */
	private int [] stones;

	/**  An array to be used in parallel with the stones, indicating where the frog landed.      */
	private boolean [] hops;

	/**
	 *  Creates a FrogHopper object.
	 *  Nothing to assign here, since the stones and hops arrays are assigned later.
	 */
	public FrogHopper ( )
	{
	}

	/**
	 *  The main method, to set up the canvas, and run the program (a GUI).
	 */
	public static void main(String[] args)
	{
		FrogHopper hoppper = new FrogHopper();
		hoppper.setUpCanvas();
		hoppper.runGUI();
    }

	/**
	 *  Sets up the canvas, using methods from StdDraw.  This includes
	 *  setting up the canvas size, the horizontal scale (Xscale), and
	 *  the vertical scale (Yscale).  Double buffering is enabled
	 *  for the animations of the frog hopping across the screen.
	 */
	public void setUpCanvas ( )
	{
		StdDraw.setCanvasSize(1200, 160);
		StdDraw.setXscale(0.0, 600.0);
		StdDraw.setYscale(0.0, 80.0);

		StdDraw.enableDoubleBuffering();
	}

	/**
	 *  Runs the Graphical User Interface.  Draws the images first (a background,
	 *  the first stone, and the frog).  Then, allows the user to choose from a
	 *  list of 20 possible stone combinations.  The path is then chosen, and an
	 *  animation of the frog crossing the river is shown.  The loop then awaits
	 *  the next stone combination chosen by the user (from the buttons on the left).
	 *  This process is repeated, until the user decides to close the program.
	 */
	public void runGUI ( )
	{
		StdDraw.picture(310, 16, "water.png");
		StdDraw.picture(60, 16, "stone.png");
		StdDraw.picture(60, 30, "frog.gif");
		int arrayChoice = chooseArray();
		while(arrayChoice != -1)
		{
			choosePath(arrayChoice);
			runAnimation(arrayChoice);
			arrayChoice = chooseArray();
		}
	}

	/**
	 *  The user chooses the stone path, using the cursor to click on a "button"
	 *  number.  This value is returned.
	 *  @return         The index of the chosen path.
	 */
	public int chooseArray ( )
	{
		drawButtons();
		while(true)
		{
			StdDraw.show();
			StdDraw.pause(30);
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			int arrayChoice = 5*(int)((x)/12) + (int)((79 - y)/12);
			if(StdDraw.isMousePressed() && y >= 18 && arrayChoice >= 0 && arrayChoice < POSSIBLE_STONE_PATHS.length)
			{
				return arrayChoice;
			}
		}
	}

	/**
	 *  Draws the buttons on the upper left of the GUI.  This is
	 *  the place where the user will click, to make a choice
	 *  for the stone path.
	 */
	public void drawButtons ( )
	{
		Font font = new Font("Arial", Font.BOLD, 12);
		StdDraw.setFont(font);
		for(int i = 0; i < POSSIBLE_STONE_PATHS.length; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				StdDraw.setPenColor(new Color(255 - 63 * j,255 - 63 * j,255 - 63 * j));
				StdDraw.filledRectangle(6 + 12 * (i / 5), 73 - 12 * (i % 5), 6.0 - j/2.0, 6.0 - j/2.0);
			}
			StdDraw.setPenColor(new Color(255,255,255));
			StdDraw.text(6 + 12 * (i / 5), 72 - 12 * (i % 5), "" + (i + 1));
		}
	}

	/**
	 *  The stones are chosen according to the arrayChoice.  Then, the parallel
	 *  boolean array (hops) is sized according to this array of stones.  Finally,
	 *  the path is chosen by setting the correct hops elements to true (where the
	 *  frog will land and hop).
	 *  @param arrayChoice        The index of the stone path that has been chosen.
	 */
	public void choosePath(int arrayChoice)
	{
		stones = POSSIBLE_STONE_PATHS[arrayChoice];
		hops = new boolean[stones.length]; hops[0] = true;

		int [] jump1 = new int[stones.length]; // smallest # of jumps to stone[i] s.t. the last jump step is less than 50
		int [] jump2 = new int[stones.length]; ; // smallest # of jumps to stone[i] s.t. the last jump step is leq 70
		int [] last1 = new int[stones.length]; // jump from last1[i] to stone[i] s.t. the last jump step is less than 50
		int [] last2 = new int[stones.length]; // jump from last1[i] to stone[i] s.t. the last jump step is leq 70
		boolean [] change1 = new boolean[stones.length];
		boolean [] change2 = new boolean[stones.length]; //unnecessary?
		int last=0;
		for(int i=1 ; i<stones.length ; i++){
			jump1[i] = 10000000; //set to large for Math.min
			jump2[i] = 10000000;
		}

		for(int i=1 ; i < stones.length ; i++){ // gets shortest path to stone
			for(int j=i-1 ; j >= 0 ; j--){ //backtrack from stone[i]
				if(stones[i]-stones[j] < 50){
					if(jump1[i] > Math.min(jump1[i], Math.min(jump1[j]+1, jump2[j]+1))){
						jump1[i]=Math.min(jump1[j]+1, jump2[j]+1);
					}
					if(jump2[j] < jump1[j]){
						last1[i]=j;
						change1[i]=true;
					}
					else{
						last1[i]=j;
						change1[i]=false;
					}
				}
				if(stones[i]-stones[j] <= 70){
					if(jump2[i] > Math.min(jump2[i], jump1[j] + 1)){
						jump2[i]=jump1[j]+1;
						last2[i]=j;
						//change2[i]=true;
					}
				}
				else{
					break;
				}
			}
			if(jump1[i]==10000000 && jump2[i]==10000000){ //curr stone unreachable
				break;
			}
			last=i;
		}

		int curr=0; curr=(jump2[last] < jump1[last] ? 2 : 1); // start from jump2 or jump1 type?
		while(last!=0){
			if(curr==1){
				hops[last]=true;
				if(change1[last]==true){ // if jump2 necessary
					curr=2;
				}
				last = last1[last];
			}
			else{
				hops[last]=true;
				curr=1; // return back to 1
				last = last2[last];
			}
		}
		for(int i=0 ; i<hops.length ; i++){
			System.out.print(hops[i]+" ");
		}

	}

	/**
	 *  Runs the animation of the frog in the GUI, using the
	 *  placement of the stones (in the stones array), and
	 *  hopping where the boolean array hops is true.
	 *  @param arrayChoice        The index of the stone path that has been chosen.
	 */
	public void runAnimation(int arrayChoice)
	{
		Font font = new Font("Arial", Font.BOLD, 14);
		StdDraw.setFont(font);
		int i = 0;
		while(i <= findLastStoneReached() + 1)
		{
			StdDraw.clear(new Color(255,255,255));
			drawButtons();
			StdDraw.picture(310, 16, "water.png");
			drawAllStonesWithDistances();
			StdDraw.text(60, 70, "" + (arrayChoice + 1));
			if(i <= findLastStoneReached())
			{
				drawIndividualDistancesCurrentlyHopped(i);
				StdDraw.picture(60 + stones[i], 30, "frog.gif");
			}
			else
			{
				drawIndividualDistancesCurrentlyHopped(i-1);
				if(findLastStoneReached() == stones.length - 1)
				{
					StdDraw.picture(582, 30, "frog.gif");
				}
				else
				{
					StdDraw.picture(60, 30, "frog.gif");
				}
			}
			StdDraw.show();
			StdDraw.pause(300);
			i = goToNextGoodHopIndex(i);
		}
	}

	/**
	 *  Determines the index of the last stone reached by the
	 *  frog.  This is used to determine if the frog makes it
	 *  across the river.
	 */
	 public int findLastStoneReached ( )
	 {
		int maxStone = 0;
		for(int i = 0; i < hops.length; i++)
		{
			if(hops[i])
			{
				maxStone = i;
			}
		}
		return maxStone;
	 }

	/**
	 *  Draws the stones in the appropriate places in the GUI.
	 *  Also draws a number beneath each stone.
	 */
	public void drawAllStonesWithDistances ( )
	{
		StdDraw.setPenColor(new Color(0,0,0));
		for(int i = 0; i < stones.length; i++)
		{
			StdDraw.text(60 + stones[i],7,"" + stones[i]);
			StdDraw.picture(60 + stones[i], 16, "stone.png");
		}
	}

	/**
	 *  Draws the distances from each hop, finding the difference between
	 *  "good" stones (stones where the frog lands/hops).  These are drawn
	 *  toward the top of the GUI.
	 *  @param currentSpot        The current index.
	 */
	public void drawIndividualDistancesCurrentlyHopped(int currentSpot)
	{
		int lastHoppedIndex = 0;
		StdDraw.setPenColor(new Color(0,0,0));
		StdDraw.filledRectangle(60 + stones[currentSpot]/2.0,55,stones[currentSpot]/2.0,0.5);
		for(int i = 0; i <= currentSpot; i++)
		{
			if(hops[i] || i == 0)
			{
				StdDraw.filledRectangle(60 + stones[i],55,3,0.5);
				StdDraw.filledRectangle(60 + stones[i],55,0.5,3);
				StdDraw.picture(60 + stones[i], 23, "asterisk.png", (int)(Math.random() * 360));
			}
			if(i != 0 && hops[i])
			{
				StdDraw.setPenColor(new Color(0,0,0));
				StdDraw.text(60 + stones[i] - (stones[i] - stones[lastHoppedIndex])/2.0,49,"" + (stones[i] - stones[lastHoppedIndex]));
				lastHoppedIndex = i;
			}
			StdDraw.setPenColor(new Color(0,0,0));
		}
	}

	/**
	 *  Finds the next place to hop, from the current index.
	 *  @param currentSpot        The current index.
	 */
	public int goToNextGoodHopIndex(int currentIndex)
	{
		for(int i = currentIndex + 1; i < hops.length; i++)
		{
			if(hops[i])
			{
				return i;
			}
		}
		return currentIndex + 1;
	}
}
