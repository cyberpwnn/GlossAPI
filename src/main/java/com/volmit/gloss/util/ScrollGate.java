package com.volmit.gloss.util;

public class ScrollGate
{
	private int current;

	public ScrollGate(int initial)
	{
		current = initial;
	}

	public ScrollResult scroll(int next)
	{
		if(Math.abs((current + 11) - (current + 11)) != 1)
		{
			return new ScrollResult(0, ScrollDirection.UP);
		}

		if(next == 8 && current == 0)
		{
			return new ScrollResult(1, ScrollDirection.UP);
		}

		if(next == 0 && current == 8)
		{
			return new ScrollResult(1, ScrollDirection.DOWN);
		}

		if(next > current)
		{
			return new ScrollResult(1, ScrollDirection.DOWN);
		}

		else
		{
			return new ScrollResult(1, ScrollDirection.UP);
		}
	}

	public int getCurrent()
	{
		return current;
	}
}
