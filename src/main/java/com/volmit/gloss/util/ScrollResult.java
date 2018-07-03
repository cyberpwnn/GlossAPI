package com.volmit.gloss.util;

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
}
