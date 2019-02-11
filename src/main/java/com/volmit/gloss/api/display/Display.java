package com.volmit.gloss.api.display;

import org.bukkit.Location;

import com.volmit.gloss.api.context.Node;
import com.volmit.gloss.api.source.Source;

import primal.lang.collection.GList;

public interface Display
{
	public UpdateTracker getTracker();

	public int getSize();

	public void clear();

	public void setEmissive(boolean emissive);

	public void setEmissiveLevel(int lightLevel);

	public int getEmissiveLevel();

	public boolean isEmissive();

	public GList<DisplayComponent> getComponents();

	public GList<Node> getNodes();

	public void add(Node node, DisplayComponent component);

	public void update(double distanceSquared, Location target, Source src);

	public Location getTarget();

	public void setTarget(Location l);

	public void destroy();

	public void justClicked();
}
