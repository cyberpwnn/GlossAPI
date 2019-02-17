package com.volmit.gloss.api.context;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public interface DropContext
{
	public void update();

	public void update(Item item);

	public boolean hasContext(Item item);

	public Player getPlayer();
}
