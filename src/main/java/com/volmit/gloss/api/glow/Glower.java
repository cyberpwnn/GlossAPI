package com.volmit.gloss.api.glow;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface Glower
{
	public Player getObserver();

	public Entity getEntity();

	public ChatColor getColor();

	public void setColor(ChatColor color);

	public void setGlowing(boolean glowing);

	public void destroy();
}
