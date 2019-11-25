/**
 * SideToSide.java
 *
 * A class SideToSideGecko that extends DancingGecko. Contains
 * the basic move methods for a DancingGecko. Moves right and left
 * in a pattern.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 11/12/2019
 */

import java.awt.Color;

public class SideToSideGecko extends DancingGecko {
	private int state=0;

	public SideToSideGecko(int x, int y, Color color){
		super(x, y, color);
	}

	public SideToSideGecko(int x, int y, Color color, Point p){
		super(x, y, color, p);
	}

	public void step(){
		if(state==0){
			super.moveSide(64);
		}
		else if(state==1){
			super.moveSide(-64);
		}
		state = 1-state;
	}
}
