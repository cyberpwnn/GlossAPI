package com.volmit.gloss.api.display;

import org.bukkit.Location;

public class LitSource
{
	private Location current;
	private ILighter lighter;
	private int level;

	public LitSource(Location initial, ILighter lighter, int level)
	{
		this.current = initial.clone();
		this.lighter = lighter;
		this.level = level;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;

		if(level > 0)
		{
			lighter.unlight(current);
			lighter.light(current, getLevel());
			lighter.refresh(current.getChunk());
		}

		else
		{
			lighter.unlight(current);
			lighter.refresh(current.getChunk());
		}
	}

	public void unlight()
	{
		setLevel(0);
	}

	public void setPosition(Location newLocation)
	{
		try
		{
			lighter.unlight(current);
			lighter.refresh(current.getChunk());

			this.current = newLocation.clone();

			if(level > 0)
			{
				lighter.light(current, getLevel());
				lighter.refresh(current.getChunk());
			}
		}

		catch(Throwable e)
		{

		}
	}
}
