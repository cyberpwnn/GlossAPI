package com.volmit.gloss.event;

import org.bukkit.entity.Player;

import com.volmit.gloss.util.ScrollResult;

public class GlossPlayerScrollEvent extends GlossEvent
{
	private final ScrollResult r;
	private final Player p;

	public GlossPlayerScrollEvent(ScrollResult r, Player p)
	{
		this.p = p;
		this.r = r;
	}

	public ScrollResult getResult()
	{
		return r;
	}

	public Player getPlayer()
	{
		return p;
	}
}
