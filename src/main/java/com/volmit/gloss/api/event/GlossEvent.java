package com.volmit.gloss.api.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GlossEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();

	public GlossEvent()
	{

	}

	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}

	public static HandlerList getHandlerList()
	{
		return handlers;
	}
}
