package com.volmit.gloss.api.display;

import org.bukkit.Location;

import com.volmit.gloss.api.context.Node;
import com.volmit.gloss.api.source.Source;
import com.volmit.volume.lang.collections.GList;

public interface Display
{
	public UpdateTracker getTracker();

	public int getSize();

	public void clear();

	public GList<DisplayComponent> getComponents();

	public GList<Node> getNodes();

	public void add(Node node, DisplayComponent component);

	public void update(double distanceSquared, Location target, Source src);

	public Location getTarget();

	public void setTarget(Location l);

	public void destroy();

	public void justClicked();
}
