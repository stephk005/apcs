/**
 * TravelingGecko.java
 *
 * A class Traveling that extends DancingGecko. Leads a following gecko to
 * do what ForwardandBackGecko would do.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 11/12/2019
 */

import java.awt.Color;

public class TravelingGecko extends DancingGecko implements Leader{
	private FollowingGecko follower;
    private int state = 1;

	public TravelingGecko(int x, int y, Color color){
		super(x, y, color);
	}

	public TravelingGecko(int x, int y, Color color, Point p){
		super(x, y, color, p);
	}

	public void addFollower(DancingGecko gecko){
		follower = (FollowingGecko)(gecko);
	}

	public void removeFollower(DancingGecko gecko){
		follower = null;
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
		if(super.checkForward(state*64) && follower.checkForward(state*64)){
			moveForward(state*64);
			follower.moveForward(state*64);
		}
		else{
            state*=(-1);
            moveForward(state*64);
			follower.moveForward(state*64);
		}
	}

}
