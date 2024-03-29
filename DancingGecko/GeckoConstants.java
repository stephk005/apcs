
/**
 * GeckoConstants.java
 *
 * Constants for the DancingGecko and the DanceFloor.
 *
 * @author Scott DeRuiter
 * @version 1.0
 * @since 11/12/2019
 */

import java.awt.Color;

public class GeckoConstants
{
	public enum DanceStep{FORWARD, BACKWARD, RIGHT, LEFT, TURN_RIGHT, TURN_LEFT, PAUSE};

	public static final Color SCREEN_COLOR = new Color(0, 0, 0);
	public static final int DRAW_DELAY = 500;
	public static final int SCREEN_WIDTH = 1200;
	public static final int SCREEN_HEIGHT = 800;

	public static final Point NORTH = new Point(0,1);
	public static final Point EAST = new Point(-1,0);
	public static final Point SOUTH = new Point(0,-1);
	public static final Point WEST = new Point(1,0);
}
