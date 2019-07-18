package com.volmit.gloss.api.display;

import org.bukkit.entity.Player;

public interface FilteredRenderer extends FilterChain
{
	public String filter(String r);

	public String filter(String r, Player p);
}
