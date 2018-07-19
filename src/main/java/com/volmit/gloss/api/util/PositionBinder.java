package com.volmit.gloss.api.util;

import org.bukkit.Location;

@FunctionalInterface
public interface PositionBinder
{
	public Location bind();
}
