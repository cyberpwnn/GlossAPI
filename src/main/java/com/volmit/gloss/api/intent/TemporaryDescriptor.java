package com.volmit.gloss.api.intent;

import com.volmit.gloss.api.util.PositionBinder;

public interface TemporaryDescriptor extends Descriptor
{
	public void setHealth(long health);

	public long getHealth();

	public boolean hasHealth();

	public boolean shouldDestroy();

	public void update();

	public void bindPosition(PositionBinder b);
}
