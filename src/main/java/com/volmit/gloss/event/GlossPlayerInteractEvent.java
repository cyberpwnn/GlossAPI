package com.volmit.gloss.event;

import org.bukkit.entity.Player;

import com.volmit.gloss.util.ActionType;

public class GlossPlayerInteractEvent extends GlossEvent
{
	private final ActionType r;
	private final Player p;

	public GlossPlayerInteractEvent(ActionType r, Player p)
	{
		this.p = p;
		this.r = r;
	}

	public ActionType getResult()
	{
		return r;
	}

	public Player getPlayer()
	{
		return p;
	}
}
