/**
 * Leader.java
 *
 * A class FollowingGecko that follows a Leader. Takes in Leader
 * in constructor and follows all instructions.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 11/14/2019
 */

import java.awt.Color;

public class FollowingGecko extends DancingGecko{

	public FollowingGecko (Leader ld, Color clr){ //TravelingGecko
		super(ld.getLocation().getX() + ld.getDirection().getX() * 64, ld.getLocation().getY() + ld.getDirection().getY() * 64, clr, ld.getDirection());
		ld.addFollower(this);
	}

	public FollowingGecko (Leader ld, int x, int y, Color clr, Point pt){ //RoutineLeaderGecko
		super(x, y, clr, pt);
		ld.addFollower(this);
	}

	public void step(){}
}
