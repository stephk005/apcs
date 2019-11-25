/**
 * ForwardAndBackGecko.java
 *
 * A class ForwardAndBackGecko that extends DancingGecko. Contains
 * the basic move methods for a DancingGecko. Moves forward and back
 * in a pattern.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 11/12/2019
 */

import java.awt.Color;

public class ForwardAndBackGecko extends DancingGecko {
	private int state=0;

	public ForwardAndBackGecko(int x, int y, Color color){
		super(x, y, color);
	}

	public ForwardAndBackGecko(int x, int y, Color color, Point p){
		super(x, y, color, p);
	}

	public void step(){
		if(state==0){
			super.moveForward(64);
		}
		else if(state==1){
			super.moveForward(-64);
		}
		state = 1-state;
	}
}
