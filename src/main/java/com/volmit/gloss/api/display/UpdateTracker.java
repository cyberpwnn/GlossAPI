package com.volmit.gloss.api.display;

import primal.compute.math.M;

public class UpdateTracker
{
	public long lastUpdate = M.ms();
	private double maxRange;
	private double fastRange;
	private int maxSpeed;
	private int minSpeed;

	public UpdateTracker(double maxRange, double fastRange, int maxSpeed, int minSpeed)
	{
		this.maxRange = maxRange * maxRange;
		this.fastRange = fastRange * fastRange;
		this.maxSpeed = maxSpeed;
		this.minSpeed = minSpeed;
	}

	public int getUpdateRate(double distanceSquared)
	{
		int rate = 1;

		if(distanceSquared <= maxRange)
		{
			if(distanceSquared <= fastRange)
			{
				rate = maxSpeed;
			}

			else
			{
				double pct = 1D - ((distanceSquared - fastRange) / (maxRange - fastRange));
				rate = (int) ((pct * (maxSpeed - minSpeed)) + minSpeed);
			}
		}

		return rate;
	}

	public boolean shouldUpdate(double distanceSquared)
	{
		if(distanceSquared <= maxRange)
		{
			int targetms = (int) (1000D / getUpdateRate(distanceSquared));

			if(M.ms() - lastUpdate > targetms)
			{
				lastUpdate = M.ms();
				return true;
			}
		}

		return false;
	}
}
