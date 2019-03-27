package com.volmit.gloss.api.display;

import org.bukkit.Chunk;
import org.bukkit.Location;

public interface ILighter
{
	public void light(Location l, int ll);

	public void unlight(Location l);

	public void refresh(Chunk c);
}
