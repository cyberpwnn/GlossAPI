package com.volmit.gloss.api.function;

import org.bukkit.entity.Player;

@FunctionalInterface
public interface Function
{
	public Object parse(Player p);
}
