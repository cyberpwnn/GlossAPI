package com.volmit.gloss.api.source;

import org.bukkit.Location;

public interface PositionalSource extends Source
{
	@Override
	public Location getLocation();

	public void setLocation(Location l);
}
