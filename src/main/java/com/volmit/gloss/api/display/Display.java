package com.volmit.gloss.api.display;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.volmit.gloss.api.context.Node;
import com.volmit.gloss.api.intent.Emissive;
import com.volmit.gloss.api.source.Source;

import mortar.lang.collection.GList;

public interface Display extends Emissive, PivotDisplay
{
	public UpdateTracker getTracker();

	public Location getBallPoint(Player p);

	public Vector getBallVector(Player p);

	public int getSize();

	public void clear();

	public void stick(int index);

	public void unstick();

	public void setStackSpreadMultiplier(double d);

	public double getStackSpreadMultiplier();

	public int stickFor(Player p);

	public GList<DisplayComponent> getComponents();

	public GList<Node> getNodes();

	public int getClosestIndex(Player p);

	public DisplayComponent getClosestComponent(Player p);

	public void add(Node node, DisplayComponent component);

	public void update(double distanceSquared, Location target, Source src);

	public Location getTarget();

	public void setTarget(Location l);

	public void destroy();

	public void justClicked();

	public void pivot(Player player);

	public Player getPlayer();
}
