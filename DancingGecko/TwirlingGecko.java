/**
 * TwirlingGecko.java
 *
 * A class TwirlingGecko that extends DancingGecko. Contains the basic
 * move methods for a DancingGecko. Spins right every dance step.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 11/12/2019
 */

import java.awt.Color;

//step size 64
public class TwirlingGecko extends DancingGecko {
	public TwirlingGecko(int x, int y, Color color){
		super(x, y, color);
	}

	public TwirlingGecko(int x, int y, Color color, Point p){
		super(x, y, color, p);
	}

	public void step(){
		super.spinRight();
	}
}
