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
		int current = this.current;
		this.current = next;

		if(Math.abs((current + 11) - (next + 11)) != 1)
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + current;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(obj == null)
		{
			return false;
		}
		if(!(obj instanceof ScrollGate))
		{
			return false;
		}
		ScrollGate other = (ScrollGate) obj;
		if(current != other.current)
		{
			return false;
		}
		return true;
	}
}
