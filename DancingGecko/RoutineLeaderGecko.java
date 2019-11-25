/**
 * RoutineLeaderGecko.java
 *
 * A class RoutineLeaderGecko that extends DancingGecko. Leads a
 * following gecko to do what RoutineGecko would do.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 11/24/2019
 */

import java.awt.Color;

import java.awt.Color;

public class RoutineLeaderGecko extends RoutineGecko implements Leader{
	private DancingGecko[] followers = new FollowingGecko[20];
    private int curr = 0;

	public RoutineLeaderGecko(int x, int y, Color color, GeckoConstants.DanceStep[] ds){
		super(x, y, color, ds);
	}

	public RoutineLeaderGecko(int x, int y, Color color, Point p, GeckoConstants.DanceStep[] ds){
		super(x, y, color, p, ds);
	}

	public void addFollower(DancingGecko gecko){
		followers[curr] = (FollowingGecko)(gecko);
        curr++;
	}

	public void removeFollower(DancingGecko gecko){
		for(int i=0 ; i<curr ; i++) {
            if(followers[i].equals(gecko)) {
                removeShift(i);
                curr--;
                return;
            }
        }
	}

    public void removeShift(int idx) {
        for(int i=idx ; i<curr-1 ; i++) {
            followers[i] = followers[i+1];
        }
    }

    public Point getLocation() {
        Point p = super.getLocation();
        return p;
    }

    public Point getDirection() {
        Point p = super.getDirection();
        return p;
    }

	public void step(){
		int currStep = super.stepType();
        super.step();
        for(int i=0 ; i<curr ; i++) {
            followers[i].step();
            if(currStep == 0) {
                followers[i].moveSide(-64);
            }
            if(currStep == 1){
    			followers[i].moveSide(64);
    		}
    		if(currStep == 2){
    			followers[i].moveForward(-64);
    		}
    		if(currStep == 3){
    			followers[i].moveForward(64);
    		}
    		if(currStep == 4){
    			followers[i].spinLeft();
    		}
    		if(currStep == 5){
    			followers[i].spinRight();
    		}
    		if(currStep == 6){
    			;
    		}
        }

	}

}
