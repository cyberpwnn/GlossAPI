package com.volmit.gloss.api.util;

public class ScrollResult
{
	private int amount;
	private ScrollDirection direction;

	public ScrollResult(int amount, ScrollDirection direction)
	{
		this.amount = amount;
		this.direction = direction;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public ScrollDirection getDirection()
	{
		return direction;
	}

	public void setDirection(ScrollDirection direction)
	{
		this.direction = direction;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
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
		if(!(obj instanceof ScrollResult))
		{
			return false;
		}
		ScrollResult other = (ScrollResult) obj;
		if(amount != other.amount)
		{
			return false;
		}
		if(direction != other.direction)
		{
			return false;
		}
		return true;
	}
}
