/**
 * TwirlingGecko.java
 *
 * A class RoutineGecko that extends DancingGecko. Contains the basic
 * move methods for a DancingGecko. Follows an array of directions
 * defined in class GeckoConstants.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 11/12/2019
 */

import java.awt.Color;

//step size 64
public class RoutineGecko extends DancingGecko {
	private GeckoConstants.DanceStep[] ds;
	private int idx = 0;

	public RoutineGecko (int x, int y, Color color, GeckoConstants.DanceStep[] ds){
		super(x, y, color);
		this.ds = ds;
	}

	public RoutineGecko (int x, int y, Color color, Point p, GeckoConstants.DanceStep[] ds){
		super(x, y, color, p);
		this.ds = ds;
	}

	public void step(){
		if(ds[idx].equals(GeckoConstants.DanceStep.LEFT)){
			super.moveSide(-64);
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.RIGHT)){
			super.moveSide(64);
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.BACKWARD)){
			super.moveForward(-64);
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.FORWARD)){
			super.moveForward(64);
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.TURN_LEFT)){
			super.spinLeft();
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.TURN_RIGHT)){
			super.spinRight();
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.PAUSE)){
			;
		}
		idx = (idx+1) % ds.length;
	}

    public int stepType() {
        if(ds[idx].equals(GeckoConstants.DanceStep.LEFT)){
			return 0;
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.RIGHT)){
			return 1;
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.BACKWARD)){
			return 2;
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.FORWARD)){
			return 3;
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.TURN_LEFT)){
			return 4;
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.TURN_RIGHT)){
			return 5;
		}
		if(ds[idx].equals(GeckoConstants.DanceStep.PAUSE)){
			return 6;
		}
        return -1;
    }
}
