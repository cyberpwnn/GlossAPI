package com.volmit.gloss.api.source;

import org.bukkit.Location;

import com.volmit.gloss.api.capture.VC;
import com.volmit.gloss.api.context.Context;
import com.volmit.gloss.api.util.Updateable;

import primal.lang.collection.GList;

public interface Source extends Updateable
{
	public void assign(String node, VC<?> capture);

	public void unassign(String node);

	public GList<String> getNodes();

	public VC<?> getCapture(String node);

	public SourceType getType();

	public Context getRelatedContext();

	public Location getLocation();
}
