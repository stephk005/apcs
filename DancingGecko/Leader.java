/**
 * Leader.java
 *
 * An interface Leader that extends DancingGecko. Creates an interface
 * for a leader that other geckos will follow.
 *
 * @author Stephanie Wu
 * @version 1.0
 * @since 11/14/2019
 */

import java.awt.Color;

public interface Leader {
    public abstract Point getLocation();
	public abstract Point getDirection();
	public abstract void addFollower(DancingGecko gecko);
	public abstract void removeFollower(DancingGecko gecko);
}
