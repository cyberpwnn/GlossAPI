package com.volmit.gloss.api.glow;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

@FunctionalInterface
public interface GRT
{
	public Glower getGlower(Entity entity, Player observer);
}
